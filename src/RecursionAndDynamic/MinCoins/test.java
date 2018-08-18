package RecursionAndDynamic.MinCoins;

public class test {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3};
        System.out.println(new OrgQuestion().minCoins(nums, 20));
        System.out.println(new OrgQuestion().minCoinsTwo(nums, 20));

        int[] nums2 = {5, 5, 2, 3};
        System.out.println(new ExtQue().minCoins(nums2, 15));
        System.out.println(new ExtQue().minCoinsTwo(nums2, 15));

    }
}
