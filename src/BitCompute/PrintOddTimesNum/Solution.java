package BitCompute.PrintOddTimesNum;

/**
 * 在其他数都出现偶数次的数组中找到出现奇数次的数
 *
 * 给定一个整型数组arr，其中只有一个数出现了奇数次，其他的数都出现了偶数次，打印这个数
 *
 * 进阶：
 *  有两个数出现了奇数次，其他的数都出现了偶数次，打印这个数。
 * 要求：
 * 时间复杂度为O(N),额外空间复杂度为O(1)
 */
public class Solution {
    public void printOddTimesNum(int[] arr){
        int eO=0;
        for (int cur : arr){
            eO ^= cur;
        }
        System.out.println(eO);
    }

    public void printOddTimesNumTwo(int[] arr){
        int eO=0,eOhasOne =0;
        for (int cur : arr){
            eO ^= cur;
        }
        int rightOne = eO & (~eO+1);
        for (int cur :arr){
            if ((cur & rightOne) !=0){
                eOhasOne ^= cur;
            }
        }
        System.out.println(eOhasOne + " "+(eO^eOhasOne));

    }
}
