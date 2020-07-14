package com.zzhen.dataStructure.base.recursion;

/**
 * <p>功能描述：8皇后问题描述</p>
 * <p>类名称：com.zzhen.dataStructure.base.recursion.Queue8Demo</p>
 * <p>创建时间：2020/7/7 15:40</p>
 * @author zzhen
 */
public class Queue8Demo {

    /**
     * 表示有多少个皇后
     */
    int max = 8;

    /**
     * 保存皇后放置位置的结果
     */
    int[] array = new int[max];

    /**
     * 解法的数量
     */
    static int total;

    /**
     * 判断次数
     */
    static int judgeNum;

    public static void main(String[] args) {
        Queue8Demo queue8Demo = new Queue8Demo();
        queue8Demo.check(0);
        System.out.println("解法的数量：" + total);
        System.out.println("判断次数：" + judgeNum);
    }

    public void check(int n){
        if (n == max) {  //n=8,8个皇后已经放置好了
            print();
            return ;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n,放到该行的第1列
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 打印数组
     */
    private void print(){
        total++;
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 查看当我们放置第n皇后，就去检测该皇后是否和前面已经摆好的皇后重复
     * @param n 第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgeNum++;
        for (int i = 0; i < n; i++) {
            //不在同一列
            if(array[i] == array[n]){
                return false;
            }
            //不在同一斜线
            if (Math.abs(n -i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
}
