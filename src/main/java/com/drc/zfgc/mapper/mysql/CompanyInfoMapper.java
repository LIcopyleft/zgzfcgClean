package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.CompanyInfoExample;
import com.drc.zfgc.model.CompanyInfo;

import java.util.List;

public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer urlId);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    List<CompanyInfo> selectByExampleWithBLOBs(CompanyInfoExample example);

    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    CompanyInfo selectByPrimaryKey(Integer urlId);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKeyWithBLOBs(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}
