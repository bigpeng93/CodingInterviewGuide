package RecursionAndDynamic.MinCost;

/**
 * 最小编辑代价
 *
 * 给定两个字符串str1和str2，再给定三个整数ic、dc和rc，分别代表插入、删除
 * 和替换一个字符的代价，返回将str1和str2的最小代价。
 *
 * 举例：
 *  str1="abc",str2="adc",ic=5,dc=3,rc=2，
 *  从"abc"编辑到"adc",把'b'替换成'd'代价最小，为2；
 *  str1="abc",str2="adc",ic=5,dc=3,rc=10，
 *  从"abc"编辑到"adc"，先删除'b'再插入'd'代价最小，为8；
 *  str1="abc",str2="abc",ic=5,dc=3,rc=2，
 *  不同编辑了，本来就是一样的字符串，所以返回0。
 */
public class Question {
    public int minCost(String str1,String str2,int ic,int dc,int rc){
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] dp = new int[char1.length+1][char2.length+1];
        dp[0][0] = 0;
        for (int i=1;i<=char1.length;i++){
            dp[i][0] = i*dc;
        }
        for (int i=1;i<=char2.length;i++){
            dp[0][i] = i*ic;
        }
        for (int i = 1;i<=char1.length;i++){
            for (int j=1;j<=char2.length;j++){
                //dp第一行和第一列分别都对应着空字符
                if (char1[i-1] == char2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //替换
                    dp[i][j] = dp[i-1][j-1]+rc;
                }
                //删除
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+dc);
                //插入
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ic);

            }
        }
        for (int i = 0;i<char1.length+1;i++){
            for (int j=0;j<=char2.length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[char1.length][char2.length];
    }

    //空间压缩
    public int minCostTwo(String str1,String str2,int ic,int dc,int rc) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        char[] longer = char1.length>char2.length?char1:char2;
        char[] shorter = char1.length<char2.length?char1:char2;
        int[] dp = new int[shorter.length+1];
        dp[0] = 0;
        //如果str2较长就交换ic和dc的值
        if (char1.length<char2.length){
            int tmp = ic;
            ic = dc;
            dc = tmp;
        }
        for (int i = 1; i <= shorter.length; i++) {
            dp[i] = i * ic;
        }
        for (int i = 1;i<=longer.length;i++){
            int pre = dp[0];
            dp[0] = i*dc;
            System.out.print(dp[0]+" ");
            for (int j = 1;j<=shorter.length;j++){
                int temp = dp[j];
                //dp第一行和第一列分别都对应着空字符
                if (char1[i-1] == char2[j-1]){
                    dp[j] = pre;
                }else {
                    //替换
                    dp[j] = pre +rc;
                }
                //删除
                dp[j] = Math.min(dp[j],temp+dc);
                //插入
                dp[j] = Math.min(dp[j],dp[j-1]+ic);
                pre = temp;
                System.out.print(dp[j]+" ");
            }
            System.out.println();
        }
        return dp[shorter.length];
    }
}
