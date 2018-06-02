package BitCompute.GetMax;

/**
 * 不用任何比较判断找出两个数中较大的数
 *
 * 给定两个32位整数a和b，返回a和b中较大的数
 *
 * 要求： 不用任何比较判断
 */

public class getMax {
    public int flip (int a){
        return a^1;
    }

    //判断最高位，如果为负数则返回0，如果为0或正数则返回1；
    public int sign(int n){
        return flip((n>>31) &1);
    }

    //方法一:如果a-b的值出现溢出，返回结果就不正确
    public int getMaxOne(int a,int b){
        int c = a-b;
        int sc1 = sign(c);
        int sc2 = flip(sc1);
        return sc1*a + sc2*b;
    }


    /*
     * 如果a的符号与b的符号不同(difSab=1,sameSab=0)，则有：
     *     如果a为0或者正数，那么b为负(sca = 1,scb =0),应该返回a；
     *     如果a为负，那么b为正(sca=0,scb = 1),应该返回b,
     * 如果a的符号和b的符号相同(difSab=0,sameSab =1)，则有：
     *     如果a-b为0或正数(scc=1),应该返回a；
     *     如果a-b为负(scc =0),应该返回b。
     * 所以应该返回a*(difSab*sca+sameSab*scc)+b*flip(difSab*sca+sameSab*scc)
     * 或者a*(difSab*sca+sameSab*scc)+b*{difSab*sca+sameSab*flip(scc)}。
     *
     */
    public int getMaxTwo(int a,int b){
        int c = a-b;
        int sca = sign(a);
        int scb = sign(b);
        int scc = sign(c);
        //判断a和b的符号是否相等
        int difSab = sca ^ scb;

        int sameSab = flip(difSab);
        int return1 = difSab*sca + sameSab*scc;
        //int return2 = flip(return1);
        int return2 = difSab*sca + sameSab*flip(scc);
        return a*return1+b*return2;
    }

}
