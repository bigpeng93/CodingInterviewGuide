package RecursionAndDynamic.Lcst;

/**
 * 最长公共子串问题
 *
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子串
 *
 * 举例：
 *  str1="1AB2345CD",str2="12345EF",返回"2345"
 * 要求：
 *  如果str1长度为M，str2长度为N，实现时间复杂度为O(M*N),额外空间复杂度为O(1)的方法。
 */
public class Question {

    //动态规划
    public String list(String str1,String str2){
        if (str1==null||str2==null||str1.equals("")||str2.equals(""))
            return "";
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        int[][] dp = getdp(chrs1,chrs2);
        int max = 0;
        int end = 0;
        for (int i =0;i<chrs1.length;i++){
            for (int j =0;j<chrs2.length;j++){
                if (dp[i][j]>max){
                    max = dp[i][j];
                    end = j;
                }
            }
        }
        return str2.substring(end-max+1,end+1);

    }

    public int[][] getdp(char[] str1,char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0]==str2[0] ?1:0;
        for (int i = 1;i<str1.length;i++){
            dp[i][0] = str1[i]==str2[0]?1:0;
        }
        for (int i = 1;i<str2.length;i++){
            dp[0][i] = str1[0]==str2[i]?1:0;
        }
        for (int i =1;i<str1.length;i++){
            for (int j =1;j<str2.length;j++){
                if (str1[i]==str2[j])
                    dp[i][j] = dp[i-1][j-1] +1;
            }
        }
        return dp;
    }


    //

}
