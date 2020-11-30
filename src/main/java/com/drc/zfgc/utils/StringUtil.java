package com.drc.zfgc.utils;

import com.drc.zfgc.lisener.DataListener;
import com.drc.zfgc.model.CompanyInfo;
import com.drc.zfgc.model.Region;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tengchao.li
 * @description
 * @date 2020/8/27
 */
public class StringUtil {

    final static String TEMP_STR = "000000000000000000";
    final static String SEED_STR = "DRC";

    public static String getCompanyCode(String codeType, String regionCode, CompanyInfo companyInfo) {

      /*  编码组成：编码类型（1位）+地区编码（6位）+企业信用代码/工商注册码（18位）。
        编码类型：1表示第8-25位以后是企业信用代码，0表示8-25是工商注册码。
        地区编码：行政区划编码，用省级行政区划代码*/

        // int  = compCode.length();
        String compCode = companyInfo.getBizlicregno();

        if(regionCode == null || StringUtils.isBlank(regionCode)){

            String addr = RegExpUtil.getAddr(companyInfo.getAuditplace(), 1);
            Region region = DataListener.getRegionByName(addr, 1);
            if (region!=null){
                regionCode = region.getRegionId();
            }

            regionCode = regionCode.substring(0,2) + "0000";

        }else{
            regionCode = regionCode.substring(0,2) + "0000";
        }

        String code = codeType + regionCode;
        if (compCode.length() < 18) {
            compCode = TEMP_STR.substring(0, 18 - compCode.length()) + compCode;
        }
        return code + compCode;

    }

    public static String getRandomProNo() {


        String uuid = UUID.randomUUID().toString().split("-")[3];
        String proNo = SEED_STR +"-"+ System.currentTimeMillis()+"-"+uuid;
        return proNo;
    }


    public static void fixSpacialString(Map map, List<String> cellInfoList) {
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
    }


    public static void main(String[] args) {
   //     String companyCode = getCompanyCode("1", "222222", "111");
     //   System.out.print(getRandomProNo());


    }


    /**
     * 获取32位UUID
     *
     * @return 32位UUID
     */
    public static String get32UUID() {
        UUID uuid = UUID.randomUUID();
        String uuid32 = uuid.toString().replace("-", "");
        return uuid32;
    }

    /**
     * 判断字符串是否包含汉字
     */
    public static boolean containsChinese(String source) {
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher matcher = pattern.matcher(source);
        boolean contains = false;
        if (matcher.find()) {
            contains = true;
        }
        return contains;
    }

    /**
     * 去掉结尾字符串
     */
    public static String deleteLastChar(String source, String target) {
        if (null != source && target != null && source.length() > 0) {
            if (source.lastIndexOf(target) == source.length()
                    - target.length()) {
                return source.substring(0, source.length() - target.length());
            }
        }
        return source;
    }

    ;

    /**
     * 以索引位置分隔
     */
    public static String[] splitByIndex(String source, int index) {
        String[] result = new String[2];
        result[0] = source.substring(0, index);
        result[1] = source.substring(index);
        return result;
    }

    /**
     * 获取首字母大写
     */
    public static String firstLetterUpperCase(String source) {
        return source.substring(0, 1).toUpperCase() + source.substring(1);
    }


    /**
     * 获取首字母小写
     */
    public static String firstLetterLowerCase(String source) {
        return source.substring(0, 1).toLowerCase() + source.substring(1);
    }

