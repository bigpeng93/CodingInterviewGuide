package RecursionAndDynamic.List;

/**
 * 最长递增子序列
 * <p>
 * 给定数组arr，返回arr的最长递增子序列。
 * <p>
 * 举例：
 * arr=[2,1,5,3,6,4,8,9,7]，返回的最长递增子序列为[1,3,4,8,9].
 * 要求：
 * 如果arr长度为N，请实现时间复杂度为O(N logN)的方法。
 */
public class OrgQuestion {

    //方法一：时间复杂度为O(N^2)
    public int[] listOne(int[] arr) {
        if (arr.length <= 0 || arr == null)
            return null;
        int[] dp = getdpOne(arr);
        return generateLIS(arr, dp);
    }

    //dp[i]表示在以arr[i]这个数结尾的情况下，arr[0...i]中最大递增子序列长度。时间复杂度为O(N^2)
    public int[] getdpOne(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }
        return dp;

    }

    //根据dp数组得到的最长递增子序列。时间复杂度为O(N)
    public int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    //方法二：时间复杂度O(N logN)
    public int[] listTwo(int[] arr) {
        if (arr.length <= 0 || arr == null)
            return null;
        int[] dp = getdpTwo(arr);
        return generateLIS(arr, dp);
    }

    //时间复杂度O(N logN)。只需要改写计算dp数组的过程即可。
    public int[] getdpTwo(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m])
                    l = m + 1;
                else
                    r = m - 1;
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }
}
