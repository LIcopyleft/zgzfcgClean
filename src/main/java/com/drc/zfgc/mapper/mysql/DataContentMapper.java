package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Mapper
public interface DataContentMapper {

    // int insert(DataContentWithBLOBs record);

    int insertSelective(DataContentWithBLOBs record);

    List<DataContentWithBLOBs> selectByExampleWithBLOBs(DataContentExample example);

    List<DataContent> selectByExample(DataContentExample example);

    DataContentWithBLOBs selectByPrimaryKey(Integer urlId);


    @Select("select * from ${table} where url_id>=(select url_id from ${table} order by url_id limit ${from},1) limit ${to}")
        //   @Select("select * from ${table} where id >=(select id from ${table} order by id limit ${from},1) limit ${to}")
    List<DataContentWithBLOBs> selectAll(@Param("from") long from, @Param("to") long to, @Param("table") String table);

    @Select("select * from ${table} where url_id>=(select url_id from ${table} order by url_id limit ${from},1) limit ${to}")
        //   @Select("select * from ${table} where id >=(select id from ${table} order by id limit ${from},1) limit ${to}")
   // @Select("SELECT * FROM  ${table}  WHERE url_id >= ${from} and url_id < ${to}")
    List<CNGovDataUrl> selectAll3(@Param("from") long from, @Param("to") long to, @Param("table") String table);

    @Select("SELECT * FROM  ${table}  WHERE url_id >= ${from} and url_id < ${to}")
    List<CNGovDataUrl> selectAll4(@Param("from") long from, @Param("to") long to, @Param("table") String table);

    @Select("SELECT * FROM  ${table}  WHERE url_id >= ${from} and url_id < ${to}")
    List<CNGovCleanData> selectAll6(@Param("from") long from, @Param("to") long to, @Param("table") String table);
    @Select("SELECT * FROM  spider_71_ggzy_zgzfcgw_content  a left join spider_71_ggzy_zgzfcgw_url b on a.url_id = b.url_id  WHERE url_id >= ${from} and url_id < ${to}")
    List<CNGovDataUrl> selectAll5(@Param("from") long from, @Param("to") long to);


    @Select("select * from ${table} where url_id>=(select url_id from ${table} order by url_id limit ${from},1) limit ${to}")
        //   @Select("select * from ${table} where id >=(select id from ${table} order by id limit ${from},1) limit ${to}")
    List<GovData> selectAll2(@Param("from") long from, @Param("to") long to, @Param("table") String table);

    @Select("${sql}")
    List<CNGovDataUrl> selectBySql(@Param("sql") String sql);

    @Select("select * from ${table} where url_id>=(select url_id from ${table} where stageShow = #{type} order by url_id limit ${from},1) limit ${to}")
    List<DataContentWithBLOBs> selectByType(@Param("from") long from, @Param("to") long to, @Param("table") String table, @Param("type") String type);

    @Select("select * from ${table} where url_id = ${urlId}")
    List<DataContentWithBLOBs> selectByUrlId(@Param("table") String table, @Param("urlId") long urlId);

    @Select("select * from spider_2_ggzy_beijing_content where url_id>=(select url_id from spider_2_ggzy_beijing_content order by url_id limit #{from},1) limit #{to}")
    List<GovData> selectAllBJ(@Param("from") int from, @Param("to") int to);


    @Select({"select * from spider_2_ggzy_content where stageShow = #{stageShow}"})
    List<DataContentWithBLOBs> selectAllByStageShow(@Param("stageShow") String stageShow);

    int updateByPrimaryKeySelective(DataContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DataContentWithBLOBs record);

    int insertList(List<DataContentWithBLOBs> list);

    int insertList_BJ(List<GovData> list, @Param("tableName") String tableName);

    int insertCNCleanDataList(List<CNGovCleanData> list, @Param("tableName") String tableName);


    @Select("select * from ${table} where ${filed} is null limit ${from} , ${to}")
    List<GovData> selectThisFiledIsNull(String table, @Param("filed") String filed, @Param("from") int from, @Param("to") int to);

    @Select("select * from ${table} where url_id = ${urlId}")
    DataContentWithBLOBs selectById(String table, Integer urlId);

    @Select("select * from ${table} where url_id = ${urlId}")
    CNGovDataUrl selectById3(@Param("table") String table, @Param("urlId")Integer urlId);

    @Select("select * from ${table} where url_id in (${urlIds})")
    List<CNGovDataUrl> selectByIds(@Param("table") String table, @Param("urlIds")String urlIds);

   /* @Select("select url_id from ${table}")
    List<Integer> selectUrlIds(String table);*/

    @Select("update ${table} SET ${field} = #{fieldVal}  where url_id = #{urlId}")
    @Transactional(propagation = Propagation.SUPPORTS)
    DataContentWithBLOBs updateFiledByUrlId(String table, String field, String fieldVal, Integer urlId);

   /* @Select("SELECT  * from spider_2_ggzy_beijing_content_clean where classify_show = '政府采购'")
    List<GovData> selectTable();*/
    //  @Select("SELECT * from spider_10_ggzy_anhui_url a join spider_10_ggzy_anhui_content b ON a.url_id = b.url_id where FIND_IN_SET(a.url_id,${urlIds})")

    @Select({"<script>",
            "SELECT a.url_id ,a.category ,a.title , a.pubTime, a.url , a.address as region , b.content  from spider_10_ggzy_anhui_url a join spider_10_ggzy_anhui_content b ON a.url_id = b.url_id where a.url_id in ",
            "<foreach collection=\"urlIds\" item=\"urlId\" index=\"index\" open=\"(\" separator=\",\" close=\")\">",
            "#{urlId}",
            "</foreach>",
            "</script>"})
    List<DataContentWithBLOBs> anHui(@Param("urlIds") List urlIds);

    @Select("select url_id from ${table} limit ${beginIndex},${querySize}")
    List<Integer> selectUrlIds(String table, int beginIndex, int querySize);


    @Select("select count(*) from ${tableName}")
    int countNum(@Param("tableName") String tableName);

    @Select("select DISTINCT(category) from ${tableName}")
    List<String> getCategory(@Param("tableName") String tableName);

    @Select("select * from test_region where name = #{regionName}")
    List<Region> selectRegionByName(@Param("regionName") String regionName);

    @Select("select * from test_region where region_id = #{regionId}")
    Region selectRegionByRegionId(@Param("regionId") String regionId);

    @Select("select * from test_region")
    List<Region> selectAllRegion();

    @Select("select * from test_items")
    List<Items> selectAllItems();

    @Select("select url_id, corpTel , auditPlace , contactNm , bizLicRegNo , agentNm , officeAddr , regValidDateStr from spider_71_agent_info")
    List<CompanyInfo> selectAllCompany();

    int insertCompany(CompanyDBInfo info);


}
