package tool.mastery.core;

import java.io.UnsupportedEncodingException;

public class CharacterUtil {
//  GENERAL_PUNCTUATION 判断中文的“号  
    //  CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号  
    //  HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号  
    public static boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
    }  
  
    public static boolean isChinese(String strName) { 
    	boolean flag = false;
        char[] ch = strName.toCharArray();  
        for (int i = 0; i < ch.length; i++) {  
            char c = ch[i];  
            //如果到达最后一个字符
            if( i == ch.length) {
            	//如果是中文
            	if (isChinese(c)) {  
            		flag = true;  
                }
            }else {
            	//如果是中文
            	if (isChinese(c)) {  
            		flag = true;  
                }else {
                	continue;
                }
            }
        }  
        return flag;
    }  
    
    public static String transcoding(String orgin) {
		String temp = orgin;
		String notifyName = null;
		try {
			byte[] bytes = temp.getBytes("ISO-8859-1");
			notifyName = new String(bytes, "utf-8");// 此乱码的原因是 用request对象得到的参数
													// 是经过utf-8编码再以iso8859-1编码过来的乱码
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return notifyName;
	}
    
    public static String process(String value) {
    	String retVal = value;
    	if(!CharacterUtil.isChinese(value)) {
    		retVal = CharacterUtil.transcoding(value);
    	}
    	return retVal;
    }
    
    
    public static void main(String[] args) {  
        System.out.println(isChinese("sdf士大夫dsfsdf"));  
    }  
}
