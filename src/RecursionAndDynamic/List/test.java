package RecursionAndDynamic.List;

public class test {
    public static void main(String[] args) {
        int[] arr= {2,1,5,3,6,4,8,9,7};
        int[] result1= new OrgQuestion().listOne(arr);

        for (int num:result1){
            System.out.print(num+" ");

        }
        System.out.println();
        int[] result2= new OrgQuestion().listTwo(arr);
        for (int num :result2){
            System.out.print(num+" ");
        }
    }
}
