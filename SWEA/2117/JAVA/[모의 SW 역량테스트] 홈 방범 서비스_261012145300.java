// SWEA #2117 · [모의 SW 역량테스트] 홈 방범 서비스
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
// Solved At: 2026-10-12 14:53:00 KST
// Language: JAVA
// Execution Time: 107 ms
// Memory: 30848 KB

import java.io.*;
import java.util.*;

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {

    static int N, M;
    static int[][] grid;
    static List<Pair> houses;

    static int getCost(int K) {
        return K * K + (K - 1) * (K - 1);
    }

    static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static int getHouses(int r, int c) {
        int[] count = new int[2 * N];

        for (Pair p : houses) {
            int dist = getDistance(r, c, p.r, p.c);
            count[dist]++;
        }

        int total = 0;
        int maxHouses = 0;

        for (int K = 1; K <= 2 * N - 1; K++) {
            total += count[K - 1];

            if (getCost(K) <= total * M) {
                maxHouses = Math.max(maxHouses, total);
            }
        }

        return maxHouses;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            houses = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    grid[i][j] = input;

                    if (input == 1) {
                        houses.add(new Pair(i, j));
                    }
                }
            }

            int maxHouses = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maxHouses = Math.max(
                        maxHouses,
                        getHouses(i, j)
                    );
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(maxHouses)
              .append("\n");
        }

        System.out.print(sb);
    }
}