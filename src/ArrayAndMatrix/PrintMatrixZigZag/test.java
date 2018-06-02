package ArrayAndMatrix.PrintMatrixZigZag;

public class test {
    public static void main(String[] args) {
        int matris[][] ={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(matris.length+" "+matris[0].length);
        new Solution().PrintMatrixZigZag(matris);
    }
}
