package com.zzhen.dataStructure.base.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>功能描述：后缀表达式-》计算器</p>
 * <p>类名称：com.zzhen.dataStructure.base.stack.SuffixCalculator</p>
 * <p>创建时间：2020/7/13 14:23</p>
 * @author zzhen
 */
public class SuffixCalculator {

    //核心思想
    /**
     * 从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，
     * 弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），
     * 并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
     */
    public static void main(String[] args) {
       String suffixStr = "3 4 + 5 * 6 -";
       int result = calculator(getList(suffixStr));
        System.out.println("result = " + result);
    }


    public static List<String> getList(String suffixStr){
        String[] split = suffixStr.split(" ");
        return Arrays.asList(split);
    }

    public static int calculator(List<String> suffixList){
        Stack<String> stack = new Stack<>();
        int num1;
        int num2;
        for (String s : suffixList) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")){
                    res = num2 - num1;
                } else if (s.equals("*")){
                    res = num2 * num1;
                } else if (s.equals("/")){
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
