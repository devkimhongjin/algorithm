// JUNGOL #1402 · 약수 구하기
// https://jungol.co.kr/problem/1402
// Language: Java
// Execution Time: 160 ms
// Memory: 33.4 MB

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

        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }

        int smallCount = divisors.size();

        boolean isPerfectSquare =
                divisors.get(smallCount - 1) * divisors.get(smallCount - 1) == N;

        int totalCount = isPerfectSquare
                ? smallCount * 2 - 1
                : smallCount * 2;

        if (K > totalCount) {
            System.out.println(0);
            return;
        }

        if (K <= smallCount) {
            System.out.println(divisors.get(K - 1));
            return;
        }

        int index = totalCount - K;

        System.out.println(N / divisors.get(index));
    }
}