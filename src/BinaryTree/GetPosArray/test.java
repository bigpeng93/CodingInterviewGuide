package BinaryTree.GetPosArray;

import BinaryTree.Node.TestBinaryTree;

public class test extends TestBinaryTree{
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pos = new Solution().getPosArray(pre, in);
        for(int num:pos)
            System.out.print(num+" ");
    }
}
