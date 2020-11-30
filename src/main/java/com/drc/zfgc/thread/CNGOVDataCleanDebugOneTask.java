package com.drc.zfgc.thread;

import com.drc.zfgc.enums.StatusCodeEnum;
import com.drc.zfgc.mapper.mysql.DataContentMapper;
import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.contant.ContantCN;
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
import java.util.concurrent.LinkedBlockingQueue;

public class CNGOVDataCleanDebugOneTask implements Runnable {

    private int beginIndex;
    private int endIndex;
    private ConfigParam config;
    static DataContentMapper mapper = SpringContextHolder.getBean("dataContentMapper");
    private static final Logger logger = LoggerFactory.getLogger(CNGOVDataCleanDebugOneTask.class);


    public CNGOVDataCleanDebugOneTask(int beginIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.config = config;
    }

    public CNGOVDataCleanDebugOneTask(int beginIndex, int endIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.config = config;
    }

    @Override
    public void run() {
        try {

            //    int[] arr = new int[]{9180, 9182, 9183, 9184, 9188, 9191, 9204, 9207, 9209, 9221, 9227, 9229, 9230, 9231, 9232, 9234, 9236, 9237, 9238, 9242, 9243, 9246, 9251, 9255, 9256, 9258, 9259, 9260, 9261, 9262, 9264, 9265, 9271, 9272, 9276, 9277, 9289, 9291, 9295, 9311, 9312, 9316, 9319, 9329, 9332, 9334, 9338, 9339, 9345, 9349, 9351, 9354, 9355, 9356, 9358, 9360, 9365, 9367, 9369, 9371, 9372, 9373, 9381, 9383, 9389, 9392, 9402, 9403, 9405, 9408, 9415, 9416, 9417, 9419, 9430, 9433, 9434, 9437, 9438, 9447, 9448, 9451, 9453, 9457, 9459, 9475, 9478, 9486, 9488, 9492, 9493, 9496, 9498, 9500, 9502, 9504, 9508, 9509, 9511, 9514, 9515, 9521, 9522, 9525, 9531, 9532, 9541, 9542, 9544, 9545, 9550, 9552, 9555, 9556, 9559, 9560, 9561, 9562, 9569, 9571, 9580, 9582, 9584, 9587, 9592, 9596, 9601, 9605, 9606, 9608, 9609, 9610, 9611, 9612, 9614, 9615, 9617, 9618, 9623, 9625, 9633, 9634, 9635, 9638, 9647, 9650, 9652, 9657, 9660, 9665, 9669, 9674, 9675, 9676, 9677, 9679, 9680, 9684, 9685, 9686, 9690, 9694, 9697, 9698, 9701, 9708, 9712, 9713, 9714, 9718, 9745, 9768, 9772, 9783, 9786, 9788, 9790, 9792, 9793, 9795, 9796, 9797, 9798, 9799, 9802, 9807, 9809, 9810, 9816, 9821, 9827, 9831, 9833, 9834, 9835, 9836, 9838, 9840, 9841, 9842, 9845, 9847, 9848, 9854, 9858, 9862, 9865, 9866, 9871, 9872, 9874, 9877, 9880, 9882, 9885, 9887, 9889, 9890, 9892, 9894, 9901, 9906, 9913, 9924, 9926, 9927, 9928, 9929, 9930, 9933, 9939, 9940, 9941, 9943, 9949, 9955, 9956, 9958, 9959, 9961, 9965, 9966, 9969, 9973, 9975, 9976, 9984, 9985, 9987, 9988, 9989, 9992, 9993, 9994, 9995, 9997, 9999, 10001, 10002, 10005, 10008, 10009, 10015, 10016, 10018, 10019, 10020, 10021, 10022, 10023, 10024, 10026, 10027, 10029, 10030, 10031, 10034, 10035, 10036, 10037, 10038, 10039, 10041, 10042, 10046, 10047, 10048, 10049, 10053, 10057, 10058, 10059, 10060, 10061, 10064, 10066, 10067, 10068, 10069, 10070, 10071, 10072, 10073, 10074, 10075, 10076, 10077, 10079, 10082, 10083, 10085, 10086, 10088, 10089, 10091, 10095, 10099, 10106, 10118, 10120, 10125, 10126, 10132, 10133, 10137, 10140, 10147, 10150, 10151, 10153, 10154, 10166, 10168, 10170, 10171, 10176, 10182, 10187, 10191, 10195, 10196, 10198, 10201, 10202, 10206, 10210, 10212, 10214, 10224, 10228, 10229, 10232, 10233, 10236, 10237, 10240, 10241, 10242, 10244, 10247, 10249, 10251, 10252, 10256, 10257, 10258, 10263, 10266, 10270, 10272, 10274, 10276, 10277, 10291, 10294, 10300, 10302, 10303, 10305, 10307, 10308, 10309, 10313, 10316, 10317, 10320, 10322, 10325, 10328, 10331, 10332, 10333, 10335, 10336, 10339, 10345, 10354, 10355, 10356, 10357, 10358, 10359, 10362, 10365, 10372, 10373, 10377, 10378, 10383, 10384, 10397, 10405, 10409, 10410, 10412, 10416, 10417, 10423, 10432, 10434, 10435, 10436, 10437, 10443, 10448, 10450, 10451, 10453, 10470, 10471, 10473, 10474, 10477, 10481, 10484, 10485, 10490, 10491, 10492, 10495, 10499, 10500, 10505, 10507, 10508, 10512, 10513, 10515, 10516, 10519, 10521, 10522, 10525, 10530, 10532, 10533, 10534, 10537, 10539, 10542, 10543, 10549, 10551, 10553, 10562, 10565, 10567, 10569, 10570, 10573, 10577, 10579, 10587, 10588, 10589, 10590, 10591, 10593, 10597, 10598, 10599, 10601, 10605, 10608, 10614, 10618, 10621, 10622, 10623, 10624, 10625, 10627, 10629, 10631, 10634, 10638, 10647, 10648, 10650, 10651, 10654, 10656, 10658, 10664, 10665, 10668, 10671, 10676, 10677, 10678, 10679, 10680, 10681, 10682, 10683, 10684, 10687, 10690, 10692, 10695, 10696, 10698, 10705, 10712, 10719, 10722, 10723, 10724, 10728, 10729, 10731, 10732, 10734, 10735, 10737, 10738, 10739, 10743, 10745, 10751, 10753, 10754, 10756, 10758, 10759, 10764, 10767, 10768, 10769, 10770, 10771, 10772, 10778, 10779, 10780, 10794, 10799, 10803, 10816, 10817, 10832, 10834, 10836, 10839, 10840, 10841, 10842, 10847, 10852, 10858, 10859, 10862, 10869, 10879, 10880, 10881, 10883, 10884, 10890, 10898, 10900, 10911, 10912, 10920, 10922, 10925, 10932, 10934, 10936, 10939, 10940, 10942, 10943, 10954, 10961, 10966, 10967, 10968, 10988, 10996, 10998, 11008, 11026, 11031, 11034, 11046, 11047, 11049, 11050, 11052, 11053, 11055, 11056, 11057, 11058, 11059, 11062, 11071, 11072, 11074, 11075, 11076, 11077, 11078, 11079, 11081, 11083, 11088, 11089, 11090, 11096, 11104, 11107, 11111, 11126, 11130, 11133, 11135, 11136, 11138, 11147, 11153, 11157, 11161, 11164, 11167, 11169, 11175, 11177, 11179, 11180, 11181, 11186, 11196, 11197, 11199, 11202, 11203, 11205, 11207, 11209, 11211, 11212, 11229, 11230, 11233, 11234, 11235, 11240, 11241, 11242, 11244, 11247, 11248, 11250, 11253, 11256, 11259, 11260, 11265, 11267, 11270, 11274, 11281, 11286, 11288, 11291, 11295, 11303, 11306, 11307, 11310, 11317, 11318, 11319, 11320, 11321, 11322, 11323, 11324, 11326, 11330, 11331, 11338, 11340, 11342, 11343, 11348, 11349, 11350, 11352, 11353, 11354, 11355, 11363, 11368, 11369, 11376, 11377, 11378, 11380, 11381, 11382, 11383, 11389, 11395, 11398, 11402, 11403, 11407, 11409, 11416, 11427, 11432, 11434, 11436, 11437, 11438, 11440, 11441, 11442, 11444, 11449, 11450, 11451, 11453, 11459, 11470, 11471, 11475, 11476, 11477, 11479, 11480, 11483, 11485, 11486, 11497, 11499, 11507, 11510, 11513, 11514, 11515, 11519, 11520, 11523, 11525, 11527, 11528, 11530, 11532, 11536, 11537, 11538, 11539, 11544, 11547, 11551, 11556, 11565, 11566, 11567, 11569, 11572, 11578, 11581, 11583, 11587, 11590, 11591, 11592, 11593, 11594, 11595, 11596, 11602, 11606, 11613, 11614, 11616, 11619, 11620, 11625, 11635, 11639, 11645, 11649, 11653, 11659, 11660, 11661, 11663, 11664, 11666, 11670, 11671, 11672, 11673, 11674, 11676, 11680, 11686, 11689, 11691, 11692, 11700, 11702, 11705, 11710, 11718, 11719, 11723, 11730, 11731, 11732, 11733, 11734, 11735, 11736, 11738, 11739, 11740, 11742, 11744, 11745, 11746, 11748, 11751, 11754, 11762, 11763, 11768, 11769, 11778, 11780, 11781, 11783, 11785, 11789, 11790, 11794, 11812, 11813, 11817, 11818, 11821, 11823, 11827, 11828, 11831, 11835, 11837, 11840, 11841, 11842, 11846, 11847, 11848, 11853, 11858, 11859, 11861, 11866, 11868, 11874, 11876, 11877, 11882, 11885, 11887, 11893, 11897, 11911, 11915, 11924, 11928, 11931, 11932, 11942, 11943, 11944, 11945, 11948, 11949, 11951, 11953, 11954, 11956, 11960, 11961, 11963, 11964, 11967, 11971, 11974, 11982, 12001, 12003, 12009, 12010, 12011, 12013, 12014, 12016, 12028, 12029, 12030, 12032, 12033, 12034, 12037, 12038, 12042, 12047, 12048, 12064, 12071, 12072, 12073, 12074, 12077, 12078, 12079, 12082, 12087, 12096, 12098, 12099, 12103, 12104, 12105, 12106, 12109, 12110, 12111, 12116, 12118, 12123, 12126, 12128, 12129, 12130, 12131, 12133, 12134, 12135, 12136, 12137, 12140, 12141, 12145, 12152, 12155, 12156, 12157, 12158, 12164, 12168, 12170, 12172, 12176, 12177, 12182, 12184, 12189, 12190, 12191, 12193, 12195, 12196, 12201, 12205, 12208, 12210, 12211, 12212, 12213, 12214, 12215};

            /*for (int i = 0; i < arr.length; i++) {
                beginIndex = arr[i];
                endIndex = arr[i] + 1;*/

            beginIndex = 62002;
            endIndex = beginIndex+1;
            List<CNGovCleanData> list = new Vector<>();
            String cleanTableName = config.getCleanTableName();
            List<CNGovDataUrl> dataContent = mapper.selectAll4(beginIndex, endIndex, cleanTableName);
            //   List<DataContentWithBLOBs> dataContent = (List<DataContentWithBLOBs>) cnGovDataUrls;
            if (dataContent == null || dataContent.size() < 1) {
                logger.warn(Thread.currentThread().getName() + "end====query db is null====beginIndex=" + beginIndex);
                return;
            }
            logger.info(Thread.currentThread().getName() + "查询完毕. beginIndex = " + beginIndex + "->" + endIndex + "size = " + dataContent.size());

            LinkedBlockingQueue<CNGovDataUrl> queues = new LinkedBlockingQueue();

            for (CNGovDataUrl data : dataContent) {
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
            }
            //遍历 清洗 赋值
            if (queues.size() < 1) {

                return;
            }

            while (queues.iterator().hasNext()) {
                CNGovDataUrl data = queues.poll();
                try {
                    String content = data.getContent();
                    if (StringUtils.isBlank(content)) {
                        continue;
                    }
                    /*
                     * @description  清洗逻辑
                     * @author tengchao.li
                     * @date 2020/9/28
                     * @param
                     * @return void
                     */
                    CNGovCleanData cleanData = clean(data);
                    logger.debug("\r\n" + "[" + data.getType() + "]对象关键信息:" + data.toString());
                    if (cleanData == null) {
                        continue;
                    }
                    // data.setContent(null);
                    list.add(cleanData);
                } catch (Exception e) {
                    logger.error("ParaseErr{urlId:" + data.getUrlId() + "====url:" + data.getUrl() + "}", e);
                    continue;
                }

                if (list.size() == config.getInsertMax() || queues.size() == 0) {
                    if (list.size() < 1) {
                        continue;
                    }
                    try {

                        //       int row = mapper.insertCNCleanDataList(list, config.getInsertTableName());
                        //     logger.info(Thread.currentThread().getName() + "==url_id over" + dataContent.get(dataContent.size() - 1).getUrlId() + "=====insert\t" + row + "行");
                    } catch (Exception e) {
                        throw e;
                    }
                    list.clear();
                    continue;
                }
            }
            //   }
            // logger.info(Thread.currentThread().getName() + "==url_id over" + dataContent.get(dataContent.size() - 1).getUrlId() + "=====insert\t" + row + "行");
        } finally {
            //   config.getLatch().countDown();
        }
    }

