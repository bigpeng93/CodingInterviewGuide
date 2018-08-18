package ArrayAndMatrix.MatrixMaxSum;

/**
 * 子矩阵的最大累加和问题
 * <p>
 * 给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和。
 * <p>
 * 例如，矩阵matrix为：
 * -90   48   78
 * 64  -40   64
 * -81   -7   66
 * 其中，最大累加和的子矩阵为：
 * 48   78
 * -40   64
 * -7   66
 * <p>
 * 所以返回累加和209。
 * 例如，matrix为：
 * -1   -1   -1
 * -1    2    2
 * -1   -1   -1
 * <p>
 * 其中，最大累加和的子矩阵为：
 * 2    2
 * 所以返回累加和4.
 */
public class Solution {
    public int maxSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i != arr.length; i++) {
            s = new int[arr[0].length];
            for (int j = i; j != arr.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += arr[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }
}
