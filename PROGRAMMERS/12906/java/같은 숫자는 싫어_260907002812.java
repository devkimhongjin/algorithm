// PROGRAMMERS #12906 · 같은 숫자는 싫어
// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// Language: java

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i : arr){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(stack.peek() != i){
                    stack.push(i);
                }
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i = 0 ; !stack.isEmpty() ; i++){
            answer[i] = stack.pollLast();
        }
        

        return answer;
    }
}