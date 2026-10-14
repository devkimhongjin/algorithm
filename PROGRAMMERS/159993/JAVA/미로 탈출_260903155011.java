// PROGRAMMERS #159993 · 미로 탈출
// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// Solved At: 2026-09-03 15:50:11 KST
// Language: JAVA

import java.util.*;
class Solution {

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
        
        @Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
    }
    
    public int solution(String[] maps) {
        int startToLever = 0;
        int leverToExit = 0;
        
        int N = maps.length;
        int M = maps[0].length();
        
        int sr = 0;
        int sc = 0;
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(maps[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[][] dist = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dist[i], N*M);
        }
        
        queue.offer(new Node(sr, sc, 0));
        
        int lr = 0;
        int lc = 0;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.dist < dist[cur.r][cur.c]){
                dist[cur.r][cur.c] = cur.dist;
            }
            else{
                continue;
            }
            char curChar = maps[cur.r].charAt(cur.c);
            if(curChar == 'L'){
                lr = cur.r;
                lc = cur.c;
                startToLever = cur.dist;
                break;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M ||
                  maps[nr].charAt(nc) == 'X'){
                    continue;
                }
                queue.offer(
                    new Node(nr,
                             nc,
                             cur.dist + 1));
                
            }
        }
        if(startToLever == 0){
            return -1;
        }
        
        queue = new PriorityQueue<>();
        dist = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dist[i], N*M);
        }
        queue.offer(new Node(lr, lc, 0));
        
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.dist < dist[cur.r][cur.c]){
                dist[cur.r][cur.c] = cur.dist;
            }
            else{
                continue;
            }
            char curChar = maps[cur.r].charAt(cur.c);
            if(curChar == 'E'){
                leverToExit = cur.dist;
                break;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M ||
                  maps[nr].charAt(nc) == 'X'){
                    continue;
                }
                queue.offer(
                    new Node(nr,
                             nc,
                             cur.dist + 1));
                
            }
        }
        
        if(leverToExit == 0){
            return -1;
        }
         
        return startToLever + leverToExit;
    }
}