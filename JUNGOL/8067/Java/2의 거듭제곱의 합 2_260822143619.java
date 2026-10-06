// JUNGOL #8067 · 2의 거듭제곱의 합 2
// https://jungol.co.kr/problem/8067
// Language: Java
// Execution Time: 372 ms
// Memory: 33.5 MB

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long minDiff = Long.MAX_VALUE;
        long bestValue = Long.MAX_VALUE;

        int answerX = 0;
        int answerY = 0;

        for (int x = 0; x <= 60; x++) {
            for (int y = x; y <= 60; y++) {

                long value = (1L << x) + (1L << y);
                long diff = Math.abs(N - value);

                if (diff < minDiff ||
                    (diff == minDiff && value < bestValue)) {

                    minDiff = diff;
                    bestValue = value;
                    answerX = x;
                    answerY = y;
                }
            }
        }

        System.out.println(answerX + " " + answerY);
    }
}