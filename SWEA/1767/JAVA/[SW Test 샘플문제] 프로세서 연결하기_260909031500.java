// SWEA #1767 · [SW Test 샘플문제] 프로세서 연결하기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
// Language: JAVA
// Execution Time: 99 ms
// Memory: 28892 KB

import java.io.*;
import java.util.*;

class Solution {

    static class Core {
        int r;
        int c;

        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int[][] processor;

    static Core[] coreList;
    static int cores;

    static int minLineLength;
    static int maxConnect;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 현재 코어에서 해당 방향으로 전선을 연결할 수 있는지 확인
    static boolean isValidDir(Core core, int dir) {
        int r = core.r + dr[dir];
        int c = core.c + dc[dir];

        while (r >= 0 && r < N && c >= 0 && c < N) {

            // 코어 또는 이미 설치된 전선이 있으면 연결 불가능
            if (processor[r][c] != 0) {
                return false;
            }

            r += dr[dir];
            c += dc[dir];
        }

        return true;
    }

    // 해당 방향으로 전선을 설치하거나 제거
    // value = 2 : 설치
    // value = 0 : 제거
    static int setLine(Core core, int dir, int value) {
        int r = core.r + dr[dir];
        int c = core.c + dc[dir];

        int length = 0;

        while (r >= 0 && r < N && c >= 0 && c < N) {
            processor[r][c] = value;
            length++;

            r += dr[dir];
            c += dc[dir];
        }

        return length;
    }

    static void dfs(int idx, int connect, int lineLength) {

        // 남은 코어를 전부 연결해도 현재 최대 연결 수보다 작으면 탐색할 필요 없음
        if (connect + (cores - idx) < maxConnect) {
            return;
        }

        // 모든 내부 코어에 대한 선택이 끝난 경우
        if (idx == cores) {

            // 더 많은 코어를 연결한 경우
            if (connect > maxConnect) {
                maxConnect = connect;
                minLineLength = lineLength;
            }

            // 연결 수가 같으면 전선 길이가 짧은 경우 선택
            else if (connect == maxConnect) {
                minLineLength = Math.min(minLineLength, lineLength);
            }

            return;
        }

        Core core = coreList[idx];

        // 현재 코어를 4방향으로 연결해봄
        for (int dir = 0; dir < 4; dir++) {

            if (!isValidDir(core, dir)) {
                continue;
            }

            // 전선 설치
            int length = setLine(core, dir, 2);

            dfs(
                idx + 1,
                connect + 1,
                lineLength + length
            );

            // 백트래킹: 설치했던 전선 제거
            setLine(core, dir, 0);
        }

        // 현재 코어를 연결하지 않는 경우
        dfs(idx + 1, connect, lineLength);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());
            processor = new int[N][N];

            List<Core> list = new ArrayList<>();

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {

                    processor[r][c] =
                        Integer.parseInt(st.nextToken());

                    if (processor[r][c] == 1) {

                        // 가장자리 코어는 이미 전원에 연결되어 있으므로
                        // DFS 탐색 대상에서 제외
                        if (r == 0 || r == N - 1
                                || c == 0 || c == N - 1) {
                            continue;
                        }

                        list.add(new Core(r, c));
                    }
                }
            }

            // 내부 코어만 저장
            coreList = list.toArray(new Core[0]);
            cores = coreList.length;

            maxConnect = 0;
            minLineLength = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append(minLineLength)
              .append("\n");
        }

        System.out.print(sb);
    }
}