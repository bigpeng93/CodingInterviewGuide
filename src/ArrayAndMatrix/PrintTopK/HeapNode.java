package ArrayAndMatrix.PrintTopK;

public class HeapNode {
    public int value;   //值是什么
    public int arrNum;  //来自哪个数组
    public int index;   //来自数组的哪个位置

    public HeapNode(int value, int arrNum, int index) {
        this.value = value;
        this.arrNum = arrNum;
        this.index = index;
    }
}
