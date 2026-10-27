// JUNGOL #12352 · 즐거운 회의
// https://jungol.co.kr/problem/12352
// Solved At: 2026-10-20 09:42:51 KST
// Language: Java
// Execution Time: 1254 ms
// Memory: 63.8 MB


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] a = new int[N + 1];
        int[] b = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[T + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int L = Math.max(a[c], a[d]);
            int R = Math.min(b[c], b[d]);

            if (L < R) {
                diff[L]++;
                diff[R]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int t = 0; t < T; t++) {
            count += diff[t];
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
