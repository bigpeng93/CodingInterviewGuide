package ArrayAndMatrix.MinPathValue;

public class test {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(new Solution().minPathValue(matrix));
    }
}
