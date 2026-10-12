// SWEA #7465 · 창용 마을 무리의 개수
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
// Solved At: 2026-08-12 17:42:00 KST
// Language: JAVA
// Execution Time: 106 ms
// Memory: 29056 KB

import java.io.*;
import java.util.*;

class Solution {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

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

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            int answer = N;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if (union(n1, n2)) {
                    answer--;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}