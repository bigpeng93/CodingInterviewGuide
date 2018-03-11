package RecursionAndDynamic.Lcse;

/**
 * 最长公共子序列问题
 *
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子序列
 *
 * 举例：
 *  str1="1A2C3D4B56",str2="B1D23CA45B6A".
 *  "123456"或者"12C4B6"都是最长公共子序列，返回哪一个都行。
 */
public class Question {
    public int[][] getdp(char[] str1,char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0]==str2[0] ?1:0;
        for (int i = 1;i<str1.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],(str1[i]==str2[0]?1:0));
        }
        for (int i = 1;i<str2.length;i++){
            dp[0][i] = Math.max(dp[0][i-1],(str1[0]==str2[i]?1:0));
        }
        for (int i =1;i<str1.length;i++){
            for (int j=1;j<str2.length;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (str1[i]==str2[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }

    public String lcse(String str1,String str2){
        if (str1==null||str2==null||str1.equals("")||str2.equals(""))
            return "";
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        int[][] dp = getdp(chrs1,chrs2);
        int row = chrs1.length-1;
        int col = chrs2.length-1;
        char[] chars = new char[dp[row][col]];
        int index = chars.length-1;
        while (index>=0){
            if (row>0 && dp[row][col]==dp[row-1][col])
                row--;
            else  if (col>0 && dp[row][col]==dp[row][col-1])
                col--;
            else {
                chars[index--] = chrs1[row];
                row--;
                col--;
            }
        }
        return String.valueOf(chars);
    }
}
