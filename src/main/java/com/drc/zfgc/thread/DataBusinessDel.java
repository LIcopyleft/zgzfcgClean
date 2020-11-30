package com.drc.zfgc.thread;

import com.drc.zfgc.enums.StatusCodeEnum;
import com.drc.zfgc.enums.TypeStatusEnum;
import com.drc.zfgc.lisener.DataListener;
import com.drc.zfgc.model.*;
import com.drc.zfgc.utils.FieldUtils;
import com.drc.zfgc.utils.RegExpUtil;
import com.drc.zfgc.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author tengchao.li
 * @description
 * @date 2020/10/20
 */
public class DataBusinessDel {



    private static final Logger logger = LoggerFactory.getLogger(DataBusinessDel.class);
   // static DataContentMapper mapper = SpringContextHolder.getBean("dataContentMapper");

    /*
     * @description  公告类别
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void categoryDel(CNGovCleanData cleanData) {
        if(cleanData.getCategory().equals("htgg")){
           return;
        }
        String url = cleanData.getUrl();
        //公告类别
        String category = url.split("/")[4];
        cleanData.setCategory(category);
    }

    /*
     * @description  金额类型修正
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void amountFix(CNGovCleanData cleanData) {
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
    }


    /*
     * @description
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void processTypeDel(CNGovCleanData cleanData) {
        String finalType = cleanData.getFinalType();
        /*if (StringUtils.isBlank(finalType)){
            StringUtils.isBlank("");
        }*/
        if (StringUtils.isBlank(finalType)) {
            return;
        }

