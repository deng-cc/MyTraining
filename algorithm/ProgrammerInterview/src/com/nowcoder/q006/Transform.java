package com.nowcoder.q006;

public class Transform {
    /**
     有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
     给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     测试样例：
     [[1,2,3],[4,5,6],[7,8,9]],3
     返回：[[7,4,1],[8,5,2],[9,6,3]]
     */
    public int[][] transformImage(int[][] mat, int n) {
        //最基础的解法，同时不符题意地使用额外内存空间
        int[][] done = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                done[j][i] = mat[n - 1 - i][j];
            }
        }
        return done;
    }

    /**这个算法参考网友的思路，注意矩阵中次对角线互换的方式*/
    /*
    首先上下翻转，再按照主对角线翻转
    1 2 3        7 8 9        7 4 1
    4 5 6   -->  4 5 6  -->   8 5 2
    7 8 9        1 2 3        9 6 3
    如果是逆时针翻转则先翻主对角线，再上下翻转
     */
    public int[][] transformImage2(int[][] mat, int n) {
        int a;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                a = mat[i][j];
                mat[i][j] = mat[n - i - 1][j];
                mat[n - i - 1][j] = a;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                a = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = a;
            }
        }

        return mat;
    }



}
