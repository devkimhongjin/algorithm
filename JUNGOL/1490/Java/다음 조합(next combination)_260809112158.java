// JUNGOL #1490 · 다음 조합(next combination)
// https://jungol.co.kr/problem/1490
// Language: Java
// Execution Time: 137 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] comb = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			comb[i] = Integer.parseInt(st.nextToken());
		}

		int index = K - 1;

		while (index >= 0 && comb[index] == N - (K - 1 - index)) {
			index--;
		}
		if (index < 0) {
			sb.append("NONE");
		} else {
			comb[index]++;

			for (int i = index + 1; i < K; i++) {
				comb[i] = comb[i - 1] + 1;
			}

			for (int n : comb) {
				sb.append(n).append(" ");
			}
		}

		System.out.print(sb);
	}
}