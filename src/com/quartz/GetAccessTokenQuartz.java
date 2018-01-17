/*
 * 文件名：GetAccessTokenQuartz.java 版权：Copyright by www.chinauip.com 描述： 修改人：Administrator
 * 修改时间：2018年1月17日 跟踪单号： 修改单号： 修改内容：
 */

package com.quartz;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.weixin.util.ConstantUtils;
import com.weixin.util.HttpClientUtils;


/**
 * 获取ccessToken的定时任务 〈功能详细描述〉
 * 
 * @author suwy
 * @version 2018年1月17日
 * @see GetAccessTokenQuartz
 * @since
 */
@Component("getAccessTokenQuartz")
public class GetAccessTokenQuartz
{

    public void getAccessToken()
    {
        System.out.println("开始获取AccessToken");
        String res = HttpClientUtils.commonGet(ConstantUtils.ACCESS_TOKEN_URL, "utf-8");
        if (!"error".equals(res))
        {
            JSONObject json;
            try
            {
                json = new JSONObject(res);
                if (json.getString("access_token") != null)
                {
                    ConstantUtils.ACCESS_TOKEN = json.getString("access_token");
                }
            }
            catch (JSONException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
