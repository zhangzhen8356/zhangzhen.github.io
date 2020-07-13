package com.zzhen.dataStructure.base.stack;

/**
 * <p>功能描述：中缀表达式-》计算器</p>
 * <p>类名称：com.zzhen.dataStructure.base.stack.InfixCalculator</p>
 * <p>创建时间：2020/7/13 14:22</p>
 * @author zzhen
 */
public class InfixCalculator {


    public static void main(String[] args) {
        //中缀表达式
        String calculatorStr =  "70+6*5+80";
        ArrayStack3 operStack = new ArrayStack3(10);
        ArrayStack3 numStack = new ArrayStack3(10);
        int num1;
        int num2;
        char oper;
        char character = ' ';
        int tempResult;
        int i = 0;
        String tempNumStr = "";
        while (true) {
            //跳出死循环
            if(i > calculatorStr.length() - 1){
                break;
            }
            character = calculatorStr.charAt(i);
            if (numStack.isOper(character)) {
                //判断运算符栈是否为空
                if (operStack.isEmpty()) {
                    operStack.push(character);
                } else {
                    //是运算符
                    if (operStack.priorty(character) > operStack.priorty(operStack.peek())) {
                        //读取到的运算符大于运算符栈栈顶的符号
                        operStack.push(character);
                    } else {
                        //小于
                        num2 = numStack.pop();
                        num1 = numStack.pop();
                        oper = (char) operStack.pop();
                        tempResult = numStack.cal(num1, num2, oper);

                        //将计算得到的结果加到操作算栈中
                        numStack.push(tempResult);
                        operStack.push(character);
                    }
                }
            } else {

                //是数字， 需要注意char类型转int类型
              //  numStack.push(character - 48);
                tempNumStr += character;
                if(i == calculatorStr.length() - 1){
                    numStack.push(Integer.parseInt(tempNumStr));
                    tempNumStr = "";
                } else {
                    if (operStack.isOper(calculatorStr.charAt(i + 1))) {
                        numStack.push(Integer.parseInt(tempNumStr));
                        tempNumStr = "";
                    }
                }
            }
            i++;
        }

        //再次while循环，计算最终结果
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = (char) operStack.pop();
            tempResult = numStack.cal(num1, num2, oper);
            //将计算
            numStack.push(tempResult);
        }

        int result = numStack.pop();
        System.out.printf("运算结果为：%d", result);
    }

}

class ArrayStack3 {
    /**
     * 最大容量
     */
    private int maxSize;

    /**
     * 数据对象，存放元素
     */
    private int[] stack;

    /**
     * 栈顶指针坐标
     */
    private int top = -1;

    public ArrayStack3(int num) {
        this.maxSize = num;
        this.stack = new int[num];
    }

    /**
     * 是否满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 查看当前栈顶的值
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空~");
        }
        return stack[top];
    }

    /**
     * 获取元素
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空~");
        }
        int result = stack[top];
        top--;
        return result;
    }

    /**
     * 添加元素
     */
    public void push(int object) {
        if (isFull()) {
            System.out.println("栈空间满");
            return;
        }
        stack[++top] = object;
    }

    /**
     * 展示栈元素
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空~");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("栈元素stack[%d] = %d\n", top, stack[top]);
        }
    }

    /**
     * 根据操作符，判断优先级
     */
    public int priorty(int operChar){
        if (operChar == '/' || operChar == '*') {
            return 1;
        } else if (operChar == '+' || operChar == '-'){
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 是否是操作符
     * @param oper
     */
    public boolean isOper(char oper){
        return oper == '/' || oper == '*' || oper == '+' || oper == '-';
    }

    /**
     * 根据操作符，执行响应的计算
     */
    public int cal(int num1, int num2, char oper){
        int result = 0;
        switch (oper) {
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
                default:
                    break;
        }
        return result;
    }

}
