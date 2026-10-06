// PROGRAMMERS #1835 · 단체사진 찍기
// https://school.programmers.co.kr/learn/courses/30/lessons/1835
// Language: java

import java.util.*;

class Solution {

    static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static final int N = 8;

    static Map<Character, Integer> index;
    static boolean[] visited;
    static int[] position;
    static String[] conditions;
    static int answer;

    static void dfs(int depth) {
        // 8명을 모두 배치했으면 조건 확인
        if (depth == N) {
            if (isValid()) {
                answer++;
            }
            return;
        }

        // 현재 위치(depth)에 들어갈 친구 선택
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            position[i] = depth;

            dfs(depth + 1);

            visited[i] = false;
        }
    }

    static boolean isValid() {
        for (String s : conditions) {

            int c1 = index.get(s.charAt(0));
            int c2 = index.get(s.charAt(2));

            char op = s.charAt(3);
            int requiredDist = s.charAt(4) - '0';

            // 두 친구 사이에 있는 사람 수
            int actualDist = Math.abs(position[c1] - position[c2]) - 1;

            if (op == '=' && actualDist != requiredDist) {
                return false;
            }

            if (op == '<' && actualDist >= requiredDist) {
                return false;
            }

            if (op == '>' && actualDist <= requiredDist) {
                return false;
            }
        }

        return true;
    }

    public int solution(int n, String[] data) {
        answer = 0;
        conditions = data;

        index = new HashMap<>();

        for (int i = 0; i < N; i++) {
            index.put(FRIENDS[i], i);
        }

        visited = new boolean[N];
        position = new int[N];

        dfs(0);

        return answer;
    }
}