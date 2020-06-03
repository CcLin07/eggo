package com.ego.controller;

import com.ego.commons.pojo.UIdatagrid;
import com.ego.sevice.TBItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品查询页面跳转
 * @author Lin
 */
@Controller
public class TBItemController {

    @Autowired
    private TBItemService tbItemService;
    @RequestMapping("/item/list")
    @ResponseBody
    public UIdatagrid showItem(int page,int rows){
        return tbItemService.showItem(page,rows);
    }
}
