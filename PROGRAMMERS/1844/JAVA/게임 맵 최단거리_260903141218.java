// PROGRAMMERS #1844 · 게임 맵 최단거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
// Solved At: 2026-09-03 14:12:18 KST
// Language: JAVA

import java.util.*;

class Solution {
// BFS에서 각 위치의 좌표와 시작점으로부터의 거리를 저장하는 클래스
static class Location{
    int r;      // 행
    int c;      // 열
    int dist;   // 시작점부터 현재 위치까지의 거리

    public Location(int r, int c, int dist){
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

public int solution(int[][] maps) {

    // 목적지까지 도달할 수 없는 경우 -1 반환
    int answer = -1;
    
    // 맵의 행과 열 크기
    int n = maps.length;
    int m = maps[0].length;
    
    // 각 위치의 방문 여부를 저장
    boolean[][] visited = new boolean[n][m];
    
    // 상하좌우 이동을 위한 방향 배열
    int[] dr = {0, 1, -1, 0};
    int[] dc = {1, 0, 0, -1};
    
    // BFS 탐색을 위한 큐
    Deque<Location> queue = new ArrayDeque<>();

    // 시작 위치 (0, 0)를 거리 1로 큐에 삽입
    queue.offer(new Location(0, 0, 1));
    
    // 큐가 빌 때까지 BFS 탐색
    while(!queue.isEmpty()){

        // 현재 탐색할 위치를 큐에서 꺼냄
        Location cur = queue.poll();

        // 목적지에 도착했다면 현재까지의 거리가 최단 거리
        if(cur.r == n-1 && cur.c == m-1){
            answer = cur.dist;
            break;
        }

        // 현재 위치에서 상하좌우 탐색
        for(int i = 0 ; i < 4 ; i++){

            // 이동할 위치 계산
            int nr = cur.r + dr[i];
            int nc = cur.c + dc[i];
            
            // 맵의 범위를 벗어나거나,
            // 벽이거나,
            // 이미 방문한 위치라면 탐색하지 않음
            if(nr < 0 || nr >= n || nc < 0 || nc >= m
               || maps[nr][nc] != 1 || visited[nr][nc]){
                continue;
            }

            // 방문 처리
            visited[nr][nc] = true;

            // 이동한 위치와 증가한 거리를 큐에 삽입
            queue.offer(new Location(nr, nc, cur.dist+1));
        }
    }
    
    // 목적지까지의 최단 거리 반환
    // 도달하지 못했다면 -1 반환
    return answer;
}