package StringProblem.IsRotation;

public class test {
    public static void main(String[] args) {
        String a = "cdab";
        String b = "abcd";
        String c = "acdb";
        System.out.println(new Solution().isRotation(a, c));
    }
}
