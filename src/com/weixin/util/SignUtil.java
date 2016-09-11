package com.weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 签名验证
 * @author sjakl
 *
 */
public class SignUtil {

	private  static String token = "";//自己在微信上设置的token
	
	//检查签名
	public static boolean checkSignature(String signature, String timestamp, String nonce){
		String[] arr = new String[]{token,timestamp,nonce};
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		
		MessageDigest mdt = null;
		String temp = null;
		
		try {
			mdt = MessageDigest.getInstance("SHA-1");
			byte[] digest = mdt.digest(content.toString().getBytes());
			temp = bytesToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp != null ? temp.equals(signature.toUpperCase()) : false;
		
	}
	
	//将字节数组转换为16进制的字符串
	private static String bytesToStr(byte[] bytes){
		StringBuilder strDisgest = new StringBuilder();
		for(int i=0;i<bytes.length;i++){
			strDisgest.append(byteToHex(bytes[i]));
		}
		return strDisgest.toString();
	}
	
	//将字节转换16进制
	private static String byteToHex(byte mByte){
		  char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
	        char[] tempArr = new char[2];  
	        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
	        tempArr[1] = Digit[mByte & 0X0F];  
	        String s = new String(tempArr);  
	        return s;  
	}
	
}
