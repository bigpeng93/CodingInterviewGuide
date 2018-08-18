package StringProblem.Replace;

/**
 * 替换字符串中连续出现的指定字符串
 */
public class Solution {
    public String replace(String str, String from, String to) {
        if (str == null || from == null || str.equals("") || from.equals(""))
            return str;
        char[] chars = str.toCharArray();
        char[] charf = from.toCharArray();
        int match = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == charf[match++]) {
                if (match == charf.length) {
                    clear(chars, match, i);
                    match = 0;
                }
            } else {
                if (chars[i] == charf[0]) {
                    i--;
                }
                match = 0;
            }
        }

        String res = "";
        String cur = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                cur = cur + String.valueOf(chars[i]);
            }
            if (chars[i] == 0 && (i == 0 || chars[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        return res;
    }

    public void clear(char[] chars, int len, int end) {
        while (len-- != 0) {
            chars[end--] = 0;
        }
    }
}
