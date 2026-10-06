// PROGRAMMERS #68645 · 삼각 달팽이
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
// Language: java

class Solution {
    public int[] solution(int n) {
        int total = n * (n + 1) / 2;
        int[] answer = new int[total];
        int[][] map = new int[n][n];

        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};

        int r = 0;
        int c = 0;
        int dir = 0;

        for (int num = 1; num <= total; num++) {
            map[r][c] = num;
            
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (
                nr < 0 || nr >= n ||
                nc < 0 || nc >= n ||
                map[nr][nc] != 0
            ) {
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}