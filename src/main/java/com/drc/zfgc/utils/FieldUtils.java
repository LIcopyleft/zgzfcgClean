package com.drc.zfgc.utils;

import cn.hutool.core.util.StrUtil;
import com.drc.zfgc.model.GovData;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author tengchao.li
 * @description 标准化处理时间, 金额 等字段
 * @date 2020/5/15
 */
public class FieldUtils {

    private static final String p_amount_d = "[零圆元角分壹贰叁肆伍陆柒捌玖拾佰仟万亿整]+";
    //需要去掉 逗号(,)匹配
    private static final String p_amount_x = "-?([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,})?";
    public static final String p_date = "\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}|\\d{4}(年)\\d{1,2}月\\d{1,2}日{0,}";
    private static final String p_phone = "\\d{0,4}(—|-){0,1}\\d{8}|\\d{11}";
    private static final String p_remove_lxdh = "[\\u4e00-\\u9fa5]{0,}:";
    private static final String p_name = "[\\u4e00-\\u9fa5]{2,3}|[\\u4e00-\\u9fa5]{1}(  | )[\\u4e00-\\u9fa5]{1,2}";
    private static final String p_zipcode = "[1-9]\\d{5}";

    //－

    private static final Logger logger = LoggerFactory.getLogger(FieldUtils.class);


