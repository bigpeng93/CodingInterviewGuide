package ArrayAndMatrix.getMaxLength;

import ArrayAndMatrix.TestArray;

public class test extends TestArray {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        System.out.println(new Solution().getMaxLength(nums,3));
    }
}
