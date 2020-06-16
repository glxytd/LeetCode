package com.Array;

import java.util.HashSet;
import java.util.Set;

/*对角线遍历
    给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

    示例:
    输入:
    [
     [ 1, 2, 3, 4],
     [ 5, 6, 7, 8],
     [ 9,10,11,12]
    ]
    输出:  [1,2,5,9,6,3,4,7,10,11,8,12]
 */
public class FindDiagonalOrder {
    //右上和左下两种运动方向，撞墙（边界）则反向
    //右上：i--,j++   右上撞墙：i==-1 || j==N  撞上墙：i++;j不变  撞右墙：i+=2,j--
    //左下：i++,j--   左下撞墙：i==M || j==-1  撞下墙：i--;j=+2  撞左墙：i不变;j++
    public static int[] findDiagonalOrder(int[][] matrix) {
        //边界校验
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int M = matrix.length;
        int N = matrix[0].length;
        System.out.println("M:"+M+",N:"+N);
        int row = 0, column = 0;
        int direction = 1;//默认右上
        int[] result = new int[M*N];
        int r = 0;
        while (r<M*N) {
            result[r++] = matrix[row][column];
            System.out.println(matrix[row][column]);
            if (direction == 1) {
                row--;
                column++;
                if (row ==-1) {//撞上墙
                    row++;
                    direction = -1;
                }else if (column == N) {//撞右墙
                    row+=2;
                    column--;
                    direction = -1;
                }
            } else {
                row++;
                column--;
                if (row == M) {//撞下墙反向
                    row--;
                    column+=2;
                    direction = 1;
                }else if (column ==-1 ) {//撞左墙反向
                    column++;
                    direction = 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        findDiagonalOrder(matrix);
    }
}
