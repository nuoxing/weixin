package com.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * 在使用自定义菜单时，获取access_token
 * @author sjakl
 *
 */
public class TokenUtil {

	public static String getToken() throws JSONException {
		String resStr = "";
		String urlStr = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxfca61bd3ccdce1d8&secret=b1ad66da3c03c33a23a46405a99ef59d";
		URL url = null;
		HttpsURLConnection conn = null;
		BufferedReader in = null;
		StringBuilder sb = null;
		try {
			url = new URL(urlStr);
			conn = (HttpsURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.setDoInput(true);

			sb = new StringBuilder();
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.disconnect();
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(sb.toString());
		resStr = sb.toString();
		JSONObject jsonObject = new JSONObject(resStr);
		return jsonObject.getString("access_token");

	}

}
