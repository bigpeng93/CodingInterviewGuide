package StringProblem.IsRotation;

/**
 * 判断两个字符串是否互为旋转词
 */
public class Solution {
    OtherQuestions.KMP.Solution kmp = new OtherQuestions.KMP.Solution();

    public boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        String b2 = b + b;
        return kmp.getIndexOf(b2, a) != -1;
    }

}
