package cn.zlpc.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	 public static String EncoderByMd5(String str) {
	         //确定计算方法
	         MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         BASE64Encoder base64en = new BASE64Encoder();
	         //加密后的字符串
	         String newstr = null;
			try {
				newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
			} catch (UnsupportedEncodingException e) {
				 e.printStackTrace();
			}
	         return newstr;
	     }
/*	 
	 public static void main(String[] args){
		 String test = "zhaoyan2008";
		 System.out.println(MD5Util.EncoderByMd5(test));
	 }*/
}