// SWEA #1868 · 파핑파핑 지뢰찾기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc
// Language: JAVA
// Execution Time: 189 ms
// Memory: 42240 KB

import java.io.*;
import java.util.*;

public class Solution {
    
    static int[] dr = {1, 0, -1, 0, -1, -1, 1, 1};
    static int[] dc = {0, 1, 0, -1, -1, 1, -1, 1};
    
    static int N;
    static char[][] matrix;
    static boolean[][] visited;
    
    static class Loc {
        int r;
        int c;
        
        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    // 현재 칸 주변 8방향에 지뢰가 하나도 없는지 확인
    static boolean isZero(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }
            
            if (matrix[nr][nc] == '*') {
                return false;
            }
        }
        
        return true;
    }
    
    // 0인 칸을 클릭했을 때 자동으로 열리는 영역 탐색
    static void click(int r, int c) {
        Queue<Loc> queue = new ArrayDeque<>();
        
        queue.offer(new Loc(r, c));
        visited[r][c] = true;
        
        while (!queue.isEmpty()) {
            Loc cur = queue.poll();
            
            // 현재 칸이 0이 아니라면 주변까지 확장되지 않음
            if (!isZero(cur.r, cur.c)) {
                continue;
            }
            
            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }
                
                if (matrix[nr][nc] == '*' || visited[nr][nc]) {
                    continue;
                }
                
                visited[nr][nc] = true;
                
                // 주변 칸 중 0인 칸만 다시 확장
                if (isZero(nr, nc)) {
                    queue.offer(new Loc(nr, nc));
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            
            N = Integer.parseInt(br.readLine());
            matrix = new char[N][N];
            visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                matrix[i] = br.readLine().toCharArray();
            }
            
            int clickCount = 0;
            
            // 1. 0인 칸부터 클릭
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (matrix[r][c] == '*' || visited[r][c]) {
                        continue;
                    }
                    
                    if (isZero(r, c)) {
                        click(r, c);
                        clickCount++;
                    }
                }
            }
            
            // 2. 자동으로 열리지 않은 나머지 일반 칸
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (matrix[r][c] != '*' && !visited[r][c]) {
                        clickCount++;
                    }
                }
            }
            
            sb.append(clickCount).append("\n");
        }
        
        System.out.print(sb);
    }
}