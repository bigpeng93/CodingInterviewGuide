package StringProblem.ReplaceString;

public class test {
    public static void main(String[] args) {
        char[] chars = {'a',' ','b',' ',' ','c',0,0,0,0,0,0,0,0,0};
        new Solution().replace(chars);
        char[] chars1 = {'1','2','*','*','*','3','4','5'};
        new Solution().modify(chars1);
    }
}
