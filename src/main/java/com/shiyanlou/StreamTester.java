package com.shiyanlou;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTester {
    public static void main(String[] args) {
        // 输出10个随机数
//        Random random =new Random();
//        random.ints().limit(10L).forEach(System.out::println);
//        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);

        // 输出唯一的某个数的平方
//        List<Integer> numbers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
//        // get list of unique squares
//        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        squaresList.forEach(System.out::println);

        // 输出使用了过滤方法的空字符串数量。
//        List<String>strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
//      //get count of empty string
//        long count = strings.stream().filter(string->string.isEmpty()).count();
//        System.out.println(count);
        //Collector 用于合并 Stream 的元素处理结果。它可以用于返回一个字符串列表。
        List<String>strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
        
        //Java 8 引入了用于统计的 Collector 来计算 Stream 处理完成后的所有统计数据。
//        List<Integer> numbers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
//
//        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
//
//        System.out.println("Highest number in List : " + stats.getMax());
//        System.out.println("Lowest number in List : " + stats.getMin());
//        System.out.println("Sum of all numbers : " + stats.getSum());
//        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
