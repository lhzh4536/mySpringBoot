package com.shiyanlou;

import java.util.HashMap;

public class ArraysTester {

    public static void main(String[] args) {
        int[] arrays= {1,2,3};
        int b=binarySearch(arrays,2);
//        int b=binSearch_2(arrays,0,arrays.length-1,3);
       System.out.println(b); 
       
    }
    
    static int getIndex(int[] arrays,int value) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arrays.length;i++) {
            map.put(arrays[i], i);
        }
        return (int)(map.containsKey(value)==true?map.get(value):-1);
      
    }
    
    static int binSearch_2(int[] arrays,int L, int R,int target) {
        if (target<arrays[L]||target>arrays[R]||L>R) {
            return -1;
        }
        int middle =(R+L)/2;
        if(target>arrays[middle]) {
            return  binSearch_2(arrays,middle+1,R,target);
        }else if(target<arrays[middle]) {
            return  binSearch_2(arrays,L,middle-1,target);
        }else {
            return middle;
        }
     
    }
    static int binarySearch(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid; 
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
            }
        return -1;
    }
}
