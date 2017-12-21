package com.taotao.service;

import com.taotao.pojo.Item;
import java.util.List;
import java.util.Map;

public interface IItemService {

    /**
     * 查询列表
     * @param params
     * @return
     */
    List<Item> selectListByParams(Map params);

    /**
     * 查询数量
     * @param params
     * @return
     */
    long selectCountByParams(Map params);
}
