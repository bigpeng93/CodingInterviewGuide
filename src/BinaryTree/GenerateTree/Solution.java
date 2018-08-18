package BinaryTree.GenerateTree;

import BinaryTree.Node.Node;

/**
 * 通过有序数组生成平衡搜索二叉树
 *
 * 给定一个有序数组sortArr，已知其中没有重复值，用这个有序数组生成一棵平衡搜索树二叉树，
 * 并且该搜索二叉树中序遍历的结果与sortArr一致。
 */
public class Solution {
    public Node generateTree(int[] sortArr){
        if (sortArr==null || sortArr.length < 1){
            return null;
        }
        return generate(sortArr,0,sortArr.length-1);
    }

    public Node generate(int[] sortArr,int start,int end){
        if (start > end)
            return null;
        int mid = (start+end)/2;
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr,start,mid-1);
        head.right = generate(sortArr,mid+1,end);
        return head;
    }
}
