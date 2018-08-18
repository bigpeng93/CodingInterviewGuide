package StringProblem.GetCountString;

/**
 * 字符串的统计字符串
 */
public class Solution {
    public String getCountString(String str){
        if (str == null || str.equals("")){
            return "";
        }
        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;
        for (int i = 1; i<chars.length;i++){
            if (chars[i] != chars[i-1]){
                res = count(res,String.valueOf(num),String.valueOf(chars[i]));
                num = 1;
            }else {
                num++;
            }
        }
        return count(res,String.valueOf(num),"");
    }

    /**
     *
     * @param s1 主字符串
     * @param s2 字符的数量
     * @param s3 下一个字符
     * @return
     */
    private String count(String s1,String s2,String s3){
        return s1+"_"+s2+(s3.equals("")?s3:"_"+s3);
    }


    public char getCharAt(String cstr,int index){
        if (cstr == null || cstr.equals("")){
            return 0;
        }

        char[] chars = cstr.toCharArray();
        boolean stage = true;
        int num = 0;
        int sum = 0;
        char chr = 0;

        for (int i = 0;i<chars.length;i++){
            if (chars[i] == '_'){
                stage=!stage;
            }else if (stage){
                sum += num;
                if (sum > index){
                    return chr;
                }
                num = 0;
                chr = chars[i];
            }else {
                num = num*10+chars[i]-'0';
            }
        }
        return sum + num >index?chr:0;
    }
}
