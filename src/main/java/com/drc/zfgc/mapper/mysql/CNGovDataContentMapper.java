package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.CNGovDataContentExample;
import com.drc.zfgc.model.CNGovDataContent;

import java.util.List;

//@Mapper
public interface CNGovDataContentMapper {
    int insert(CNGovDataContent record);

    int insertSelective(CNGovDataContent record);

    List<CNGovDataContent> selectByExampleWithBLOBs(CNGovDataContentExample example);

    List<CNGovDataContent> selectByExample(CNGovDataContentExample example);
}
