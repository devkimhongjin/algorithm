// JUNGOL #3521 · Tutorial : 그리디(Greedy - 탐욕, 욕심쟁이) 알고리즘
// https://jungol.co.kr/problem/3521
// Language: Java
// Execution Time: 113 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] weights = {1, 2, 4, 8, 16};
        int[] count = new int[5];

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(st.nextToken());

        int used = 0;

        for (int i = 4; i >= 0; i--) {
            int need = N / weights[i];

            int use = Math.min(need, count[i]);

            N -= use * weights[i];
            used += use;
        }

        if (N == 0) {
            System.out.println(used);
        } else {
            System.out.println("impossible");
        }
    }
}