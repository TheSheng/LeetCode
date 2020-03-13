package 字符串;

/**
 * @ClassName： 最大公因子
 * @description:
 * @author: lisheng
 * @create: 2020-03-12 08:35
 **/
//GCD算法   gcd(a,b)===>b==0?a:gcd(b,a%b)
public class 最大公因子 {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()==0||str2.length()==0)return "";
          if(!(str1+str2).equals(str2+str1)){
             return "";
          }
          return str1.substring(0,gdc(str1.length(),str2.length()));
    }
    public int gdc(int lengthA,int lengthB){
        return lengthB==0?lengthA:gdc(lengthB,lengthA%lengthB);
    }
}
