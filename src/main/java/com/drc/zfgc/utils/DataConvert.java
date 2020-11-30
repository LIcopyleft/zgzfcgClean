package com.drc.zfgc.utils;

import com.drc.zfgc.model.DataContentWithBLOBs;
import com.drc.zfgc.model.GovData;

/**
 * @author tengchao.li
 * @description 转换model
 * @date 2020/4/7
 */
public class DataConvert {

    public static GovData toGovData(DataContentWithBLOBs data){

        GovData gov = new GovData();
        gov.setProName(data.getProname());
        gov.setTitle(data.getTitle());
        gov.setClassifyShow(data.getClassifyshow());
        gov.setStageShow(data.getStageshow());
        gov.setStageName(data.getStagename());
        gov.setContent(data.getContent());
        gov.setUrl(data.getUrl());
        gov.setUrlId(data.getUrlId());
        gov.setClassify(data.getClassify());
   //     gov.setPubTime(data.getPubTime() == null ? data.getTimeshow() : data.getPubTime());
        gov.setPubTime(data.getPubTime() != null ? data.getPubTime() : data.getTimeshow());
        gov.setTradeShow(data.getTradeshow());
        gov.setDistrictShow(data.getDistrictshow());
        gov.setPlatformName(data.getPlatformname());
        gov.setLocation(data.getLocation());
        gov.setCategory(data.getCategory());
        gov.setRegion(data.getRegion());
        return gov;
    }
}
