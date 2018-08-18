package ArrayAndMatrix.Modify;

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 2, 4, 6};
        new Solution().modify(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
