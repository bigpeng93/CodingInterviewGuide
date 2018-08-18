package StringProblem.ReplaceString;

/**
 * 字符串的调整与替换
 *
 */
public class Solution {
    public void replace(char[] chars){
        if (chars==null || chars.length==0){
            return;
        }
        int num = 0;
        int len = 0;
        for (int i = 0;i<chars.length&&chars[i]!=0;i++){
            if (chars[i]==' '){
                num ++;
            }
        }
        int j = len+num*2-1;
        for (int i = len-1;i>-1;i--){
            if (chars[i] !=' '){
                chars[j--] = chars[i];
            }else {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
        }

        for (char ch:chars){
            System.out.print(ch+" ");
        }
        System.out.println();
    }

    public void modify (char[] chars){
        if (chars==null || chars.length==0)
            return;
        int j = chars.length-1;
        for (int i = chars.length-1;i>-1;i--){
            if (chars[i]!='*'){
                chars[j--] = chars[i];
            }
        }
        for (;j>-1;){
            chars[j] = '*';
        }
        for (char ch:chars){
            System.out.print(ch+" ");
        }
    }
}
