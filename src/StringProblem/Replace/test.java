package StringProblem.Replace;

public class test {
    public static void main(String[] args) {
        String str = "123abc";
        String from = "abc";
        String to = "4567";
        System.out.println(new Solution().replace(str, from, to));
    }
}
