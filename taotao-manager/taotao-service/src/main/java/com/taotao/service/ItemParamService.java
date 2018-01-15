package com.taotao.service;

import com.taotao.pojo.ItemParam;
import util.DataResult;

import java.util.List;
import java.util.Map;

public interface ItemParamService {

    DataResult getItemParamByCid(Long itemCatId);

    long selectCountByParams(Map params);

    List<ItemParam> selectListByParams(Map params);

    DataResult insertItemParam(ItemParam itemParam);
}
