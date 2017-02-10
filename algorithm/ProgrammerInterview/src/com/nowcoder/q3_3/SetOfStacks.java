package com.nowcoder.q3_3;

import java.util.ArrayList;

/**
 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。
 该数据结构应支持与普通栈相同的push和pop操作。
 给定一个操作序列int[][2] ope，每个元素中（{1, 1024}）的第一个数代表操作类型，
 若为1，则为push操作，后一个数为应push的数字；
 若为2，则为pop操作，后一个数无意义。
 请返回一个int[][]，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class SetOfStacks {
    //思路：
    //把所有的操作集成在单个List上，最终再根据size将List分割返回
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {

        ArrayList<Integer> collection = new ArrayList();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //把push和pop的结果整合到一个List中
        for (int i = 0; i < ope.length; i++) {
            if (ope[i][0] == 1) { //push
                collection.add(ope[i][1]);

            } else if (ope[i][0] == 2) {  //pop
                if (collection.size() == 0) { //如果在栈为空的情况下使用pop，出错返回null
                    System.out.println("Error Input");
                    return null;
                }
                collection.remove(collection.size() - 1);
            }
        }

        //输出分割后的结果
        if (collection.size() == 0) {
            return null;
        } else {
            //如果只有一个栈元素
            if (collection.size() < size) {
                result.add(collection);
                return result;
            }

            //如果有多个栈元素
            //确定要分割的份数
            int count = collection.size() % size == 0 ? collection.size() / size : collection.size() / size + 1;

            //循环添加
            int index = 0;
            for (int i = 0; i < count; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(size);
                for (int j = 0; j < size; j++) {
                    if (index < collection.size()) {
                        temp.add(collection.get(index));
                        index++;
                    }
                }
                result.add(temp);
            }
        }

        return result;
    }

}
