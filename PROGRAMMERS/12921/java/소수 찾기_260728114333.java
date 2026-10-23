// PROGRAMMERS #12921 · 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/12921
// Solved At: 2026-07-28 11:43:33 KST
// Language: java



class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] check = new boolean[n+1];
        //check[0] = check[1] = true;
        for(int i = 2 ; i * i <= n ; i++){
            if(check[i] == true){
                continue;
            }
            for(int j = i * 2 ; j <= n ; j+= i){
                check[j] = true;
            }
        }
        
        for(int i = 2 ; i <= n ; i++){
            answer += check[i]? 0 : 1;
        }

        
        return answer;
    }
}