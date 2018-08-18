package ArrayAndMatrix.PrintTopK;

public class test {
    public static void main(String[] args) {
        int[][] matrix = {
                {219, 405, 538, 540, 971},
                {541, 558},
                {200, 201, 202, 203}
        };
        new Solution().printTopK(matrix, 3);
    }
}
