// SWEA #3124 · 최소 스패닝 트리
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
// Solved At: 2026-10-06 13:17:38 KST
// Language: Java
// Execution Time: 2062 ms
// Memory: 130328 KB

import java.util.*;
import java.io.*;

public class Solution {

    static int[] parent;

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] edges = new int[m][3];
            parent = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                edges[i][0] = Integer.parseInt(st.nextToken());
                edges[i][1] = Integer.parseInt(st.nextToken());
                edges[i][2] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(edges,
                (a, b) -> Integer.compare(a[2], b[2])
            );

            long ans = 0;
            int count = 0;

            for (int i = 0; i < m; i++) {

                int a = edges[i][0];
                int b = edges[i][1];

                if (find(a) == find(b)) {
                    continue;
                }

                union(a, b);
                ans += edges[i][2];

                count++;

                if (count == n - 1) {
                    break;
                }
            }

            sb.append("#")
              .append(tc)
              .append(" ")
              .append(ans)
              .append("\n");
        }

        System.out.print(sb);
    }
}