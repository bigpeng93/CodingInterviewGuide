package RecursionAndDynamic.MinCoins;

/**
 * 换钱的最少货币数
 *
 * 给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim代表要找的钱数，求组成aim的最少货币数。
 *
 * 举例：
 *  arr[5,2,3]，aim=20。
 *  4张5元可以组成20元，其他的找钱方案都要使用更多张的货币，所以返回4。
 *  arr[5,2,3]，aim=0。
 *  不用任何货币就可以组成0元，返回0。
 *  arr[3,5]，aim=2。
 *  根本无法组成2元，钱不能找开的情况下默认返回-1。
 *
 */
public class OrgQuestion {
    public int minCoins(int[] arr,int aim){
        if (arr==null ||aim<=0||arr.length<=0)
            return 0;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];
        //第一列：表示找的钱数为0时需要的最少张数，即全为0.初始化时，全为0.
        //第一行：表示只能使用arr[0]货币的情况下，找某个钱数的最小张数。
        for(int i = 1;i<=aim;i++){
            dp[0][i] = max;
            if(i-arr[0] >=0 && dp[0][i-arr[0]] !=max){
                dp[0][i] = dp[0][i-arr[0]]+1;
            }
        }
        int left = 0;
        for (int i =1;i<n;i++){
            for (int j =1;j<=aim;j++){
                left = max;
                if(j-arr[i] >=0 && dp[i][j-arr[i]] !=max){
                    left = dp[i][j-arr[i]]+1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] !=max ?dp[n-1][aim]:-1;
    }

    public int minCoinsTwo(int[] arr,int aim){
        if (arr==null ||aim<=0||arr.length<=0)
            return 0;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim+1];
        for (int i = 1;i<=aim;i++){
            dp[i] = max;
            if(i-arr[0] >=0 && dp[i-arr[0]] !=max){
                dp[i] = dp[i-arr[0]]+1;
            }
        }
        int left = 0;
        for (int i =1;i<n;i++){
            for (int j =1;j<=aim;j++){
                left = max;
                if(j-arr[i] >=0 && dp[j-arr[i]] !=max){
                    left = dp[j-arr[i]]+1;
                }
                dp[j] = Math.min(left,dp[j]);
            }
        }
        return dp[aim] !=max ?dp[aim]:-1;
    }
}
