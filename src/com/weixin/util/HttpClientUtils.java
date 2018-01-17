/*
 * 文件名：HttpClientUtils.java 版权：Copyright by www.chinauip.com 描述： 修改人：Administrator 修改时间：2017年11月18日
 * 跟踪单号： 修改单号： 修改内容：
 */

package com.weixin.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;



/**
 * 发出http请求的工具类 〈功能详细描述〉
 * 
 * @author suwy
 * @version 2017年11月18日
 * @see HttpClientUtils
 * @since
 */
public class HttpClientUtils
{

    public HttpClientUtils()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * 描述:http的get请求 <br>
     * 
     * @param stUrl
     *            请求的url,请求的url有中文时，在传入前需要编码
     * @param encode
     *            读取数据的编码
     * @return 正常是返回 请求的结果 错误时返回error
     * @see
     */
    public static String commonGet(String stUrl, String encode)
    {
        System.out.println("发起http请求，url=" + stUrl);
       // LogUtils.info(HttpClientUtils.class, "发起http请求，url=" + stUrl);
        String res = "error";
        try
        {
            URL url = new URL(stUrl); // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();// 打开连接
            connection.connect();// 连接会话
            connection.setReadTimeout(30000);
            // 获取输入流
            BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), encode));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null)
            {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            res = sb.toString();
            System.out.println("res=" + res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out, true));
          //  LogUtils.error(HttpClientUtils.class, "http的get请求失败，错误原因=" + out.toString());
            System.out.println("失败!");
            res = "error";
        }
        return res;
    }

    /**
     * 描述: http的post请求<br>
     * 
     * @param url
     *            请求url
     * @param params
     *            参数 json格式
     * @param property
     *            请求属性设置,给null值时有默认值，例如： Map<String,String> property = new
     *            HashMap<String,String>(); property.put("content-type", "application/json");
     * @param wEncoding
     *            写出内容编码
     * @param rEncoding
     *            读取内容编码
     * @return 请求正常时返回请求结果 错误返回error
     * @see
     */
    public static String commonPost(String url, String params, Map<String, String> property,
                                    String wEncoding, String rEncoding)
    {
        OutputStream outStream = null;
        BufferedReader in = null;
        String result = "";
        System.out.println("发起http请求，url=" + url);
      //  LogUtils.info(HttpClientUtils.class, "发起http请求，url=" + url);
        try
        {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            if (property != null)
            {
                Set<String> keySet = property.keySet();
                for (String key : keySet)
                {
                    String res = property.get(key);
                    conn.setRequestProperty(key, res);
                }
            }
            else
            {
                conn.setRequestProperty("content-type", "application/json");
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            }
            // 发送POST请求必须设置如下两行
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(30000);
            outStream = conn.getOutputStream();
            outStream.write(params.getBytes(wEncoding));
            outStream.flush();
            outStream.close();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), rEncoding));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
            System.out.println("res="+result);
        }
        catch (Exception e)
        {
            result = "error";
            System.out.println("发送 POST 请求出现异常！" + e);
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out, true));
         //   LogUtils.error(HttpClientUtils.class, "http的post请求失败，错误原因=" + out.toString());
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally
        {
            try
            {
                if (outStream != null)
                {
                    outStream.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }

}
