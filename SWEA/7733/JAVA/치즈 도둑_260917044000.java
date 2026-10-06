// SWEA #7733 · 치즈 도둑
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDOdQqRCUDFARG
// Language: JAVA
// Execution Time: 145 ms
// Memory: 36960 KB

import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[] parent;
    static boolean[] active;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 서로 다른 두 치즈 덩어리를 합친 경우 true
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }

        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());


            List<Integer>[] tasteList = new ArrayList[101];

            for (int i = 0; i <= 100; i++) {
                tasteList[i] = new ArrayList<>();
            }

            int maxTaste = 0;

            for (int r = 0; r < N; r++) {

                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {

                    int taste = Integer.parseInt(st.nextToken());

                    // 2차원 좌표를 1차원 번호로 변환
                    int index = r * N + c;

                    tasteList[taste].add(index);

                    maxTaste = Math.max(maxTaste, taste);
                }
            }

            int size = N * N;

            parent = new int[size];
            active = new boolean[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }

            int count = 0;       // 현재 치즈 덩어리 수
            int maxCount = 0;    // 최대 치즈 덩어리 수


            for (int taste = maxTaste; taste >= 1; taste--) {

                // 현재 맛의 치즈를 모두 활성화
                for (int index : tasteList[taste]) {

                    active[index] = true;

                    // 새 치즈는 처음에는 독립된 덩어리
                    count++;

                    int r = index / N;
                    int c = index % N;

                    // 주변 활성화된 치즈와 연결
                    for (int d = 0; d < 4; d++) {

                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                            continue;
                        }

                        int next = nr * N + nc;

                        // 아직 활성화되지 않은 치즈
                        if (!active[next]) {
                            continue;
                        }

                        // 서로 다른 두 덩어리가 합쳐지면
                        // 전체 덩어리 수는 1 감소
                        if (union(index, next)) {
                            count--;
                        }
                    }
                }

                maxCount = Math.max(maxCount, count);
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(maxCount)
              .append("\n");
        }

        System.out.print(sb);
    }
}