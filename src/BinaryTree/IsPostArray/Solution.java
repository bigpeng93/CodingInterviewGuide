package BinaryTree.IsPostArray;

/**
 * 根据后序数组重建搜索二叉树
 * <p>
 * 给定一个整型数组arr，已知其中没有重复值，判断arr是否可能是节点值类型
 * 为整型的搜索二叉树后序遍历的结果。
 * 进阶：
 * 如果整型数组arr中没有重复值，且已知是一棵搜索二叉树的后序遍历结果，通过数组arr重构二叉树。
 */
public class Solution {
    public boolean isPostArray(int[] arr) {
        if (arr == null || arr.length < 1)
            return false;
        return isPost(arr, 0, arr.length - 1);
    }

    public boolean isPost(int[] arr, int start, int end) {
        if (start == end)
            return true;
        int less = -1;  //指向比最后一个元素小的那一部分的最后一个元素
        int more = end; //指向比最后一个元素大的那一部分的开始的一个元素
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] < arr[more]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }
}
