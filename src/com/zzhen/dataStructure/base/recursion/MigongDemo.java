package com.zzhen.dataStructure.base.recursion;

/**
 * <p>功能描述：递归迷宫问题</p>
 * <p>类名称：com.zzhen.dataStructure.base.recursion.MigongDemo</p>
 * <p>创建时间：2020/7/3 8:58</p>
 *
 * @author zzhen
 */
public class MigongDemo {

    public static void main(String[] args) {
        int[][] migong = new int[7][8];
        //将上下设置为墙
        for (int i = 0; i < 8; i++) {
            migong[0][i] = 1;
            migong[6][i] = 1;
        }

        for (int i = 0; i < 7; i++) {
            migong[i][0] = 1;
            migong[i][7] = 1;
        }

        migong[2][1] = 1;
        migong[2][2] = 1;

        print(migong);
        step(migong, 1, 1);
        System.out.println("迷宫出===========");
        print(migong);

    }

    private static void print(int[][] migong) {
        for (int i = 0; i < migong.length; i++) {
            for (int j = 0; j < migong[i].length; j++) {
                System.out.print(migong[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 二维数组中1标示墙，2标示这条路已经走过了， 3标示此路不通   0标示没有走过
     * 指定策略 下 -> 右 -> 上 -> 左
     *
     * @param migong 迷宫的二维数组
     * @param x      起始位置 行
     * @param y      起始位置列
     */
    private static void step(int[][] migong, int x, int y) {

        if (migong[5][6] == 2) {
            return ;
        }

        if (migong[x][y] == 0) {
            migong[x][y] = 2;
            if (migong[x + 1][y] == 0) {
                step(migong, x + 1, y);

            } else if (migong[x][y + 1] == 0) {
                step(migong, x, y + 1);

            } else if (migong[x - 1][y] == 0) {
                step(migong, x - 1, y);

            } else if (migong[x][y - 1] == 0) {
                step(migong, x, y - 1);

            } else {
                migong[x][y] = 3;
                return ;
            }
        } else {
            // 1,2,3
            return ;
        }
        //return false;
    }
}
