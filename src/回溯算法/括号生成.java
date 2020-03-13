package 回溯算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName： 括号生成
 * @description:
 * @author: lisheng
 * @create: 2020-03-06 08:41
 **/
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> rs=new ArrayList<>();
        //传入n 那么就是生成一个2n位的字符串
        generateString("",2*n,rs);
        return  rs;

    }
    public  void  generateString(String curr,Integer maxLength,List<String> rs){
        if(curr.length()==maxLength){
            rs.add(curr);
            return;
        }
        if(validate(curr+"(",maxLength)){
            generateString(curr+"(",maxLength,rs);
        }
        if(validate(curr+")",maxLength)){
            generateString(curr+")",maxLength,rs);}
    }
    public boolean validate(String s,Integer n) {

        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (curr == '(') {
                stack.push(curr);
            } else {
                if (stack.empty()) return false;
                stack.pop();
            }
            i++;
        }
        if(s.length()==n&&!stack.empty())return  false;
        return true;
    }

    //只要还有（就可以写入任意内容，如果没有 只能写左括号
public List<String> generateParenthesis1(int n) {

    List<String> list=new ArrayList<>();
    writeString("",0,list,2*n);
    return  list;
}
public  void  writeString(String curr,int leftNum,List<String> list,int MaxLength){
    if(curr.length()==MaxLength){
        if(leftNum==0) list.add(curr);
        return;
    }
    if(leftNum<MaxLength){
        writeString(curr+"(",leftNum+1,list,MaxLength);
        if(leftNum>0)writeString(curr+")",leftNum-1,list,MaxLength);
    }
}
    public static void main(String[] args) {
        括号生成 括号生成=new 括号生成();
        List<String> strings = 括号生成.generateParenthesis1(2);
        System.out.println(strings);
    }

}
