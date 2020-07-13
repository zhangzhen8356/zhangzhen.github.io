package com.zzhen.dataStructure.base;

import java.util.Scanner;

/**
 * <p>功能描述：数组队列实现</p>
 * <p>类名称：com.zzhen.dataStructure.ArraryQueueDemo</p>
 * <p>创建时间：2020/6/18 10:33</p>
 * @author zzhen
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加元素");
            System.out.println("e(exit):退出程序");
            System.out.println("g(get):获取元素");
            System.out.println("h(head):获取头元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    default:
                        break;
            }
        }
        System.out.println("程序结束~");
    }

}

class ArrayQueue {

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 最大容量
     */
    private int maxSize;

    /**
     * 保存数据的数组
     */
    private int[] arr;

    public ArrayQueue(int sizeNum){
        this.maxSize = sizeNum;
        arr = new int[sizeNum];
        this.front = -1; //指向队列头部，初始化指向队列头的前一个位置
        this.rear = -1;  //指向队列尾，指向队列尾的数据
    }

    /**
     * 队列是否满
     */
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 添加元素到队列
     */
    public void addQueue(int num){
        if (isFull()) {
            System.out.println("队列已满~");
            return ;
        }
        rear++;
        arr[rear] = num;
    }

    /**
     * 获取元素到队列
     */
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    /**
     * 展示队列所有元素
     */
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 返回对垒第一个元素
     */
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}

