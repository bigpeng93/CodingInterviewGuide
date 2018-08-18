package StackAndQueue.GetMaxWindow;


import java.util.LinkedList;

public class GetMaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w)
            return null;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!linkedList.isEmpty() && arr[linkedList.peekLast()] <= arr[i]) {
                linkedList.pollLast();
            }
            linkedList.addLast(i);
            if (i == linkedList.getFirst() + w)
                linkedList.pollFirst();
            if (i >= w - 1)
                res[index++] = arr[linkedList.peekFirst()];
        }
        return res;
    }
}
