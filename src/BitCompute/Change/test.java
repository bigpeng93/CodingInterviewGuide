package BitCompute.Change;

public class test {

    public static void main(String[] args) {
        int a[] = {2, 3};
        solution(a);
        System.out.println(a[0] + " " + a[1]);
    }

    public static void solution(int[] c) {
        int a = c[0];
        int b = c[1];
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        c[0] = a;
        c[1] = b;
        System.out.println(a + " " + b);
    }
}
