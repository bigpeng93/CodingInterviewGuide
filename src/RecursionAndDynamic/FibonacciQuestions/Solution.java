package RecursionAndDynamic.FibonacciQuestions;

/**
 * 定义了矩阵计算的函数
 *
 */
public class Solution {
    //计算矩阵的p次方
    public int[][] matrixPower(int[][] m,int p){
        int[][] res =new int[m.length][m[0].length];
        //将res设置为单位矩阵
        for (int i = 0;i<res.length;i++){
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (;p!=0;p>>=1){
            if ((p&1)!=0){
                // 将p向右移动时，最后一位为1的值就是p的分解值。
                res = muliMatrix(res,tmp);
            }
            tmp = muliMatrix(tmp,tmp);
        }
        return res;
    }

    public int[][] muliMatrix(int[][] m1,int[][] m2){
        int[][] res = new int[m1.length][m1[0].length];
        //m*n型矩阵与n*q型矩阵相乘，结果为m*q型矩阵
        for (int i = 0;i<m1.length;i++){
            for (int j = 0;j<m2[0].length;j++){
                //矩阵m1的列数和m2的行数相同，m1[0].length = m2.length
                for (int k =0;k<m1[0].length;k++){
                    res[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
}
