package com.zzhen.algorithm.base;

import java.util.Arrays;

/**
 * <p>功能描述：选择排序</p>
 * <p>类名称：com.zzhen.algorithm.base.SelectSort</p>
 * <p>创建时间：2020/7/14 15:40</p>
 * @author zzhen
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] oldArray = new int[]{101, 34, 119, 1};
        selectSort(oldArray);
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000000);  //生成一个[0,8000000)数
        }
        long startTime = System.currentTimeMillis();
        selectSort(arr);
        long endTime = System.currentTimeMillis();
        int second = (int)(endTime - startTime) / 1000;
        System.out.printf("本次排序消耗的时间：%ds", second);

    }

    public static void selectSort(int[] arr){
        //101, 34, 119, 1
        int temp;
        int index;
        for(int j = 0; j < arr.length -1; j++){
            temp = arr[j];
            index = j;
            for(int i = j + 1; i < arr.length; i++){
                if(temp > arr[i]){
                    index = i;
                    temp = arr[i];
                }
            }
            //判断是否需要换
            if (index != j) {
                arr[index] = arr[j];
                arr[j] = temp;
            }
            //System.out.println("第"+ (j+1) +"次排序之后，arr = " + Arrays.toString(arr));
        }
    }
}
