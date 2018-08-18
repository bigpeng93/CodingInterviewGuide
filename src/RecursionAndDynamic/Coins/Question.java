package RecursionAndDynamic.Coins;

/**
 * 换钱的方法数
 * <p>
 * 给定数组arr，arr中所有代表的值都为整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 在给定一个整数aim代表要找的钱数，求换钱有多少种方法。
 * <p>
 * 举例：
 * arr=[5,10,25,1]，aim=0。
 * 组成0元的方法有1种，就是所有面值的货币都不用。所以返回1。
 * arr=[5,10,25,1]，aim=15。
 * 组成15元的方法有6种，分别为3张5元，1张10元+1张5元，
 * 1张10元+5张1元，10张1元+1张5元，2张5元+5张1元，15张1元。所以返回6。
 * arr=[3,5]，aim=2。
 * 任何方法都无法组成2元。所以返回0。
 */
public class Question {

    //暴力递归
    public int coins(int[] arr, int aim) {
        if (arr.length <= 0 || arr == null || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    //index:指向arr的元素
    public int process(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length)
            res = aim == 0 ? 1 : 0;
        else {
            for (int i = 0; arr[index] * i <= aim; i++)
                res += process(arr, index + 1, aim - arr[index] * i);
        }
        return res;
    }

    //记忆搜索方法
    public int coinsTwo(int[] arr, int aim) {
        if (arr.length <= 0 || arr == null || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return processTwo(arr, 0, aim, map);
    }

    //index:指向arr的元素
    public int processTwo(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length)
            res = aim == 0 ? 1 : 0;
        else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += processTwo(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    //动态规划问题
    public int coinsThree(int[] arr, int aim) {
        if (arr.length <= 0 || arr == null || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++)
            dp[i][0] = 1;
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - arr[i] * k];
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    //动态规划优化一
    public int coinsFore(int[] arr, int aim) {
        if (arr.length <= 0 || arr == null || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++)
            dp[i][0] = 1;
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    //动态规划优化二：空间压缩
    public int coinsFive(int[] arr, int aim) {
        if (arr.length <= 0 || arr == null || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }


}
