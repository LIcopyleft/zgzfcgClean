package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.CNGovDataUrl;
import com.drc.zfgc.model.CNGovDataExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface CNGovDataMapper {

    @Select("select * from ${table} where url_id>=(select url_id from ${table} order by url_id limit ${from},1) limit ${to}")
    List<CNGovDataUrl> selectAll(@Param("from") long from, @Param("to") long to, @Param("table") String table);


    int deleteByPrimaryKey(Integer urlId);

    int insert(CNGovDataUrl record);

    int insertSelective(CNGovDataUrl record);

    List<CNGovDataUrl> selectByExample(CNGovDataExample example);

    CNGovDataUrl selectByPrimaryKey(Integer urlId);

    int updateByPrimaryKeySelective(CNGovDataUrl record);

    int updateByPrimaryKey(CNGovDataUrl record);
}
