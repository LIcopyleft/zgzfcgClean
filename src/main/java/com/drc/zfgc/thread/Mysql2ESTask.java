package com.drc.zfgc.thread;

import com.drc.zfgc.enums.TypeStatusEnum;
import com.drc.zfgc.es.BulkProcessDemo;
import com.drc.zfgc.lisener.DataListener;
import com.drc.zfgc.mapper.mysql.DataContentMapper;
import com.drc.zfgc.model.*;
import com.drc.zfgc.utils.*;
import com.drc.zfgc.contant.ContantCN;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

public class Mysql2ESTask implements Runnable {

    private int beginIndex;
    private int endIndex;
    private ConfigParam config;
    static DataContentMapper mapper = SpringContextHolder.getBean("dataContentMapper");
    private static final Logger logger = LoggerFactory.getLogger(Mysql2ESTask.class);


    public Mysql2ESTask(int beginIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.config = config;
    }

    public Mysql2ESTask(int beginIndex, int endIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.config = config;
    }

    @Override
    public void run() {
        try {

            List<CNGovDataUrl> dataContent = mapper.selectAll4(beginIndex, endIndex, config.getCleanTableName());
            //   List<DataContentWithBLOBs> dataContent = (List<DataContentWithBLOBs>) cnGovDataUrls;
            if (dataContent == null || dataContent.size() < 1) {
                logger.warn(Thread.currentThread().getName() + "end====query db is null====beginIndex=" + beginIndex);
                return;
            }
            logger.info(Thread.currentThread().getName() + "查询完毕. beginIndex = " + beginIndex + "->" + endIndex + "size = " + dataContent.size());
            //    List<GovData> datas = new LinkedList<>();
            /*for (DataContentWithBLOBs data : dataContent) {
                GovData govData = DataConvert.toGovData(data);
                datas.add(govData);
            }*/
            //    LinkedBlockingQueue<CNGovDataUrl> queues = new LinkedBlockingQueue();
            LinkedList<CNGovDataUrl> queues = new LinkedList();

           /* for (CNGovDataUrl data : dataContent) {
                //    if (config.isUseUnionTable()) {
                CNGovDataUrl dataDB = mapper.selectById3(config.getUnionTableName(), data.getUrlId());
                data.setType(data.getNotice());
                data.setNotice(null);
                if (dataDB != null) {
                    //   data.setContent(dataDB.getContent());
                    data.setContent(dataDB.getContent());
                }
                queues.add(data);
                //   }
            }*/
            //遍历 清洗 赋值
            if (dataContent.size() < 1 ) {
                return;
            }

            BulkProcessDemo.writeMysqlDataToES("cn_gov_purchase_index", "cn_gov_purchase_type" , dataContent);
/*
            while (queues.iterator().hasNext()) {
                CNGovDataUrl data = queues.poll();


            }
*/
            //    logger.info(Thread.currentThread().getName() + "==url_id over" + dataContent.get(dataContent.size() - 1).getUrlId() + "=====insert\t" + row + "行");
        } finally {
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
        if (data.getUrlId() == 8210476) {
            data.getUrlId();
        }
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
        Iterator<String> iter = cellInfoList.iterator();
        List<String> tempList = new LinkedList<>();
        Map tempMap = new HashMap();
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.contains("::")) {
                String[] split = str.replaceAll("::", "|").replace(":", "").split("\\|");
                if (split.length == 2 && split[0].equals(split[1])) {
                    continue;
                }
            }
            if (tempMap.containsKey(str.hashCode())) {
                continue;
            } else {
                map.put(str.hashCode(), str);
                tempList.add(str);
            }

        }
        cellInfoList.clear();
        cellInfoList.addAll(tempList);

        logger.debug(data.getUrl());


        //处理公告正文
        //公告正文
        Elements texts = parse.getElementsByClass("vF_detail_content");

