// PROGRAMMERS #12977 · 소수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// Solved At: 2026-07-28 11:57:58 KST
// Language: java

class Solution {
    boolean check[] = new boolean[3001];
    boolean isPrime(int n){
        for(int i = 2 ; i * i <= n ; i++){
            if(check[i] == true){
                continue;
            }
            for(int j = i * 2 ; j <= n ; j+= i){
                check[j] = true;
            }
        }
        return !check[n];
    }
    public int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        for(int i = 0 ; i < length-2 ; i++){
            for(int j = i+1 ; j < length-1 ; j++){
                for(int k = j+1 ; k < length ; k++){
                    answer += isPrime(nums[i] + nums[j] + nums[k])? 1 : 0;
                }
            }
        }
        return answer;
    }
}