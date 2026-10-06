// SWEA #1949 · [모의 SW 역량테스트] 등산로 조성
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
// Language: JAVA
// Execution Time: 91 ms
// Memory: 27136 KB

// SWEA 1949 · [모의 SW 역량테스트] 등산로 조성
// 언어: Java
// 실행시간: 89 ms · 메모리: 27,244 kb
import java.io.*;
import java.util.*;

class Solution {

    static int N;
    static int K;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int maxLength;

    static void dfs(int r, int c, int depth, boolean canDig) {

        maxLength = Math.max(maxLength, depth);

        int curHeight = grid[r][c];

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            // 범위를 벗어나거나 이미 방문한 곳이면 제외
            if (nr < 0 || nr >= N || nc < 0 || nc >= N
                    || visited[nr][nc]) {
                continue;
            }

            // 현재보다 낮으면 바로 이동
            if (grid[nr][nc] < curHeight) {

                visited[nr][nc] = true;

                dfs(nr, nc, depth + 1, canDig);

                visited[nr][nc] = false;
            }

            // 현재보다 높거나 같고,
            // 아직 지형 깎기를 사용하지 않았다면
            else if (canDig) {

                // 현재 높이보다 1 낮게 만드는 데 필요한 절삭량
                int cut = grid[nr][nc] - curHeight + 1;

                if (cut <= K) {

                    int originalHeight = grid[nr][nc];

                    // 지형 깎기
                    grid[nr][nc] -= cut;
                    visited[nr][nc] = true;

                    dfs(nr, nc, depth + 1, false);

                    // 백트래킹
                    visited[nr][nc] = false;
                    grid[nr][nc] = originalHeight;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            visited = new boolean[N][N];

            int maxHeight = 0;

            // 지도 입력 + 최고 높이 탐색
            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());

                    maxHeight = Math.max(
                            maxHeight,
                            grid[i][j]
                    );
                }
            }

            maxLength = 0;

            // 모든 최고봉을 시작점으로 DFS
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (grid[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, 1, true);
                        visited[i][j] = false;
                    }
                }
            }

            sb.append(maxLength).append("\n");
        }

        System.out.print(sb);
    }
}