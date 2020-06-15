package com.Sort;

import java.util.Random;

/*
  二分排序的思想：
  数组中下标0到i-1已经是有序的，对下标i要放到前面0至i-1的某个位置上去（插入排序思想），
  但是在判断该放到那个位置时不用插入排序的循环比对方式，而是用二分查找的方式（基于双指针）。
  找到对应位置k之后，将原来下标k至i-1整体后移一位，将原下标i放到k位置。对应原数组相当于i插到k前面
 */
public class BinarySort {

    public static void BinarySort(int[] arrays){
        for(int i=1;i<arrays.length;i++){
            int left =0;
            int right = i-1;
            int mid =-1;
            while(left <=right){
                mid = (left +right)/2; //取中间位置
                if(arrays[mid]<=arrays[i]){//相等时，i要放到mid的后一位
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }

            int temp = arrays[i];//先记录i的值
            for(int j=i-1;j>=left;j--){//得从i-1向前遍历
                arrays[j+1] = arrays[j];
            }
            arrays[left] = temp;

        }
    }


    public static float[] randomArrays(float min,float max ,int num,float sum){
        //构造num个数，每个数取值范围在min-max之间,num个数之和为sum
        float[] arrays = new float[num];

        //边界校验
        if(min*num>sum || max*num<sum) return null;

        boolean flag = true;
        do{
            //先不考虑sum，随机构造取值范围在min至sum/num之间的num个数
            Random rand = new Random();
            float realSum = 0.00f;
            for(int i=0;i<num;i++){
                //保留2位小数
                arrays[i] = min+(sum/num-min)*rand.nextInt(100)/100;
                realSum += arrays[i];
            }

            //现在num个数构造好了，realSum和sum对不上，很简单，将这num个数按照sum/realSum等比放大就OK了
            float newSum = 0.00f;
            for (int j = 0; j < num - 1; j++) {//考虑到小数点精度，只对前num-1个数值缩放
                arrays[j] = arrays[j] * sum / realSum;
                if (arrays[j] < min) {
                    arrays[j] = min;
                }else if (arrays[j] > max) {
                    arrays[j] = max;
                }
                newSum += arrays[j];
            }

            //设置第num个数
            arrays[num - 1] = sum - newSum;
            if (arrays[num - 1] < min || arrays[num - 1] > max) {//不符合要求了
                //System.out.println("///////////"+arrays[num - 1]);
                flag = false;
            }else{
                flag = true;
            }

        }while(!flag);

        return arrays;
    }

    public static float[] roll(float min,float max ,int num,float sum){
        float[] arrays = new float[num];
        //边界校验
        if(min*num>sum || max*num<sum) return null;

        Random rand = new Random();
        float value =  min+(max-min)*rand.nextInt(100)/100;
        roll( min, max ,num-1,sum-value);

        return arrays;
    }

    public static void main(String[] args) {
        float[] arrays = randomArrays(0.00f,99.99f,100,6666.66f);
        for(float f : arrays){
            System.out.println(f);
        }
    }

//    public static void main(String[] args) {
//        int[] arrays= {1,3,4,5,6,2,8,7};
//        BinarySort(arrays);
//
//        for(int n : arrays){
//            System.out.print(n);
//        }
//    }
}
