package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.model.CNGovCleanDataExample;
import com.drc.zfgc.model.CNGovCleanDataWithBLOBs;

import java.util.List;

//@Mapper
public interface CNGovCleanDataMapper {
    int deleteByPrimaryKey(Integer urlId);

    int insert(CNGovCleanDataWithBLOBs record);

    int insertSelective(CNGovCleanDataWithBLOBs record);

    List<CNGovCleanDataWithBLOBs> selectByExampleWithBLOBs(CNGovCleanDataExample example);

    List<CNGovCleanData> selectByExample(CNGovCleanDataExample example);

    CNGovCleanDataWithBLOBs selectByPrimaryKey(Integer urlId);

    int updateByPrimaryKeySelective(CNGovCleanDataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CNGovCleanDataWithBLOBs record);

    int updateByPrimaryKey(CNGovCleanData record);
}
