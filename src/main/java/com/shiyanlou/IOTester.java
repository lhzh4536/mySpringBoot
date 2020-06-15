package com.shiyanlou;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOTester {

    public static void main(String[] args) {
        try (InputStreamReader isr =new InputStreamReader(
                new FileInputStream(new File("D://aaa.txt")),"UTF-8");
                OutputStreamWriter osw =new OutputStreamWriter(
                        new FileOutputStream(new File("D://bbb.txt")),"GBK");
                       ){
            char[] cbuf =new char[1024];
            int len;
            while((len = isr.read(cbuf))!=-1) {
                osw.write(cbuf,0,len);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
//        try (BufferedReader bs =new BufferedReader(new InputStreamReader(
//                new FileInputStream(new File("D://aaa.txt")), "UTF-8"));
//                BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(
//                        new FileOutputStream(new File("D://bbb.txt")),"GBK"));
//                       ){
//            char[] cbuf =new char[1024];
//            int len;
//            while((len = bs.read(cbuf))!=-1) {
//                bw.write(cbuf, 0, len);
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
    }
}
