package ArrayAndMatrix.MaxLength;

import ArrayAndMatrix.TestArray;

public class test extends TestArray{
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(new Solution().maxLength(nums,6));
    }
}
