/*
 * �ļ�����R.java ��Ȩ��Copyright by www.chinauip.com ������ �޸��ˣ�Administrator �޸�ʱ�䣺2017��10��18�� ���ٵ��ţ� �޸ĵ��ţ�
 * �޸����ݣ�
 */

package com.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ���������
 * ��������ϸ������
 * @author Administrator
 * @version 2017��10��30��
 * @see R
 * @since
 */
public class R extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    public R()
    {
        put("code", 200);
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @return  ���
     * @see
     */
    public static R error()
    {
        return error(500, "δ֪�쳣������ϵ����Ա");
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @param msg ��ʾ��Ϣ
     * @return  ���
     * @see
     */
    public static R error(String msg)
    {
        return error(500, msg);
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @param code �������
     * @param msg ������Ϣ
     * @return  ���
     * @see
     */
    public static R error(int code, String msg)
    {
        R r = new R();
        r.put("code", Integer.valueOf(code));
        r.put("msg", msg);
        return r;
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @param msg ��ʾ��Ϣ
     * @return  ���
     * @see
     */
    public static R ok(String msg)
    {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @param map ���ظ�ǰ�˵Ľ��
     * @return  ���
     * @see
     */
    public static R ok(Map<String, Object> map)
    {
        R r = new R();
        r.putAll(map);
        return r;
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @return ���
     * @see
     */
    public static R ok()
    {
        return new R();
    }

    /**
     * 
     * ����: <br>
     * 1����<br>
     * 2����<br>
     * ʵ��: <br>
     * 1����<br>
     * 2����<br>
     * 
     * @param data ���ظ�ǰ�˵����� ���� list map�ȵ�
     * @return  ���
     * @see
     */
    public R put(Object data)
    {
        super.put("data", data);
        return this;
    }

    /**
      * @param key ���ݵ�key
      * @param value ���ݵ�ֵ
      *    @return  ���
     */
    public R put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}