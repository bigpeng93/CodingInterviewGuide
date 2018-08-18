package RecursionAndDynamic.Num;

/**
 * 数字字符串转换为字母组合的种数
 * <p>
 * 给定一个字符串str，str全部由数字字符组成，
 * 如果str中某一个或者某相邻两个字符组成的子串在1~26之间，则这个子串可以转换为一个字母。
 * 规定"1"转换为"A"，"2"转换为"B"……"26"转换为"Z"。
 * 写一个函数，求str有多少种不同的转换结果，并返回种数。
 * <p>
 * 举例：
 * str = "1111",
 * 能转换成的结果有"AAAA","LAA","ALA","AAL"和"LL",返回5。
 * str = "01",
 * "0"没有对应的字母，而"01"根据规定不可转换，返回0。
 * str = "10",
 * 能转换出的结果是"J",返回1.
 */
public class Question {
    //暴力递归
    public int num1(String str) {
        if (str == null || str.equals(""))
            return 0;
        char[] chs = str.toCharArray();
        return process(chs, 0);
    }

    public int process(char[] chs, int n) {
        if (n == chs.length)
            return 1;
        if (chs[n] == '0')
            return 0;
        int res = process(chs, n + 1);
        if (n + 1 < chs.length && (chs[n] - '0') * 10 + chs[n + 1] - '0' < 27) {
            res += process(chs, n + 2);
        }
        return res;
    }

    public int num2(String str) {
        if (str == null || str.equals(""))
            return 0;
        char[] chs = str.toCharArray();
        int cur = chs[chs.length - 1] == '0' ? 0 : 1;

        return cur;
    }
}
