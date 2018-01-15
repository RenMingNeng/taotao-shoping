package com.taotao.controller;

import com.taotao.pojo.Item;
import com.taotao.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DataResult;
import util.EasyUIPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    /**
     * 分页显示商品列表
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
        long count = itemService.selectCountByParams(params);
        params.put("startNum",(pageNum-1)*pageSize);
        params.put("endNum",pageSize);
        List<Item> itemList = itemService.selectListByParams(params);
        page.setTotal(count);
        page.setRows(itemList);
        return page;
    }

    /**
     * 新增商品保存
     * @param item
     * @param desc
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public DataResult saveItem(Item item,String desc,String itemParams) throws Exception{
        DataResult dataResult = itemService.save(item, desc, itemParams);
        return dataResult;
    }


}
