// PROGRAMMERS #60063 · 블록 이동하기
// https://school.programmers.co.kr/learn/courses/30/lessons/60063
// Solved At: 2026-09-17 17:22:15 KST
// Language: java


import java.util.*;

class Solution {
    
    static int N;
    static int[][] board;
    static boolean[][][] visited;
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static class Robot {
        int r;
        int c;
        int dir;    // 0 : 가로, 1 : 세로
        int time;
        
        public Robot(int r, int c, int dir, int time) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.time = time;
        }
    }
    
    // 해당 칸이 보드 안이고 빈칸인지 확인
    static boolean isEmpty(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N) {
            return false;
        }
        
        return board[r][c] == 0;
    }
    
    // 해당 상태로 로봇을 놓을 수 있는지 확인
    static boolean canMove(int r, int c, int dir) {
        
        // 가로
        if(dir == 0) {
            return isEmpty(r, c)
                    && isEmpty(r, c + 1);
        }
        
        // 세로
        return isEmpty(r, c)
                && isEmpty(r + 1, c);
    }
    
    static void addRobot(
            Queue<Robot> queue,
            int r,
            int c,
            int dir,
            int time
    ) {
        
        if(!canMove(r, c, dir)) {
            return;
        }
        
        if(visited[r][c][dir]) {
            return;
        }
        
        visited[r][c][dir] = true;
        queue.offer(new Robot(r, c, dir, time));
    }
    
    static boolean isArrived(Robot robot) {
        
        // 가로 상태
        if(robot.dir == 0) {
            return robot.r == N - 1
                    && robot.c + 1 == N - 1;
        }
        
        // 세로 상태
        return robot.r + 1 == N - 1
                && robot.c == N - 1;
    }
    
    static int bfs() {
        
        Queue<Robot> queue = new ArrayDeque<>();
        
        // 시작 위치
        queue.offer(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!queue.isEmpty()) {
            
            Robot robot = queue.poll();
            
            if(isArrived(robot)) {
                return robot.time;
            }
            
            /*
             * 1. 상하좌우 이동
             */
            for(int i = 0; i < 4; i++) {
                
                int nr = robot.r + dr[i];
                int nc = robot.c + dc[i];
                
                addRobot(
                    queue,
                    nr,
                    nc,
                    robot.dir,
                    robot.time + 1
                );
            }
            
            /*
             * 2. 회전
             */
            
            int r = robot.r;
            int c = robot.c;
            
            // 가로 상태
            if(robot.dir == 0) {
                
                /*
                 * 현재
                 *
                 * ■ ■
                 *
                 * 위쪽으로 회전
                 *
                 * □ □
                 * ■ ■
                 */
                if(isEmpty(r - 1, c)
                        && isEmpty(r - 1, c + 1)) {
                    
                    // 왼쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r - 1,
                        c,
                        1,
                        robot.time + 1
                    );
                    
                    // 오른쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r - 1,
                        c + 1,
                        1,
                        robot.time + 1
                    );
                }
                
                /*
                 * 아래쪽으로 회전
                 *
                 * ■ ■
                 * □ □
                 */
                if(isEmpty(r + 1, c)
                        && isEmpty(r + 1, c + 1)) {
                    
                    // 왼쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r,
                        c,
                        1,
                        robot.time + 1
                    );
                    
                    // 오른쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r,
                        c + 1,
                        1,
                        robot.time + 1
                    );
                }
            }
            
            // 세로 상태
            else {
                
                /*
                 * 현재
                 *
                 * ■
                 * ■
                 *
                 * 왼쪽으로 회전
                 *
                 * □ ■
                 * □ ■
                 */
                if(isEmpty(r, c - 1)
                        && isEmpty(r + 1, c - 1)) {
                    
                    // 위쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r,
                        c - 1,
                        0,
                        robot.time + 1
                    );
                    
                    // 아래쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r + 1,
                        c - 1,
                        0,
                        robot.time + 1
                    );
                }
                
                /*
                 * 오른쪽으로 회전
                 *
                 * ■ □
                 * ■ □
                 */
                if(isEmpty(r, c + 1)
                        && isEmpty(r + 1, c + 1)) {
                    
                    // 위쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r,
                        c,
                        0,
                        robot.time + 1
                    );
                    
                    // 아래쪽 칸 기준 회전
                    addRobot(
                        queue,
                        r + 1,
                        c,
                        0,
                        robot.time + 1
                    );
                }
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] input) {
        
        board = input;
        N = board.length;
        
        visited = new boolean[N][N][2];
        
        return bfs();
    }
}