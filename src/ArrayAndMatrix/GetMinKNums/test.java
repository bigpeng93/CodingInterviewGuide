package ArrayAndMatrix.GetMinKNums;

public class test {
    public static void main(String[] args) {
        int[] arr = {15, 17, 36, 74, 83, 62, 35, 86, 12, 25, 45};
        int[] sol = new Solution().getMInKNumByHeap(arr, 6);
        for (int num : sol) {
            System.out.println(num);
        }
    }
}
