package com.nowcoder.q1_1;

public class Different {

    /**
    请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
    给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
    保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
    测试样例：
    "aeiou"
    返回：True
    "BarackObama"
    返回：False
     */
    public boolean checkDifferent(String str) {
        //要求ASCII编码（8位，共能显示0-255，共256个不同字符）；
        //即就算字符串中每个字符都不同，长度也最多在256，一旦超出，说明一定有重复。
        if (str.length() > 256) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
