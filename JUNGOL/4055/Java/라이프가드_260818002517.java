// JUNGOL #4055 · 라이프가드
// https://jungol.co.kr/problem/4055
// Language: Java
// Execution Time: 277 ms
// Memory: 33.2 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] workers = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            workers[i][0] = Integer.parseInt(st.nextToken());
            workers[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int fired = 0; fired < N; fired++) {
            boolean[] covered = new boolean[1000];

            for (int i = 0; i < N; i++) {
                if (i == fired) continue;

                for (int t = workers[i][0]; t < workers[i][1]; t++) {
                    covered[t] = true;
                }
            }

            int time = 0;
            for (int t = 0; t < 1000; t++) {
                if (covered[t]) {
                    time++;
                }
            }

            answer = Math.max(answer, time);
        }

        System.out.println(answer);
    }
}