// JUNGOL #4774 · 딸기
// https://jungol.co.kr/problem/4774
// Solved At: 2026-11-02 09:27:33 KST
// Language: Java
// Execution Time: 1041 ms
// Memory: 46664 KiB


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        long maxA = 0;
        long ans = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            long T = Long.parseLong(st.nextToken());

            maxA = Math.max(maxA, A);
            ans = Math.max(ans, A + T);
        }

        ans = Math.max(ans, 2 * maxA);

        System.out.println(ans);
    }
}
