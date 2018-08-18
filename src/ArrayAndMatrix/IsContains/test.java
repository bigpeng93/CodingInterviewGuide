package ArrayAndMatrix.IsContains;

public class test {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2, 5},
                {2, 3, 4, 7},
                {4, 4, 4, 8},
                {5, 7, 7, 9}
        };
        System.out.println(new Solution().isContains(arr, 7));
        System.out.println(new Solution().isContainsTwo(arr, 7));
    }
}
