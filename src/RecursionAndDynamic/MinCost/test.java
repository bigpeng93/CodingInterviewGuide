package RecursionAndDynamic.MinCost;

public class test {
    public static void main(String[] args) {
        String str1= "ab12cd3";
        String str2="abcdf";
        System.out.println(new Question().minCost(str1,str2,5,3,2));
        System.out.println(new Question().minCostTwo(str1,str2,5,3,2));
    }
}
