// PROGRAMMERS #12909 · 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// Language: java

import java.util.*;
class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                char top = stack.peek();
                if(top == ')'){
                    break;
                }else{
                    if(c == '('){
                        stack.push(c);
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}