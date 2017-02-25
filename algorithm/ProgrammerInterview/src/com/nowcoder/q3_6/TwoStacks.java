package com.nowcoder.q3_6;

import java.util.ArrayList;
import java.util.Stack;

/**
 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶）
 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 测试样例：
 [1,2,3,4,5]
 返回：[5,4,3,2,1]
 */
public class TwoStacks {
    //思路：
    //将原栈A的栈顶弹出放到栈B后，继续弹出栈顶和B的栈顶比较
    //如果A.top > B.top，则直接压入
    //如果A.top < B.top，B.top压入A，A.top循环比较后再压入B。
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        //如果传参为空或元素为0
        if (numbers.length == 0 || numbers == null) {
            return null;
        }

        //初始化栈
        Stack<Integer> origin = new Stack<Integer>();
        int index = numbers.length - 1;
        for (int i = index; i >= 0; i--) {
            origin.push(numbers[i]);
        }

        //初始化临时栈和临时变量
        Stack<Integer> tempStack = new Stack<Integer>();
        int temp;


        if (tempStack.empty()) {
            tempStack.push(origin.pop());
        }
        while (!origin.empty()) {
            //弹出a.top and b.top
            int a = origin.pop();
            int b = tempStack.pop();

            //如果a.top < b.top
            if (a < b) {
                //b.top 压入到 a
                origin.push(b);
                //循环比较b.top，凡是大于a.top的均压入a，最后将a.top压入
                while (!tempStack.empty()) {
                    b = tempStack.pop();
                    if (a < b) {
                        origin.push(b);
                    } else {
                        tempStack.push(b);
                        break;
                    }
                }
                tempStack.push(a);
            } else {
                //如果a.top > b.top，直接压入
                tempStack.push(b);
                tempStack.push(a);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!tempStack.empty()) {
            result.add(tempStack.pop());
        }

        return result;
    }


    public static void main(String[] args) {
        int[] testStack = new int[]{1, 2, 3, 4, 5};
        ArrayList<Integer> result = new TwoStacks().twoStacksSort(testStack);
        for (Integer bean : result) {
            System.out.print(bean + ",");
        }

    }
}
