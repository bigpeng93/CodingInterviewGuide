package StackAndQueue.MaxTree;

public class test {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 7};
        MaxTree maxTree = new MaxTree();
        System.out.println(maxTree.getMaxTree(arr).value);
    }
}
