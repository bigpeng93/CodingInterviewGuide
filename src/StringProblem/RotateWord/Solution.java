package StringProblem.RotateWord;

/**
 * 反转字符串
 */
public class Solution {
    public void rotateWord(char[] chars){
        if (chars==null || chars.length==0)
            return;
        reverse(chars,0,chars.length-1);
        int l = -1;
        int r = -1;
        for (int i = 0;i<chars.length;i++){
            if (chars[i] != ' '){
                l= i==0 || chars[i-1]==' '?i:l;
                r= i==chars.length-1 || chars[i+1]==' '?i:r;
            }
            if (l!=-1 && r!=-1){
                reverse(chars,l,r);
                l=-1;
                r=-1;
            }
        }
        for (char ch : chars){
            System.out.print(ch);
        }
    }

    private void reverse(char[] chars,int start,int end){
        char tmp = 0;
        while (start<end){
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            end--;
            start++;
        }
    }
}
