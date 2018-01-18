/*
 * 文件名：JsSdkController.java
 * 版权：Copyright by www.chinauip.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2018年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.weixin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.R;
import com.weixin.service.JsSdkService;

@Controller
@RequestMapping("/jsSdk")
public class JsSdkController
{

    @Autowired
    private JsSdkService jsSdkService;
    
    @RequestMapping("/getData")
    @ResponseBody
    public R getJsSdkData(String url){
        System.out.println("url="+url);
        Map<String, String> map = jsSdkService.getJsSdkData(url);
        System.out.println(map.get("signature"));
        return R.ok().put(map);
    }
    
}
