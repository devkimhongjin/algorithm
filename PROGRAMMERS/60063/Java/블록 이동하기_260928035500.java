// PROGRAMMERS #60063 · 블록 이동하기
// https://school.programmers.co.kr/learn/courses/30/lessons/60063
// Language: Java
// Execution Time: 25.87 ms
// Memory: 79.107143 MB

import java.util.*;

class Solution {
    
    static int N;
    static int[][] Board;
    
    // 2x2 공간 안에서 로봇이 차지하고 있는 모양
    static int[][][] shapes = {
        {
            {1, 1},
            {0, 0}
        },
        {
            {0, 1},
            {0, 1}
        },
        {
            {0, 0},
            {1, 1}
        },
        {
            {1, 0},
            {1, 0}
        }
    };
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    /*
     * r, c :
     * 현재 shape를 표현하는 2x2 공간의 왼쪽 위 좌표
     *
     * shape :
     * 0 : 위쪽 가로
     * 1 : 오른쪽 세로
     * 2 : 아래쪽 가로
     * 3 : 왼쪽 세로
     */
    static class Robot {
        int r;
        int c;
        int shape;
        int time;
        
        public Robot(int r, int c, int shape, int time) {
            this.r = r;
            this.c = c;
            this.shape = shape;
            this.time = time;
        }
    }
    
    /*
     * r, c는 실제 보드 밖(-1)이 될 수도 있음
     *
     * 예를 들어 왼쪽 끝의 세로 로봇은
     *
     * 0 1
     * 0 1
     *
     * 형태(shape 1)로 표현하면
     * 2x2 기준 좌표 c가 -1이 될 수 있음.
     *
     * 중요한 것은 실제 로봇이 차지하는 1인 칸이
     * 보드 안에 있는지 확인하는 것.
     */
    static boolean canPlace(int r, int c, int shape) {
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                
                if(shapes[shape][i][j] == 0) {
                    continue;
                }
                
                int nr = r + i;
                int nc = c + j;
                
                // 실제 로봇 위치가 보드 밖
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    return false;
                }
                
                // 벽
                if(Board[nr][nc] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /*
     * 회전하려면 2x2 공간 전체가 비어 있어야 함.
     *
     * 예:
     *
     * 1 1
     * 0 0
     *
     * 아래쪽으로 회전하려면
     *
     * 1 1
     * □ □
     *
     * 아래 두 칸이 모두 비어 있어야 함.
     *
     * 기존 로봇 위치도 빈칸이므로
     * 결국 해당 2x2 영역 전체가 0인지 검사하면 됨.
     */
    static boolean canRotate(int r, int c) {
        
        // 회전 공간 자체가 보드 밖이면 불가능
        if(r < 0 || r + 1 >= N || c < 0 || c + 1 >= N) {
            return false;
        }
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                if(Board[r + i][c + j] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /*
     * 새로운 상태를 BFS Queue에 추가
     *
     * r, c가 -1까지 가능하므로
     * visited에서는 +1을 해서 사용
     */
    static void addRobot(
            Queue<Robot> queue,
            boolean[][][] visited,
            int r,
            int c,
            int shape,
            int time
    ) {
        
        if(!canPlace(r, c, shape)) {
            return;
        }
        
        int vr = r + 1;
        int vc = c + 1;
        
        if(visited[vr][vc][shape]) {
            return;
        }
        
        visited[vr][vc][shape] = true;
        
        queue.offer(
            new Robot(r, c, shape, time)
        );
    }
    
    // 두 칸 중 하나가 (N-1, N-1)에 도착했는지 확인
    static boolean isArrived(Robot robot) {
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                
                if(shapes[robot.shape][i][j] == 0) {
                    continue;
                }
                
                int nr = robot.r + i;
                int nc = robot.c + j;
                
                if(nr == N - 1 && nc == N - 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    static int bfs() {
        
        Queue<Robot> queue = new ArrayDeque<>();
        
        /*
         * r, c는 -1 ~ N-1까지 나올 수 있으므로
         * +1 offset을 위해 N+1 크기로 생성
         */
        boolean[][][] visited =
                new boolean[N + 1][N + 1][4];
        
        // 시작 상태
        // 1 1
        // 0 0
        addRobot(
            queue,
            visited,
            0,
            0,
            0,
            0
        );
        
        while(!queue.isEmpty()) {
            
            Robot robot = queue.poll();
            
            if(isArrived(robot)) {
                return robot.time;
            }
            
            /*
             * 1. 상하좌우 이동
             *
             * shape는 그대로 두고
             * 2x2 공간 자체를 이동
             */
            for(int i = 0; i < 4; i++) {
                
                int nr = robot.r + dr[i];
                int nc = robot.c + dc[i];
                
                addRobot(
                    queue,
                    visited,
                    nr,
                    nc,
                    robot.shape,
                    robot.time + 1
                );
            }
            
            /*
             * 2. 회전
             */
            
            int r = robot.r;
            int c = robot.c;
            
            /*
             * shape 0
             *
             * 1 1
             * 0 0
             */
            if(robot.shape == 0) {
                
                /*
                 * 아래쪽으로 회전
                 *
                 * 현재 2x2 안에서
                 *
                 * 1 1        0 1
                 * 0 0   ->   0 1
                 *
                 * 또는
                 *
                 * 1 1        1 0
                 * 0 0   ->   1 0
                 */
                if(canRotate(r, c)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        1,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        3,
                        robot.time + 1
                    );
                }
                
                /*
                 * 위쪽으로 회전
                 *
                 * 회전할 2x2 공간이 한 칸 위로 이동
                 */
                if(canRotate(r - 1, c)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r - 1,
                        c,
                        1,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r - 1,
                        c,
                        3,
                        robot.time + 1
                    );
                }
            }
            
            /*
             * shape 2
             *
             * 0 0
             * 1 1
             */
            else if(robot.shape == 2) {
                
                // 위쪽으로 회전
                if(canRotate(r, c)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        1,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        3,
                        robot.time + 1
                    );
                }
                
                // 아래쪽으로 회전
                if(canRotate(r + 1, c)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r + 1,
                        c,
                        1,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r + 1,
                        c,
                        3,
                        robot.time + 1
                    );
                }
            }
            
            /*
             * shape 3
             *
             * 1 0
             * 1 0
             */
            else if(robot.shape == 3) {
                
                // 오른쪽으로 회전
                if(canRotate(r, c)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        0,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        2,
                        robot.time + 1
                    );
                }
                
                // 왼쪽으로 회전
                if(canRotate(r, c - 1)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c - 1,
                        0,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c - 1,
                        2,
                        robot.time + 1
                    );
                }
            }
            
            /*
             * shape 1
             *
             * 0 1
             * 0 1
             */
            else {
                
                // 왼쪽으로 회전
                if(canRotate(r, c)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        0,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c,
                        2,
                        robot.time + 1
                    );
                }
                
                // 오른쪽으로 회전
                if(canRotate(r, c + 1)) {
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c + 1,
                        0,
                        robot.time + 1
                    );
                    
                    addRobot(
                        queue,
                        visited,
                        r,
                        c + 1,
                        2,
                        robot.time + 1
                    );
                }
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] board) {
        
        Board = board;
        N = board.length;
        
        return bfs();
    }
}