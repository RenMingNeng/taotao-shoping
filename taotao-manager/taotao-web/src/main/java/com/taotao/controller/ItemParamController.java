package com.taotao.controller;

import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DataResult;

@Controller
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{itemCatId}")
    public DataResult getItemParamByCid(@PathVariable Long itemCatId) {
        DataResult result = itemParamService.getItemParamByCid(itemCatId);
        return result;
    }

}
