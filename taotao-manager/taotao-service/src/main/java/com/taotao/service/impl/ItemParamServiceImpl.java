package com.taotao.service.impl;

import com.taotao.dao.ItemParamMapper;
import com.taotao.pojo.ItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DataResult;

import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    @Autowired
    private ItemParamMapper itemParamMapper;

    @Override
    public DataResult getItemParamByCid(Long itemCatId) {
        List<ItemParam> list = itemParamMapper.selectParamByCid(itemCatId);
        //判断是否查询到结果
        if (list != null && list.size() > 0) {
            return DataResult.ok(list.get(0));
        }
        return DataResult.ok();
    }

    @Override
    public long selectCountByParams(Map params) {
        return itemParamMapper.selectCountByParams(params);
    }

    @Override
    public List<ItemParam> selectListByParams(Map params) {
        return itemParamMapper.selectListByParams(params);
    }
}
