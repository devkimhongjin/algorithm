// SWEA #5607 · [Professional] 조합
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGKdbqczEDFAUo
// Solved At: 2026-10-20 11:52:06 KST
// Language: Java
// Execution Time: 103 ms
// Memory: 34280 KB

import java.io.*;
import java.util.*;

public class Solution {

    static final int MAX = 1000000;
    static final long MOD = 1234567891L;

    static long[] factorial = new long[MAX + 1];

    static long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp /= 2;
        }

        return result;
    }

    static long combination(int N, int R) {
        if (R < 0 || R > N) {
            return 0;
        }

        long numerator = factorial[N];
        long denominator = factorial[R] * factorial[N - R] % MOD;

        return numerator * pow(denominator, MOD - 2) % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        factorial[0] = 1;

        for (int i = 1; i <= MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            sb.append("#").append(tc).append(" ")
              .append(combination(N, R)).append('\n');
        }

        System.out.print(sb);
    }
}