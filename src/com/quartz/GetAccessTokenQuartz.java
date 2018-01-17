/*
 * �ļ�����GetAccessTokenQuartz.java ��Ȩ��Copyright by www.chinauip.com ������ �޸��ˣ�Administrator
 * �޸�ʱ�䣺2018��1��17�� ���ٵ��ţ� �޸ĵ��ţ� �޸����ݣ�
 */

package com.quartz;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.weixin.util.ConstantUtils;
import com.weixin.util.HttpClientUtils;


/**
 * ��ȡccessToken�Ķ�ʱ���� ��������ϸ������
 * 
 * @author suwy
 * @version 2018��1��17��
 * @see GetAccessTokenQuartz
 * @since
 */
@Component("getAccessTokenQuartz")
public class GetAccessTokenQuartz
{

    public void getAccessToken()
    {
        System.out.println("��ʼ��ȡAccessToken");
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
