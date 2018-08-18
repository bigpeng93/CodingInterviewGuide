package RecursionAndDynamic.FibonacciQuestions;


/**
 * 斐波那契系列问题的递归和动态规划
 * <p>
 * 给定整数N，返回斐波那契数列的第N项
 */

public class OrgQuestion extends Solution {
    // O(N^2) 暴力递归
    public int f1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return f1(n - 1) + f1(n - 2);
    }

    // O(N) 通过顺序计算求到第N项
    public int f2(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int pre = 1;
        int sum = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = sum;
            sum += pre;
            pre = temp;
        }
        return sum;
    }

    // O(logN) 状态矩阵求解
    public int f3(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

}
