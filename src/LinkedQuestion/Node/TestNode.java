package LinkedQuestion.Node;

public class TestNode {

    /**
     * 打印链表
     * @param head 链表的首节点
     */
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

    /**
     * 由数组创建一个链表
     * @param nums  数组
     * @return      返回链表的首节点
     */
    public static Node makeLinkedNode(int[] nums){
        return makeLoopLinkedNode(nums,-1,nums.length,true);
    }

    /**
     * 由数组创建一个双向链表
     * @param nums  数组
     * @return      返回链表的首节点
     */
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
            head=(DoubleNode)head.next;
        }
        return cur;
    }

    /**
     * 创建一个收尾相连的链表
     * @param nums  数组
     * @return  返回链表的首节点，也就是源数组的第一个元素
     */
    public static Node makeRoundLinkedNode(int[] nums){
        return makeLoopLinkedNode(nums,0,-1,true);
    }

    /**
     * 打印双向链表
     * @param head  双向链表的首节点
     */
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


    /**
     * 生成一个带有环的链表
     * @param nums  由数组创建一个链表
     * @param m     环入口节点在链表中的位置，从0开始计算
     * @param n     由数组前n个元素生成链表，从0开始计算
     * @param hOrt  true：返回链表的头部；false：返回链表的尾部
     * @return      新链表的首节点
     */
    public static Node makeLoopLinkedNode(int[] nums,int m,int n,boolean hOrt){
        int len = nums.length;
        if (len <= 0 || m>len-1)
            return null;
        Node preHead = new Node(0);     //设置一个虚拟的前置节点
        Node cur = preHead;
        if (m<0) {
            if (n<0){
                return null;
            }else if (n>len-1){
                for (int i = 0; i < len; i++) {
                    cur.next = new Node(nums[i]);
                    cur = cur.next;
                }
            }else{
                for(int i = 0;i <= m;i++){
                    cur.next = new Node(nums[i]);
                    cur = cur.next;
                }
            }
            return hOrt?preHead.next:cur;
        }else{
            int i = 0;
            Node loop = preHead;
            for(;i<m;i++){
                cur.next = new Node(nums[i]);
                cur = cur.next;
            }
            if(i==m){
                loop = cur;
            }
            while (i<len){
                cur.next = new Node(nums[i]);
                cur = cur.next;
                i++;
            }
            cur.next = loop;
            return hOrt?preHead.next:cur;
        }
    }


    /**
     * 通过数组创建链表，并返回链表的尾节点
     * @param nums  数组
     * @param m     环入口节点在链表中的位置，从0开始计算
     * @return      返回链表的尾节点
     */
    public static Node makeLoopLinkedTailNode(int[] nums,int m){
        return makeLoopLinkedNode(nums,m,-1,false);
    }

    /**
     * 将head2的第n个元素的尾部指向head1的第m个元素，使两个链表相交
     * @param head1
     * @param m
     * @param head2
     * @param n
     */
    public static void makeBothLinkedNode(Node head1,int m,Node head2,int n){
        Node mNode = getNthNode(head1,m);
        Node nNode = getNthNode(head2,n);
        if (mNode == null || nNode == null){
            return;
        }
        nNode.next = mNode;
    }

    /**
     * 获取链表的第n个元素
     * @param head  链表的首节点
     * @param n     第n个节点，从0开始计算。
     * @return      返回第n个节点
     */
    public static Node getNthNode(Node head ,int n){
        Node cur = head;
        while (n-- >0){
            if (cur == null){
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 测试链表是否是一个环，如果是，则返回环入口的节点
     * @param head
     * @return
     */
    public static Node testLoopNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2){
            if(n1 == null || n2 == null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        //printNode(makeLinkedDoubleNode(nums));
        printNode(makeLinkedDoubleNode(nums));
    }
}
