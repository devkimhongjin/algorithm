// JUNGOL #8124 · 풀뭉치
// https://jungol.co.kr/problem/8124
// Language: Java
// Execution Time: 160 ms
// Memory: 34.1 MB

import java.io.*;
import java.util.*;

class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (map[nr][nc] == '#' && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < C; c++) {
                map[r][c] = st.nextToken().charAt(0);
            }
        }

        int answer = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == '#' && !visited[r][c]) {
                    dfs(r, c);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}