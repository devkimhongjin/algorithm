// PROGRAMMERS #12977 · 소수 만들기
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// Language: java

class Solution {
    boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2 ; i * i <= n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
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