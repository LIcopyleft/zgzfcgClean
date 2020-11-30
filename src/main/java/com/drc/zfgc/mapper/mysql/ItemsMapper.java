package com.drc.zfgc.mapper.mysql;

import com.drc.zfgc.model.ItemsExample;
import com.drc.zfgc.model.Items;

import java.util.List;

public interface ItemsMapper {
    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExample(ItemsExample example);
}
