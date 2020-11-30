package com.drc.zfgc.utils;

import com.drc.zfgc.flink.FlinkHiveHbaseCleanDataMain;
import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.model.CNGovDataUrl;

import java.util.Map;

/**
 * @author tengchao.li
 * @description
 * @date 2020/8/26
 */
public class ConventUtils {


    public static void govDataUrl2CleanData(CNGovDataUrl source, CNGovCleanData target) {


        //   CNGovCleanData target = new CNGovCleanData();
        target.setUrlId(source.getUrlId());
        target.setPurchaser(source.getPurchaser());
        target.setCategory(source.getCategory());
        target.setNotice(source.getNotice());
        target.setUrl(source.getUrl());
        target.setTitle(source.getTitle());
        target.setAgency(source.getAgency());
        target.setItems(source.getCategoryUrl() != null ? source.getCategoryUrl() : source.getItems());
        target.setHashcode(source.getHashcode());
        target.setType(source.getType());
        target.setPubTime(source.getPubtime());
        //    target.setOther4(source.getAddress()==null?source.getRegion() : source.getAddress());
        target.setRegion(source.getAddress() == null ? source.getRegion() : source.getAddress());
        target.setTextContent(source.getContent());
        target.setContractSigningTime(source.getContractSigningTime());
        target.setSupplier(source.getSupplier());
   /*    target.setpurchasingMethod(source.getpurchasingMethod());
       target.setRegionId(source.getRegionId());
       target.setRegion(source.getRegion());
       target.setRegion1(source.getRegion1());
       target.setRegion2(source.getRegion2());
       target.setRegion3(source.getRegion3());
       target.setProName(source.getProName());
       target.setProNo(source.getProNo());
       target.setAgencyCode(source.getAgencyCode());
       target.setAgencyId(source.getAgencyId());
       target.setSupplier(source.getSupplier());
       target.setSupplierCode(source.getSupplierCode());
       target.setSupplierId(source.getSupplierId());
       target.setReType(source.getReType());
       target.setReTypeStatus(source.getReTypeStatus());
       target.setTransactionStage(source.getTransactionStage());
       target.setProcessType(source.getProcessType());
       target.setObtainPurchasingFileAddr(source.getObtainPurchasingFileAddr());
       target.setObtainPurchasingFileTime(source.getObtainPurchasingFileTime());
       target.setOther1(source.getOther1());
       target.setOther2(source.getOther2());
       target.setOther3(source.getOther3());
       target.setOther4(source.getOther4());
       target.setResFileOpenTime(source.getResFileOpenTime());
       target.setResFileOpenAddr(source.getResFileOpenAddr());
       target.setResFileSubAddr(source.getResFileSubAddr());
       target.setSubFileDeadTime(source.getSubFileDeadTime());
       target.setprequalificationTime(source.getprequalificationTime());
       target.setFristPubTime(source.getFristPubTime());
       target.setProPubTime(source.getProPubTime());
       target.setObtainBiddingFileTime(source.getObtainBiddingFileTime());
       target.setObtainBiddingFileAddr(source.getObtainBiddingFileAddr());
       target.setBiddingFilePrice(source.getBiddingFilePrice());
       target.setOpenBiddingTime(source.getOpenBiddingTime());
       target.setOpenBiddingAddr(source.getOpenBiddingAddr());
       target.setUpdateTime(source.getUpdateTime());
       target.setWinBiddingTime(source.getWinBiddingTime());
       target.setExpertName(source.getExpertName());
       target.setIsPpp(source.getIsPpp());
       target.setBudgetAmount(source.getBudgetAmount());
       target.setBudgetAmountCurrency(source.getBudgetAmountCurrency());
       target.setBudgetAmountUnit(source.getBudgetAmountUnit());
       target.setContractSigningTime(source.getContractSigningTime());
       target.setWinBiddingTotalAmount(source.getWinBiddingTotalAmount());
       target.setWinBiddingTotalAmountUnit(source.getWinBiddingTotalAmountUnit());
       target.setProConnect(source.getProConnect());
       target.setProConnectPhone(source.getProConnectPhone());
       target.setPurchaserAddr(source.getPurchaserAddr());
       target.setPurchaserPhone(source.getPurchaserPhone());
       target.setAgencyAddr(source.getAgencyAddr());
       target.setAgencyPhone(source.getAgencyPhone());
       target.setWinBiddingSupplier(source.getWinBiddingSupplier());
       target.setWinBiddingSupplierPhone(source.getWinBiddingSupplierPhone());
       target.setWinBiddingSupplierAddr(source.getWinBiddingSupplierAddr());
       target.setSummaryAnnex(source.getSummaryAnnex());
       target.setTextAnnex(source.getTextAnnex());*/
        //  target.target

    }


