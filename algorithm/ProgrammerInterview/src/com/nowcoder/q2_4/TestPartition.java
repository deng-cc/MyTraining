package com.nowcoder.q2_4;

public class TestPartition {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        //2,4,3,1,5
        n2.next = n4;
        n4.next = n3;
        n3.next = n1;
        n1.next = n5;

        ListNode result = new Partition().partition(n2, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
