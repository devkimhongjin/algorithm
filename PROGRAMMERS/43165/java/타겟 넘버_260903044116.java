// PROGRAMMERS #43165 · 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165
// Language: java

class Solution {
    static int targetSum;
    static int[] sNumbers;
    static int count = 0;
    void dfs(int i, int sum){
        if(i >= sNumbers.length){
            return;
        }
        dfs(i+1 , sum);
        sum += sNumbers[i];
        if(sum == targetSum){
            count++;
            return;
        }else if(sum > targetSum){
            return;
        }
        dfs(i+1 , sum);
    }
    public int solution(int[] numbers, int target) {
        int sum = 0;
        for(int n : numbers){
            sum += n;
        }
        sNumbers = numbers;
        targetSum = (sum-target) / 2;
        
        dfs(0, 0);
        
        return count;
    }
}