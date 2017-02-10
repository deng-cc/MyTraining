package com.nowcoder.q2_7;

import java.util.ArrayList;

/**
 请编写一个函数，检查链表是否为回文。
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false
 */
public class Palindrome {
    //思路：
    //回文的特性，逆序和正序内容一样，那么得到一个逆序的链表，来相互比较，相同则true，否则false
    public boolean isPalindrome(ListNode pHead) {
        //得到正序的链表
        ListNode normalNode = pHead;

        /*
        //得到逆序的链表（将其值存到集合中，再反向取出变成逆序链表）
        ArrayList normalSeq = new ArrayList();
        while (pHead != null) {
            normalSeq.add(pHead.val);
            if (pHead.next == null) {
                break;
            }
            pHead = pHead.next;
        }
        ListNode inverseNode = new ListNode(-1);
        ListNode curNode = inverseNode;
        for (int i = normalSeq.size() - 1; i >= 0; i--) {
            curNode.next = new ListNode((Integer) normalSeq.get(i));
            curNode = curNode.next;
        }
        inverseNode = inverseNode.next;

        //将逆序的链表值分别取出和原链表对比，一旦出现不同则false
        while (inverseNode != null) {
            if (inverseNode.val != normalNode.val) {
                return false;
            } else {
                inverseNode = inverseNode.next == null? null: inverseNode.next;
                normalNode = normalNode.next == null? null: normalNode.next;
            }
        }

        return true;
        */


        //看了网友思路，其实这里我走了弯路，可以直接与集合中的数比较，没必要再来个反向链表
        //所以优化的话如下：

        //得到逆序的链表（将其值存到集合中，再反向取出和正向链表比较）
        ArrayList normalSeq = new ArrayList();
        while (pHead != null) {
            normalSeq.add(pHead.val);
            if (pHead.next == null) {
                break;
            }
            pHead = pHead.next;
        }

        for (int i = normalSeq.size() - 1; i >= 0; i--) {
            if (normalNode.val != (Integer) normalSeq.get(i)) {
                return false;
            } else {
                normalNode = normalNode.next;
            }
        }

        return true;
    }
}
