// PROGRAMMERS #161988 · 연속 펄스 부분 수열의 합
// https://school.programmers.co.kr/learn/courses/30/lessons/161988
// Solved At: 2026-09-21 17:30:59 KST
// Language: java

class Solution {
    public long solution(int[] sequence) {

        long prefix1 = 0;
        long prefix2 = 0;
        
        prefix1 = sequence[0] * -1;
        long min1 = prefix1; long max1 = prefix1;
        prefix2 = sequence[0];
        long min2 = prefix2; long max2 = prefix2;
        
        for(int i = 1 ; i < sequence.length ; i++){
            prefix1 += sequence[i] * (i % 2 == 0 ? -1 : 1);
            prefix2 += sequence[i] * (i % 2 == 0 ? 1 : -1);
            if(prefix1 < min1){
                min1 = prefix1;
            }
            if(prefix1 > max1){
                max1 = prefix1;
            }
            if(prefix2 < min2){
                min2 = prefix2;
            }
            if(prefix2 > max2){
                max2 = prefix2;
            }
        }
        
        max1 = Math.max(max1, max1-min1);
        max2 = Math.max(max2, max2-min2);

        return Math.max(max1, max2);
    }
}