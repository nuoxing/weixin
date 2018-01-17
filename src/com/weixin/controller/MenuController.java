/*
 * 文件名：MenuController.java
 * 版权：Copyright by www.chinauip.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2018年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.R;
import com.weixin.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController
{
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/create")
    @ResponseBody
    public  R createMenu(){
        menuService.createMenu();
        return R.ok();
    }

}
