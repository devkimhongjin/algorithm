// SWEA #2382 · [모의 SW 역량테스트] 미생물 격리
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl
// Language: JAVA
// Execution Time: 1205 ms
// Memory: 128708 KB

import java.io.*;
import java.util.*;

class Solution {

    static int N;

    static int[] dr = {9, -1, 1, 0, 0};
    static int[] dc = {9, 0, 0, -1, 1};

    static class Micro {
        int r;
        int c;
        int qty;
        int dir;

        public Micro(int r, int c, int qty, int dir) {
            this.r = r;
            this.c = c;
            this.qty = qty;
            this.dir = dir;
        }

        public void move() {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 약품 셀에 도착
            if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                qty /= 2;
                dir = (dir % 2 == 0) ? dir - 1 : dir + 1;
            }

            r = nr;
            c = nc;
        }

        public boolean isDead() {
            return qty <= 0;
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Micro> list = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int qty = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                list.add(new Micro(r, c, qty, dir));
            }

            for (int i = 0; i < M; i++) {

                List<Micro>[][] visited = new ArrayList[N][N];

                // 1. 모든 미생물 이동
                for (Micro m : list) {

                    m.move();

                    // 이동 후 죽었다면 visited에 넣지 않음
                    if (m.isDead()) {
                        continue;
                    }

                    if (visited[m.r][m.c] == null) {
                        visited[m.r][m.c] = new ArrayList<>();
                    }

                    visited[m.r][m.c].add(m);
                }

                // 2. 죽은 미생물 제거
                list.removeIf(Micro::isDead);

                // 3. 같은 위치의 미생물 합치기
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {

                        if (visited[r][c] != null &&
                            visited[r][c].size() >= 2) {

                            // 가장 큰 군집이 방향을 가짐
                            visited[r][c].sort(
                                (m1, m2) -> m2.qty - m1.qty
                            );

                            Micro main = visited[r][c].get(0);

                            for (int j = 1; j < visited[r][c].size(); j++) {

                                Micro other = visited[r][c].get(j);

                                main.qty += other.qty;
                                list.remove(other);
                            }
                        }
                    }
                }
            }

            int count = 0;

            for (Micro m : list) {
                count += m.qty;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}