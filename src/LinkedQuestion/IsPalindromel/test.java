package LinkedQuestion.IsPalindromel;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,3,3,2,1};
        System.out.println("solution_One:"+new Solution().isPalindromal(makeLinkedNode(nums)));
        System.out.println("solution_Two:"+new Solution().isPalindromalTwo(makeLinkedNode(nums)));
        System.out.println("solution_Two:"+new Solution().isPalindromalThere(makeLinkedNode(nums)));
    }
}
