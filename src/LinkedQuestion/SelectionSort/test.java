package LinkedQuestion.SelectionSort;

import LinkedQuestion.Node.TestNode;

public class test extends TestNode {
    public static void main(String[] args) {
        int[] nums= {2,3,4,1,6,5,8,7};
        printNode(new Solution().selectionSort(makeLinkedNode(nums)));
    }
}
