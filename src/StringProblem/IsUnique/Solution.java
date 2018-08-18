package StringProblem.IsUnique;

public class Solution {
    public boolean isUniqueOne(char[] chas){
        if (chas == null){
            return false;
        }
        boolean[] map =new boolean[256];
        for (int i = 0;i<chas.length;i++){
            if (map[chas[i]] ){
                return false;
            }
            map[chas[i]] = false;
        }
        return true;
    }

    public boolean isUniqueTwo(char[] chas){
        return true;
    }

}
