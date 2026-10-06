// PROGRAMMERS #159993 · 미로 탈출
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// Language: java

import java.util.*;

class Solution {

    static class Node {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public int solution(String[] maps) {
        int startToLever = 0;
        int leverToExit = 0;

        int N = maps.length;
        int M = maps[0].length();

        int sr = 0;
        int sc = 0;

        // 시작점 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        // 시작점 방문 처리 후 큐에 삽입
        visited[sr][sc] = true;
        queue.offer(new Node(sr, sc, 0));

        int lr = 0;
        int lc = 0;

        // 시작점 -> 레버 BFS
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            char curChar = maps[cur.r].charAt(cur.c);

            // 레버에 도착한 경우
            if (curChar == 'L') {
                lr = cur.r;
                lc = cur.c;
                startToLever = cur.dist;
                break;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 범위를 벗어나거나, 벽이거나, 이미 방문한 경우 제외
                if (nr < 0 || nr >= N || nc < 0 || nc >= M ||
                    maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
                    continue;
                }

                // 큐에 넣을 때 방문 처리
                visited[nr][nc] = true;

                queue.offer(
                    new Node(
                        nr,
                        nc,
                        cur.dist + 1
                    )
                );
            }
        }

        // 레버에 도달하지 못한 경우
        if (startToLever == 0) {
            return -1;
        }

        // 레버 -> 출구 탐색을 위해 초기화
        queue = new ArrayDeque<>();
        visited = new boolean[N][M];

        // 레버 위치 방문 처리
        visited[lr][lc] = true;
        queue.offer(new Node(lr, lc, 0));

        // 레버 -> 출구 BFS
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            char curChar = maps[cur.r].charAt(cur.c);

            // 출구에 도착한 경우
            if (curChar == 'E') {
                leverToExit = cur.dist;
                break;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                // 범위를 벗어나거나, 벽이거나, 이미 방문한 경우 제외
                if (nr < 0 || nr >= N || nc < 0 || nc >= M ||
                    maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
                    continue;
                }

                // 큐에 넣을 때 방문 처리
                visited[nr][nc] = true;

                queue.offer(
                    new Node(
                        nr,
                        nc,
                        cur.dist + 1
                    )
                );
            }
        }

        // 출구에 도달하지 못한 경우
        if (leverToExit == 0) {
            return -1;
        }

        return startToLever + leverToExit;
    }
}
