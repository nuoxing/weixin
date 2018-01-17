/*
 * 文件名：R.java 版权：Copyright by www.chinauip.com 描述： 修改人：Administrator 修改时间：2017年10月18日 跟踪单号： 修改单号：
 * 修改内容：
 */

package com.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 结果返回类
 * 〈功能详细描述〉
 * @author Administrator
 * @version 2017年10月30日
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
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @return  结果
     * @see
     */
    public static R error()
    {
        return error(500, "未知异常，请联系管理员");
    }

    /**
     * 
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param msg 提示信息
     * @return  结果
     * @see
     */
    public static R error(String msg)
    {
        return error(500, msg);
    }

    /**
     * 
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param code 错误代码
     * @param msg 错误信息
     * @return  结果
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
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param msg 提示信息
     * @return  结果
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
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param map 返回给前端的结果
     * @return  结果
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
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @return 结果
     * @see
     */
    public static R ok()
    {
        return new R();
    }

    /**
     * 
     * 描述: <br>
     * 1、…<br>
     * 2、…<br>
     * 实现: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param data 返回给前端的数据 例如 list map等等
     * @return  结果
     * @see
     */
    public R put(Object data)
    {
        super.put("data", data);
        return this;
    }

    /**
      * @param key 数据的key
      * @param value 数据的值
      *    @return  结果
     */
    public R put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}