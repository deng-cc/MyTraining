package com.nowcoder.q011;

/**
 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class Partition {
    //思路：参考网友
    //创建两个链表，一个链表是存放小于x的元素，另一个链表存放大于等于x的元素
    //然后遍历一遍原有链表，将小于x元素的节点加到第一个链表上，将大于等于x元素的节点加到第二个链表上。便可实现分割。
    public ListNode partition(ListNode pHead, int x) {
        //如果为空或只有当前节点
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode curNode = pHead;
        ListNode sListNode = new ListNode(-1);
        ListNode bListNode = new ListNode(-1);
        ListNode sTemp = sListNode;
        ListNode bTemp = bListNode;

        while (curNode != null) {
            if (curNode.val < x) {
                sTemp.next = new ListNode(curNode.val);
                sTemp = sTemp.next;
            } else {
                bTemp.next = new ListNode(curNode.val);
                bTemp = bTemp.next;
            }

            if (curNode.next == null) {
                break;
            }

            curNode = curNode.next;
        }

        sTemp.next = bListNode.next;

        return sListNode.next;
    }
}
