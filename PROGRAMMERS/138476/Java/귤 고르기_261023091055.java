// PROGRAMMERS #138476 · 귤 고르기
// https://school.programmers.co.kr/learn/courses/30/lessons/138476
// Solved At: 2026-10-23 09:10:55 KST
// Language: Java
// Execution Time: 341.19 ms
// Memory: 88.373529 MB

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());

        counts.sort(Collections.reverseOrder());

        int answer = 0;

        for (int count : counts) {
            k -= count;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}