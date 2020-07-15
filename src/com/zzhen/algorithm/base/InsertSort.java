package com.zzhen.algorithm.base;

import java.util.Arrays;

/**
 * <p>功能描述：插入排序</p>
 * <p>类名称：com.zzhen.algorithm.base.InsertSort</p>
 * <p>创建时间：2020/7/14 16:13</p>
 * @author zzhen
 */
public class InsertSort {
    public static void main(String[] args) {
        //101,34,119,1
        int[] arr = new int[]{101,34,119,1};
        insertSort(arr);
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int)(Math.random() * 800000);
        }
        long startTime = System.currentTimeMillis();
        insertSort(arr1);
        long endTime = System.currentTimeMillis();
        int second = (int)(endTime - startTime) / 1000;
        System.out.printf("本次排序消耗的时间：%ds", second); //耗时0s
    }

    public static void insertSort(int[] arr){
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出循环,找到位置了
            arr[insertIndex + 1] = insertVal;
            //System.out.println("第"+ i +"次排序后的结果arr:" + Arrays.toString(arr));
        }
    }
    /**
     * 一步一步走
     * @param arr
     */
    public static void insertSort01(int[] arr){
        //101,34,119,1
        int insertVal;
        int insertIndex;
        insertVal = arr[1];
        insertIndex = 1-1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //退出循环,找到位置了
        arr[insertIndex + 1] = insertVal;
        System.out.println("第一次排序后的结果arr:" + Arrays.toString(arr));

        insertVal = arr[2];
        insertIndex = 2-1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //退出循环,找到位置了
        arr[insertIndex + 1] = insertVal;
        System.out.println("第二次排序后的结果arr:" + Arrays.toString(arr));

        insertVal = arr[3];
        insertIndex = 3-1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        //退出循环,找到位置了
        arr[insertIndex + 1] = insertVal;
        System.out.println("第三次排序后的结果arr:" + Arrays.toString(arr));
    }
}
