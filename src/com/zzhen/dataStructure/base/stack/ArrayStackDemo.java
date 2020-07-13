package com.zzhen.dataStructure.base.stack;

import java.util.Scanner;

/**
 * <p>功能描述：栈实现</p>
 * <p>类名称：com.zzhen.dataStructure.base.stack.ArrayStackDemo</p>
 * <p>创建时间：2020/6/24 17:24</p>
 * @author zzhen
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        String key = "";
        boolean flag = true;
        while (flag) {
            System.out.println("push:添加数据到栈空间");
            System.out.println("pop:弹出数据从栈空间");
            System.out.println("show:展示栈空间数据");
            System.out.println("exit:退出");
            Scanner scanner = new Scanner(System.in);
            key = scanner.next();
            switch (key) {
                case "push":
                    System.out.println("请输入要保存的数据");
                    int num = scanner.nextInt();
                    arrayStack.push(num);
                    break;
                case "pop":
                    try {
                        int result = arrayStack.pop();
                        System.out.printf("从栈中弹出的数据为：%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    flag = false;
                    break;
                case "show":
                    arrayStack.show();
                    break;
                    default:
                        break;
            }
        }
        System.out.println("程序停止~");
    }

}
class ArrayStack {
    /**
     * 最大容量
     */
    private int maxSize;

    /**
     * 栈数组
     */
    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    /**
     * 判断是否满
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 出栈
     */
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈为空~");
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * 入栈
     */
    public void push(int num){
        if(isFull()){
            System.out.println("栈空间满了~");
            return;
        }
        stack[++top] = num;
    }

    /**
     * 展示栈空间数据
     */
    public void show(){
        if (isEmpty()) {
            System.out.println("栈空间为空~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈空间数据stack[%d] = %d\n", top, stack[top]);
        }
    }
}