    /**
     * 删除Html标签
     */
    public static String removeHtmlTag(String htmlStr) {
        // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
        String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
        String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        // 定义HTML标签的正则表达式
        String regEx_html = "<[^>]+>";
        // 定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        String regEx_special = "\\&[a-zA-Z]{1,10};";

        // 1.过滤script标签
        Pattern p_script = Pattern.compile(regEx_script,
                Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        // 2.过滤style标签
        Pattern p_style = Pattern.compile(regEx_style,
                Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        // 3.过滤html标签
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        // 4.过滤特殊标签
        Pattern p_special = Pattern.compile(regEx_special,
                Pattern.CASE_INSENSITIVE);
        Matcher m_special = p_special.matcher(htmlStr);
        htmlStr = m_special.replaceAll("");

        return htmlStr;
    }

    public static String removeEleProp(String htmlStr) {
        final String regEx_tag = "<(\\w[^>|\\s]*)[\\s\\S]*?>";
        Pattern p = Pattern.compile(regEx_tag, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(htmlStr);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String tagWithProp = m.group(0);
            String tag = m.group(1);
            if ("img".equals(tag)) {
                // img标签保留属性，可进一步处理删除无用属性，仅保留src等必要属性
                m.appendReplacement(sb, tagWithProp);
            } else if ("a".equals(tag)) {
                // a标签保留属性，可进一步处理删除无用属性，仅保留href等必要属性
                m.appendReplacement(sb, tagWithProp);
            } else {
                m.appendReplacement(sb, "<" + tag + ">");
            }
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 去除空格
     */
    public static String removeSpace(String source) {
        source = replaceSpace(source).replaceAll("\\s+", "");
        return source;
    }

    /**
     * 替换空格
     */
    public static String replaceSpace(String source) {
        source = source.replaceAll("\t", " ");
        source = source.replaceAll("\r", " ");
        source = source.replaceAll("\n", " ");
        source = source.replaceAll("\\s+", " ");
        source = source.trim();
        return source;
    }

    /**
     * 去除emoji
     */
    public static String removeEmoji(String source) {
        while (true) {
            Integer pos = source.indexOf("\uD83D");
            if (pos == -1) {
                pos = source.indexOf("\uD83C");
            }
            if (pos != -1) {
                source = source.substring(0, pos) + source.substring(pos + 2);
            } else {
                return source;
            }
        }
    }

    /**
     * 替换符号为目标字符串
     */
    public static String StringFilter(String source, String target) {
        // 符号的正则表达式
        final String regex = "[\\pP\\p{Punct}￥ ]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(source);
        return m.replaceAll(target).trim();
    }

    public static String removeSpecial(String text) {
        if (text == null) {
            return "";
        }
        // 过滤script标签
        text = Pattern.compile(
                "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>",
                Pattern.CASE_INSENSITIVE).matcher(text).replaceAll("");

        // 过滤style标签
        text = Pattern.compile(
                "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>",
                Pattern.CASE_INSENSITIVE).matcher(text).replaceAll("");

        // 过滤table标签
        Matcher tableMatcher = Pattern.compile(
                "<[\\s]*?table[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?table[\\s]*?>",
                Pattern.CASE_INSENSITIVE).matcher(text);
        while (tableMatcher.find()) {
            String table = tableMatcher.group();
            Matcher pMatcher = Pattern.compile(
                    "<[\\s]*?p[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?p[\\s]*?>",
                    Pattern.CASE_INSENSITIVE).matcher(table);
            StringBuffer ps = new StringBuffer();
            while (pMatcher.find()) {
                String p = pMatcher.group();
                ps.append(p);
            }
            text = text.replace(table, ps.toString());
        }

        // 过滤特殊标签
        text = Pattern.compile("\\&[a-zA-Z]+;", Pattern.CASE_INSENSITIVE)
                .matcher(text).replaceAll("");

        // 过滤低位字符
        text = text.replaceAll("\t", "").replaceAll("\r", "")
                .replaceAll(" ", "").replaceAll("　", "");
        // 过滤div/p标签
        text = Pattern.compile("<[\\s]*?\\/?[\\s]*?(div|p)[^>]*?>",
                Pattern.CASE_INSENSITIVE).matcher(text).replaceAll("\n");

        // 过滤html标签
        text = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE)
                .matcher(text).replaceAll("");

        // 过滤首末低位字符
        text = text.trim().replaceAll("\n+", "\n");

        return text;
    }


    static String str16 = "0000000000000000";

   /* public static void main(String[] args) {
        getRowKey("1");
        System.out.println(getRowKey("1"));
    }*/

    public static String getRowKey(String key) {
        if (key == null){
            return str16;
        }
        if (key.length() < 16) {
            return str16.substring(0, 16 - key.length()) + key;
        }
        return key;
    }

    public static String replaceAll(String theString, String toReplace, String replacement) {

        if (theString == null) {
            return null;
        } else if (theString.indexOf(toReplace) == -1) {
            return theString;
        } else {
            StringBuilder stringBuilder = new StringBuilder(theString);
            int index = theString.length();
            int offset = toReplace.length();

            while((index = theString.lastIndexOf(toReplace, index - 1)) > -1) {
                stringBuilder.replace(index, index + offset, replacement);
            }

            return stringBuilder.toString();
        }
    }
}
