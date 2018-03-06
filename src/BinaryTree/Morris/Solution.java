package BinaryTree.Morris;

import BinaryTree.Node.Node;

/**
 * 遍历二叉树的神级方法 —— Morris遍历
 *
 * 给定一颗二叉树的头节点head，完成二叉树的先序、中序和后序遍历。
 * 如果二叉树的节点数为N，要求时间复杂度为O(N),额外空间复杂度为O(1)。
 */
public class Solution {
    //中序遍历
    public void morrisIn(Node head){
        if(head==null)
            return;
        Node cur1= head;
        Node cur2= null;
        while (cur1!=null){
            cur2 = cur1.left;
            if (cur2!=null){
                //找到各个左子树中最右的节点
                while (cur2.right!=null && cur2.right!=cur1){
                    cur2 = cur2.right;
                }
                //将最右节点的right指向各自的根节点
                if (cur2.right==null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {         //用于在打印时将右节点和各自的根节点断开
                    cur2.right =null;
                }
            }
            System.out.print(cur1.value+" ");
            cur1 = cur1.right;
        }
    }

    //先序遍历
    public void morrisPre(Node head){
        if(head==null)
            return;
        Node cur1= head;
        Node cur2= null;
        while (cur1!=null){
            cur2 = cur1.left;
            if (cur2!=null){
                //找到各个左子树中最右的节点
                while (cur2.right!=null && cur2.right!=cur1){
                    cur2 = cur2.right;
                }
                //将最右节点的right指向各自的根节点
                if (cur2.right==null){
                    cur2.right = cur1;
                    System.out.print(cur1.value+" ");
                    cur1 = cur1.left;
                    continue;
                }else {         //用于在打印时将右节点和各自的根节点断开
                    cur2.right =null;
                }
            }else
                System.out.print(cur1.value+" ");
            cur1 = cur1.right;
        }
    }

    //后序遍历
    public void MorrisPos(Node head){
        if (head==null)
            return;
        Node cur1 = head;
        Node cur2 = null;
    }
}
