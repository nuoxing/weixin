/*
 * �ļ�����Button.java
 * ��Ȩ��Copyright by www.chinauip.com
 * ������
 * �޸��ˣ�Administrator
 * �޸�ʱ�䣺2018��1��17��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.weixin.wechat.menu;

/**
 * 
 * һ���˵�
 * ��������ϸ������
 * @author Administrator
 * @version 2018��1��17��
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
