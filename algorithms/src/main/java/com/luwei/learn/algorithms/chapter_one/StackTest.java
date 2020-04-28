package com.luwei.learn.algorithms.chapter_one;

import java.util.Stack;

public class StackTest {
    public static Double getResult(String param){
       Stack<String> ops = new Stack<>();
       Stack<Double> vals = new Stack<>();
       if(!param.equals("")){
           //读取字符，如果是运算符则压入栈
           for(int i = 0; i < param.length() - 1; i++){
               String tmp = param.substring(i,i+1);
               if(tmp.equals("(")){
                   continue;
               }else if(tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")){
                   ops.push(tmp);
               }else if(tmp.equals(")")){
                   String op = ops.pop();
                   double v = vals.pop();
                   if(op.equals("+")){
                       v = vals.pop() + v;
                   }else if(op.equals("-")){
                       v = vals.pop() - v;
                   }else if(op.equals("*")){
                       v = vals.pop() * v;
                   }else if(op.equals("/")){
                       v = vals.pop() / v;
                   }
                   vals.push(v);
               }else{
                   vals.push(Double.parseDouble(tmp));
               }
           }
       }
        return vals.pop();
    }

    public static void main(String args[]){
        System.out.println(getResult("(1+((2+3)*(4*5)))"));
    }
}
