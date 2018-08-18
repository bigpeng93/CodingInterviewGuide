package ArrayAndMatrix.Modify;

/**
 * 奇数下标都是奇数或者偶数下标都是偶数
 * <p>
 * 给定一个长度不少于2的数组arr，实现一个函数调整arr，要么让所有的偶数下标都是偶数，
 * 要么让所有的奇数下标都是奇数
 * <p>
 * 要求：
 * 如果arr的长度为N，函数要求时间复杂度为O(N)，额外空间复杂度为O(1).
 */
public class Solution {
    public void modify(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int event = 0;  //指向下标为偶数
        int odd = 1;     //指向下标为奇数
        int end = arr.length - 1; //指向数组的尾部
        while (event <= end && odd <= end) {
            if ((arr[end] & 1) == 0) {
                swap(arr, end, event);
                event += 2;
            } else {
                swap(arr, end, odd);
                odd += 2;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;

    }
}
