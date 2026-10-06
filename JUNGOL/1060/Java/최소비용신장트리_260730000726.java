// JUNGOL #1060 · 최소비용신장트리
// https://jungol.co.kr/problem/1060
// Language: Java
// Execution Time: 208 ms
// Memory: 34.9 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                cost[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] minCost = new int[N];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N];

        minCost[0] = 0;

        long totalCost = 0;
        int selectedCount = 0;

        for (int count = 0; count < N; count++) {

            int current = -1;
            int currentMinCost = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                if (!visited[i] && minCost[i] < currentMinCost) {
                    currentMinCost = minCost[i];
                    current = i;
                }
            }

            if (current == -1) {
                break;
            }

            visited[current] = true;
            totalCost += minCost[current];
            selectedCount++;

            for (int next = 0; next < N; next++) {
				
                if (cost[current][next] == 0) {
                    continue;
                }

                if (!visited[next]
                        && cost[current][next] < minCost[next]) {

                    minCost[next] = cost[current][next];
                }
            }
        }

        if (selectedCount != N) {
            System.out.println("MST를 만들 수 없습니다.");
        } else {
            System.out.println(totalCost);
        }
    }
}