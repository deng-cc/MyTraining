package com.nowcoder.q1_3;

import java.util.Arrays;

public class Same {

    /**
     给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
     给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
     测试样例：
     "This is nowcoder","is This nowcoder"
     返回：true
     "Here you are","Are you here"
     返回：false
     */
    public boolean checkSam(String stringA, String stringB) {
        //字符串长度不等，那么一定不能重排转换
        if (stringA.length() != stringB.length()) {
            return false;
        }
        //利用Arrays类的静态方法sort对byte[]进行排序后再new为String，判断String是否相等
        byte[] bytesA = stringA.getBytes();
        byte[] bytesB = stringB.getBytes();
        Arrays.sort(bytesA);
        Arrays.sort(bytesB);
        //或在此直接使用 return Arrays.equals(bytesA, bytesB);
        String strA = new String(bytesA);
        String strB = new String(bytesB);
        if (strA.equals(strB)) {
            return true;
        } else {
            return false;
        }
    }
}
