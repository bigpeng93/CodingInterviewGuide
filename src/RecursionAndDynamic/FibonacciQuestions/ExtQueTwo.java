package RecursionAndDynamic.FibonacciQuestions;

/**
 * 假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。第一年农场有1只成熟的母牛，
 * 从第二年开始，母牛开始生小母牛。每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量。
 * <p>
 * 举例：
 * N=6，第1年1头成熟母牛记为a；第2年a生了新的小母牛，记为b，总牛数为2；
 * 题目最优解第3年a生了新的小母牛，记为c，总牛数为3；第4年a生了新的小母牛，记为d，总牛数为4。
 * 第5年b成熟了，a和b分别生了新的小母牛，总牛数为6；第6年c也成熟了，a、b和c分别生了新的小母牛，
 * 总牛数为9，返回9。
 */
public class ExtQueTwo extends Solution {
    public int c1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2 || n == 3)
            return n;
        return c1(n - 1) + c1(n - 3);
    }

    public int c2(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2 || n == 3)
            return n;
        int pre = 1;
        int temp = 2;
        int cur = 3;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = cur;
            tmp2 = temp;
            cur += pre;
            temp = tmp1;
            pre = tmp2;
        }
        return cur;
    }

    public int c3(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2 || n == 3)
            return n;
        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, n - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }
}
