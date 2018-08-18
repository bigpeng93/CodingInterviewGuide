package RecursionAndDynamic.Coins;

public class test {
    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        int aim = 15;
        System.out.println(new Question().coinsThree(arr, aim));
        System.out.println(new Question().coinsFore(arr, aim));
        System.out.println(new Question().coinsFive(arr, aim));

    }
}
