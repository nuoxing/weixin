/*
 * 文件名：Menu.java
 * 版权：Copyright by www.chinauip.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2018年1月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.weixin.wechat.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu
{

    private List<ClickMenu> listClick;
    private List<SubButton> listSub;
    public List<ClickMenu> getListClick()
    {
        return listClick;
    }
    public void setListClick(List<ClickMenu> listClick)
    {
        this.listClick = listClick;
    }
    public List<SubButton> getListSub()
    {
        return listSub;
    }
    public void setListSub(List<SubButton> listSub)
    {
        this.listSub = listSub;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("{\"button\":[");
        if (listClick!=null){
            for (ClickMenu vo : listClick){
                sb.append(vo.toString());
                sb.append(",");
            }
        }
       
        if (listSub!=null){
            for(SubButton vo : listSub){
                sb.append(vo.toString());
                sb.append(",");
            } 
        }
      
        String str = sb.toString();
        str = str.substring(0, str.length()-1);
        return str + "]}";
    }
    
    
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        List<ClickMenu> listClick = new ArrayList<ClickMenu>();
        ClickMenu vo1 = new ClickMenu();
        vo1.setName("一级");
        vo1.setKey("1111");
        vo1.setType("click");
        listClick.add(vo1);
        menu.setListClick(listClick);
        
        List<SubButton> listSub = new ArrayList<SubButton>();
        SubButton vo2 = new SubButton();
        vo2.setName("一级2");
        List<ViewMenu> listView= new ArrayList<ViewMenu>();
        ViewMenu view  = new ViewMenu();
        view.setName("二级百度");
        view.setType("view");
        view.setUrl("http://www.baidu.com");
        vo2.setListView(listView);
        vo2.setListView(listView);
        listView.add(view);
        listSub.add(vo2);
        menu.setListSub(listSub);
        System.out.println(menu.toString());
    }
    
    
    
    
}
