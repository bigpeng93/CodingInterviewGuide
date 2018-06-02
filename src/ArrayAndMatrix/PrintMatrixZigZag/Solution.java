package ArrayAndMatrix.PrintMatrixZigZag;

/**
 * “之”字形打印矩阵
 *
 * 给定一个矩阵Matrix，按照“之”字型的方式打印这个矩阵，例如：
 *
 *      1   2   3   4
 *      5   6   7   8
 *      9   10  11  12
 *
 *  “之”字型打印的结果为：1,2,5,9,6,3,4,7,10,11,8,12
 *
 * 要求：
 *  额外空间复杂度为O(N)
 */
public class Solution {

    public void PrintMatrixZigZag(int[][] matrix){
        //横向扫描的行和列
        int tR =0;
        int tC =0;

        //纵向扫描的行和列
        int dR =0;
        int dC =0;

        //矩阵的行数和列数
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;

        //之字形打印方向的判断条件
        //fromUp为true,则从向上往下打印;若为false,则从下往上打印
        boolean fromUp = false;

        while (tR != endR+1){
            printLevel(matrix,tR,tC,dR,dC,fromUp);

            //计算顺序不可颠倒
            tR = tC==endC?tR+1:tR;
            tC = tC==endC?tC:tC+1;
            dC = dR==endR?dC+1:dC;
            dR = dR==endR?dR:dR+1;

            fromUp = !fromUp;

        }
    }

    public void printLevel(int [][] matrix ,int tR,int tC,int dR,int dC,boolean fromUp){
        if (fromUp){
            while (tR <= dR ){
                System.out.print(matrix[tR++][tC--]+" ");
            }
        }else {
            while (dR >= tR){
                System.out.print(matrix[dR--][dC++]+" ");
            }
        }
    }
}
