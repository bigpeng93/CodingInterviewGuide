package BitCompute.Count;

/**
 * 整数的二进制表达中有多少个1
 *
 * 给定一个32位整数n，可为0，可为正，可为负，返回该整数二进制表达中1的个数
 *
 */
public class Solution {
    public int countOne(int n){
        int res = 0;
        while (n!=0){
            res += n&1;
            n >>>=1;
        }
        return res;
    }

    public int countTwo(int n){
        int res = 0;
        while (n!=0){
            //n&=(n-1)的实质是抹掉最右边的1
            n&=(n-1);
            res++;
        }
        return res;
    }

    public int count3(int n){
        int res =0;
        while (n!=0){
            n -= n&(~n+1);
            res++;
        }
        return res;
    }
}