    public static void cleanDataLengthDel(CNGovCleanData data) {


        //       CNGovCleanData data = new CNGovCleanData();
        data.setPurchaser(data.getPurchaser() == null ? null : data.getPurchaser().length() > 80 ? null : data.getPurchaser() == null ? null : data.getPurchaser().length() > 80 ? null : data.getPurchaser());
        if (data.getPurchaser() != null && data.getPurchaser().contains("采购人：")) {
            data.setPurchaser(data.getPurchaser().replace("采购人：", ""));

        }
        if (data.getAgency() != null && data.getAgency().contains("代理机构：")) {
            data.setAgency(data.getAgency().replace("代理机构：", ""));

        }

        data.setPurchasingMethod(data.getPurchasingMethod() == null ? null : data.getPurchasingMethod().length() > 80 ? null : data.getPurchasingMethod());
        //  data.setCategory(data.getCategory() == null ? null : data.getPurchaser().length() > 80 ? null : data.getPurchaser());

        data.setRegion(data.getRegion() == null ? null : data.getRegion().length() > 80 ? null : data.getRegion());


        //      data.setTitle(data.getTitle() == null ? null : data.getTitle().length() > 100 ? null : data.getTitle());
        data.setProName(data.getProName() == null ? null : data.getProName().length() > 100 ? null : data.getProName());
        data.setAgency(data.getAgency() == null ? null : data.getAgency().length() > 80 ? null : data.getAgency());

        //    data.setProNo(data.getProNo() == null ? null : data.getProNo().length() > 80 ? null : data.getProNo());


        data.setSupplier(data.getSupplier() == null ? null : data.getSupplier().length() > 80 ? null : data.getSupplier());

        data.setObtainPurchasingFileAddr(data.getObtainPurchasingFileAddr() == null ? null : data.getObtainPurchasingFileAddr().length() > 80 ? null : data.getObtainPurchasingFileAddr());
        data.setObtainPurchasingFileTime(data.getObtainPurchasingFileTime() == null ? null : data.getObtainPurchasingFileTime().length() > 80 ? null : data.getObtainPurchasingFileTime());

        data.setResFileOpenTime(data.getResFileOpenTime() == null ? null : data.getResFileOpenTime().length() > 80 ? null : data.getResFileOpenTime());
        data.setResFileOpenAddr(data.getResFileOpenAddr() == null ? null : data.getResFileOpenAddr().length() > 80 ? null : data.getResFileOpenAddr());
        data.setResFileSubAddr(data.getResFileSubAddr() == null ? null : data.getResFileSubAddr().length() > 80 ? null : data.getResFileSubAddr());
        data.setSubFileDeadTime(data.getSubFileDeadTime() == null ? null : data.getSubFileDeadTime().length() > 80 ? null : data.getSubFileDeadTime());
        data.setPrequalificationTime(data.getPrequalificationTime() == null ? null : data.getPrequalificationTime().length() > 80 ? null : data.getPrequalificationTime());
        data.setFristPubTime(data.getFristPubTime() == null ? null : data.getFristPubTime().length() > 80 ? null : data.getFristPubTime());
        data.setProPubTime(data.getProPubTime() == null ? null : data.getProPubTime().length() > 80 ? null : data.getProPubTime());
        data.setObtainBiddingFileTime(data.getObtainBiddingFileTime() == null ? null : data.getObtainBiddingFileTime().length() > 80 ? null : data.getObtainBiddingFileTime());
        data.setObtainBiddingFileAddr(data.getObtainBiddingFileAddr() == null ? null : data.getObtainBiddingFileAddr().length() > 80 ? null : data.getObtainBiddingFileAddr());
        data.setBiddingFilePrice(data.getBiddingFilePrice() == null ? null : data.getBiddingFilePrice().length() > 80 ? null : data.getBiddingFilePrice());
        data.setOpenBiddingTime(data.getOpenBiddingTime() == null ? null : data.getOpenBiddingTime().length() > 80 ? null : data.getOpenBiddingTime());
        data.setOpenBiddingAddr(data.getOpenBiddingAddr() == null ? null : data.getOpenBiddingAddr().length() > 80 ? null : data.getOpenBiddingAddr());

        data.setWinBiddingTime(data.getWinBiddingTime() == null ? null : data.getWinBiddingTime().length() > 80 ? null : data.getWinBiddingTime());
        data.setExpertName(data.getExpertName() == null ? null : data.getExpertName().length() > 80 ? null : data.getExpertName());

        data.setBudgetAmount(data.getBudgetAmount() == null ? null : data.getBudgetAmount().length() > 80 ? null : data.getBudgetAmount());


        data.setContractSigningTime(data.getContractSigningTime() == null ? null : data.getContractSigningTime().length() > 80 ? null : data.getContractSigningTime());
        data.setWinBiddingTotalAmount(data.getWinBiddingTotalAmount() == null ? null : data.getWinBiddingTotalAmount().length() > 80 ? null : data.getWinBiddingTotalAmount());
        data.setProConnect(data.getProConnect() == null ? null : data.getProConnect().length() > 80 ? null : data.getProConnect());
        data.setProConnectPhone(data.getProConnectPhone() == null ? null : data.getProConnectPhone().length() > 80 ? null : data.getProConnectPhone());
        data.setPurchaserAddr(data.getPurchaserAddr() == null ? null : data.getPurchaserAddr().length() > 80 ? null : data.getPurchaserAddr());
        data.setPurchaserPhone(data.getPurchaserPhone() == null ? null : data.getPurchaserPhone().length() > 80 ? null : data.getPurchaserPhone());
        data.setAgencyAddr(data.getAgencyAddr() == null ? null : data.getAgencyAddr().length() > 80 ? null : data.getAgencyAddr());
        data.setAgencyPhone(data.getAgencyPhone() == null ? null : data.getAgencyPhone().length() > 80 ? null : data.getAgencyPhone());
        data.setWinBiddingSupplier(data.getWinBiddingSupplier() == null ? null : data.getWinBiddingSupplier().length() > 80 ? null : data.getWinBiddingSupplier());
        data.setWinBiddingSupplierPhone(data.getWinBiddingSupplierPhone() == null ? null : data.getWinBiddingSupplierPhone().length() > 80 ? null : data.getWinBiddingSupplierPhone());
        data.setWinBiddingSupplierAddr(data.getWinBiddingSupplierAddr() == null ? null : data.getWinBiddingSupplierAddr().length() > 80 ? null : data.getWinBiddingSupplierAddr());


        //  target.target

    }


