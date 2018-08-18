package BitCompute.Change;

/**
 * 如何不用任何额外的变量交换两个整数的值
 * <p>
 * 如果给定整数a和b，用一下三行代码即可交换a和b的值
 * a = a ^ b
 * b = a ^ b
 * a = a ^ b
 * 假设a异或b的结果为c，c就是a整数位信息和b整数位信息的所有不用信息
 * a异或c的结果就是b。
 * b异或c的结果就是a。
 */
public class changeNum {
    int a, b;

    public changeNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void sulution() {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}
