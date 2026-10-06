// JUNGOL #1618 · 3제곱수의 조합
// https://jungol.co.kr/problem/1618
// Language: Java
// Execution Time: 120 ms
// Memory: 32.8 MB

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        long answer = 0;
        long exponent = 1; //

        while (N > 0) {
            if ((N & 1) == 1) {
                answer += exponent;
            }
            exponent *= 3;
            N >>= 1;
        }
        
        System.out.println(answer);
    }
}