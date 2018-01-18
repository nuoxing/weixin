/*
 * �ļ�����JsSdkService.java
 * ��Ȩ��Copyright by www.chinauip.com
 * ������
 * �޸��ˣ�Administrator
 * �޸�ʱ�䣺2018��1��17��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
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
    //����� �Լ���
    private static String noncestr = "WmfdregPz0wzccnWswy";
    
    //����ǩ����ʱ���
    private static String timestamp = "";
    
    //jsapi_ticket�ǹ��ں����ڵ���΢��JS�ӿڵ���ʱƱ�� ��Ч��2Сʱ
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
