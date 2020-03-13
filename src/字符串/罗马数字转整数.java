package 字符串;

/**
 * @ClassName： 罗马数字转整数
 * @description:
 * @author: lisheng
 * @create: 2020-03-04 15:25
 **/
public class 罗马数字转整数 {
    public static int romanToInt(String s) {
        int sum=0;
        int index=0;
       while (index<s.length()){
           char c = s.charAt(index);
           int thisNum=getNum(c);
           if(index+1<s.length()){
               char next=s.charAt(index+1);
               int nextNum=getNum(next);
               if(thisNum<nextNum){
                   sum+=-thisNum+nextNum;
                   index+=2;
               }else{
                   sum+=thisNum;
                   index++;
               }

           }else {
               sum+=thisNum;
               index++;
           }
       }
       return sum;
    }
    public static int getNum(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;

        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));

    }
}
