package RecursionAndDynamic.LongestConsecutive;

import java.util.HashMap;

/**
 * 数组中的最长连续序列
 * <p>
 * 给定无序数组arr，返回其中最长的连续序列的长度
 * <p>
 * 举例：
 * arr={100,4,200,1,3,2},最长的连续序列为[1,2,3,4],所以返回4.
 */
public class Question {
    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], 1);
                if (hashMap.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(hashMap, arr[i] - 1, arr[i]));
                }
                if (hashMap.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(hashMap, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    /**
     * 更新map中的left和right的数据
     *
     * @param map  key代表遍历过的某个数，value代表key这个数所在的最长连续序列的长度。
     * @param less
     * @param more
     * @return
     */
    public int merge(HashMap map, int less, int more) {
        int left = less - (int) map.get(less) + 1;
        int right = more + (int) map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
