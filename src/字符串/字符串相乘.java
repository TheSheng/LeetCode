package 字符串;

/**
 * @ClassName： 字符串相乘
 * @description:
 * @author: lisheng
 * @create: 2020-04-13 09:54
 **/
public class 字符串相乘 {
    public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] rs=new int[length1+length2];
        //乘数的位数
        for(  int currPos=1;currPos<=num1.length();currPos++){
            int num=num1.charAt(length1-currPos)-'0';
            for(int beCurrpos=1;beCurrpos<=num2.length();beCurrpos++){
                int beNum=num2.charAt(length2-beCurrpos)-'0';
                int thisRs= num * beNum;
                //两个个位数相乘 最多两位数  十位落在 currPos+beCurrpos 个位落在 -1
                rs[rs.length-(currPos+beCurrpos)]+=thisRs/10;
                rs[rs.length-(currPos+beCurrpos-1)]+=thisRs%10;
            }
        }
        StringBuilder rsStr=new StringBuilder();
        int next=0;
        for(int i=rs.length-1;i>=0;i--){
            int thisNum = rs[i]+next;
            next=thisNum/10;
            rsStr.append(thisNum%10);
        }
        rsStr=rsStr.reverse();
        boolean canReplace=true;
        int start=0;
        for(;start<rsStr.length();start++){
            if(rsStr.charAt(start)=='0'&&canReplace)continue;
            break;
        }
        if(start==rsStr.length())return "0";
        return rsStr.substring(start,rsStr.length());
    }

    public static void main(String[] args) {
        String multiply = multiply("2", "3");
        System.out.println(multiply);
    }
}
