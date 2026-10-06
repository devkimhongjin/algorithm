// JUNGOL #8852 · 영어 수행평가
// https://jungol.co.kr/problem/8852
// Language: Java
// Execution Time: 184 ms
// Memory: 38.9 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String seats = br.readLine();

        List<Long> adjusted = new ArrayList<>();

        int studentIndex = 0;

        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == '1') {
                adjusted.add((long) i - studentIndex);
                studentIndex++;
            }
        }

        int K = adjusted.size();

        if (K <= 1) {
            System.out.println(0);
            return;
        }
        long median = adjusted.get(K / 2);

        long answer = 0;

        for (long x : adjusted) {
            answer += Math.abs(x - median);
        }

        System.out.println(answer);
    }
}