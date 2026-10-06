// JUNGOL #2809 · 약수
// https://jungol.co.kr/problem/2809
// Language: Java
// Execution Time: 111 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        List<Integer> divisors = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                divisors.add(i);
				sb.append(i).append(" ");
            }
        }

        int smallCount = divisors.size();

        boolean isPerfectSquare =
                divisors.get(smallCount - 1) * divisors.get(smallCount - 1) == N;

        smallCount = isPerfectSquare
                ? smallCount  - 1
                : smallCount;
		for(int i = smallCount-1 ; i >= 0 ; i--){
			sb.append(N / divisors.get(i)).append(" ");
		}
        

        System.out.println(sb);
    }
}