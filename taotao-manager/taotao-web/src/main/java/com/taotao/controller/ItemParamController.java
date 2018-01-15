package com.taotao.controller;

import com.taotao.pojo.ItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DataResult;
import util.EasyUIPage;
import util.JsonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/itemParam")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public DataResult getItemParamByCid(@PathVariable Long itemCatId) {
        DataResult result = itemParamService.getItemParamByCid(itemCatId);
        return result;
    }

    /**
     * 分页显示商品规格列表
     * @param pageSize
     * @param pageNum
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIPage getItemList(
            @RequestParam(value = "rows", required = true, defaultValue = "30") Integer pageSize,
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer pageNum) {
        EasyUIPage page = new EasyUIPage();
        Map params = new HashMap();
        long count = itemParamService.selectCountByParams(params);
        params.put("startNum",(pageNum-1)*pageSize);
        params.put("endNum",pageSize);
        List<ItemParam> itemList = itemParamService.selectListByParams(params);
        page.setTotal(count);
        page.setRows(itemList);
        return page;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public DataResult insertItemParam(@PathVariable Long cid,String paramData,String catName) {
        ItemParam itemParam = new ItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setItemCatName(catName);
        itemParam.setParamData(paramData);
        DataResult result = itemParamService.insertItemParam(itemParam);
        return result;
    }
}
