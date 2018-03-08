package BinaryTree.GetTwoErrNodes;

import BinaryTree.Node.Node;
import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[][] nums = {
                {4},
                {2,6},
                {1,7,5,3}
        };
        Node[] errs = new Solution().getTwoErrNodes(makeBinaryNode(nums));
        for(Node err :errs){
            System.out.println(err.value);
        }
    }
}
