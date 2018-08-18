package BinaryTree.BiggestSubBST;

import BinaryTree.Node.Node;

/**
 * 找到二叉树中的最大搜索二叉子树
 * <p>
 * 给定一棵二叉树的头节点head，已知其中所有节点的值都不一样，找到含有节点最多的搜索二叉子树，
 * 并返回这棵子树的头节点。
 * 例如，
 * <p>
 * 6
 * /         \                                         10
 * 1           12          最大搜索二叉子树             /     \
 * /   \      /      \       ==============>           4      14
 * 0     3    10      13                               / \    /  \
 * /  \    /  \                             2   5  11  15
 * 4    14 20  16
 * / \   / \
 * 2   5 11 15
 * 要求：
 * 如果节点数为N，要求时间复杂度为O(N)，额外空间复杂度为O(h)，h为二叉树的高度。
 */
public class Solution {
    public Node biggestSubBST(Node head) {
        int[] record = new int[3];
        return posOrder(head, record);
    }

    public Node posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        Node lBST = posOrder(left, record);
        int lSize = record[0];      //左子树的节点数
        int lMin = record[1];       //左子树的最小值
        int lMax = record[2];       //左子树的最大值
        Node rBST = posOrder(right, record);
        int rSize = record[0];      //右子树的节点数
        int rMin = record[1];       //右子树的最小值
        int rMax = record[2];       //右子树的最大值
        record[1] = Math.min(lMin, value);
        record[2] = Math.max(rMax, value);
        if (left == lBST && rBST == rBST && lMax < value && rMin > value) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
    }
}
