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
    public String lcst(String str1,String str2){
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
    //空间压缩
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


    public String lcstTwo(String str1,String str2){
        if (str1==null||str2==null||str1.equals("")||str2.equals(""))
            return "";
        char[] chrs1 = str1.toCharArray();
        char[] chrs2 = str2.toCharArray();
        int max = 0;
        int end = 0;
        int row = 0;
        int col = chrs2.length;
        while (row < chrs1.length){
            int i = row;
            int j = col;
            int len = 0;
            while (i<chrs1.length && j< chrs2.length){
                if (chrs1[i] != chrs2[j]){
                    len =0;
                }else
                    len++;
                if (len>max){
                    max = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col>0)
                col--;
            else
                row++;
        }
        return str1.substring(end-max+1,end+1);
    }

}
