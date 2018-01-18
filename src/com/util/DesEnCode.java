package com.util;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;


/**
 * 进行加密及解密操作
 * 
 * @author 杨国华
 * @version 2017年9月25日
 * @see DesEnCode
 * @since
 */
public class DesEnCode
{
    /**
     * DES解密
     * 
     * @param message
     *            需要解密的内容
     * @param key
     *            密钥
     * @return 解密后的字符串
     * @throws Exception Exception
     */
    public static String decrypt(String message, String key)
        throws Exception
    {

        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] retByte = cipher.doFinal(bytesrc);
        //return new String(retByte);
        return new String(retByte, "UTF-8");
    }
    
    
    

    /**
     * DES加密
     * 
     * @param message
     *            需要加密的内容
     * @param key
     *            密钥
     * @return 加密后的字符串
     * @throws Exception Exception
     */
    public static byte[] encrypt(String message, String key)
        throws Exception
    {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    
    public static String enBySha1(String str){
        MessageDigest mdt;
        String temp = "";
        try
        {
            mdt = MessageDigest.getInstance("SHA-1");
            byte[] digest = mdt.digest(str.toString().getBytes());
            temp  = toHexString(digest);
        }
        catch (NoSuchAlgorithmException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
       return temp;
    }
    
    /**
     * 将字符串转换十六进制数组
     * 
     * @param ss
     *            需要转换的字符串
     * @return 转换后的十六进制数组
     */
    public static byte[] convertHexString(String ss)
    {
        byte[] digest = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++ )
        {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte)byteValue;
        }

        return digest;
    }

    
    /**
     * 将BYTE数组中的内容转换为十六进制的字符串
     * 
     * @param b
     *            BYTE数组
     * @return 转换后的十六进制的字符串
     */
    public static String toHexString(byte[] b)
    {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++ )
        {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
            {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }

        return hexString.toString();
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println(DesEnCode.enBySha1("aa"));
    }
    
    
   
}
