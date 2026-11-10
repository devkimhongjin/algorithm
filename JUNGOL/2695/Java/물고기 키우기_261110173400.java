// JUNGOL #2695 · 물고기 키우기
// https://jungol.co.kr/problem/2695
// Solved At: 2026-11-10 17:34:00 KST
// Language: Java
// Execution Time: 812 ms
// Memory: 46164 KiB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fishes = new int[N];

        for (int i = 0; i < N; i++) {
            fishes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fishes);

        int sum = 0;
        int answer = 0;

        for (int fish : fishes) {
            if (sum > 0) {
                while (sum < fish) {
                    answer++;
                    sum *= 2;
                }
            }
            sum += fish;
        }

        System.out.println(answer);
    }
}