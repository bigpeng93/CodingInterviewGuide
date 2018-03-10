package RecursionAndDynamic.MinPathSum;

public class test {
    public static void main(String[] args) {
        int[][] nums = {
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        System.out.println(new OrgQuestion().minPathSum(nums));
        System.out.println(new OrgQuestion().minPathSumTwo(nums));
    }
}