    //
    static int count = 0;

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


        String removeHtmlTag = StringUtil.removeHtmlTag(content);

        List lst = new LinkedList();
        String[] split = removeHtmlTag.split("\\n");

        for (String str : split) {
            if (StringUtils.isNotBlank(str)) {
                String[] split1 = str.split("\\t");
                lst.addAll(Arrays.asList(split1));
            }
        }

        //    System.out.println(removeHtmlTag);
        //     removeHtmlTag = com.spring.springbootdemo.utils.StringUtils.removeSpace(removeHtmlTag);
        String removeHtmlTag2 = StringUtil.replaceSpace(removeHtmlTag);

        Map map = new HashMap();
        content = HtmlUtils.removeCNStr(content);
        Document parse = Jsoup.parse(content);

        Integer statusCode = null;

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

        logger.info(data.getUrl());

        //处理公告正文
        //公告正文
        Elements texts = parse.getElementsByClass("vF_detail_content");
        Elements textP = null;
        Elements textLi = null;
        if (texts != null && texts.size() > 0) {
            statusCode = StatusCodeEnum.NORMAL.getCode();
            Element textEle = texts.get(0);
            textP = textEle.getElementsByTag("p");
            //TODO 增加处理正文中table
            //    cellInfoList = TableDeal.tableSizeOverOne(tableList);
            if (textP == null || textP.size() < 3) {
                textLi = textEle.getElementsByTag("li");
                if (textLi == null || textLi.size() < 3) {
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
                    textP = textLi;
                }
                //    System.out.println(split1);
            }

        } else {

            //增加状态
            statusCode = StatusCodeEnum.M_DEL.getCode();

            textP = parse.getElementsByTag("p");
            //存在没有p标签标记, 直接 eg:http://www.ccgp.gov.cn/cggg/dfgg/gkzb/201403/t20140318_4055411.htm
            if (textP.size() < 10) {
                statusCode = StatusCodeEnum.PEOPLE_DEL.getCode();
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

        //再次验证
       /* if(textP.size() < 3){

            String replaceContent = StringUtil.replaceAll(content, "\\<div", "\\<p");
            parse = Jsoup.parse(replaceContent);
            textP = parse.getElementsByTag("p");
        }*/


        map = HtmlUtils.prasePToMap(textP);
       /* String text = textP.text();
        String[] s = text.split("  ");*/
        //   cellInfoList.addAll(cellInfoList2);
        Map map1 = HtmlUtils.plistToMap(cellInfoList);
        //       map = HtmlUtils.prasePToMap(p);
        //   map1.putAll(map);

        //在这判断中标供应商是否有多个

        //判断名称相同 值不同

        //是否可能存在多个供应商标识

        map.putAll(map1);

        CNGovCleanData cleanData = new CNGovCleanData();

        ConventUtils.govDataUrl2CleanData(data, cleanData);

        cleanData = (CNGovCleanData) ReflectionUtils.mapToField(map, cleanData, ContantCN.filedBJValueSet());

        //1.公告类别处理
        DataBusinessDel.categoryDel(cleanData);

        //2.地区字段处理
        cleanData.setRegion("湖北");
        DataBusinessDel.regionDel(cleanData);

        //3.品目 处理
        DataBusinessDel.itemsDel(cleanData);

        //4 .代理机构处理
        DataBusinessDel.agencyDel(cleanData);

        //5 .供应商处理
        DataBusinessDel.supplierDel(cleanData);

        //6 .公告重归类 处理
        DataBusinessDel.typeDel(cleanData);

        if (StringUtils.isBlank(cleanData.getPurchaser())) {
            System.err.print(" 采购人为空");
        }

        // 7.采购流程归类
        DataBusinessDel.processTypeDel(cleanData);

        DataBusinessDel.amountFix(cleanData);


        String supplier1 = cleanData.getSupplier();
        if (supplier1 != null && supplier1.length() > 80) {
            cleanData.setSupplier(null);
        }

        if (cleanData.getProNo() == null) {
            count++;
            //    System.out.println(count + cleanData.getProNo());
            logger.error(cleanData.getUrl() + "\n" + count);
        }


        if (cleanData.getProNo() == null || StringUtils.isBlank(cleanData.getProNo())) {
            cleanData.setProNo(StringUtil.getRandomProNo());
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


}
