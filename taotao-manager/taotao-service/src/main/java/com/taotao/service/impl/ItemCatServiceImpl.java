package com.taotao.service.impl;

import com.taotao.dao.ItemCatMapper;
import com.taotao.pojo.ItemCat;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {


    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> getItemCatList(Long parentId) {

        return itemCatMapper.getItemCatList(parentId);
    }
}
