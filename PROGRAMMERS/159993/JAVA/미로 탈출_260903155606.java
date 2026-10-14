// PROGRAMMERS #159993 · 미로 탈출
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// Solved At: 2026-09-03 15:56:06 KST
// Language: JAVA

import java.util.*;

class Solution {

    // BFS 탐색에서 사용할 위치 정보
    static class Node{
        int r;      // 행 위치
        int c;      // 열 위치
        int dist;   // 시작점부터 현재 위치까지의 거리

        public Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(String[] maps) {
        
        // 시작점에서 레버까지의 거리
        int startToLever = 0;
        
        // 레버에서 출구까지의 거리
        int leverToExit = 0;
        
        // 맵의 행, 열 크기
        int N = maps.length;
        int M = maps[0].length();
        
        // 방문 여부 배열
        boolean[][] visited;
        
        // 시작점의 위치
        int sr = 0;
        int sc = 0;
        
        // 시작점 S의 위치 탐색
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(maps[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }

        // 상하좌우 이동 방향
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        
        // BFS 탐색을 위한 큐
        Queue<Node> queue = new ArrayDeque<>();
        
        // 각 위치까지의 최소 거리
        int[][] dist = new int[N][M];
        
        // 거리 배열을 충분히 큰 값으로 초기화
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dist[i], N*M);
        }
        
        // 시작 위치를 거리 0으로 큐에 삽입
        queue.offer(new Node(sr, sc, 0));
        
        // 레버의 위치
        int lr = 0;
        int lc = 0;
        
        // 시작점에서 레버까지 BFS 탐색
        while(!queue.isEmpty()){
            
            // 현재 위치를 큐에서 꺼냄
            Node cur = queue.poll();
            
            // 현재 경로가 기존 거리보다 짧다면 갱신
            if(cur.dist < dist[cur.r][cur.c]){
                dist[cur.r][cur.c] = cur.dist;
            }else{
                continue;
            }
            
            // 현재 위치의 문자 확인
            char curChar = maps[cur.r].charAt(cur.c);
            
            // 레버에 도착한 경우
            if(curChar == 'L'){
                lr = cur.r;
                lc = cur.c;
                startToLever = cur.dist;
                break;
            }
            
            // 상하좌우 탐색
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                // 맵 범위를 벗어나거나 벽인 경우 제외
                if(nr < 0 || nr >= N || nc < 0 || nc >= M ||
                  maps[nr].charAt(nc) == 'X'){
                    continue;
                }
                
                // 다음 위치를 거리 +1 하여 큐에 삽입
                queue.offer(
                    new Node(nr,
                             nc,
                             cur.dist + 1));
                
            }
        }
        
        // 레버에 도달하지 못한 경우
        if(startToLever == 0){
            return -1;
        }
        
        // 레버에서 출구까지 다시 탐색하기 위해 큐 초기화
        queue = new ArrayDeque<>();
        
        // 거리 배열 초기화
        dist = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dist[i], N*M);
        }
        
        // 레버 위치에서 거리 0으로 탐색 시작
        queue.offer(new Node(lr, lc, 0));
        
        // 레버에서 출구까지 BFS 탐색
        while(!queue.isEmpty()){
            
            // 현재 위치를 큐에서 꺼냄
            Node cur = queue.poll();
            
            // 현재 경로가 기존 거리보다 짧다면 갱신
            if(cur.dist < dist[cur.r][cur.c]){
                dist[cur.r][cur.c] = cur.dist;
            }else{
                continue;
            }
            
            // 현재 위치의 문자 확인
            char curChar = maps[cur.r].charAt(cur.c);
            
            // 출구에 도착한 경우 거리 저장
            if(curChar == 'E'){
                leverToExit = cur.dist;
            }

            // 상하좌우 탐색
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                // 맵 범위를 벗어나거나 벽인 경우 제외
                if(nr < 0 || nr >= N || nc < 0 || nc >= M ||
                  maps[nr].charAt(nc) == 'X'){
                    continue;
                }
                
                // 다음 위치를 거리 +1 하여 큐에 삽입
                queue.offer(
                    new Node(nr,
                             nc,
                             cur.dist + 1));
                
            }
        }
        
        // 출구에 도달하지 못한 경우
        if(leverToExit == 0){
            return -1;
        }

        // 시작점 -> 레버 거리와 레버 -> 출구 거리의 합 반환
        return startToLever + leverToExit;
    }
}