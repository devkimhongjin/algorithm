// JUNGOL #1658 · 최대공약수와최소공배수
// https://jungol.co.kr/problem/1658
// Language: Java
// Execution Time: 106 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {

    // 유클리드 호제법
    static long gcd(long a, long b) {
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = gcd(A, B);
        long lcm = A / gcd * B;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}