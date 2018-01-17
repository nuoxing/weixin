/*
 * �ļ�����MenuService.java
 * ��Ȩ��Copyright by www.chinauip.com
 * ������
 * �޸��ˣ�Administrator
 * �޸�ʱ�䣺2018��1��17��
 * ���ٵ��ţ�
 * �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.weixin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quartz.GetAccessTokenQuartz;
import com.weixin.util.ConstantUtils;
import com.weixin.util.HttpClientUtils;
import com.weixin.wechat.menu.ClickMenu;
import com.weixin.wechat.menu.Menu;
import com.weixin.wechat.menu.SubButton;
import com.weixin.wechat.menu.ViewMenu;

@Service
public class MenuService
{

    @Autowired
    private GetAccessTokenQuartz getAccessTokenQuartz;
    
    public void createMenu(){
        if(StringUtils.isEmpty(ConstantUtils.ACCESS_TOKEN)){//��ʱ����û��ִ��һ��
            getAccessTokenQuartz.getAccessToken();
        }
        
        HttpClientUtils.commonPost(ConstantUtils.getCreateMenuUrl(), getMenu(), null, "utf-8", "utf-8");
    }
    
    
    public String getMenu(){
        Menu menu = new Menu();
        List<ClickMenu> listClick = new ArrayList<ClickMenu>();
        ClickMenu vo1 = new ClickMenu();
        vo1.setName("һ��");
        vo1.setKey("1111");
        vo1.setType("click");
        listClick.add(vo1);
        menu.setListClick(listClick);
        
        List<SubButton> listSub = new ArrayList<SubButton>();
        SubButton vo2 = new SubButton();
        vo2.setName("һ��2");
        List<ViewMenu> listView= new ArrayList<ViewMenu>();
        ViewMenu view  = new ViewMenu();
        view.setName("�����ٶ�");
        view.setType("view");
        view.setUrl("http://www.baidu.com");
        vo2.setListView(listView);
        vo2.setListView(listView);
        listView.add(view);
        listSub.add(vo2);
        menu.setListSub(listSub);
        return menu.toString();
    }
}
