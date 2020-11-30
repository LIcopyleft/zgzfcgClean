package com.drc.zfgc.utils;

import com.drc.zfgc.enums.WinBidNoticeEnum;
import com.drc.zfgc.model.TableCell;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author tengchao.li
 * @description
 * @date 2020/3/31
 */
public class TableMarkHeader {

    //   private static Set set = new LinkedHashSet();
    private static final Logger logger = LoggerFactory.getLogger(TableMarkHeader.class);
    public static int[] markHeader(List<TableCell> tableCells) {
        int colMaxIndex = 0;
        int rowMaxIndex = 0;
        int[] maxIndex = new int[2];

        for (TableCell cell : tableCells) {

            if (cell.getColIndex() > colMaxIndex) {
                colMaxIndex = cell.getColIndex();
            }
            if (cell.getRowIndex() > rowMaxIndex) {
                rowMaxIndex = cell.getRowIndex();
            }

            String text = cell.getText();
            if (StringUtils.isNotBlank(text)) {
                //重要特殊字段
                if (cell.getText().contains("中标金额") || cell.getText().contains("成交金额") || cell.getText().contains("成交总价")) {
                    logger.debug("中标金额修正: "+text + "--> 中标金额");
                    cell.setText("中标金额");

                }
            }
            WinBidNoticeEnum type = WinBidNoticeEnum.getFiledType(cell.getText());
            if (type != null) {
                cell.setHeader(true);
                cell.setHeaderType(type.getHeaderType());
                cell.setRegexStr(type.getRegex().equals("提取正则表达式") ? null : type.getRegex());
                cell.setHeaderClass(type.getHeaderClass());
            }
            //     Iterator iterator = set.iterator();

        }
        //对表格列表二次校验，同行或者同列有 超过两个（或半数）为表头，且位于第一行或第一列 该行或改列视为表头
        int rowHeaderNum = 0;
        int colHeaderNum = 0;
        for (TableCell cell : tableCells) {
            if (0 == cell.getRowIndex() && cell.isHeader()) {
                rowHeaderNum++;
            }
            if (0 == cell.getColIndex() && cell.isHeader()) {
                colHeaderNum++;
            }

        }
        if (rowHeaderNum > colHeaderNum && rowHeaderNum > 1) {
            for (TableCell cell : tableCells) {
                if (cell.getRowIndex() == 0) {
                    cell.setHeader(true);
                }
            }
            logger.debug("判定为横向表头");
        } else if (rowHeaderNum < colHeaderNum && colHeaderNum > 1) {
            //取消判定整列为表头
            /*for (TableCell cell : tableCells) {
                if (cell.getColIndex() == 0) {
                    cell.setHeader(true);
                }
            }*/
            logger.debug("判定为纵向表头");
        } else {
            logger.debug("未自动判定");
        }


        maxIndex[0] = rowMaxIndex;
        maxIndex[1] = colMaxIndex;
        //       FileUtils.writeAppendFile("feild.txt", set);
        return maxIndex;
    }


    /**
     * 领属关系分析模块
     *
     * @param maxIndex
     * @param tableCells
     */
    public static void relationshipAnalysis(int[] maxIndex, List<TableCell> tableCells) {
        int rowMaxIndex = maxIndex[0];
        int colMaxIndex = maxIndex[1];

        for (TableCell cell : tableCells) {
           /* if("赛默飞世尔".equals(cell.getText())){
                System.out.println();
            }*/

            if (!cell.isHeader()) {
                Integer rowIndex = cell.getRowIndex();//行索引
                Integer colIndex = cell.getColIndex();//列索引
                // index 1 col and 1 row must is header !
                if (colIndex == 0 && rowIndex == 0) {
                    continue;
                }

                TableCell maybeHeaderCell = CellUtils.getMaybeHeaderCell(cell, tableCells);

                if (maybeHeaderCell != null) {
                    cell.setHeaderType(maybeHeaderCell.getHeaderType());
                    cell.setHeaderClass(maybeHeaderCell.getHeaderClass());

                } else {
                    // 为null 为表格第一行
                    cell.setHeaderType(cell.getText());
                    cell.setHeaderClass(cell.getText());
                }


            }
        }


    }

}