        Elements textP = null;
        if (texts != null && texts.size() > 0) {
            Element textEle = texts.get(0);
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

        String url = cleanData.getUrl();
        //公告类别
        String category = url.split("/")[4];
        cleanData.setCategory(category);

        //2 .行政区域处理
        String region = cleanData.getRegion();
        //根据id 查询

        //判断地区等级  非省级补全 上级
        String purchaserAddr = cleanData.getPurchaserAddr();
        String agencyAddr = cleanData.getAgencyAddr();
        if (purchaserAddr == null || StringUtils.isBlank(purchaserAddr) || purchaserAddr.length() < 3) {
            purchaserAddr = cleanData.getOpenBiddingAddr();
        }
        if (purchaserAddr == null) {
            purchaserAddr = cleanData.getTitle();

        }
        if ("市辖区".equals(region)) {
            //获取市级行政区
            String regionStr = fromAddrGetRegionStr(purchaserAddr, 2);

            //        List<Region> regions = mapper.selectRegionByName(regionStr);
            //    河北省、山西省、辽宁省、吉林省、黑龙江省、江苏省、浙江省、安徽省、福建省、江西省、山东省、河南省、湖北省、湖南省、广东省、海南省、四川省、贵州省、云南省、陕西省、甘肃省、青海省、台湾省
            List<Region> regionList = DataListener.getRegionList();
            for (Region reg : regionList) {
                if ("城区".equals(reg.getName())) {
                    continue;
                }
                if (regionStr.contains(reg.getName()) && reg.getIsRepeat().equals("0")) {
                    region = regionStr;
                    cleanData.setRegion(region);
                    break;
                } else if (regionStr.contains(reg.getName()) && reg.getIsRepeat().equals("1")) {
                    regionStr = fromAddrGetRegionStr(regionStr, 3);
                    //    System.err.print("地区信息为找到======");
                }

            }
            //  String addr = RegExpUtil.getAddr(purchaserAddr, 2);
        }

        List<Region> regions = mapper.selectRegionByName(region);
        if (regions != null) {
            regionListDel(cleanData, purchaserAddr, regions);

        } else {
            //未直接获取到行政区域或者
            String tempName = fromAddrGetRegionStr(purchaserAddr, 3);

            List<Region> regionList = mapper.selectRegionByName(tempName);

            if (regionList.size() < 1) {
                regionList = mapper.selectRegionByName(cleanData.getOther4());
            }

            regionListDel(cleanData, purchaserAddr, regionList);
        }


        //3.品目 处理
        String items = cleanData.getItems();
        if (StringUtils.isNotBlank(items)) {
            String[] split = items.split("/");

            /*String temp = "";
            for (int i = 0; i < split.length; i++) {
                if (i == 2) {
                    temp += split[i];
                } else {
                    temp += split[i] + "/";
                }
                // TODO mapper.getItemsCodeByName
                cleanData.setOther1(split[2]);
                cleanData.setItems(temp);
                //保存原始值
                cleanData.setOther2(items);
            }
            */
            //保存原始值
            cleanData.setOther2(items);
            if (split.length > 3) {
                String temp = "";
                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        temp += split[i];
                    } else {
                        temp += split[i] + "/";
                    }
                }
                Items itemByName = DataListener.getItemByName(split[2]);
                if (itemByName != null) {
                    cleanData.setOther1(itemByName.getItemId());
                }
                cleanData.setItems(temp);
            } else {
                // TODO mapper.getItemsCodeByName  下面应该是code 关联品目表
                Items itemByName = DataListener.getItemByName(split[split.length - 1]);
                if (itemByName != null) {
                    cleanData.setOther1(itemByName.getItemId());
                }
                cleanData.setItems(items);
            }

        }

        //代理机构处理
        String agency = cleanData.getAgency();
        if (StringUtils.isNotBlank(agency)) {


            CompanyInfo company = DataListener.getCompanyByName(agency);
            if (company != null) {
                //统一社会信用代码 / 组织机构代码
                //   String bizlicregno = company.getBizlicregno();

                String companyCode = StringUtil.getCompanyCode("1", cleanData.getRegionId(), company);
                cleanData.setAgencyCode(companyCode);

                CompanyDBInfo info = new CompanyDBInfo();
                info.setName(company.getAgentnm());
                info.setConnect(company.getContactnm());
                info.setPhoneNum(company.getCorptel());
                //注册地址
                info.setRegisteredAddr(company.getOfficeaddr());
                info.setRegDate(company.getRegvaliddatestr());
                info.setRegAddr(company.getAuditplace());
                info.setCreditCode(company.getBizlicregno());
                //    info.setRemarks(company.getRemarks());
                //    info.setId(company.getId());
                info.setCode(companyCode);
                info.setUrlId(cleanData.getUrlId());
                mapper.insertCompany(info);
            } else {

                //   System.out.print("后续从工商信息中获取");

            }
            //    StringUtil.getCompanyCode();

            //  cleanData.setAgencyId();
            //mapper.insertAgency()

        }

        //供应商处理
        String supplier = cleanData.getSupplier();
        if (StringUtils.isNotBlank(supplier)) {

            //TODO mapper.get()
            //生成code
            cleanData.setSupplierCode("code");
            //  cleanData.setAgencyId();
            //mapper.insertAgency()

        }

        //公告重归类 处理
        //获取公告类型
        String type = cleanData.getType();
        String title = cleanData.getTitle();
        if (type.contains("成交公告") || type.contains("中标公告") || type.contains("其他公告")) {
            if (title.contains("中标候选")) {
                cleanData.setReType("中标候选人公告");
                cleanData.setReTypeStatus(TypeStatusEnum.DEAL.getCode());
            } else if (type.contains("其他公告")) {
                if (title.contains("合同")) {
                    cleanData.setReType("合同公告");
                } else if (title.contains("单一来源")) {
                    cleanData.setReType("单一来源公告");
                } else if (title.contains("竞争性磋商")) {
                    cleanData.setReType("竞争性磋商公告");
                } else if (title.contains("公开招标")) {
                    cleanData.setReType("公开招标公告");
                } else if (title.contains("中标候选人")) {
                    cleanData.setReType("中标候选人公告");
                } else if (title.contains("邀请招标")) {
                    cleanData.setReType("邀请招标公告");
                } else if (title.contains("终止")) {
                    cleanData.setReType("废标终止公告");
                } else if (title.contains("资格预审")) {
                    cleanData.setReType("资格预审公告");
                } else {
                    cleanData.setReType(type);
                }

                //   cleanData.setReTypeStatus(TypeStatusEnum.PRE_DEAL_ROBOT.getCode());
            } else {
                cleanData.setReType(type);
                cleanData.setReTypeStatus(TypeStatusEnum.NO_DEAL.getCode());
            }
            if (type.contains("其他公告")) {
                if (cleanData.getReTypeStatus() != null && !"其他公告".equals(cleanData.getReType())) {
                    cleanData.setReTypeStatus(TypeStatusEnum.OTHER_ROBOT_PRE_DEAL.getCode());
                } else {
                    cleanData.setReTypeStatus(TypeStatusEnum.OTHER_ROBOT_NO_PRE_DEAL.getCode());
                }

            }


        } else {
            cleanData.setReType(type);
            cleanData.setReTypeStatus(TypeStatusEnum.NO_DEAL.getCode());
        }

        if (StringUtils.isBlank(cleanData.getPurchaser())) {
            System.err.print(" 采购人为空");

        }


        //采购流程归类
        String reType = cleanData.getReType();
        /*if (StringUtils.isBlank(reType)){
            StringUtils.isBlank("");
        }*/


        if (reType.contains("公开招标")
                || reType.contains("询价公告")
                || reType.contains("竞争性谈判")
                || reType.contains("资格预审")
                || reType.contains("单一来源")
                || reType.contains("邀请公告")
                || reType.contains("竞争性磋商")
        ) {
            cleanData.setProcessType("采购公告");

        } else if (reType.contains("更正公告")) {
            cleanData.setProcessType("更正公告");
        } else if (reType.contains("中标候选人公告")
                || reType.contains("中标公告")
                || reType.contains("成交公告")
        ) {
            cleanData.setProcessType("结果公告/中标结果公告");
        } else if (reType.contains("废标终止")) {
            cleanData.setProcessType("结果公告/废标终止公告");
        } else if (reType.contains("采购合同公告")) {
            cleanData.setProcessType("合同公告");
        } else if (reType.contains("其它公告") || reType.contains("其他公告")) {
            cleanData.setProcessType("其它公告");
        }


        //公告去重

        String budgetAmount = cleanData.getBudgetAmount();
        String budgetAmountCurrency = cleanData.getBudgetAmountCurrency();
        String budgetAmountUnit = cleanData.getBudgetAmountUnit();
        String winBiddingTotalAmount = cleanData.getWinBiddingTotalAmount();
        String winBiddingTotalAmountUnit = cleanData.getWinBiddingTotalAmountUnit();
        String biddingFilePrice = cleanData.getBiddingFilePrice();

        budgetAmount = FieldUtils.formatAmount(budgetAmount);
        biddingFilePrice = FieldUtils.formatAmount(biddingFilePrice);
        winBiddingTotalAmount = FieldUtils.formatAmount(winBiddingTotalAmount);

        if (biddingFilePrice != null && StringUtils.isNotBlank(biddingFilePrice)) {
            BigDecimal bigDecimal = new BigDecimal(biddingFilePrice);
            if (bigDecimal.compareTo(new BigDecimal(9999)) > 0) {
                logger.debug("自动修正金额");
                BigDecimal amount = bigDecimal.divide(new BigDecimal(10000));
                biddingFilePrice = amount.toString();
            }
        }


        cleanData.setBudgetAmount(budgetAmount);
        cleanData.setWinBiddingTotalAmount(winBiddingTotalAmount);
        cleanData.setBiddingFilePrice(biddingFilePrice);

        String supplier1 = cleanData.getSupplier();
        if (supplier1 != null && supplier1.length() > 80) {
            cleanData.setSupplier(null);
        }


        if (cleanData.getProNo() == null || StringUtils.isBlank(cleanData.getProNo())) {
            cleanData.setProNo(StringUtil.getRandomProNo());
        }

        if (StringUtils.isNotBlank(title)) {
            if (title.contains("ppp") || title.contains("PPP")) {
                cleanData.setIsPpp(true);
            }

        }
        //    FieldUtils.formatDateAndTime();

        //TODO 两次正则可获取项目编号  ? 确认title 是否需要去掉项目编号等信息
        //([\w-]{6,})|[（(【](?:\1)[）)】]|[（(【]{1}.*[）)】]{1}
        //([\w-]{6,})

        //再次校验,去除字符串长度超过80
        ConventUtils.cleanDataLengthDel(cleanData);
        cleanData.setTextContent(null);
        return cleanData;
    }

    private static String fromAddrGetRegionStr(String purchaserAddr, int levelCode) {
        String addr = RegExpUtil.getAddr(purchaserAddr, levelCode);
        String[] split = addr.replaceAll("省", "省|").replaceAll("市", "市|").split("\\|");
        String tempName = "";
        for (String key : split) {
            if (addr.contains("区") && key.contains("区")) {
                tempName = key;

            } else if ((addr.contains("市") && key.contains("市")) || key.contains("自治区")) {
                tempName = key;

            } else if (addr.contains("市") && key.contains("省")) {
                tempName = key;

            }
        }
        return tempName;
    }

    private static void regionListDel(CNGovCleanData cleanData, String purchaserAddr, List<Region> regions) {
        if (regions.size() == 1) {
            Region reg = regions.get(0);
            setRegionInfo(cleanData, reg);
        } else {
            //有重名并且采购人地址为空
            if (StringUtils.isBlank(purchaserAddr)) {
                System.err.print("有重名并且采购人地址为空 =============== 未处理id : " + cleanData.getUrlId());
                return;
            }

            //有重名的地区
            outer:
            for (Region reg : regions) {
                //    mapper.selectRegionByRegionId(reg.getParentId());
                String fullName = reg.getFullName();
                String[] split = fullName.replace("\\" + reg.getName(), "").split("\\\\");
                for (String key : split) {
                    if (purchaserAddr.contains(key)) {
                        setRegionInfo(cleanData, reg);
                        break outer;
                    }
                }


            }


        }

    }

    private static void setRegionInfo(CNGovCleanData cleanData, Region reg) {
        if (reg.getLevel().equals("1")) {
            cleanData.setRegionId(reg.getRegionId());
            cleanData.setRegion1(reg.getName());

        } else if (reg.getLevel().equals("2")) {
            Region parReg = mapper.selectRegionByRegionId(reg.getParentId());
            cleanData.setRegion1(parReg.getName());
            cleanData.setRegion2(reg.getName());
            cleanData.setRegionId(reg.getRegionId());

        } else if (reg.getLevel().equals("3")) {
            Region parReg = mapper.selectRegionByRegionId(reg.getParentId());
            Region parparReg = mapper.selectRegionByRegionId(parReg.getParentId());

            cleanData.setRegion1(parparReg.getName());
            cleanData.setRegion2(parReg.getName());
            cleanData.setRegion3(reg.getName());

            cleanData.setRegionId(reg.getRegionId());
        }
    }


}
