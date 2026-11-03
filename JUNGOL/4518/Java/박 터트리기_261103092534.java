// JUNGOL #4518 · 박 터트리기
// https://jungol.co.kr/problem/4518
// Solved At: 2026-11-03 09:25:34 KST
// Language: Java
// Execution Time: 605 ms
// Memory: 34068 KiB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = K * (K + 1) / 2;

        if (N < min) {
            System.out.print(-1);
        } else {
            int remain = N - min;

            if (remain % K == 0) {
                System.out.print(K - 1);
            } else {
                System.out.print(K);
            }
        }
    }
}