package BinaryTree.IsBalance;

import BinaryTree.Node.Node;

/**
 * 判断二叉树是否为平衡二叉树
 *
 * 平衡二叉树的性质为：要么是一颗空树，要么任何一个节点的左右子树高度差的绝对值不超过1。
 * 给定一棵二叉树的头节点head，判断这棵二叉树是否为平衡二叉树。
 */
public class Solution {
    public boolean isBalance(Node head){
        boolean[] res = new boolean[1];
        int level = 1;
        res[0] = true;
        getHeight(head,level,res);
        return res[0];
    }

    public int getHeight(Node head,int level,boolean[] res){
        if (head== null){
            return level;
        }
        int lh = getHeight(head.left,level+1,res);
        if (!res[0]){
            return level;
        }
        int rh = getHeight(head.right,level+1,res);
        if (!res[0]){
            return level;
        }
        if(Math.abs(lh-rh)>1){
            res[0] = false;
        }
        return Math.max(lh,rh);
    }
}
