package com.lhzh;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {

    public static void main(String[] args) throws IOException{

        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串,依赖关系
        String dependStr = br.readLine();
        StringBuilder stringBuilder =new StringBuilder();
        char[] chars = dependStr.toCharArray();
        int num =0;
        for (int i=0;i<chars.length;){
            char aChar = chars[i];

            if(!isNum(aChar)&&!isLow(aChar)){
                System.out.println("!error");
                return;
            }
            if (isNum(aChar)){
                num =(chars[i]-'0')+num*10;
                i++;

            }else if (isLow(aChar)){
                if(num==0){
                    num=1;
                }
                if(num==2){
                    System.out.println("!error");
                    return;
                }
                for (int a=1;a<=num;a++) {
                    stringBuilder.append(aChar);
                }
                num=0;
                i++;

            }
        }

        System.out.print(stringBuilder);
        br.close();
    }
 private static boolean isNum(char c){
    return  (c-'0')>=0&&(c-'9')<=0;
 }
    private static boolean isLow(char c){
        return  (c-'a')>=0&&(c-'z')<=0;
    }

}
