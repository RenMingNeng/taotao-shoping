package com.taotao.dao;

import com.taotao.pojo.ItemParam;

import java.util.List;
import java.util.Map;

public interface ItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemParam record);

    int insertSelective(ItemParam record);

    int updateByPrimaryKeySelective(ItemParam record);

    int updateByPrimaryKeyWithBLOBs(ItemParam record);

    int updateByPrimaryKey(ItemParam record);

    List<ItemParam> selectParamByCid(Long itemCatId);

    long selectCountByParams(Map params);

    List<ItemParam> selectListByParams(Map params);
}