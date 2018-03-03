package ArrayAndMatrix.LeftUnique;

/**
 * 给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素升序，而不用保证有部分是否有序。
 * 例如：
 *  arr={1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9}，调整之后arr={1,2,3,4,5,6,7,8,9,...}
 */
public class Solution {
    public void leftUnique(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int u = 0;
        int i = 1;
        while (i != arr.length){
            if (arr[i++] != arr[u]){
                swap(arr,++u,i-1);
            }
        }
    }

    /**
     *  给定一个数组arr，其中只可能含有0,1,2三个值，请实现arr的排序。
     *  另一中问法为：有一个数组，其中只有红球、篮球和黄球，请实现红球全放在数组的左边，
     * 篮球放在中间，黄球放在右边。
     *  另一种问法为：有一个数组，再给定一个值K，请实现比K小的数都放在数组的左边，
     * 等于K的数放在数组的中间，比K大的数放在数组的右边。
     */

    public void sort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        int left = -1;
        int index = 0;
        int right = arr.length;
        while(index < right){
            if(arr[index] == 0) {
                swap(arr,index++,++left);
            }else if(arr[index ] == 2){
                swap(arr,index,--right);
            }else
                index++;
        }
    }

    private void swap(int[] nums,int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
