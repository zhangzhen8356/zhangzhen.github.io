package com.zzhen.algorithm.base;

import java.util.Arrays;

/**
 * <p>功能描述：冒泡排序实现</p>
 * <p>类名称：com.zzhen.algorithm.base.BubbleSort</p>
 * <p>创建时间：2020/7/14 14:57</p>
 * @author zzhen
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] oldArray = new int[]{6,4,2,1,5};
        bubbleSort(oldArray);
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000000);  //生成一个[0,8000000)数
        }
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        int second = (int)(endTime - startTime) / 1000;
        System.out.printf("本次排序消耗的时间：%ds", second); //耗时9s
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr){
       //4,2,1,5
        //临时变量
        int temp;
        boolean flag = true;
        for (int j = 1; j < arr.length; j++) {
            for(int i = 0; i < arr.length -j; i++){
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;  //重置标示位
            }
//            System.out.printf("第%d次排序之后，arr = " + Arrays.toString(arr), j);
//            System.out.println();
        }

    }
}
