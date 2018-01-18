/*
 * 文件名：JsSdkService.java
 * 版权：Copyright by www.chinauip.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2018年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.weixin.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quartz.GetAccessTokenQuartz;
import com.util.DesEnCode;
import com.weixin.util.ConstantUtils;

@Service
public class JsSdkService
{
    //随机串 自己给
    private static String noncestr = "WmfdregPz0wzccnWswy";
    
    //生成签名的时间戳
    private static String timestamp = "";
    
    //jsapi_ticket是公众号用于调用微信JS接口的临时票据 有效期2小时
    public static String jsapi_ticket = "";
    
    @Autowired
    private GetAccessTokenQuartz getAccessTokenQuartz;
    
    public  Map<String,String> getJsSdkData(String url){
        Map<String,String> map = new HashMap<String,String>();
        if (StringUtils.isEmpty(JsSdkService.jsapi_ticket)){
            getAccessTokenQuartz.getAccessToken();
        }
       timestamp=String.valueOf(new Date().getTime()/1000);
        
       map.put("noncestr", noncestr);
       map.put("timestamp", timestamp);
       map.put("jsapi_ticket", jsapi_ticket);
       map.put("url", url);
       
       String signature = "";
      
       StringBuilder sb = new StringBuilder();
     
       sb.append("jsapi_ticket=").append(jsapi_ticket).append("&");
       sb.append("noncestr=").append(noncestr).append("&");
       sb.append("timestamp=").append(timestamp).append("&");
       sb.append("url=").append(url);
       
       System.out.println(sb.toString());
       signature = DesEnCode.enBySha1(sb.toString());
       System.out.println(signature);
       map.put("signature", signature);
       map.put("appid", ConstantUtils.APPID);
       return map;
    }
    
}
