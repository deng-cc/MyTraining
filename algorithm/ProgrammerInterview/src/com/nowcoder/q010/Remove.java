package com.nowcoder.q010;

/**
 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 */
public class Remove {
    //思路：参考网友
    //首先，不能访问之前的节点，但是可以访问后续节点。
    //然后，对于尾节点，直接delete掉，返回false即可。
    //最后，对于中间节点简记为A = pNode，利用其后续节点B = pNode->next和C = pNode->next->next变相删除。
    //即 A--->B--->C，要删除A。这样变相删除：把B的值给A的值域，把C的地址赋给A的地址域。
    public boolean removeNode(ListNode pNode) {
        //判断是否尾节点
        if (pNode.next == null) {
            return false;
        } else {
            //通过覆盖变相删除节点
            pNode.val = pNode.next.val; //将下个节点的值移动到当前节点
            pNode.next = pNode.next.next; //然后指向下下个节点
        }
        return true;

    }
}
