package RecursionAndDynamic.IsCross;

/**
 * 字符串的交错组成
 * <p>
 * 给定三个字符串str1,str2和aim，如果aim包含仅包含来自str1和str2的所有字符，而且在aim中属于str1的字符之间
 * 保持原来在str1中的顺序，属于str2的字符之间保持原来的在str2中的顺序，那么称aim是str1和str2的交错组成。
 * 实现一个函数，判断aim是否是str1和str2交错组成。
 * <p>
 * 举例：
 * str1="AB"，str2="12"。那么"AB12"、"A1B2"、"A12B"、"1A2B"和"1AB2"等等都是str1和str2交错组成
 */
public class Question {

    public boolean isCross(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null)
            return false;
        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        char[] chrAim = aim.toCharArray();
        if (chrAim.length != chr1.length + chr2.length)
            return false;
        boolean[][] dp = new boolean[chr1.length + 1][chr2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= chr1.length; i++) {
            if (chr1[i - 1] != chrAim[i - 1])
                break;
            dp[i][0] = true;
        }
        for (int i = 1; i <= chr2.length; i++) {
            if (chr2[i - 1] != chrAim[i - 1])
                break;
            dp[0][i] = true;
        }

        for (int i = 1; i <= chr1.length; i++) {
            for (int j = 1; j <= chr2.length; j++) {
                if ((chr1[i - 1] == chrAim[i + j - 1] && dp[i - 1][j])
                        || (chr2[j - 1] == chrAim[i + j - 1] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[chr1.length][chr2.length];
    }

    //压缩空间
    public boolean isCrossTwo(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null)
            return false;
        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        char[] chrAim = aim.toCharArray();
        if (chrAim.length != chr1.length + chr2.length)
            return false;
        char[] longer = chr1.length > chr2.length ? chr1 : chr2;
        char[] shorter = chr1.length < chr2.length ? chr1 : chr2;
        boolean[] dp = new boolean[shorter.length + 1];
        dp[0] = true;
        for (int i = 1; i <= shorter.length; i++) {
            if (shorter[i - 1] != chrAim[i - 1])
                break;
            dp[i] = true;
        }

        for (int i = 1; i <= chr1.length; i++) {
            boolean pre = dp[0];
            for (int j = 1; j <= chr2.length; j++) {
                boolean temp = dp[j];
                if ((chr1[i - 1] == chrAim[i + j - 1] && temp)
                        || (chr2[j - 1] == chrAim[i + j - 1] && pre)) {
                    dp[j] = true;
                }
                pre = temp;
            }
        }
        return dp[shorter.length];
    }
}
