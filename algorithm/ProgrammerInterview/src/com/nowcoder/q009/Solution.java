package com.nowcoder.q009;

public class Solution {
    /**
     输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        //看样子数据结构需要好好补补...
        //思路：参考网友
        //两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指针走(k-1)步，到达第k个节点。
        //然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。

        if (head == null || k <= 0) {
            return null;
        }

        ListNode pre = head;
        ListNode last = head;

        for (int i = 1; i < k; i++) {
            //防止k大于链表长度
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }

        //第二个指针开始移动
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }

        return last;
    }
}
