/*
 * �ļ�����HttpClientUtils.java ��Ȩ��Copyright by www.chinauip.com ������ �޸��ˣ�Administrator �޸�ʱ�䣺2017��11��18��
 * ���ٵ��ţ� �޸ĵ��ţ� �޸����ݣ�
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
 * ����http����Ĺ����� ��������ϸ������
 * 
 * @author suwy
 * @version 2017��11��18��
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
     * ����:http��get���� <br>
     * 
     * @param stUrl
     *            �����url,�����url������ʱ���ڴ���ǰ��Ҫ����
     * @param encode
     *            ��ȡ���ݵı���
     * @return �����Ƿ��� ����Ľ�� ����ʱ����error
     * @see
     */
    public static String commonGet(String stUrl, String encode)
    {
        System.out.println("����http����url=" + stUrl);
       // LogUtils.info(HttpClientUtils.class, "����http����url=" + stUrl);
        String res = "error";
        try
        {
            URL url = new URL(stUrl); // ���ַ���ת��ΪURL�����ַ
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();// ������
            connection.connect();// ���ӻỰ
            connection.setReadTimeout(30000);
            // ��ȡ������
            BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), encode));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null)
            {// ѭ����ȡ��
                sb.append(line);
            }
            br.close();// �ر���
            connection.disconnect();// �Ͽ�����
            res = sb.toString();
            System.out.println("res=" + res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out, true));
          //  LogUtils.error(HttpClientUtils.class, "http��get����ʧ�ܣ�����ԭ��=" + out.toString());
            System.out.println("ʧ��!");
            res = "error";
        }
        return res;
    }

    /**
     * ����: http��post����<br>
     * 
     * @param url
     *            ����url
     * @param params
     *            ���� json��ʽ
     * @param property
     *            ������������,��nullֵʱ��Ĭ��ֵ�����磺 Map<String,String> property = new
     *            HashMap<String,String>(); property.put("content-type", "application/json");
     * @param wEncoding
     *            д�����ݱ���
     * @param rEncoding
     *            ��ȡ���ݱ���
     * @return ��������ʱ���������� ���󷵻�error
     * @see
     */
    public static String commonPost(String url, String params, Map<String, String> property,
                                    String wEncoding, String rEncoding)
    {
        OutputStream outStream = null;
        BufferedReader in = null;
        String result = "";
        System.out.println("����http����url=" + url);
      //  LogUtils.info(HttpClientUtils.class, "����http����url=" + url);
        try
        {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // ����ͨ�õ���������
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
            // ����POST�������������������
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setReadTimeout(30000);
            outStream = conn.getOutputStream();
            outStream.write(params.getBytes(wEncoding));
            outStream.flush();
            outStream.close();
            // ����BufferedReader����������ȡURL����Ӧ
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
            System.out.println("���� POST ��������쳣��" + e);
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out, true));
         //   LogUtils.error(HttpClientUtils.class, "http��post����ʧ�ܣ�����ԭ��=" + out.toString());
            e.printStackTrace();
        }
        // ʹ��finally�����ر��������������
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
