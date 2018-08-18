package RecursionAndDynamic.MinHP;

public class test {
    public static void main(String[] args) {
        int[][] arr = {
                {-2, -3, 3},
                {-5, -10, 1},
                {0, 30, -5}
        };
        System.out.println(new Question().minHP(arr));
        System.out.println(new Question().minHPTwo(arr));
    }
}
