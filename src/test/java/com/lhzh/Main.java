package com.lhzh;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        String self ;
        List<String> next;
        List<String> pre;
        Boolean isFault;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public List<String> getNext() {
            return next;
        }

        public void setNext(String next) {
            if (this.next==null){
                this.next=new ArrayList<String>();
            }
            this.next.add(next);
        }

        public List<String> getPre() {
            return pre;
        }
        //依赖的元素
        public void setPre(String pre) {
            if (this.pre==null){
                this.pre=new ArrayList<String>();
            }
            this.pre.add(pre);
        }

        public Boolean isFault() {
            return isFault;
        }

        public void setFault(Boolean fault) {
            isFault = fault;
        }
    }
    static Map<String,Node> result =new HashMap<>();  //结果
    static Map<String,Node> nodes = new HashMap<>();//所有节点
    static Map<String,Node> head =new HashMap<>();//最底层依赖
    public static void main(String[] args) throws IOException{

        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串,依赖关系
        String dependStr = br.readLine();
            // 将依赖关系根据逗号进行分隔
            String[] strings = dependStr.trim().split(",");
            // 分别将其中的每个数值读出
            for(String str :strings) {
                String[] nodestr= str.trim().split("-");
                String thisstr =nodestr[0];
                String prestr =nodestr[1];
                //设置依赖元素
                Node thisnode= new Node();
                thisnode.setSelf(thisstr);
                thisnode.setPre(prestr);
                thisnode.setFault(false);
                //设置被依赖元素
                Node prenode= new Node();
                prenode.setSelf(prestr);
                prenode.setNext(thisstr);
                prenode.setFault(false);
                //放入map中
                nodes.put(thisstr,thisnode);
                head.remove(thisstr);
                nodes.put(prestr,prenode);
                head.put(prestr,prenode);

            }
        //读取故障列表
        String faultsStr = br.readLine();
        // 将故障列表取出,并设置标记为故障
        String[] faultsstrs = faultsStr.trim().split(",");
        for (String falut:faultsstrs){
            Node falutnode = nodes.get(falut);

            falutnode.setFault(true);
        }

        //从底层节点开始遍历,添加非故障节点
        head.forEach((k,v)->{
            if(!v.isFault){
                result.put(k,v);
                setResult(v);
            }
        });
        //输出
        if (result.size()==0){
            System.out.println(",");
        }else {

            Set<String> keySet = result.keySet();
            Object[] objects = keySet.toArray();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i=keySet.size()-1;i>=0;i--){
                stringBuilder.append((String) objects[i]).append(",");
            }
            int length = stringBuilder.length();
            stringBuilder.delete(length-1,length);
            System.out.println(stringBuilder.toString());
        }

    }
    private static void setResult(Node v){
        List<String> next = v.getNext();
        for (String str :next){
            if (!nodes.get(str).isFault){
                result.put(str,v);
            }
        }

    }
    //读取一行
    private static String readString()throws IOException{
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取字符串
        String line = br.readLine();
        return line;
    }
    //读取两个数字
    private  static int[] readTwoInt() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);

       return new int[]{n,v};

    }
    //读取数组
    private  static int[] readInts() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        // 将字符串根据空格进行分隔
        String[] strings = line.trim().split(" ");
        // 分别将其中的每个数值读出
        int n = Integer.parseInt(strings[0]);
        int v = Integer.parseInt(strings[1]);
        // 读取第二行数据
        line = br.readLine();
        strings = line.trim().split(" ");
        // 创建一个int型的数组用来储存第二行的多个数字
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

    return nums;

    }

    static void  readSquat() throws IOException {
        // 创建一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取第一行数据
        String line = br.readLine();
        String msg=null;
        int ans= 0;
        while ( (msg = br.readLine())!= null){
            // 将字符串根据空格进行分隔
            String[] strings = msg.trim().split(" ");
            // 分别将其中的每个数值读出
            for(String str :strings) {
                ans += Integer.parseInt(str);
            }
        }


        System.out.println(ans);
    }
}
