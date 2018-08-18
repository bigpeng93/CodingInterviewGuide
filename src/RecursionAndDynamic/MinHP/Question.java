package RecursionAndDynamic.MinHP;

/**
 * 龙与地下城游戏问题
 * <p>
 * <p>
 * 给定一个二维数组map，含义是一张地图，例如如下，矩阵：
 * -2 　-3　 3
 * -5　-10　 1
 * 0 　30　-5
 * 游戏规则如下：
 * 骑士从左上角出发，每次只能向右或者向下走，最后到达右下角见到公主。
 * 地图中每个位置的只代表骑士要遭遇的事。如果是负数，表示此处有怪兽，要让骑士损失血量。如果是非负数，表示此处有血瓶，能让骑士回血。
 * 骑士从左上角到右下角的过程，走到任何一个位置，血量都不能少于１。
 * <p>
 * 为了保证骑士能顺利见到公主，初始血量至少是多少？根据map，返回初始血量。
 */
public class Question {
    public int minHP(int[][] arr) {
        if (arr.length <= 0 || arr == null || arr[0] == null || arr[0].length <= 0)
            return 1;
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = arr[row][col] > 0 ? 1 : -arr[row][col] + 1;
        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = Math.max(dp[row][i + 1] - arr[row][i], 1);
        }
        int right = 0;
        int down = 0;
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - arr[i][col], 1);
            for (int j = col - 1; j >= 0; j--) {
                right = Math.max(dp[i][j + 1] - arr[i][j], 1);
                down = Math.max(dp[i + 1][j] - arr[i][j], 1);
                dp[i][j] = Math.max(right, down);

            }
        }
        return dp[0][0];
    }

    //空间压缩  error
    public int minHPTwo(int[][] arr) {
        if (arr.length <= 0 || arr == null || arr[0] == null || arr[0].length <= 0)
            return 1;
        int more = Math.max(arr.length, arr[0].length);
        int less = Math.max(arr.length, arr[0].length);
        boolean rowMore = more == arr.length;
        int[] dp = new int[less];
        int tmp = arr[arr.length - 1][arr[0].length - 1];
        dp[less - 1] = tmp > 0 ? 1 : -tmp + 1;
        int row = 0;
        int col = 0;
        for (int j = less - 2; j >= 0; j--) {
            row = rowMore ? more - 1 : j;
            col = rowMore ? j : more - 1;
            dp[j] = Math.max(dp[j + 1] - arr[row][col], 1);
        }
        int choosen1 = 0;
        int choosen2 = 0;
        for (int i = more - 2; i >= 0; i--) {
            row = rowMore ? i : less - 1;
            col = rowMore ? less - 1 : i;
            dp[less - 1] = Math.max(dp[less - 1] - arr[row][col], 1);
            for (int j = less - 2; j >= 0; j--) {
                row = rowMore ? i : j;
                col = rowMore ? j : i;
                choosen1 = Math.max(dp[j] - arr[row][col], 1);
                choosen2 = Math.max(dp[j + 1] - arr[row][col], 1);
                dp[j] = Math.min(choosen1, choosen2);
            }
        }
        return dp[0];

    }

}
