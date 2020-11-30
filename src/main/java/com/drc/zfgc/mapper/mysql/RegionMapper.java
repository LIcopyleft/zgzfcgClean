package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.Region;
import com.drc.zfgc.model.RegionExample;

import java.util.List;

public interface RegionMapper {
    int deleteByPrimaryKey(String regionId);

    int insert(Region record);

    int insertSelective(Region record);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(String regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
}
