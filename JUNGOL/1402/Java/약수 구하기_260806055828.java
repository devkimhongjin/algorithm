// JUNGOL #1402 · 약수 구하기
// https://jungol.co.kr/problem/1402
// Language: Java
// Execution Time: 198 ms
// Memory: 33.2 MB

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

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;

                if (count == K) {
                    System.out.println(i);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}