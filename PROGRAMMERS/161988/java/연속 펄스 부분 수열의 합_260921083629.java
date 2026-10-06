// PROGRAMMERS #161988 · 연속 펄스 부분 수열의 합
// https://school.programmers.co.kr/learn/courses/30/lessons/161988
// Language: java

class Solution {
    public long solution(int[] sequence) {

        long prefix = 0;
        long min = 0;
        long max = 0;

        for(int i = 0 ; i < sequence.length ; i++){
            prefix += sequence[i] * (i % 2 == 0 ? -1L : 1L);

            min = Math.min(min, prefix);
            max = Math.max(max, prefix);
        }

        return max - min;
    }
}