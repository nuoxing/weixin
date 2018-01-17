package com.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;

import com.weixin.util.ConstantUtils;
import com.weixin.util.HttpClientUtils;
import com.weixin.util.MessageUtil;

public class Test {

	@org.junit.Test
	public void textTest() throws Exception{
		InputStream inputStream=null;
		String str="<xml>" +
				"<ToUserName><![CDATA[gh_680bdefc8c5d]]></ToUserName>" +
				"<FromUserName><![CDATA[oIDrpjqASyTPnxRmpS9O_ruZGsfk]]></FromUserName>" +
				"<CreateTime>1359028446</CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[测试文字]]></Content>" +
				"<MsgId>5836982729904121631</MsgId>" +
				"</xml>";
		inputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
		Map<String, String> parseXml = MessageUtil.parseXml(inputStream);
		Iterator<Entry<String, String>> iterator = parseXml.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey());
			System.out.println(next.getValue());
		}
	}
	
	//所谓的接口调用情况
	@org.junit.Test
	public void apiTest() throws Exception{
		//String urlStr="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxfca61bd3ccdce1d8&secret=b1ad66da3c03c33a23a46405a99ef59d";
		String urlStr="http://localhost:8080/test/json.do"; 
		URL url=new URL(urlStr);  
	       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	     
	       conn.setRequestMethod("GET");  
	       //conn.setDoOutput(true);  
	       conn.setDoInput(true);  
	      // PrintWriter printWriter = new PrintWriter(conn.getOutputStream());  
	        
	      // printWriter.flush();          
	       BufferedReader in = null;   
	       StringBuilder sb = new StringBuilder();   
	       try{     
	           in = new BufferedReader( new InputStreamReader(conn.getInputStream(),"UTF-8") );   
	           String str = null;    
	           while((str = in.readLine()) != null) {    
	               sb.append( str );     
	           }     
	        } catch (Exception ex) {   
	           throw ex;   
	        } finally{    
	         try{   
	             conn.disconnect();  
	             if(in!=null){  
	                 in.close();  
	             }  
	            // if(printWriter!=null){  
	             //    printWriter.close();  
	            // }  
	         }catch(IOException ex) {     
	             throw ex;   
	         }     
	        } 
	       System.out.println(sb.toString());
	}
	
	//测试图片
	@org.junit.Test
	public void imageTest() throws Exception{
		InputStream inputStream=null;
		String str="<xml>" +
				"<ToUserName><![CDATA[gh_680bdefc8c5d]]></ToUserName>" +
				"<FromUserName><![CDATA[oIDrpjqASyTPnxRmpS9O_ruZGsfk]]></FromUserName>" +
				"<CreateTime>1359028446</CreateTime>" +
				"<MsgType><![CDATA[image]]></MsgType>"+
				"<PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/L4qjYtOibummHn90t1mnaibYiaR8ljyicF3MW7XX3BLp1qZgUb7CtZ0DxqYFI4uAQH1FWs3hUicpibjF0pOqLEQyDMlg/0]]></PicUrl>"+
			    "<MsgId>5836982871638042400</MsgId>"+
				"<MediaId><![CDATA[PGKsO3LAgbVTsFYO7FGu51KUYa07D0C_Nozz2fn1z6VYtHOsF59PTFl0vagGxkVH]]></MediaId>"+
				"</xml>";
		inputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
		Map<String, String> parseXml = MessageUtil.parseXml(inputStream);
		Iterator<Entry<String, String>> iterator = parseXml.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey());
			System.out.println(next.getValue());
		}
	}
	
	@org.junit.Test
	public void tokenapi() throws JSONException{
		System.out.println(HttpClientUtils.commonGet(ConstantUtils.ACCESS_TOKEN_URL, "utf-8"));
	}
			
	
}
