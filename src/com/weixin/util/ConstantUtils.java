/*
 * 文件名：ConstantUtils.java
 * 版权：Copyright by www.chinauip.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2018年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.weixin.util;

public class ConstantUtils
{
    //测试号id
    public final static String APPID = "wx25740c8af0cd0481";
    
    public final static String SECRET="05bf0e1646a101cc59bb42f2d976e94a";

    public  static String TOKEN = "swy";//自己在微信上设置的token
    
    //获取access_token的链接
    public  static String ACCESS_TOKEN_URL  = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+SECRET+"";
    
    //获得到的access_token
    public static String ACCESS_TOKEN = "";
    
    //创建菜单的链接
    public static String CREATE_MENU_RUL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    
    
    public static String getCreateMenuUrl(){
        return CREATE_MENU_RUL+ACCESS_TOKEN;
    }
}
