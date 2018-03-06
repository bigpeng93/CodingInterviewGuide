package ArrayAndMatrix.LeftUnique;

import ArrayAndMatrix.TestArray;

public class test extends TestArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9};
        new Solution().leftUnique(nums);
        printArray(nums);
        int[] nums2 = {1,2,1,2,0,1,2,2,0,0};
        new Solution().sort(nums2);
        printArray(nums2);
    }
}
