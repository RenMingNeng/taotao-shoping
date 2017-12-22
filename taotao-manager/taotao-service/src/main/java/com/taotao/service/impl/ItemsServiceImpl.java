package com.taotao.service.impl;

import com.taotao.dao.ItemMapper;
import com.taotao.pojo.Item;
import com.taotao.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("itemsService")
public class ItemsServiceImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> selectListByParams(Map params) {
        return itemMapper.selectListByParams(params);
    }

    @Override
    public long selectCountByParams(Map params) {
        return itemMapper.selectCountByParams(params);
    }
}
