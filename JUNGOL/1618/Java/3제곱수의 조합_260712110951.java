// JUNGOL #1618 · 3제곱수의 조합
// https://jungol.co.kr/problem/1618
// Language: Java
// Execution Time: 118 ms
// Memory: 33.1 MB

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        long answer = 0;
        int exponent = 0;

        while (N > 0) {
            if (N % 2 == 1) {
                answer += (long) Math.pow(3, exponent);
            }
            N /= 2;
            exponent++;
        }

        System.out.println(answer);
    }
}