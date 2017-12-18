package com.taotao.service.impl;

import com.taotao.mapper.ItemMapper;
import com.taotao.pojo.Item;
import com.taotao.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemsService")
public class ItemsServiceImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Item selectOne(String itemId) {
        return itemMapper.selectOneItem(itemId);
    }
}
