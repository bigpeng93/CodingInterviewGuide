package ArrayAndMatrix;

/**
 * 找到无序数组中最小的K个数
 *
 * 给定一个无序的整型数组arr，找到其中最小的k个数
 *
 * 要去：
 *  如果数组arr的长度为N，排序后自然可以得到最小的K个数，此时的时间复杂度与排序的时间复杂度相同，
 *  均为O(NlogN),要求实现时间复杂度为O(NlogK)和O(N)的方法。
 *
 */
public class GetMinKNums {
    public int[] getMInKNumByHeap(int[] arr, int k){
        if (k < 1 || k > arr.length){
            return arr;
        }

        int[] Kheap = new int[k];
        for (int i = 0;i!=k;i++){
            heapInsert(Kheap,arr[i],i);
        }

        for (int i = k;i!=arr.length;i++){
            if (arr[i] < Kheap[0]){
                Kheap [0] = arr[i];

            }
        }
        return Kheap;

    }
    private void heapInsert(int[] arr,int value,int index){
        arr[index] = value;
        while (index!=0){
            int parent = (index-1)/2;
            if (arr[parent] <arr[index]){
                swap(arr,parent,index);
                index = parent;
            }else {
                break;
            }
        }
    }

    private void swap(int[] arr,int index1,int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }


    private void heapify(int[] arr,int index,int heapSize){
        int left
    }
}
