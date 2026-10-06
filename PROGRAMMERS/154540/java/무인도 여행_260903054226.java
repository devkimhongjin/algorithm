// PROGRAMMERS #154540 · 무인도 여행
// https://school.programmers.co.kr/learn/courses/30/lessons/154540
// Language: java

import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static String[] sMaps;
    static int N;
    static int M;
    static int sum;
    
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0, 0, -1};
    
    void dfs(int r, int c){
        visited[r][c] = true;
        sum += sMaps[r].charAt(c) - '0';
        for(int i = 0 ; i < 4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M
              || sMaps[nr].charAt(nc) == 'X' || visited[nr][nc]){
                continue;
            }
            dfs(nr, nc);
        }
    }
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        sMaps = maps.clone();
        N = maps.length;
        M = maps[0].length();
        
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    sum = 0;
                    dfs(i, j);
                    answer.add(sum);
                }
            }
        }
        
        return answer.size() == 0?
            new int[]{-1} :
            answer.stream()
                  .mapToInt(Integer::intValue)
                  .sorted()
                  .toArray();
    }
}