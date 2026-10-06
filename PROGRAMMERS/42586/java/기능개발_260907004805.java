// PROGRAMMERS #42586 · 기능개발
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// Language: java

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int length = progresses.length;
        int[] days = new int[length];
        
        for(int i = 0 ; i < length ; i++){
            int left = 100 - progresses[i];
            days[i] = left / speeds[i] + (left % speeds[i] == 0 ? 0 : 1);
        }
        
        int cnt = 1;
        int prev = days[0];
        for(int i = 1 ; i < length ; i++){
            if(days[i] <= prev){
                cnt++;
            }else{
                prev = days[i];
                answer.add(cnt);
                cnt = 1;
            }
            if(i == length -1){
                answer.add(cnt);
            }
        }
        
        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}