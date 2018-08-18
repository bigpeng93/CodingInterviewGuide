package ArrayAndMatrix.Product;

public class test {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int[] res1 = new Solution().productOne(arr);
        for (int i : res1) {
            System.out.print(i + " ");
        }
        int[] res2 = new Solution().productTwo(arr);
        for (int i : res2) {
            System.out.print(i + " ");
        }
    }
}
