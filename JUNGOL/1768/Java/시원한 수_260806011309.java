// JUNGOL #1768 · 시원한 수
// https://jungol.co.kr/problem/1768
// Language: Java
// Execution Time: 128 ms
// Memory: 33.1 MB

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        long S = Long.parseLong(br.readLine());
        long E = Long.parseLong(br.readLine());

        int count = 0;

        for (long i = 1; ; i++) {
            long sixthPower = i * i * i * i * i * i;

            if (sixthPower > E) {
                break;
            }

            if (sixthPower >= S) {
                count++;
            }
        }

        System.out.print(count);
    }
}