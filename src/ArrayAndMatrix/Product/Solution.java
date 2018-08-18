package ArrayAndMatrix.Product;

/**
 * 不包含本位置值的累乘数组
 * <p>
 * 给定一个整形数组arr，返回不包含本位置值的累乘数组
 * <p>
 * 例如：
 * arr=[2,3,1,4],返回[12,8,24,6],即除自己外，其他位置的累乘。
 * <p>
 * 要求：
 * 时间复杂度为O(N)
 * 除需要返回的结果数组外，额外空间复杂度为O(1)
 * <p>
 * 进阶：
 * 对时间和空间复杂度的要求不变，而且不可以使用除法。
 */
public class Solution {
    public int[] productOne(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        //用于记录数组中0出现的次数
        int count = 0;
        int all = 1;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] != 0) {
                all *= arr[i];
            } else {
                count++;
            }
        }
        int[] res = new int[arr.length];
        if (count == 0) {
            for (int i = 0; i != arr.length; i++) {
                res[i] = all / arr[i];
            }
        }
        if (count == 1) {      //如果出现两个及以上的0，则res数组全部为0.
            for (int i = 0; i != arr.length; i++) {
                if (arr[i] == 0)
                    res[i] = all;
            }
        }
        return res;
    }

    public int[] productTwo(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i != arr.length; i++) {
            res[i] = res[i - 1] * arr[i];
        }
        int tmp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * tmp;
            tmp *= arr[i];
        }
        res[0] = tmp;
        return res;
    }

}
