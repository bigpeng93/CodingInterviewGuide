package LinkedQuestion.Node;

public class TestNode {
    public static void printNode(Node head){
        while (head != null){
            if(head != head.next)
                System.out.print(head.value+" ");
            else {
                System.out.print(head.value);
                break;
            }
            head = head.next;
        }
        System.out.println();
    }
    public static Node makeLinkedNode(int[] nums){
        int len = nums.length;
        if(len <= 0)
            return null;
        Node head = new Node(nums[0]);
        Node preHead = head;
        for(int i = 0; i<len-1;i++){
            head.next = new Node(nums[i+1]);
            head=head.next;
        }
        head.value = nums[len-1];
        return preHead;
    }
    public static DoubleNode makeLinkedDoubleNode(int[] nums){
        int len = nums.length;
        if(len <=0)
            return null;
        DoubleNode head = new DoubleNode(nums[0]);
        head.last = null;

        DoubleNode cur = head;


        for(int i = 0; i<len-1;i++){
            head.next = new DoubleNode(nums[i+1]);
            head.next.last = head;
            head=head.next;
        }
        return cur;
    }

    public static Node makeRoundLinkedNode(int[] nums){
        int len = nums.length;
        if(len <= 0)
            return null;
        Node head = new Node(nums[0]);
        Node preHead = head;
        for(int i = 0; i<len-1;i++){
            head.next = new Node(nums[i+1]);
            head=head.next;
        }
        head.value = nums[len-1];
        head.next = preHead;
        return preHead;
    }

    public static void printNode(DoubleNode head){
        while (head != null){
            System.out.print(head.value);
            if(head.next !=null && head.next.last.value == head.value){
                System.out.print(" <---> ");
            }
            if(head.next !=null && head.next.last.value != head.value){
                System.out.print(" ----> ");
            }
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        printNode(makeLinkedDoubleNode(nums));
    }
}
