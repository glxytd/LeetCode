package com.Array;

import java.util.HashSet;
import java.util.Set;

/*旋转矩阵
        给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
        不占用额外内存空间能否做到？
        示例 1:
        给定 matrix =
        [
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ],

        原地旋转输入矩阵，使其变为:
        [
        [7,4,1],
        [8,5,2],
        [9,6,3]
        ]

        示例 2:
        给定 matrix =
        [
        [ 5, 1, 9,11],
        [ 2, 4, 8,10],
        [13, 3, 6, 7],
        [15,14,12,16]
        ],
        原地旋转输入矩阵，使其变为:
        [
        [15,13, 2, 5],
        [14, 3, 4, 1],
        [12, 6, 8, 9],
        [16, 7,10,11]
        ]
 */
public class Rotate {
    //前提，想明白matrix[i][j]会旋转到原来的matrix[j][N - i - 1]位置，即matrix[j][N - i - 1] = matrix[i][j]

    //旋转法
    /*思路：
            (1) 因为是正方形矩阵，所以旋转一个位置一定同时牵动了其它三个位置。
            (2) 根据位置对应关系将当前位置带入，推出四个位置的变化关系。
            (3) 限定遍历范围，确保每一个位置都只旋转一次并覆盖到所有发生变化的位置。
    如果是偶数边长的矩阵，可以横竖分别对折平分成四个小正方形；
    如果是奇数边长，则排除中心位置（旋转后位置不变），按高比宽长一位（或者相反）的平分成四个小矩形。
            (4) 遍历完成后将数组返回。
    */
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // 外层循环遍历到中间位置，奇数边长包含中间位置
        for (int i = 0; i < (N + 1) / 2; i++) {
            // 内层循环遍历到中间位置，奇数边长不包含中间位置
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][i];
                matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
                matrix[j][N - i - 1] = temp;
            }
        }
    }

    //翻转法（甜姨的思路，NB）
    public void rotate2(int[][] matrix) {
        int N = matrix.length;
        // 主对角线翻转
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //行中线左右翻转
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
        }
    }
}
