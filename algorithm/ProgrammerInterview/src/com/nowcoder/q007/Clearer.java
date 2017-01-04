package com.nowcoder.q007;

import java.util.ArrayList;

public class Clearer {
    /**
     请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
     给定一个N阶方阵int[][](C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]方阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
     测试样例：
     [[1,2,3],[0,1,2],[0,0,1]]
     返回：[[0,0,3],[0,0,0],[0,0,0]]
     */
    public int[][] clearZero(int[][] mat, int n) {
        //思路：
        //找到元素为0的位置，记录其坐标
        //记录方式，i和j分别存入两个不同容器
        //遍历每个元素的坐标，如果其坐标存在容器中，则清零

        ArrayList<Integer> listI = new ArrayList<Integer>();
        ArrayList<Integer> listJ = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    listI.add(i);
                    listJ.add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (listJ.contains(j) || listI.contains(i)) {
                    mat[i][j] = 0;
                }
            }
        }

        return mat;
    }

    /**
     这个是在讨论帖看到的网友的版本，思路是类似的，可是更加巧妙，没有用到集合类；相当于建立了一个映射板，把要清零的元素进行了标记。
     这里还巧妙利用了数组初始化的特性：
        如果没有明确的初始化数组元素，那么数组就会用默认的类型值初始化，
        例如假若没有初始化整型数组，元素都将默认值为0，没有初始化的boolean值是false，对象数组是null。
     */
    public int[][] clearZero2(int[][] mat, int n) {
        boolean[] rowArray = new boolean[n];
        boolean[] columnArray = new boolean[n];
        //记录为0的位置，把相应的行列位置设为true
        for(int i=0; i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    rowArray[i]=true;
                    columnArray[j]=true;
                }
            }
        }
        //遍历找到之前记录的位置，把相应行列赋值为0
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(rowArray[i]||columnArray[j])
                {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
}
