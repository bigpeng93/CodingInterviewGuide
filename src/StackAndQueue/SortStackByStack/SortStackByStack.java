package StackAndQueue.SortStackByStack;

import java.util.Arrays;
import java.util.Stack;

public class SortStackByStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        System.out.println(Arrays.asList(stack));
    }
}
