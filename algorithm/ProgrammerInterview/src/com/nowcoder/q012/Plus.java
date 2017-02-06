package com.nowcoder.q012;

/**
 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 编写函数对这两个整数求和，并用链表形式返回结果。
 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 测试样例：
 {1,2,3},{3,2,1}
 返回：{4,4,4}
 */
public class Plus {
    //思路：按照小学数学中学习的加法原理从末尾到首位，对每一位对齐相加即可
    public ListNode plusAB(ListNode a, ListNode b) {
        /*
        //结果的head，最终其next就为所需的ListNode
        ListNode resultHead = new ListNode(-1);

        //用来进行运算
        ListNode resultCurrent = resultHead;

        //进位
        int addToNextDigit = 0;

        //只有在a为null、b为null且进位为0的情况下，该循环才终止
        while (a != null || b != null || addToNextDigit != 0) {
            //确定数位上的值（都为空时算为0）
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;

            //计算同位相加再加上进位的总和
            int sum = aVal + bVal + addToNextDigit;
            //计算加后的位值
            int nodeDigit = sum % 10;
            //计算加后的进位值
            addToNextDigit = sum / 10;

            //存储计算结果
            resultCurrent.next = new ListNode(nodeDigit);

            //移位，以进行下一位的计算(三元计算避免nullPointer)
            resultCurrent = resultCurrent.next;
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }

        return resultHead.next;
        */

        ListNode headNode = new ListNode(-1);
        ListNode curNode = headNode;
        int nextVal = 0;

        while (!(a == null && b == null && nextVal == 0)) {
            int addA = a == null ? 0 : a.val;
            int addB = b == null ? 0 : b.val;

            int sum = addA + addB + nextVal;


            curNode.next = new ListNode(sum % 10);
            nextVal = sum / 10;

            curNode = curNode.next;
            a = a == null ? null : a.next;
            b = b == null ? null : b.next;
        }

        return headNode.next;

    }

    public static void main(String[] args) {
        //192 + 169 = 361  --> 163
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(0);

        ListNode n4 = new ListNode(0);
        /*
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(1);
        */

        n1.next = n2;
        n2.next = n3;



        Plus test = new Plus();
        ListNode result = test.plusAB(n1, n4);
        while (true) {
            System.out.println(result.val);
            result = result.next;
            if (result.next == null) {
                System.out.println(result.val);
                break;
            }
        }
    }
}
