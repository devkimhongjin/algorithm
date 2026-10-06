// JUNGOL #4017 · 소는 왜 길을 건너갔을까? 5
// https://jungol.co.kr/problem/4017
// Language: Java
// Execution Time: 260 ms
// Memory: 34.1 MB

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
        int B = Integer.parseInt(st.nextToken());

        boolean[] broken = new boolean[N];

        for (int i = 0; i < B; i++) {
            int index = Integer.parseInt(br.readLine()) - 1;
            broken[index] = true;
        }

        int currentFix = 0;

        for (int i = 0; i < K; i++) {
            if (broken[i]) {
                currentFix++;
            }
        }

        int minFix = currentFix;

        for (int right = K; right < N; right++) {
            int left = right - K;

            if (broken[left]) {
                currentFix--;
            }

            if (broken[right]) {
                currentFix++;
            }

            minFix = Math.min(minFix, currentFix);
        }

        System.out.println(minFix);
    }
}