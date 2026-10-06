// PROGRAMMERS #1844 · 게임 맵 최단거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
// Language: java

import java.util.*;
class Solution {
    static class Location{
        int r;
        int c;
        int dist;
        public Location(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};
        
        Deque<Location> queue = new ArrayDeque<>();
        queue.offer(new Location(0, 0, 1));
        
        while(!queue.isEmpty()){
            Location cur = queue.poll();
            if(cur.r == n-1 && cur.c == m-1){
                answer = cur.dist;
                break;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m
                   || maps[nr][nc] != 1 || visited[nr][nc]){
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new Location(nr, nc, cur.dist+1));
            }
        }
        
        
        return answer;
    }
}