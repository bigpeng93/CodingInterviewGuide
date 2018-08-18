package ArrayAndMatrix.Sort;

public class test {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 6, 5, 3, 4, 8, 7};
        int[] arr2 = {1, 2, 6, 5, 3, 4, 8, 7};

        new Solution().sortOne(arr1);
        new Solution().sortTwo(arr2);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : arr2)
            System.out.print(i + " ");
    }
}
