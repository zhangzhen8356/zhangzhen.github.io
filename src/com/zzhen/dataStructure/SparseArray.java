package com.zzhen.dataStructure;


/**
 * <p>功能描述：稀疏数组使用</p>
 * <p>类名称：com.zzhen.dataStructure.SparseArray</p>
 * <p>创建时间：2020/6/17 17:20</p>
 * @author zzhen
 */
public class SparseArray {

    public static void main(String[] args) {
        //黑子使用1标示  蓝子使用2标示
        int[][] cheerArray = new int[11][11];
        cheerArray[1][2] = 1;
        cheerArray[2][3] = 2;
        cheerArray[3][4] = 2;
        //打印一下原始棋盘的数组
        System.out.println("==========原始棋盘数组=========");
        for (int[] ints : cheerArray) {
            for (int val : ints) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        //由原始棋盘数组转为稀疏数组并存盘
        int total = 0;
        for (int[] ints : cheerArray) {
            for (int val : ints) {
                if(val != 0){
                    total++;
                }
            }
        }
        int[][] sparseArray = new int[total + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = total;

        int rowNum = 0;
        for (int i = 0; i < cheerArray.length; i++) {
            for (int j = 0; j < cheerArray[i].length; j++) {
                if(cheerArray[i][j] != 0){
                    rowNum++;
                    sparseArray[rowNum][0] = i;
                    sparseArray[rowNum][1] = j;
                    sparseArray[rowNum][2] = cheerArray[i][j];
                }
            }
        }
        //打印一下稀疏棋盘的数组
        System.out.println("==========稀疏数组=========");
        for (int[] ints : sparseArray) {
            for (int val : ints) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        //稀疏数组还原到棋盘数组
        int[][] newCheerArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            newCheerArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //打印一下还原之后原始棋盘的数组
        System.out.println("==========还原原始棋盘数组=========");
        for (int[] ints : newCheerArray) {
            for (int val : ints) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

    }
}
