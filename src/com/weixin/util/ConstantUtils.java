/*
 * �ļ�����ConstantUtils.java
 * ��Ȩ��Copyright by www.chinauip.com
 * ������
 * �޸��ˣ�Administrator
 * �޸�ʱ�䣺2018��1��17��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.weixin.util;

public class ConstantUtils
{
    //���Ժ�id
    public final static String APPID = "wx25740c8af0cd0481";
    
    public final static String SECRET="05bf0e1646a101cc59bb42f2d976e94a";

    public  static String TOKEN = "swy";//�Լ���΢�������õ�token
    
    //��ȡaccess_token������
    public  static String ACCESS_TOKEN_URL  = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+SECRET+"";
    
    //��õ���access_token
    public static String ACCESS_TOKEN = "";
    
    //�����˵�������
    public static String CREATE_MENU_RUL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    
    
    public static String getCreateMenuUrl(){
        return CREATE_MENU_RUL+ACCESS_TOKEN;
    }
}