    public static void map2CNGovDataUrl(Map<String, String> dataMap, CNGovDataUrl data) {
        //     data.setp(dataMap.get("put_time"));
        data.setPubtime(dataMap.get("pubtime"));
        data.setItems(dataMap.get("category_url"));
        data.setAgency(dataMap.get("agency"));
        data.setPurchaser(dataMap.get("purchaser"));
        data.setHashcode(dataMap.get("hashcode"));
        data.setUrlId(Integer.valueOf(dataMap.get("url_id")));
        data.setTitle(dataMap.get("title"));
        data.setUrl(dataMap.get("url"));
        data.setContent(dataMap.get("content"));

        data.setCategory(dataMap.get("category"));
        data.setRegion(dataMap.get("region"));
        data.setNotice(dataMap.get("notice"));

    }

    public static void hiveData2CNGovDataUrl(FlinkHiveHbaseCleanDataMain.HiveData hiveData, CNGovDataUrl data) {
        //     data.setp(dataMap.get("put_time"));
        data.setPubtime(hiveData.getPubtime());
        data.setItems(hiveData.getCategory_url());
        data.setAgency(hiveData.getAgency());
        data.setPurchaser(hiveData.getPurchaser());
        data.setHashcode(hiveData.getHashcode());
        data.setUrlId(hiveData.getUrl_id());
        data.setTitle(hiveData.getTitle());
        data.setUrl(hiveData.getUrl());
        data.setContent(hiveData.getContent());

        data.setCategory(hiveData.getCategory());
        data.setRegion(hiveData.getRegion());
        data.setNotice(hiveData.getNotice());

    }
}
