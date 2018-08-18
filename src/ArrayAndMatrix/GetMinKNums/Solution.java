package ArrayAndMatrix.GetMinKNums;

/**
 * 找到无序数组中最小的K个数
 * <p>
 * 给定一个无序的整型数组arr，找到其中最小的k个数
 * <p>
 * 要去：
 * 如果数组arr的长度为N，排序后自然可以得到最小的K个数，此时的时间复杂度与排序的时间复杂度相同，
 * 均为O(NlogN),要求实现时间复杂度为O(NlogK)和O(N)的方法。
 */
public class Solution {
    public int[] getMInKNumByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }

        int[] Kheap = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(Kheap, arr[i], i);
        }

        for (int i = k; i != arr.length; i++) {
            if (arr[i] < Kheap[0]) {
                Kheap[0] = arr[i];
                heapify(Kheap, 0, k);
            }
        }
        return Kheap;

    }

    //生成一个大根堆的广度优先遍历的数组，其中parent所指向的变量为index的父节点。
    private void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    //调整大根堆
    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (arr[left] > arr[index]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(arr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
}
