package RecursionAndDynamic.MinPathSum;

/**
 * 矩阵的最小路径和
 * <p>
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * <p>
 * 举例：
 * 如果给定的m如下：
 * 1  3  5  9
 * 8  1  3  4
 * 5  0  6  1
 * 8  8  4  0
 * 路径1,3,1,0,6,1,0是所有路径中路径和最小的，所以返回12.
 */
public class OrgQuestion {
    public int minPathSum(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }


    public int minPathSumTwo(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowmore = more == m.length;
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j], arr[j - 1]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];

    }
}
