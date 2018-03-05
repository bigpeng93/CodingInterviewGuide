package BinaryTree.OrderRecur;

import BinaryTree.Node.Node;

/**
 * 分别用递归和非递归方式实现二叉树先序、中序和后序遍历
 *
 * 用递归和非递归的方式，分别按照二叉树先序、中序和后序的打印所有的节点。
 * 我们约定：
 *  先序遍历顺序为根、左、右；
 *  中序遍历顺序为左、根、右；
 *  后序遍历顺序为左、右、根。
 */
public class Solution {
    //递归：先序遍历
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //递归：中序遍历
    public void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    //递归：后序遍历
    public void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }
}
