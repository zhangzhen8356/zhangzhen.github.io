package com.zzhen.dataStructure;

import java.util.Scanner;

/**
 * <p>功能描述：环形数组队列</p>
 * <p>类名称：com.zzhen.dataStructure.CircleArrayQueueDemo</p>
 * <p>创建时间：2020/6/18 16:43</p>
 * @author zzhen
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("a(add)添加元素");
            System.out.println("g(get)获取元素");
            System.out.println("s(show)展示队列");
            System.out.println("h(head)获取队列的头元素");
            System.out.println("e(exit)退出");
            Scanner scanner = new Scanner(System.in);
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入一个数：");
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("队列取出元素为%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.printf("队列取出头元素为%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    default:
                        break;
            }
        }
        System.out.println("程序结束~~~");
    }
}

class CircleArrayQueue {

    /**
     * 队列的第一个元素的坐标
     * 默认值为0
     */
    private int front;

    /**
     * 队列最后一个元素的下一个坐标（数组要预留一个空间）
     * 默认值为0
     */
    private int rear;

    /**
     * 数组的最大容量
     */
    private int maxSize;

    /**
     * 保存数据的数组
     */
    private int[] arr;

    public CircleArrayQueue(int num){
        this.maxSize = num;
        this.arr = new int[num];
    }

    /**
     * 是否满
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加元素到队列
     */
    public void addQueue(int num){
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取元素从队列
     */
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    /**
     * 展示队列中所有元素
     */
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        int size = (rear + maxSize - front) % maxSize;
        for (int i = front; i < size + front; i++){
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 获取队列第一个元素
     */
    public int headQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
