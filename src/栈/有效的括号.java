package 栈;

import java.util.*;

/**
 * @ClassName： 有效的括号
 * @description:
 * @author: lisheng
 * @create: 2020-03-05 18:51
 **/
public class 有效的括号 {
    //{  123 } 125 【91 】93 (40 )41
    //如果第一个是闭括号 false

    //如果是开阔号 计数+1  记录当前的开括号种类
        //下一位  如果是开阔号 计数+1  入栈  如果遇到不等的闭括号false  相等移除队列头部  最后如果队列不为空也是false
    public boolean isValid(String s) {
        if(s.length()==0)return true;
        List<Character> listKai= Arrays.asList('{','[','(');
        Stack<Character> stack=new Stack<>();
        Integer index=0;
        while (index<s.length()){
            char c=s.charAt(index);
            if(listKai.contains(c)){
                stack.add(c);
            }else{
                //如果是闭括号 可能已经出完了会报错 [])
                if(stack.empty())return  false;
                Character last = stack.lastElement();
                //如果是对应的符号 则移除
                if(last+1==c||last+2==c){
                    stack.pop();
                }else{
                    return  false;
                }
            }
            index++;

        }
        if(!stack.empty()){
            return false;
        }
        return  true;
    }




}
