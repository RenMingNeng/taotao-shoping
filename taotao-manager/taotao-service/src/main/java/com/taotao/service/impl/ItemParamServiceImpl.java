package com.taotao.service.impl;

import com.taotao.dao.ItemParamMapper;
import com.taotao.pojo.ItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DataResult;

import java.util.List;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private ItemParamMapper itemParamMapper;

    @Override
    public DataResult getItemParamByCid(Long itemCatId) {
        DataResult dataResult = new DataResult();
        List<ItemParam> list = itemParamMapper.selectParamByCid(itemCatId);
        //判断是否查询到结果
        if (list != null && list.size() > 0) {
            return DataResult.ok(list.get(0));
        }
        dataResult.setData(list);
        return dataResult;
    }
}
