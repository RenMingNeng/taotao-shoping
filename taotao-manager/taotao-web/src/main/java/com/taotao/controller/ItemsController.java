package com.taotao.controller;

import com.taotao.pojo.Item;
import com.taotao.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/item")
public class ItemsController {

    @Autowired
    private IItemService itemService;


    @RequestMapping(value="/itemList")
    public ModelAndView itemList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("item/item-list");
        return mv;
    };

    @RequestMapping(value="/getItem")
    @ResponseBody
    public Item getItemById(
            @RequestParam(value = "id", required = false, defaultValue = "536563") String itemId) {
        try {
             Item item = itemService.selectOne(itemId);
            return item;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Item();
    }
}
