package ArrayAndMatrix.PrintHalfMajor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在数组中找到出现次数大于N/K的数
 * <p>
 * 给定一个整形数组arr，打印其中出现次数大于一半的数，如果没有这样的数，打印提示信息
 * <p>
 * 进阶：
 * 给定一个整型数组arr，再给定一个整数K，打印所有出现次数大于N/K的数，如果没有这样的数，
 * 打印提示信息
 * <p>
 * 要求：
 * 原问题要求时间复杂度为O(N)，额外空间复杂度为O(1)。进阶问题要求时间复杂度为
 * O(N*K)，额外空间复杂度为O(K)。
 */
public class Solution {

    //原问题
    public void printHalfMajor(int[] arr) {
        int cand = 0;
        int times = 0;

        //如果存在次数大于一般的数，则cand的值等于这个值，如果不存在，则值不确定。
        for (int i = 0; i != arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (arr[i] == cand) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] == cand) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.println("no such number.");
        }

    }


    //进阶
    public void printKMajor(int[] arr, int k) {
        if (k < 2) {
            System.out.println("the value k is invalid.");
            return;
        }
        HashMap<Integer, Integer> cands = new HashMap<>();
        for (int i = 0; i != arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                cands.put(arr[i], cands.get(arr[i]) + 1);
            } else {
                if (cands.size() == k - 1) {
                    removeNums(cands);
                } else {
                    cands.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, cands);
        boolean print = false;
        for (Map.Entry<Integer, Integer> entry : reals.entrySet()) {
            if (entry.getValue() > arr.length / k) {
                print = true;
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println(print ? "" : "no such number.");
    }


    //每次删除k个元素，如果一个存在出现次数大于N/K的数，则一定会存在于cands中，另外也可能包含其他的次数小于N/K的数
    private void removeNums(HashMap<Integer, Integer> cands) {
        List<Integer> mapKey = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cands.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                mapKey.add(entry.getKey());
            }
            cands.put(key, value - 1);
        }
        for (int key : mapKey) {
            cands.remove(key);
        }
    }

    private HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i != arr.length; i++) {
            if (cands.containsKey(arr[i])) {
                if (reals.containsKey(arr[i])) {
                    reals.put(arr[i], reals.get(arr[i]) + 1);
                } else {
                    reals.put(arr[i], 1);
                }
            }
        }
        return reals;
    }
}
