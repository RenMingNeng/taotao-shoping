package com.taotao.service.impl;

import com.taotao.dao.ItemDescMapper;
import com.taotao.dao.ItemMapper;
import com.taotao.pojo.Item;
import com.taotao.pojo.ItemDesc;
import com.taotao.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DataResult;
import util.IDUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("itemsService")
public class ItemsServiceImpl implements IItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;


    @Override
    public List<Item> selectListByParams(Map params) {
        return itemMapper.selectListByParams(params);
    }

    @Override
    public long selectCountByParams(Map params) {
        return itemMapper.selectCountByParams(params);
    }

    @Override
    public DataResult save(Item item, String desc) {
        Date date = new Date();
        //获得商品id
        long id = IDUtils.genItemId();
        //1、添加商品信息
        item.setId(id);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(date);
        item.setUpdated(date);
        itemMapper.insert(item);
        //2、同步添加商品描述
        //创建TbItemDesc对象
        ItemDesc itemDesc = new ItemDesc();
        //获得一个商品id
        itemDesc.setItemId(id);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        //插入数据
        itemDescMapper.insert(itemDesc);
        return DataResult.ok();
    }
}
