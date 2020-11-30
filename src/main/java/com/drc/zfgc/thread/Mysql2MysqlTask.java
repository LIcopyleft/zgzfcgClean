package com.drc.zfgc.thread;

import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.contant.ContantCN;
import com.drc.zfgc.mapper.mysql.DataContentMapper;
import com.drc.zfgc.model.CNGovDataUrl;
import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Mysql2MysqlTask implements Runnable {

    private int beginIndex;
    private int endIndex;
    private ConfigParam config;
    static DataContentMapper mapper = SpringContextHolder.getBean("dataContentMapper");
    private static final Logger logger = LoggerFactory.getLogger(Mysql2MysqlTask.class);


    public Mysql2MysqlTask(int beginIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.config = config;
    }

    public Mysql2MysqlTask(int beginIndex, int endIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.config = config;
    }

    @Override
    public void run() {
        try {
            List<CNGovCleanData> dataContent = mapper.selectAll6(beginIndex, endIndex, config.getCleanTableName());
            //   List<DataContentWithBLOBs> dataContent = (List<DataContentWithBLOBs>) cnGovDataUrls;
            if (dataContent.size() < 1) {
                logger.warn(Thread.currentThread().getName() + "end====query db is null====beginIndex=" + beginIndex);
                return;
            }
            logger.info(Thread.currentThread().getName() + "查询完毕. beginIndex = " + beginIndex + "->" + endIndex + "size = " + dataContent.size());
            int row = mapper.insertCNCleanDataList(dataContent, config.getInsertTableName());
            config.getFinishNum().addAndGet(row);
            logger.info("已插入" + row + "行");
        } finally {
            logger.info("总插入" + config.getFinishNum().toString());
            config.getLatch().countDown();

        }
    }

    //


    /**
     * 中标公告,处理和cggg 完全相同
     *
     * @param data
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static CNGovCleanData clean(CNGovDataUrl data) throws InvocationTargetException, IllegalAccessException {
       /* if (data.getUrlId() == 8210476) {
            data.getUrlId();
        }*/
        //    final String p_date = "\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}|\\d{4}(年)\\d{1,2}月\\d{1,2}日{0,}";

        String content = data.getContent();
        Map map = new HashMap();
        content = HtmlUtils.removeCNStr(content);
        Document parse = Jsoup.parse(content);

        //公告概要
        List<String> cellInfoList = new LinkedList<>();
        /*Elements summary = parse.getElementsByClass("table");
        if (summary != null && summary.size() > 0) {
            Element table = summary.get(0).getElementsByTag("table").get(0);
            List<Element> tableList = new ArrayList<>();
            tableList.add(table);

            logger.debug("表格内容解析开始*******************************");//表格解析开始
            cellInfoList = TableDeal.tableSizeOverOne(tableList);
            logger.debug("打印解析内容\n" + Arrays.toString(cellInfoList.toArray()));
            logger.debug("表格内容解析结束");
        }*/

        // 统一处理表格 : 包括公告概要, 和正文, 按上面注释会获取不到正文中包含表格数据
        List<Element> tableList = HtmlUtils.getHtmlTableList(parse);
        cellInfoList = TableDeal.tableSizeOverOne(tableList);
        logger.debug("打印解析内容\n" + Arrays.toString(cellInfoList.toArray()));
        logger.debug("表格内容解析结束");

        //增加修正
        StringUtil.fixSpacialString(map, cellInfoList);

        //处理公告正文
        //公告正文
        Elements texts = parse.getElementsByClass("vF_detail_content");
        Elements textP = null;
        Element textEle = null;
        if (texts != null && texts.size() > 0) {
            textEle = texts.get(0);
            textP = textEle.getElementsByTag("p");

            //TODO 增加处理正文中table
            //    cellInfoList = TableDeal.tableSizeOverOne(tableList);

        } else {
            textP = parse.getElementsByTag("p");
            //存在没有p标签标记, 直接 eg:http://www.ccgp.gov.cn/cggg/dfgg/gkzb/201403/t20140318_4055411.htm
            if (textP.size() < 10) {
                String text = parse.text();
                Elements finalTextP = new Elements();
                //    String[] s = text.split(" ");
                Arrays.stream(text.split(" ")).forEach(a -> {
                    Element ele = new Element("p");
                    ele.html(a);
                    finalTextP.add(ele);
                });
                textP = finalTextP;
                //    List<String> list = Arrays.asList(s);
                //    finalTextP.add();
                //   textP = finalTextP;
            }
        }

        //存在 没有p标签
        if (textP == null || textP.size() < 3) {
            Elements textLi = parse.getElementsByTag("li");
            if (textLi.size() < 3 && textEle != null) {
                String html = textEle.html().replaceAll("\\'", "").replaceAll("\"", "");
                String[] split1 = html.split("\\<br\\>");
                Elements elements = new Elements();

                for (String str : split1) {
                    Element element = new Element("p");
                    element.html(str);
                    elements.add(element);
                    // textP.append(str);
                }
                textP = elements;
            } else {
                Map mapLi = HtmlUtils.prasePToMap(textLi);
                map.putAll(mapLi);
            }

        }

        //再次验证
        if (textP.size() < 3) {
            String replaceContent = StringUtil.replaceAll(content, "\\<div", "\\<p");
            parse = Jsoup.parse(replaceContent);
            textP = parse.getElementsByTag("p");
        }


        map = HtmlUtils.prasePToMap(textP);
       /* String text = textP.text();
        String[] s = text.split("  ");*/

        //   cellInfoList.addAll(cellInfoList2);
        Map map1 = HtmlUtils.plistToMap(cellInfoList);
        //       map = HtmlUtils.prasePToMap(p);
        //   map1.putAll(map);
        map.putAll(map1);

        CNGovCleanData cleanData = new CNGovCleanData();

        ConventUtils.govDataUrl2CleanData(data, cleanData);

        cleanData = (CNGovCleanData) ReflectionUtils.mapToField(map, cleanData, ContantCN.filedBJValueSet());

        //1.公告类别处理
        DataBusinessDel.categoryDel(cleanData);

        //2.地区字段处理
        DataBusinessDel.regionDel(cleanData);

        //3.品目 处理
        DataBusinessDel.itemsDel(cleanData);

        //4 .代理机构处理
        DataBusinessDel.agencyDel(cleanData);

        //5 .供应商处理
        DataBusinessDel.supplierDel(cleanData);

        //6 -1 .公告重归类 处理
        DataBusinessDel.typeDel(cleanData);

        //6 -2 .公告重归类 处理
        DataBusinessDel.finalTypeDel(cleanData);

        // 7.采购流程归类
        DataBusinessDel.processTypeDel(cleanData);

        //8.交易阶段归类
        DataBusinessDel.processStageDel(cleanData);
        // 9. 招标方法处理
        DataBusinessDel.purchaseMethod(cleanData);

        DataBusinessDel.amountFix(cleanData);
        // 10.项目编号处理
        DataBusinessDel.proNoDel(cleanData);

        //11 . 清洗状态标识,主要给后续人工处理更有针对性
        DataBusinessDel.cleanStatusDel(cleanData, cellInfoList);

        // FieldUtils.formatDateAndTime();
        //TODO 两次正则可获取项目编号  ? 确认title 是否需要去掉项目编号等信息
        //([\w-]{6,})|[（(【](?:\1)[）)】]|[（(【]{1}.*[）)】]{1}

        //([\w-]{6,})
        //再次校验,去除字符串长度超过80


        ConventUtils.cleanDataLengthDel(cleanData);

        //如果非中标公告类公告, 去除供应商 , 中标价等相关中标字段信息

        ConventUtils.cleanDataLengthDel(cleanData);
        if (!"中标公告".equals(cleanData.getType()) && !"成交公告".equals(cleanData.getType())) {
            cleanData.setSupplier(null);
            cleanData.setWinBiddingSupplier(null);
            cleanData.setWinBiddingTime(null);
            cleanData.setWinBiddingSupplierAddr(null);
            cleanData.setWinBiddingSupplierPhone(null);
            cleanData.setWinBiddingTotalAmount(null);
        }

        cleanData.setTextContent(null);
        return cleanData;
    }


}
