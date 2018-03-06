package ArrayAndMatrix.MaxLength;

import java.util.HashMap;

/**
 * 未排序数组中累加和为给定值的最长子数组系列问题
 *
 * 给定一个无序数组arr，其中元素可正、可负、可0。
 * 求arr所有数组中正数与负数个数相等的最长子数组长度。
 */
public class Solution {
    public int maxLength(int[] arr,int k){
        if (arr==null||arr.length<=0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int len = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if (map.containsKey(sum-k)){
                len = Math.max(len,i-map.get(sum-k));
            }
            if (!map.containsKey(sum))
                map.put(sum,i);
        }
        return len;

    }
}
