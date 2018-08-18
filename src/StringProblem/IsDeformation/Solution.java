package StringProblem.IsDeformation;

/**
 * A判断两个字符串是否互为变形词
 * <p>
 * 给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，
 * 那么str1和str2互为变形词。请实现函数判断两个字符串是否互为变形词。
 * <p>
 * 举例：
 * str1="123",str2="321",返回true.
 * str1="123",str2="2331",返回true.
 */
public class Solution {
    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < ch1.length - 1; i++) {
            map[ch1[i]]++;
        }
        for (int i = 0; i < ch2.length - 1; i++) {
            if (map[ch2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
