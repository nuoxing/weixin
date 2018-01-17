/*
 * 文件名：Button.java
 * 版权：Copyright by www.chinauip.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2018年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.weixin.wechat.menu;

/**
 * 
 * 一级菜单
 * 〈功能详细描述〉
 * @author Administrator
 * @version 2018年1月17日
 * @see ClickMenu
 * @since
 */
public class ClickMenu
{
    
    private String type;
    private String name;
    private String key;
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getKey()
    {
        return key;
    }
    public void setKey(String key)
    {
        this.key = key;
    }
    @Override
    public String toString()
    {
        return "{\"type\":\"" + type + "\", \"name\":\"" + name + "\", \"key\":\"" + key + "\"}";
    }
    
    

}
