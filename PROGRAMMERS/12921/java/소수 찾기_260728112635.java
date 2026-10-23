// PROGRAMMERS #12921 · 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/12921
// Solved At: 2026-07-28 11:26:35 KST
// Language: java

class Solution {
    public boolean isPrime(int n){
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        for(int i = 2 ; i <= n ; i++){
            answer += isPrime(i)? 1:0;
        }
        return answer;
    }
}