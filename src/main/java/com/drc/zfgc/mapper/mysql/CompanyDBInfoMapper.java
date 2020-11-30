package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.CompanyDBInfo;
import com.drc.zfgc.model.CompanyDBInfoExample;
import com.drc.zfgc.model.CompanyDBInfoKey;

import java.util.List;

public interface CompanyDBInfoMapper {
    int deleteByPrimaryKey(CompanyDBInfoKey key);

    int insert(CompanyDBInfo record);

    int insertSelective(CompanyDBInfo record);

    List<CompanyDBInfo> selectByExample(CompanyDBInfoExample example);

    CompanyDBInfo selectByPrimaryKey(CompanyDBInfoKey key);

    int updateByPrimaryKeySelective(CompanyDBInfo record);

    int updateByPrimaryKey(CompanyDBInfo record);
}
