package StringProblem.RemoveKZeros;

/**
 * 去掉字符串中连续出现K个0的字符串
 * <p>
 * 给定一个字符串str和一个整数k，如果str中正好有连续的k个'0'字符出现时，
 * 把k个连续的'0'字符去掉，返回处理后的字符串。
 * <p>
 * 举例：
 * str ='A00B',k=2,返回'A00B'
 * str ='A0000B000',k=3,返回'A0000B'.
 */
public class Solution {
    public String remocveKZeros(String str, int k) {
        if (str == null || k < 1) {
            return str;
        }
        char[] ch = str.toCharArray();
        int count = 0;
        int start = -1;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        ch[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0) {
                ch[start++] = 0;
            }
        }
        return String.valueOf(ch);
    }
}
