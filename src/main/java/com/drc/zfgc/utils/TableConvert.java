package com.drc.zfgc.utils;

import com.drc.zfgc.model.TableCell;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableConvert {
    private static final Logger logger = LoggerFactory.getLogger(TableConvert.class);

    /**
     * 将表格进行二维展开
     *
     * @param table
     * @return
     */

    public static Element[][] toTable(Element table) {
        if (!table.nodeName().equals("table")) {
            return null;
        }

        Elements tableRows = table.getElementsByTag("tr");
        int tableHeight = tableRows.size();

        //找 展开的最大列数，存在问题：如果某一列 全部使用 colspan 且其值都 大于2，有可能出错
        int tableWidth = 0;
        for (int tr_idx = 0; tr_idx < tableHeight; tr_idx++) {
            Elements tds = tableRows.get(tr_idx).select("td, th");
            int colspanNum = 0;//合并列
            for (Element td : tds) {
                try {

                    if (td.hasAttr("colspan")) {
                        String attr = td.attr("colspan");
                        String get = RegExpUtil.regGet(attr, "[0-9]{1,}");
                        colspanNum = Integer.valueOf(get);
                    }
                }catch (Exception e){
                    String attr = td.attr("colspan");
              //      System.out.print(td.attr("colspan"));
                }
            }

            if (colspanNum > 0) {
                colspanNum--;
            }
            int td_size = tds.size() + colspanNum;
            if (td_size > tableWidth) {
                tableWidth = td_size;
            }
        }

        logger.debug("tableHeight:" + tableHeight + ";tableWidth:" + tableWidth);

        if (tableHeight < 2 || tableWidth < 2) {
            return null;
        }

        //定义二维数组
        Element[][] result = new Element[tableHeight][tableWidth];

        //使用canreplace 来占位
        for (int i = 0; i < tableHeight; i++) {
            for (int j = 0; j < tableWidth; j++) {
                result[i][j] = new Element(Tag.valueOf("canreplace"), "");
            }
        }


        //出现不规范的 colspan 则会出现   实际列数 > tableWidth ，直接抛出异常
        try {
            for (int rowIndex = 0; rowIndex < tableHeight; rowIndex++) {
                Elements colCells = tableRows.get(rowIndex).select("td, th");
//                System.out.println("row" + rowIndex + ":\n" + colCells);
                int pointIndex = 0;//列的索引real
                int realColIndex = -1; //解决 rowspan td 列转换后位置有时对应有误
                for (int colIndex = 0; colIndex < colCells.size(); colIndex++) {
                    Element currentCell = colCells.get(colIndex);
                    realColIndex++;
                    if (currentCell.hasAttr("colspan")) {
                        String attr = currentCell.attr("colspan");
                        String get = RegExpUtil.regGet(attr, "[0-9]{1,}");
                        Integer colspanVal = Integer.valueOf(get);
                        realColIndex = realColIndex + colspanVal - 1;
                    }
                    //放到二维数组
                    try {
                        if (result[rowIndex][colIndex].tagName().equalsIgnoreCase("canreplace")) {
                            result[rowIndex][colIndex] = currentCell;
                            pointIndex = colIndex;
                        } else {
                            pointIndex = colIndex + 1;
                            //查找可放置 一直找到一个可替换
                            pointIndex = getPointIndex(tableWidth, result, rowIndex, pointIndex, currentCell);
                            if(pointIndex == -1){
                                return null;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }

                    // 检查 colspan
                    int colspan = 1;
                    if (currentCell.hasAttr("colspan")) {
                        String attr = currentCell.attr("colspan");
                        String get = RegExpUtil.regGet(attr, "[0-9]{1,}");
                        colspan = Integer.valueOf(get);
                        currentCell.removeAttr("colspan");
                    }
                    //复制表格内容
                    if (colspan > 1) {
                        for (int emptyColindex = 1; emptyColindex < colspan; emptyColindex++) {
                            pointIndex++;
                            pointIndex = getPointIndex(tableWidth, result, rowIndex, pointIndex, currentCell);
                            /*if(pointIndex == -1){
                                return null;
                            }*/
                        }
                    }

                    // 检查rowspan
                    int rowspan = 1;
                    if (currentCell.hasAttr("rowspan")) {
                        String attr = currentCell.attr("rowspan");
                        String get = RegExpUtil.regGet(attr, "[0-9]{1,}");
                        rowspan = Integer.valueOf(get);
                        currentCell.removeAttr("rowspan");
                    }

                    if (rowspan > 1) {
                        for (int i = 1; i < rowspan; i++) {
                            if (i >= tableHeight) {
                                break; // ignore bad rowspans
                            }
                            //    logger.debug("===rowIndex===" + rowIndex + "====tempColIndex===" + pointIndex + "===" + result[rowIndex][pointIndex].tagName());
                            //	result[rowIndex + i][realColIndex] = currentCell;//new Element(invalidTag, "");
                            //	currentCell.html("/");
                            result[rowIndex + i][realColIndex] = currentCell;//new Element(invalidTag, "");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
         //   return null;
        }

        return result;
    }

    private static int getPointIndex(int tableWidth, Element[][] result, int rowIndex, int pointIndex, Element currentCell) throws Exception {

        while (pointIndex < tableWidth && !result[rowIndex][pointIndex].tagName().equalsIgnoreCase("canreplace")) {
            pointIndex++;
            //    logger.debug("===rowIndex===" + rowIndex + "====tempColIndex===" + pointIndex + "===" + result[rowIndex][pointIndex].tagName());

        }


        if (pointIndex < tableWidth && result[rowIndex][pointIndex].tagName().equalsIgnoreCase("canreplace")) {
            result[rowIndex][pointIndex] = currentCell;
        } else {
         //   logger.error("table格式不标准: " + currentCell.text());
          //  return -1;
         //   throw new Exception("table格式有错误！");
        }
        return pointIndex;
    }

    public static void main(String[] args) {

    }

    public static List<String> toList(Element ele) {
        List list = new ArrayList();
        Element[][] table = toTable(ele);
        if(table == null){
            return null;
        }
        for (int rowIndex = 1; rowIndex < table.length; rowIndex++) {
            //logger.debug("|");
            // sb.append("|");
            //   int rowIndex =0;
            for (int colIndex = 1; colIndex < table[rowIndex].length; colIndex++) {


                Element head = table[0][colIndex];
                Element element = table[rowIndex][colIndex];


                list.add(head.text() + ":" + element.text());
            }
            //   }


        }
        return list;
    }

    private static List<TableCell> printTable(Element[][] table) {
        if (table == null) {
            return null;
        }
        ;
        List<TableCell> cellList = new ArrayList<>();
        //    logger.debug("==================");
        StringBuilder sb = new StringBuilder("\n");
        for (int rowIndex = 0; rowIndex < table.length; rowIndex++) {
            //logger.debug("|");
            sb.append("|");
            for (int colIndex = 0; colIndex < table[rowIndex].length; colIndex++) {
                Element element = table[rowIndex][colIndex];

                TableCell cell = new TableCell();
                cell.setColIndex(colIndex);
                cell.setRowIndex(rowIndex);

                if (element == null) {
                    cell.setText(null);
                    sb.append(" ");
                    //    logger.debug("  ");
                } else {
                    cell.setText(element.text());
                    sb.append(element.text());
                    //    logger.debug(element.text());
                }
                cellList.add(cell);
                sb.append(" |");
                //    logger.debug(" |");
            }
            sb.append("\n");
        }

        logger.debug(sb.toString());
//        logger.debug(JSON.toJSONString(cellList));
        //    logger.debug("==================");

        return cellList;
    }

    public static List<TableCell> toCellList(Element table) {

        Element[][] elements = toTable(table);
        return printTable(elements);
    }


    /**
     * 表格 按照第一行为表头,拼接字符串
     *
     * @param tab
     */
    public static List tableToListStr(Element tab) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        //   Document tab = Jsoup.parse(table);
        Elements trs = tab.getElementsByTag("tr");
        Elements first = trs.first().children();
        for (int i = 1; i < trs.size(); i++) {
            Elements element = trs.get(i).getElementsByTag("td");
            Map<Integer, String> m = null;
            int size;
            if (element.size() == first.size()) {
                size = element.size();

            } else {
                size = element.size() > first.size() ? first.size() : element.size();
            }
            for (int j = 0; j < size; j++) {
                String name = first.get(j).text() + ":" + element.get(j).text();
             /*   if (element.get(j).hasAttr("colspan")) {
                    colSpanStr.append(element.get(j).text() + "|");
                    continue;
                    //  logger.info("has colspan = " + element.get(j).attr("colspan") + element.get(j).text());
                } */
                if (element.get(j).hasAttr("rowspan")) {
                    String num = (element.get(j)).attr("rowspan");
                    m = new HashMap();
                    //直接使用# 号可能会有问题
                    m.put(j, name + "#!$" + num);
                    //下次循环到该index 直接拼接本次str
                }
                if (m != null && m.containsKey(j)) {
                    String[] split = m.get(j).split("\\#\\!\\$");
                    if (Integer.valueOf(split[1]) < 1) {
                        m.remove(j);
                    } else {
                        name = first.get(j).text() + ":" + split[0];
                        m.put(j, name + "#!$" + (Integer.valueOf(split[1]) - 1));
                    }
                }
                sb.append(name);
                sb.append("|");
            }
        }
        String string = sb.toString();
        String[] split = string.split("\\|");
        for (String str : split) {
            if (str.contains(":")) {
                list.add(str);
            }

        }
        //   list.add(sb.toString());
        return list;
    }


}
