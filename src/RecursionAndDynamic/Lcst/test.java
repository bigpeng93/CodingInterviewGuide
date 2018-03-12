package RecursionAndDynamic.Lcst;

public class test {
    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2= "12345EF";
        System.out.println(new Question().lcst(str1,str2));
        System.out.println(new Question().lcstTwo(str1,str2));

    }
}