    public static String formatAmount(String amt) {
        //    System.out.println(String.format("%.2f", f));
      /*  String budgetAmount = data.getBudgetAmount();
        String winBidAmount = data.getWinBidTotalAmount();
*/
        String formatAmount = null;
        if (amt == null || StringUtils.isBlank(amt)) {
            return null;
        }
        amt = amt.replaceAll("，", "").replaceAll(",", "");

        logger.debug("待格式化金额 : " + amt);


//        logger.debug(winBidAmount);
        List<String> dAmountList = RegExpUtil.getMatchers(amt, p_amount_d);
        String xAmount = RegExpUtil.regGet(amt, p_amount_x);

        if (xAmount != null && xAmount.contains("包")) {
            return amt;
        }

        //      int unit = 0;
        if (dAmountList.size() > 0) {
            for (String amount : dAmountList) {
                if ("元".equals(amount)) {
                    continue;
                } else if ("万元".equals(amount) || "万".equals(amount)) {
                    //     unit = 10000;
                    try {

                        if (xAmount != null && StringUtils.isNotBlank(xAmount)) {
                            xAmount = StrUtil.cleanBlank(xAmount);
                            BigDecimal b = new BigDecimal(xAmount);
                            BigDecimal multiply = b.multiply(BigDecimal.valueOf(10000)).setScale(2, BigDecimal.ROUND_HALF_UP);
                            //   data.setBudgetAmount(multiply.toString());
                            formatAmount = multiply.toString();
                            return formatAmount;
                        } else {
                            continue;
                        }
                    } catch (Exception e) {
                        logger.error("格式化出错:" + amt, e.fillInStackTrace());
                        if (amt != null && amt.length() > 50) {
                            return amt.substring(0, 50);
                        }
                        return amt;
                        //   return null;
                    }

                }

                String parse = MoneyUtils.rmbBigToSmall(amount);
                if (parse == null || "0.0".equals(parse)) {
                    formatAmount = xAmount;
                } else {
                    formatAmount = parse;
                }
                logger.debug("格式化后 : " + formatAmount);

            }

        }
        if (formatAmount == null) {
            formatAmount = xAmount;
        }

        //    String.format("%.2f", formatAmount);
        if (formatAmount == null) {
            return null;
        }
        try {


            BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(formatAmount)).setScale(2, BigDecimal.ROUND_HALF_UP);

            //判断金额  金额一般不会低于1000 , 修正未获取到单位而导致的金额不对 . 低于1000 则金额乘以 10000
            if (bigDecimal.compareTo(new BigDecimal(1000)) < 0) {
                logger.debug("自动修正金额");
                BigDecimal amount = bigDecimal.multiply(new BigDecimal(10000));
                bigDecimal = amount;
            }

            logger.debug("格式化后 : " + bigDecimal.toString());
            return bigDecimal.toString();
        } catch (Exception e) {
            return null;
        }
        //    Number parse = AmountFormatUtils.parse(dAmount);
    }

    public static String formatDate(String time) {

        if (time == null || StringUtils.isBlank(time)) {
            return null;
        }

        String dateStr = RegExpUtil.regGet(time, p_date);
        if (dateStr == null) {
            return null;
        }

        dateStr = dateStr.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "");

        Date date = DateUtils.strToDate(dateStr);
        try {
            dateStr = DateUtils.parseDateToStr(date, DateUtils.YYYY_MM_DD);
        } catch (Exception e) {
            return null;
        }

        return dateStr;
    }

    /**
     * 可能包含电话字符串获取 电话
     *
     * @param phoneStr
     * @return
     */
    public static String getPhone(String phoneStr) {

        if (phoneStr == null || StringUtils.isBlank(phoneStr)) {
            return null;
        }
        phoneStr = phoneStr.replaceAll("－", "-");
        String phone = RegExpUtil.regGet(phoneStr, p_phone);
        return phone;
    }

    public static void formatContact(GovData data) {

        String proContact = data.getProContact();
        String phone = getPhone(proContact);
        if (phone != null && StringUtils.isNotBlank(phone)) {
            data.setProPhone(phone);
        }

        if (data.getProPhone() != null && StringUtils.isNotBlank(data.getProPhone())) {
            String proPhone = data.getProPhone();
            List<String> matchers = RegExpUtil.getMatchers(proPhone, p_phone);
            String join = String.join(",", matchers);
            data.setProPhone(join);
        }


       /* String s = proContact.replaceAll("：", ":").replaceAll(p_remove_lxdh, "").replaceAll(p_phone, "");
        String blank = StrUtil.cleanBlank(s);
        List<String> matchers = RegExpUtil.getMatchers(p_name, blank);*/

        List<String> name = getName(proContact);
        if (name != null) {
            String join = String.join(",", name);
            data.setProContact(join);
        }


        data.setBuyingOrg(data.getBuyingOrg() == null ? null : data.getBuyingOrg().trim());
        data.setBuyingAddr(data.getBuyingAddr() == null ? null : data.getBuyingAddr().trim());
        data.setProxyOrgName(data.getProxyOrgName() == null ? null : data.getProxyOrgName().trim());
        data.setProxyOrgAddr(data.getProxyOrgAddr() == null ? null : data.getProxyOrgAddr().trim());
        data.setWinBidBisAddr(data.getWinBidBisAddr() == null ? null : data.getWinBidBisAddr().trim());
        data.setWinBidBisName(data.getWinBidBisName() == null ? null : data.getWinBidBisName().trim());
        data.setProName(data.getProName() == null ? null : data.getProName().trim());
        data.setProNo(data.getProNo() == null ? null : data.getProNo().trim());
        data.setZipcode(data.getZipcode() == null ? null : RegExpUtil.regGet(data.getZipcode(), p_zipcode));
        data.setWinBidBisName(data.getWinBidBisName() == null ? null : data.getWinBidBisName().length() > 100 ? null : data.getWinBidBisName());
        String expertName = data.getExpertName();
        List<String> names = getName(expertName);

        data.setExpertName(names == null ? null : String.join(",", names));

        //  [\u4e00-\u9fa5]{2,3}

        String proxyOrgPhone = data.getProxyOrgPhone();
        if (proxyOrgPhone != null && StringUtils.isNotBlank(proxyOrgPhone)) {
            data.setProxyOrgPhone(proxyOrgPhone);
        }

        if (data.getProxyOrgPhone() != null && StringUtils.isNotBlank(data.getProxyOrgPhone())) {
            String proPhone = data.getProxyOrgPhone();
            List<String> matchers = RegExpUtil.getMatchers(proPhone, p_phone);
            String join = String.join(",", matchers);
            data.setProxyOrgPhone(join);
        }
    }

    public static List<String> getName(String name) {

        if (name != null && StringUtils.isNotBlank(name)) {
            List<String> list = new ArrayList<>();
            name = name.replaceAll("：", ":").replaceAll(p_remove_lxdh, "").replaceAll(p_phone, "");
            List<String> matchers = RegExpUtil.getMatchers(name, p_name);
            if (matchers != null) {
                for (String str : matchers) {
                    System.err.println(str + "++++++++++QIAN++++++++++++");
                    str = str.replaceAll(String.valueOf((char) 160), "").replaceAll(String.valueOf((char) 32), "");
                    System.err.println(str + "++++++++++HOU++++++++++++");
                    list.add(str);
                }

                return list;
            }

        }
        return null;
    }


    public static void formatDateAndTime(GovData data) {
        if (data == null) {
            return;
        }


        String budgetAmount = FieldUtils.formatAmount(data.getBudgetAmount());
        String winBidAmount = FieldUtils.formatAmount(data.getWinBidTotalAmount());
        String filePrice = FieldUtils.formatAmount(data.getTenderingFilePrice());

        data.setBudgetAmount(budgetAmount);
        // data.setWinBidBisAmount(winBidAmount);
        data.setWinBidTotalAmount(winBidAmount);
        //修正价格判断时, 小于1000 乘以 万操作
        if (StringUtils.isNotBlank(filePrice)) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(filePrice));
            if (bigDecimal.compareTo(BigDecimal.valueOf(10000)) > 0) {
                filePrice = bigDecimal.divide(BigDecimal.valueOf(10000)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
            }
        }
        data.setTenderingFilePrice(filePrice);

        String noticeTime = FieldUtils.formatDate(data.getNoticeTime());
        String pubtime = FieldUtils.formatDate(data.getPubTime());
        String entitlecCheckTime = FieldUtils.formatDate(data.getEntitledCheckTime());
        String firstNoticeTime = FieldUtils.formatDate(data.getFirstNoticeTime());
        String obtainFileTime = FieldUtils.formatDate(data.getObtainFileTime());
        String winBidTime = FieldUtils.formatDate(data.getWinBidTime());
        String resFileOpenTime = FieldUtils.formatDate(data.getResFileOpenTime());
        String resFileSubTime = FieldUtils.formatDate(data.getResFileSubTime());
        String tenderingNoticeTime = FieldUtils.formatDate(data.getTenderingNoticeTime());
        String subFileDeadTime = FieldUtils.formatDate(data.getSubmitFileDeadTime());
        String openTenderTime = FieldUtils.formatDate(data.getOpentendertime());

        data.setNoticeTime(noticeTime);
        data.setPubTime(pubtime);
        data.setWinBidTime(winBidTime);
        data.setEntitledCheckTime(entitlecCheckTime);
        data.setFirstNoticeTime(firstNoticeTime);
        data.setObtainFileTime(obtainFileTime);
        data.setTenderingNoticeTime(tenderingNoticeTime);
        data.setResFileOpenTime(resFileOpenTime);
        data.setResFileSubTime(resFileSubTime);
        data.setSubmitFileDeadTime(subFileDeadTime);
        data.setOpentendertime(openTenderTime);
    }


}
