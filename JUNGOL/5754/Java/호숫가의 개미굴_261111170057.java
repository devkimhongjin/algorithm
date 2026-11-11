// JUNGOL #5754 · 호숫가의 개미굴
// https://jungol.co.kr/problem/5754
// Solved At: 2026-11-11 17:00:57 KST
// Language: Java
// Execution Time: 659 ms
// Memory: 59924 KiB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        long[] C = new long[N];

        long answer = 0;
        int start = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            C[i] = Long.parseLong(st.nextToken());

            answer += C[i];

            if (C[i] > 0 && start == -1) {
                start = i;
            }
        }

        if (start == -1) {
            System.out.print(N / 2);
            return;
        }

        int row = 0;

        for (int i = 1; i <= N; i++) {
            int idx = (start + i) % N;

            if (C[idx] == 0) {
                row++;
            } else {
                answer += (row + 1) / 2;
                row = 0;
            }
        }

        System.out.print(answer);
    }
}
