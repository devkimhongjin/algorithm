// JUNGOL #3546 · 소코반
// https://jungol.co.kr/problem/3546
// Language: Java
// Execution Time: 263 ms
// Memory: 34 MB

import java.io.*;
import java.util.*;

public class Main {

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int R;
    static int C;

    static char[][] map;
    static boolean[][] target;

    static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        void setPosition(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isOutside(int r, int c) {
        return r < 0 || r >= R || c < 0 || c >= C;
    }

    static boolean isBox(char cell) {
        return cell == 'b' || cell == 'B';
    }

    static int getDirection(char command) {
        switch (command) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
            default:
                throw new IllegalArgumentException(
                        "잘못된 명령어: " + command
                );
        }
    }

    // 플레이어 또는 상자가 떠난 칸을 원래 상태로 복구
    static void restoreCell(int r, int c) {
        map[r][c] = target[r][c] ? '+' : '.';
    }

    // 플레이어를 해당 위치에 배치
    static void placeWorker(int r, int c) {
        map[r][c] = target[r][c] ? 'W' : 'w';
    }

    // 상자를 해당 위치에 배치
    static void placeBox(int r, int c) {
        map[r][c] = target[r][c] ? 'B' : 'b';
    }

    static void moveWorker(Position worker, char command) {
        int dir = getDirection(command);

        int r = worker.r;
        int c = worker.c;

        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (isOutside(nr, nc)) {
            return;
        }

        char nextCell = map[nr][nc];

        // 벽이면 이동하지 않음
        if (nextCell == '#') {
            return;
        }

        // 다음 칸에 상자가 있는 경우
        if (isBox(nextCell)) {
            int boxNextR = nr + dr[dir];
            int boxNextC = nc + dc[dir];

            if (isOutside(boxNextR, boxNextC)) {
                return;
            }

            char boxNextCell = map[boxNextR][boxNextC];

            // 상자 뒤에 벽이나 다른 상자가 있으면 밀 수 없음
            if (boxNextCell == '#' || isBox(boxNextCell)) {
                return;
            }

            // 상자를 한 칸 이동
            placeBox(boxNextR, boxNextC);

            // 플레이어의 이전 위치 복구
            restoreCell(r, c);

            // 플레이어가 상자가 있던 자리로 이동
            placeWorker(nr, nc);

            worker.setPosition(nr, nc);
            return;
        }

        // 빈칸 또는 목표 지점으로 이동
        restoreCell(r, c);
        placeWorker(nr, nc);

        worker.setPosition(nr, nc);
    }

    static boolean isCompleted() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (target[r][c] && map[r][c] != 'B') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        target = new boolean[R][C];

        Position worker = null;

        for (int r = 0; r < R; r++) {
            String line = br.readLine();

            for (int c = 0; c < C; c++) {
                char cell = line.charAt(c);

                map[r][c] = cell;

                if (cell == 'w') {
                    worker = new Position(r, c);
                } else if (cell == 'W') {
                    worker = new Position(r, c);
                    target[r][c] = true;
                } else if (cell == '+' || cell == 'B') {
                    target[r][c] = true;
                }
            }
        }

        char[] moves = br.readLine().toCharArray();

        if (worker == null) {
            throw new IllegalStateException("플레이어 위치가 없습니다.");
        }

        boolean completed = isCompleted();

        // 완료 상태가 아니라면 명령 수행
        if (!completed) {
            for (char command : moves) {
                moveWorker(worker, command);

                // 모든 상자가 목표에 도착한 순간 중단
                if (isCompleted()) {
                    completed = true;
                    break;
                }
            }
        }

        System.out.println(completed ? "complete" : "incomplete");

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}