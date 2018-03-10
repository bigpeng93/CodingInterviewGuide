package RecursionAndDynamic.MinCoins;

/**
 * 给定数组arr，arr中所有的值都为正数。每个值仅代表一张钱的面值，再给定一个整数aim
 * 代表要找的钱数，求组成aim的最少货币数。
 *
 * 举例：
 *  arr=[5,2,3],aim = 20.
 *  5元、2元和3元的钱各有1张，所以无法组成20元，默认返回-1.
 *  arr=[5,2,5,3],aim=10.
 *  5元的货币有2张，可以组成10元，且该方案所需张数最少，返回2.
 *  arr=[5,2,5,3],aim=15.
 *  所有的钱加起来才能组成15元，返回4.
 *  arr=[5,2,5,3],aim=0.
 *  不用任何货币就可以组成0元，返回0.
 */
public class ExtQue {
    public int minCoins(int[] arr,int aim){
        if (aim < 0|| arr.length<=0||arr==null)
            return -1;
        int n = arr.length;
        int[][] dp = new int[n][aim+1];
        int max= Integer.MAX_VALUE;
        int left = 0;
        for (int i = 1;i<=aim;i++){
            dp[0][i] = max;
        }
        if (arr[0] <=aim){
            dp[0][arr[0]] = 1;
        }
        for (int i =1;i<n;i++){
            for (int j=1;j<=aim;j++){
                left = max;
                if (j-arr[i]>=0 && dp[i-1][j-arr[i]] !=max)
                    left = dp[i-1][j-arr[i]]+1;
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim]!=max ? dp[n-1][aim]:-1;

    }

    public int minCoinsTwo(int[] arr,int aim){
        if (aim == 0|| arr.length<=0||arr==null)
            return 0;
        int n = arr.length;
        int[] dp = new int[aim+1];
        int max= Integer.MAX_VALUE;
        int left = 0;
        for (int i = 1;i<=aim;i++){
            dp[i] = max;
        }
        if (arr[0] <=aim){
            dp[arr[0]] = 1;
        }
        for (int i =1;i<n;i++){
            //需要反向遍历，否则会出现重复使用。
            for (int j = aim;j>0;j--){
                left = max;
                if (j-arr[i]>=0 && dp[j-arr[i]]!=max){
                    left = dp[j-arr[i]] + 1;
                }
                dp[j] = Math.min(left,dp[j]);
            }

        }
        return dp[aim]!=max ? dp[aim]:-1;

    }
}
