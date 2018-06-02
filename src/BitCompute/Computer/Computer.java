package BitCompute.Computer;

/**
 * 只用位运算不用算数运算实现正数的加减乘除运算
 *
 * 给定两个32位整数a和b，可正、可负、可0。不能使用算数运算符，分别实现a和b的加减乘除运算。
 *
 * 要求：
 *  如果给定的a和b执行加减乘除的某些结果本来就会导致数据的溢出，
 *  那么你实现的函数不必对那些结果负责。
 *
 */
public class Computer {
    public int add (int a,int b){
        int sum =a;
        while (b!=0){
            sum = a^b;
            b = (a&b)<<1;
            a = sum;
        }
        return sum;
    }

    //减法：取反加一
    public int negNum (int n){
        return add(~n,1);
    }
    public int minus (int a,int b){
        return add(a,negNum(b));
    }
    //乘法：满足a*b=a*2^0*b0+a*2^1*b1+...+a*2^31*b31;
    //bn:b的第n位的值
    public int multi(int a,int b){
        int res = 0;
        while (b!=0){
            if ((b&1)!=0){
                res = add(res,a);
            }
            a <<=1;
            b >>>=1;
        }
        return res;
    }


}