        if (finalType.contains("公开招标")
                || finalType.contains("询价公告")
                || finalType.contains("竞争性谈判")
                || finalType.contains("资格预审")
                || finalType.contains("单一来源")
                || finalType.contains("邀请公告")
                || finalType.contains("竞争性磋商")
        ) {
            cleanData.setProcessType("采购公告");

        } else if (finalType.contains("更正公告")) {
            cleanData.setProcessType("更正公告");
        } else if (finalType.contains("中标候选人公告")
                || finalType.contains("中标公告")
                || finalType.contains("成交公告")
        ) {
            cleanData.setProcessType("结果公告/中标结果公告");
        } else if (finalType.contains("废标终止")) {
            cleanData.setProcessType("结果公告/废标终止公告");
        } else if (finalType.contains("采购合同公告") || finalType.contains("合同公告")) {
            cleanData.setProcessType("合同公告");
        } else if (finalType.contains("其它公告") || finalType.contains("其他公告")) {
            cleanData.setProcessType("其它公告");
        }
    }


    /*
     * @description  公告类型处理
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void typeDel(CNGovCleanData cleanData) {
        String type = cleanData.getType();
        String title = cleanData.getTitle();
        if (StringUtils.isBlank(type) || StringUtils.isBlank(title)) {
            return;
        }

        if (type.contains("成交公告") || type.contains("中标公告")) {
            if (title.contains("中标候选")) {
                cleanData.setReType("中标候选人公告");
                cleanData.setReTypeStatus(TypeStatusEnum.DEAL.getCode());
            } else {
                cleanData.setReTypeStatus(TypeStatusEnum.NO_DEAL.getCode());
                cleanData.setReType(type);
            }

        } else if (type.contains("其它公告") || type.contains("其他公告")) {
            cleanData.setReTypeStatus(TypeStatusEnum.OTHER_ROBOT_PRE_DEAL.getCode());
            if (title.contains("合同公告")) {
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
            } else if (title.contains("更正公告")) {
                cleanData.setReType("更正公告");
            } else {
                cleanData.setReTypeStatus(TypeStatusEnum.OTHER_ROBOT_NO_PRE_DEAL.getCode());
                cleanData.setReType(type);
            }

        } else {
            cleanData.setReType(type);
            cleanData.setReTypeStatus(TypeStatusEnum.NO_DEAL.getCode());
        }

        if (StringUtils.isNotBlank(title)) {
            if (title.contains("ppp") || title.contains("PPP")) {
                cleanData.setIsPpp(true);
            }

        }

    }


    /*
     * @description  供应商处理
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void supplierDel(CNGovCleanData cleanData) {
        String supplier = cleanData.getSupplier();
        if (StringUtils.isNotBlank(supplier)) {

            //TODO mapper.get()
            //生成code
            //    cleanData.setSupplierCode("code");
            //  cleanData.setAgencyId();
            //mapper.insertAgency()

        }
    }


    /*
     * @description  代理机构处理
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void agencyDel(CNGovCleanData cleanData) {
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
                //    mapper.insertCompany(info);
            } else {

                //   System.out.print("后续从工商信息中获取");

            }
            //    StringUtil.getCompanyCode();

            //  cleanData.setAgencyId();
            //mapper.insertAgency()

        }
    }

    /*
     * @description  品目处理
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void itemsDel(CNGovCleanData cleanData) {
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
    }

    /*
     * @description  地区处理
     * @author tengchao.li
     * @date 2020/10/20
     * @param cleanData
     * @return void
     */
    public static void regionDel(CNGovCleanData cleanData) {
        //2 .行政区域处理
    //    String regionName = cleanData.getRegion();
        //根据id 查询

        //判断地区等级  非省级补全 上级
        String purchaserAddr = cleanData.getPurchaserAddr();
    //    String agencyAddr = cleanData.getAgencyAddr();
        if (purchaserAddr == null || StringUtils.isBlank(purchaserAddr) || purchaserAddr.length() < 3) {
            purchaserAddr = cleanData.getOpenBiddingAddr();
        }
        if (purchaserAddr == null) {
            purchaserAddr = cleanData.getTitle();

        }
        if ("市辖区".equals(cleanData.getRegion())) {
            //获取市级行政区
            String regionStr = fromAddrGetRegionStr(purchaserAddr, 2);
            //    List<Region> regions = mapper.selectRegionByName(regionStr);
            //    河北省、山西省、辽宁省、吉林省、黑龙江省、江苏省、浙江省、安徽省、福建省、江西省、山东省、河南省、湖北省、湖南省、广东省、海南省、四川省、贵州省、云南省、陕西省、甘肃省、青海省、台湾省
            if (StringUtils.isBlank(regionStr)){
                regionStr = cleanData.getOther4();
                regionStr = regionStr+"省/"+regionStr+"市/"+regionStr+"区/"+regionStr+"县";
            }

            List<Region> regionList = DataListener.getRegionList();
            for (Region reg : regionList) {
                if ("城区".equals(reg.getName())) {
                    continue;
                }
                if (regionStr.contains(reg.getName()) && reg.getIsRepeat().equals("0")) {
                    cleanData.setRegion(reg.getName());
                    break;
                } else if (regionStr.contains(reg.getName()) && reg.getIsRepeat().equals("1")) {
                    regionStr = fromAddrGetRegionStr(reg.getName(), 3);
                    //    System.err.print("地区信息为找到======");
                }

            }
            //  String addr = RegExpUtil.getAddr(purchaserAddr, 2);
        }

        List<Region> regions = DataListener.getRegionByName(cleanData.getRegion());

        //    List<Region> regions = mapper.selectRegionByName(regionName);
        if (regions != null && regions.size() > 0) {
            regionListDel(cleanData, purchaserAddr, regions);

        } else {
            //未直接获取到行政区域或者
            String tempName = fromAddrGetRegionStr(purchaserAddr, 3);

            List<Region> regionList = DataListener.getRegionByName(tempName);
            //    List<Region> regionList = mapper.selectRegionByName(tempName);

            if (regionList.size() < 1) {
                regionList = DataListener.getRegionByName(cleanData.getOther4());
                // regionList = mapper.selectRegionByName(cleanData.getOther4());
            }

            regionListDel(cleanData, purchaserAddr, regionList);
        }
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
        if (regions != null && regions.size() == 1) {
            Region reg = regions.get(0);
            setRegionInfo(cleanData, reg);
        } else {
            //有重名并且采购人地址为空
            if (StringUtils.isBlank(purchaserAddr)) {
                System.err.print("有重名并且采购人地址为空 =============== 未处理id : " + cleanData.getUrlId());
                return;
            }

            if(regions == null){
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

            Region parReg = DataListener.getRegionByRegionId(reg.getParentId());
            //   Region parReg = mapper.selectRegionByRegionId(reg.getParentId());
            cleanData.setRegion1(parReg.getName());
            cleanData.setRegion2(reg.getName());
            cleanData.setRegionId(reg.getRegionId());

        } else if (reg.getLevel().equals("3")) {
            Region parReg = DataListener.getRegionByRegionId(reg.getParentId());
            Region parparReg = DataListener.getRegionByRegionId(reg.getParentId());
           /* Region parReg = mapper.selectRegionByRegionId(reg.getParentId());
            Region parparReg = mapper.selectRegionByRegionId(parReg.getParentId());
*/
            cleanData.setRegion1(parparReg.getName());
            cleanData.setRegion2(parReg.getName());
            cleanData.setRegion3(reg.getName());

            cleanData.setRegionId(reg.getRegionId());
        }
    }

    /*
     * @description  交易阶段处理
     * @author tengchao.li
     * @date 2020/10/21
     * @param cleanData
     * @return void
     */
    public static void processStageDel(CNGovCleanData cleanData) {

        String processType = cleanData.getProcessType();

        if (processType == null) {
            return;
        }
        if ("采购公告".equals(processType)) {
            cleanData.setTransactionStage("采购阶段");
        } else if (processType.contains("中标结果")) {
            cleanData.setTransactionStage("中标结果");
        } else if (processType.contains("废标终止")) {
            cleanData.setTransactionStage("废标终止");
        } else if (processType.contains("合同公告")) {
            cleanData.setTransactionStage("合同阶段");
        } else {
            cleanData.setTransactionStage(null);
        }

    }

    public static void purchaseMethod(CNGovCleanData cleanData) {
        String type = cleanData.getReType();
        String processType = cleanData.getProcessType();

        if (type == null || processType == null) {
            return;
        }

        if (processType.equals("采购公告")) {
            if (type.contains("询价公告") ||
                    type.contains("竞争性谈判") ||
                    type.contains("单一来源") ||
                    type.contains("资格预审") ||
                    type.contains("邀请")
            ) {
                cleanData.setPurchasingMethod(type);
            } else {
                cleanData.setPurchasingMethod(null);
            }
        }


    }

    public static void main(String[] args) {
        CNGovCleanData cleanData = new CNGovCleanData();
        cleanData.setTitle("广西桂水工程咨询有限公司上林县政府机关大院物业服务项目[项目编号：NNZC2020-C3-00002-GSZX]成交公告");
        proNoDel(cleanData);
        System.out.println();
    }


    public static void proNoDel(CNGovCleanData cleanData) {
        if (StringUtils.isNotBlank(cleanData.getProNo()) ) {
            return;
        }
        String regex = "[\\w-]{0,}[\\-|\\[|\\]|/|\\(|\\)]{0,}[\\w-]{0,}[\\[|\\[|\\]|/|(|)]?([\\w-]{0,})";
        if (cleanData.getProNo() == null || StringUtils.isBlank(cleanData.getProNo())) {

            if (cleanData.getTitle() != null) {
                List<String> mayBeProNoLst = RegExpUtil.getMatchers(cleanData.getTitle(), regex);
                for (String proNo : mayBeProNoLst) {

                    if (proNo == null || proNo.length() < 5) {
                        continue;
                    }
                    cleanData.setNotice(String.valueOf(StatusCodeEnum.ROBOT_PRO_NO.getCode()));
                    cleanData.setProNo(proNo);
                    return;
                }

            }
        }
        cleanData.setNotice(String.valueOf(StatusCodeEnum.NO_PRO_NO.getCode()));
        cleanData.setProNo(StringUtil.getRandomProNo());
    }

    public static void cleanStatusDel(CNGovCleanData cleanData, List<String> cellInfoList) {

        if (!"中标公告".equals(cleanData.getType()) && !"成交公告".equals(cleanData.getType())) {
            return;
        }

        for (String str : cellInfoList) {

            if ((str.contains("A包") && str.contains("B包")) ||(str.contains("包1") && str.contains("包2")) || str.contains("第一中标人") || str.contains("第一中标候选人")) {

                cleanData.setNotice(String.valueOf(StatusCodeEnum.WIN_BID_INFO_NO_OK.getCode()));
            }

        }


        //   cleanData.setNotice(StatusCodeEnum.);

    }

    public static void finalTypeDel(CNGovCleanData cleanData) {

        String reType = cleanData.getReType();
        if(reType == null){
            return;
        }else if(reType.contains("招标公告") ||reType.contains("公开招标")){
            cleanData.setFinalType("公开招标");
        }else if(reType.contains("询价公告") || reType.contains("询价")){
            cleanData.setFinalType("询价公告");
        }else if(reType.contains("竞争性谈判")){
            cleanData.setFinalType("竞争性谈判");
        }else if(reType.contains("中标结果") || reType.contains("中选结果")|| reType.contains("中标公告")|| reType.contains("公开招标结果")){
            cleanData.setFinalType("中标公告");
        }else if(reType.contains("成交公告") || reType.contains("结果公告")){
            cleanData.setFinalType("成交公告");
        }else if(reType.contains("单一来源")){
            cleanData.setFinalType("单一来源");
        }else if(reType.contains("资格预审") ){
            cleanData.setFinalType("资格预审");
        }else if(reType.contains("邀请招标") ){
            cleanData.setFinalType("邀请公告");
        }else if(reType.contains("磋商") ){
            cleanData.setFinalType("竞争性磋商");
        }else if(reType.contains("终止公告") ){
            cleanData.setFinalType("终止公告");
        }else if(reType.contains("更正公告") ){
            cleanData.setFinalType("更正公告");
        }else if(reType.contains("中标候选人") ){
            cleanData.setFinalType("中标候选人公告");
        }else if(reType.contains("合同公告") ){
            cleanData.setFinalType("合同公告");
        }else if(reType.contains("其它公告") || reType.contains("其他公告") ){
            cleanData.setFinalType("其它公告");
        }else{
            cleanData.setFinalType(null);
            cleanData.setReTypeStatus(TypeStatusEnum.OTHER_ROBOT_NO_PRE_DEAL.getCode());
        }

    }
}
