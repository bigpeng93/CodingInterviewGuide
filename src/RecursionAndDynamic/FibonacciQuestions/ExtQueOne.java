package RecursionAndDynamic.FibonacciQuestions;

/**
 * 给定整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法。
 *
 * 举例：
 *  N=3，可以三次都跨1个台阶；也可以先跨2个台阶，在跨1个台阶；
 *  还可以先跨1个台阶，再跨2个台阶。所以有三种走法，返回3
 */
public class ExtQueOne extends Solution{
    //方法一：暴力递归
    public int s1(int n){
        if (n==0)
            return 0;
        if (n==1 || n==2)
            return n;
        return s1(n-1) + s1(n-2);
    }

    //方法二：按顺序求解
    public int s2(int n){
        if (n==0)
            return 0;
        if (n==1 || n==2)
            return n;
        int res = 2;
        int pre = 1;
        int temp =0;
        for (int i =3;i<=n;i++){
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    //方法三：用矩阵求解
    public int s3(int n){
        if (n<1)
            return 0;
        if (n==1|| n==2)
            return n;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return 2*res[0][0]+res[1][0];
    }
}
