package StringProblem.NumSum;

/**
 * 字符串中数字子串的求和
 * <p>
 * 给定一个字符串str，求其中全部数组串所代表的的数字之和
 * <p>
 * 要求：
 * 1、忽略小数点字符，例如"A1.3",其中包含两个数字1和3.
 * 2、如果紧贴数字子串的左侧出现字符"-"，当连续出现的数量为奇数时，则数字视为负，连续出现的数量为偶数时，
 * 则数字视为正。例如："A-1BC--12",其中包含数字为-1和12.
 * <p>
 * 举例：
 * str="A1CD2E33",返回36.
 * str="A-1B--2C--D6E",返回7.
 */
public class Solution {
    public int numSum(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] ch = str.toCharArray();
        int res = 0;
        int num = 0;
        int cur = 0;
        boolean posi = true;
        for (int i = 0; i < ch.length; i++) {
            cur = ch[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                if (ch[i] == '-') {
                    if (i - 1 > -1 && ch[i - 1] == '-') {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }
}
