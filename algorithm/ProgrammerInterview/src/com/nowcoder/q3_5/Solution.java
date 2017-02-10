package com.nowcoder.q3_5;

import java.util.Stack;

/**
 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution {
    //思路：
    //入队：将元素进栈A
    //出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；如果不为空，栈B直接出栈。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     扩展：关于java.util.Stack

     E push(E item)
        把项压入堆栈顶部。

     E pop()
        移除堆栈顶部的对象，并作为此函数的值返回该对象。

     E peek()
        查看堆栈顶部的对象，但不从堆栈中移除它。

     boolean empty()
        测试堆栈是否为空。

     int search(Object o)
        返回对象在堆栈中的位置，以 1 为基数。
     */
}
