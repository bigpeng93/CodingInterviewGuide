package StringProblem.GetIndex;

public class test {
    public static void main(String[] args) {
        String[] strs = {null,"a",null,"a",null,"b",null,"c"};
        String str = "a";
        System.out.println(new Solution().getIndex(strs,str));
    }
}
