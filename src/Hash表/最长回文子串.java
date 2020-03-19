package Hash表;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName： 最长回文子串
 * @description:
 * @author: lisheng
 * @create: 2020-03-19 08:40
 **/
public class 最长回文子串 {
    //最大长度 是 所有双数的长度 +一个最大奇数长度  错误
    //奇数长度最后留一个 其他的也可以用上 所以可以统计奇数个位数
    public int longestPalindrome(String s) {
       int [] db=new int[128];
       for(char c:s.toCharArray())db[c]++;
       int count=0;
       for(int num:db){
             count+=(num%2);
       }
       return count==0?s.length():s.length()-count+1;
    }
}
