package com.ego.controller;


import com.ego.commons.pojo.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 页面显示的控制器
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    /**
     * 显示主页面
     *
     * @return
     */
    @RequestMapping("/main")
    public String showIndex() {
        return "index";
    }

    /**
     * 登录成功后跳转的服务器
     * @return
     */
    @RequestMapping("/loginSuccess")
    @ResponseBody
    public EgoResult loginSuccess(){
        return EgoResult.ok();
    }



}
