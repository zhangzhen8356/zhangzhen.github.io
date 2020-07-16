package com.zzhen.algorithm.base;

import java.util.Arrays;

/**
 * <p>功能描述：希尔排序-简单直接排序的升级</p>
 * <p>类名称：com.zzhen.algorithm.base.ShellSort</p>
 * <p>创建时间：2020/7/15 10:22</p>
 * @author zzhen
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{101,34,119,56,2,54,1,4,6,21};
        shellSortOfChange(arr);
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int)(Math.random() * 80000000);
        }
        long startTime = System.currentTimeMillis();
        //shellSortOfChange(arr1);
        shellSortOfMove(arr1);
        long endTime = System.currentTimeMillis();
        int second = (int)(endTime - startTime) / 1000;
        System.out.printf("本次排序消耗的时间：%ds", second);  //交换：6s  移位：0s

    }

    /**
     * 交换
     * @param arr
     */
    public static void shellSortOfChange(int[] arr){
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap >0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序(交换)第" + (++count) +"轮排序：arr" + Arrays.toString(arr));
        }
    }

    /**
     * 移位
     * @param arr
     */
    public static void shellSortOfMove(int[] arr){
        int count = 0;
        for (int gap = arr.length / 2; gap >0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                if (arr[i] < arr[i - gap]) {
                    int index = i;
                    int temp = arr[index];
                    while (index -gap >= 0 && temp < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = temp;
                }
            }
            //System.out.println("希尔排序(移位)第" + (++count) +"轮排序：arr" + Arrays.toString(arr));
        }
    }

    public static void shellSortOfChange01(int[] arr){
        //101,34,119,1,2,54,1,4,6,21
        //第一次 分成五组，每组两个元素
        int temp;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if(arr[j] > arr[j + 5]){
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮排序：arr" + Arrays.toString(arr));
        //第二次 分成二组，每组5个元素
        for (int i = 2; i < arr.length; i++) {
            for(int j = i - 2; j >= 0; j -= 2){
                if(arr[j] > arr[j + 2]){
                    temp = arr[j];

                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序第二轮排序：arr" + Arrays.toString(arr));

        //第三次 分成1组，每组10个元素
        for (int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0; j -= 1){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序第三轮排序：arr" + Arrays.toString(arr));
    }

    public static void shellSortOfInsert(int[] arr){
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap >0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[i];
                if (arr[j] < arr[j - gap]){
                    while (j -gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("希尔排序(移位)第" + (++count) +"轮排序：arr" + Arrays.toString(arr));
        }
    }
}

