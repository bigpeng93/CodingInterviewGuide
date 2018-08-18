package BinaryTree.PrintTree;

import BinaryTree.Node.Node;

/**
 * 如何比较直观地打印二叉树
 *
 * 二叉树可以用常规的三种遍历结果来描述其结构，但是不够直观，尤其是二叉树中有重复值的时候，
 * 仅通过三种遍历的结果来构造二叉树的真实结构更是难上加难，有时则根本不可能。
 * 给定一棵二叉树的头节点head，已知二叉树节点值的类型为32位整数，请实现一个打印二叉树的函数，
 * 可以直观地展示树的形状，也便于画出真实的结构。
 */

public class Solution {
    public void printTree(Node head){
        printInOrder(head,0,"H",17);
    }

    /**
     * 递归打印节点
     *
     * len长度的取值：
     *  在java中，整型值占用长度最长的值是Integer.MIN_VALUE(即-2147483648)，
     *  占用长度为11，加上前缀和后缀("H"、"v"或"^")之后占用长度为13。为了在打印
     *  之后更好地区分，再把前面加上两个空格，后面加上两个空格，总共占用长度为17.
     *  也就是说长度为17的空间必然可以放下任何一个32位整数。
     *
     * @param head      进入递归的根节点
     * @param height    记录二叉树的层数
     * @param to        标志根节点或左右节点,"H"为根节点、"V"为右节点、"^"为左节点
     * @param len       打印一个节点所占用的长度
     */

    private void printInOrder(Node head,int height,String to,int len){
        if(head == null)
            return;

        printInOrder(head.right,height+1,"v",len);
        String val = to + head.value + to;
        int lenM = val.length();        //计算加上前缀和后缀之后的值的长度
        int lenL = (len-lenM)/2;        //计算左侧空格的长度
        int lenR = len-lenL-lenM;       //计算右侧空格的长度
        val = getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(height*len) + val);
        printInOrder(head.left,height+1,"^",len);
    }

    /**
     * 获取空格的字符串
     * @param num   空格的长度
     * @return
     */
    private String getSpace(int num){
        String space = " ";
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        while (i++ < num){
            buffer.append(" ");
        }
        return buffer.toString();
    }
}
