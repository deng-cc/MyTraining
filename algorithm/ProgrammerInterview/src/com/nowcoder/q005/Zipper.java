package com.nowcoder.q005;

public class Zipper {
    /**
     利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
     比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
     给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
     测试样例
     "aabcccccaaa"
     返回："a2b1c5a3"
     "welcometonowcoderrrrr"
     返回："welcometonowcoderrrrr"
     */
    public String zipString(String iniString) {
        String temp = iniString;
        String str = "";

        while (true) {
            //截取首字母
            str = str + iniString.charAt(0);

            //计算首字母连续数，并续在新字符串串尾
            int i = 0;
            int count = 1;
            for (; i + 1 < iniString.length(); i++) {
                if (iniString.charAt(i) != iniString.charAt(i + 1)) {
                    break;
                } else {
                    count++;
                }
            }
            str = str + count;

            //判断是否越界
            if (i + 1 != iniString.length()) {
                //已经压缩的那部分字符串去掉，提取后部分字符串，并继续循环
                iniString = iniString.substring(i + 1);
            } else {
                //如果越界，表示已经提取完了，通过return跳出while并返回值
                return str.length() < temp.length() ? str:temp;
            }

        }
    }
}
