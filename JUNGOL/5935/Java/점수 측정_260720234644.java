// JUNGOL #5935 · 점수 측정
// https://jungol.co.kr/problem/5935
// Language: Java
// Execution Time: 216 ms
// Memory: 38.4 MB

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int sum = 0;

        for (int i = 0; i < M; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        double bestAvg = (sum + (N - M) * 3.0) / N;
        double worstAvg = (sum - (N - M) * 3.0) / N;

        System.out.printf("%.4f %.4f", worstAvg, bestAvg);
    }
}