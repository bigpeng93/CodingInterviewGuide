package BinaryTree.ToTree;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,8,9,3,6,7};
        int[] in = {4,2,8,5,9,1,6,3,7};
        int[] pos = {4,8,9,5,2,6,7,3,1};
        Node headOne = new Solution().preInToTree(pre,in);

        Node headTwo = new Solution().inPosToTree(pos,in);
        printTree(headOne);


    }
}
