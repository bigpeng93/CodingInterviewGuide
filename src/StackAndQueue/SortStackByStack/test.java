package StackAndQueue.SortStackByStack;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] nums = {2, 7, 3, 6, 8, 4, 5, 9, 1};
        for (int num : nums) {
            stack.push(num);
        }
        SortStackByStack.sortStackByStack(stack);
    }
}
