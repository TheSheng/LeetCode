package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName： 翻转字符串里的单词
 * @description:
 * @author: lisheng
 * @create: 2020-04-14 08:35
 **/
public class 翻转字符串里的单词 {
    public static String reverseWords(String s) {
        s=s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ",list);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
