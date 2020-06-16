package com.Array;

import java.util.HashSet;
import java.util.Set;

/*零矩阵
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    示例 1：
    输入：
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    输出：
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]

    示例 2：
    输入：
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    输出：
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]
 */
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {
        //误区：边遍历边替换，容易替换多
        //解决方案：先遍历，再替换
        //遍历将需要替换的行和列存放到中间结果
        Set iSet = new HashSet();
        Set jSet = new HashSet();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }

        //替换
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(iSet.contains(i)||jSet.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }
}
