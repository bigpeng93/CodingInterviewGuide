package ArrayAndMatrix.PrintHalfMajor;

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 5, 4, 2, 2, 2, 2};
        int[] arr2 = {1, 2, 2, 2, 4, 5, 6, 6, 7};
/*        new Solution().printHalfMajor(arr);
        new Solution().printHalfMajor(arr2);*/
        new Solution().printKMajor(arr2, 4);
    }
}
