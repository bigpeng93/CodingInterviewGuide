package StringProblem.GetCountString;

public class test {
    public static void main(String[] args) {
        String str = "aaabbbddddsssggg";
        Solution solution = new Solution();
        System.out.println(solution.getCountString(str));
        System.out.println(solution.getCharAt(solution.getCountString(str),4));
    }
}
