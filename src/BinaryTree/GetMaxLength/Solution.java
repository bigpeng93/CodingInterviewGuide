package BinaryTree.GetMaxLength;

import BinaryTree.Node.Node;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 *
 * 给定一颗二叉树的头节点head和一个32位整数sum，二叉树节点值类型为整型，
 * 求累加和为sum的最长路径长度。路径是指从某个节点往下，每次最多选择一个孩子节点或者不选所
 * 形成的节点链。
 * 例如，二叉树：
 *              -3
 *            /     \
 *          3         -9
 *        /   \      /   \
 *       1     0    2     1
 *            / \
 *           1   6
 * 如果sum=6，那么累加和为6的最长路径为：-3、3、0、6，所以返回4；
 * 如果sum=9，那么累加和为-9的最长路径为：-9，所以返回-1。
 * 注：本题不考虑节点值相加可能溢出的情况
 */
public class Solution {
    public int getMaxLength(Node head,int sum){
        return 0;
    }
}
