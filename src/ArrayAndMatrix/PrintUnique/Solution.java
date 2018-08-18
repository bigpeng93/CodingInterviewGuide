package ArrayAndMatrix.PrintUnique;

/**
 * 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 * <p>
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组。
 * 例如：
 * arr = [-8,-4,-3,1,2,4,5,8,9]，k=10，打印结果为：
 * 1,9
 * 2,8
 * <p>
 * 补充题目：
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序三元组。
 * 例如：
 * arr = [-8,-4,-3,1,2,4,5,8,9]，k=10，打印结果为：
 * -4,5,9
 * -3,4,9
 * -3,5,8
 * 0,1,9
 * 0,2,8
 * 1,4,5
 */
public class Solution {
    //打印二元组
    public void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return;

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                //判断是否重复打印
                if (left == 0 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[left] + "," + arr[right]);
                }
                right--;
                left++;
            }
        }
    }

    //打印三元组
    public void printUniqueTriad(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return;
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                printRest(arr, i, k);
            }
        }
    }

    private void printRest(int[] arr, int i, int k) {
        int left = i + 1;
        int right = arr.length - 1;
        int rest = k - arr[i];
        while (left < right) {
            if (arr[left] + arr[right] < rest) {
                left++;
            } else if (arr[left] + arr[right] > rest) {
                right--;
            } else {
                if (left == 0 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[i] + "," + arr[left] + "," + arr[right]);
                }
                right--;
                left++;
            }
        }
    }

}
