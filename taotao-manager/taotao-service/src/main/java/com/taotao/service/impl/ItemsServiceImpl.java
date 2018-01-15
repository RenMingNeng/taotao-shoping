package com.taotao.service.impl;

import com.taotao.dao.ItemDescMapper;
import com.taotao.dao.ItemMapper;
import com.taotao.dao.ItemParamItemMapper;
import com.taotao.pojo.Item;
import com.taotao.pojo.ItemDesc;
import com.taotao.pojo.ItemParamItem;
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
    @Autowired
    private ItemParamItemMapper itemParamItemMapper;


    @Override
    public List<Item> selectListByParams(Map params) {
        return itemMapper.selectListByParams(params);
    }

    @Override
    public long selectCountByParams(Map params) {
        return itemMapper.selectCountByParams(params);
    }

    @Override
    public DataResult save(Item item, String desc, String itemParams) throws Exception {
        Date date = new Date();
        //获得商品idDate date = new Date();
        long id = IDUtils.genItemId();
        //1、添加商品信息
        item.setId(id);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(date);
        item.setUpdated(date);
        itemMapper.insert(item);
        // 添加商品描述信息
        DataResult dataResult = insertItemDesc(id,desc);
        if(dataResult.getStatus() != 200){
            throw  new Exception();
        }
        // 添加商品规格参数
        dataResult = insertItemParamItem(id,itemParams);
        if(dataResult.getStatus() != 200){
            throw  new Exception();
        }
        return DataResult.ok();
    }

    /**
     * 添加商品描述
     * @param itemId
     * @param desc
     * @return
     */
    private DataResult insertItemDesc(Long itemId,String desc){
        Date date = new Date();
        //创建TbItemDesc对象
        ItemDesc itemDesc = new ItemDesc();
       //获得一个商品id
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
      //插入数据
        itemDescMapper.insert(itemDesc);
        return DataResult.ok();
    }

    /**
     * 添加规格参数
     * @param itemId
     * @param itemParams
     * @return
     */
    private DataResult insertItemParamItem(Long itemId,String itemParams){
        Date date = new Date();
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParams);
        itemParamItem.setCreated(date);
        itemParamItem.setUpdated(date);
        // 向表中插入数据
        itemParamItemMapper.insert(itemParamItem);
        return DataResult.ok();
    }
}
