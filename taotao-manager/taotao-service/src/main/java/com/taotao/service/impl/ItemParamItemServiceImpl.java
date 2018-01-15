package com.taotao.service.impl;

import com.taotao.dao.ItemParamItemMapper;
import com.taotao.pojo.ItemParamItem;
import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.JsonUtils;

import java.util.List;
import java.util.Map;

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;


    @Override
    public String getItemParamByItemId(Long itemId) {
        List<ItemParamItem> list = itemParamItemMapper.selectByItemId(itemId);
        if(null == list || list.size() == 0){
            return "";
        }
        // 取规格参数
        String paramData = list.get(0).getParamData();
        // 将规格参数 生成html页面展示
        List<Map> listMap= JsonUtils.jsonToList(paramData,Map.class);
        StringBuffer sb = new StringBuffer();
        for (Map map : listMap) {
            sb.append("<div>\n");
            sb.append("<h3>"+ map.get("group") +"</h3>\n");
            List<Map> listMap2 = (List<Map>) map.get("params");
            sb.append("<dl>\n");
            for (Map map2 : listMap2) {
                sb.append("<dt>"+ map2.get("k") +"</dt><dd>"+ map2.get("v") +"</dd>\n");
            }
            sb.append("</dl>\n");
            sb.append("</div>");
        }
        return sb.toString();
    }
}
