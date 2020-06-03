package com.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 加密辅助类
 * @author wsc
 * @time 2016-2-25
 */
public class SignUtil {
	
	private static String key = "IXCfWBE5dRfyuIcFmhe2ANQ6VmoRZxRP";

	public static String getSign(Map<String,Object> map) throws Exception{
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(!entry.getValue().equals("")&& !entry.getKey().equals("sign")){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
		//先按照字符串长度取短的那个字符串的长度作为条件，然后循环判断两个字符串的第一个字符的ASCII码大小，做出递增排序，如果两个字符串第一个字符的ASCII码一致，则判断第二个字符，以此类推，通过这种方式将字符串通过首字母的ASCII码进行排序。
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        result = MD5Encrypt.encrypt(result).toUpperCase();
        return result;
    }
}

