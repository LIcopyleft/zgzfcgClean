package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.GovData;
import com.drc.zfgc.model.GovDataKey;

import java.util.List;

//@Mapper
public interface GovDataMapper {
    int deleteByPrimaryKey(GovDataKey key);

    int insert(GovData record);
   // int insertList(List<GovData> list);

    int insertSelective(GovData record);

    List<GovData> selectByExampleWithBLOBs(GovData example);

    List<GovData> selectByExample(GovData example);

    GovData selectByPrimaryKey(GovDataKey key);

    int updateByPrimaryKeySelective(GovData record);

    int updateByPrimaryKeyWithBLOBs(GovData record);

    int updateByPrimaryKey(GovData record);
}
