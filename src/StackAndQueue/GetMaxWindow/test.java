package StackAndQueue.GetMaxWindow;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 4, 3, 3, 6, 7};
        GetMaxWindow getMaxWindow = new GetMaxWindow();
        int[] arr = getMaxWindow.getMaxWindow(nums, 3);
        System.out.println(arr.length);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //System.out.println(Arrays.asList(getMaxWindow.getMaxWindow(nums,3)).toString());
    }
}
