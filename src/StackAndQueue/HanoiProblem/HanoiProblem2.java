package StackAndQueue.HanoiProblem;

import java.util.Arrays;
import java.util.Stack;

public class HanoiProblem2 {
    public int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> ls = new Stack<Integer>();
        Stack<Integer> ms = new Stack<Integer>();
        Stack<Integer> rs = new Stack<Integer>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--)
            ls.push(i);
        Active[] actives = {Active.No};
        int steps = 0;
        while (rs.size() != num + 1) {
            steps += process(actives, Active.MToL, Active.LToM, ls, ms, left, mid);
            steps += process(actives, Active.LToM, Active.MToL, ms, ls, mid, left);
            steps += process(actives, Active.MToR, Active.RToM, rs, ms, right, mid);
            steps += process(actives, Active.RToM, Active.MToR, ms, rs, mid, right);
        }
        return steps;
    }

    private int process(Active[] active, Active preActive, Active nowActive,
                        Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (active[0] != preActive && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            active[0] = nowActive;
            System.out.println("Move " + tStack.peek() + " from " + from + "to " + to);
            return 1;
        }
        return 0;
    }
}
