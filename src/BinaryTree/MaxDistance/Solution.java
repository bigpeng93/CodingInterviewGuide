package BinaryTree.MaxDistance;

import BinaryTree.Node.Node;


/**
 * 二叉树节点间的最大距离问题
 *
 * 从二叉树的节点A出发，可以向上或者向下出发，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫做A到B的距离。
 *
 *          1
 *      /       \
 *     2         3
 *    / \       / \
 *   4   5     6   7
 *
 * 节点4和节点2的距离为2，节点5和节点6的距离为5.给定一棵二叉树的头节点head，求整棵树上节点间的最大距离。
 */
public class Solution {
    public int maxDistance(Node head){
        if (head==null)
            return 0;
        int left = head.left==null?0:getLevel(head.left,0);
        int right = head.right==null?0:getLevel(head.right,0);
        return left+right+1;
    }
    public int getLevel(Node head,int level){
        if (head == null)
            return level;
        int left = getLevel(head.left,level+1);
        int right = getLevel(head.right,level+1);
        return Math.max(left,right);
    }
}
