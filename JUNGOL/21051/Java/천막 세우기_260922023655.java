// JUNGOL #21051 · 천막 세우기
// https://jungol.co.kr/problem/21051
// Language: Java
// Execution Time: 257 ms
// Memory: 33.4 MB

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);

		long a = Long.parseLong(br.readLine());
		long A = a * a;

		for(long i = 1; ; i++) {
			long remain = A - i * i;

			if(remain <= 0) {
				break;
			}

			if(remain % (2 * i) == 0) {
				long x = remain / (2 * i);

				System.out.print(x + " " + (x + i));
				return;
			}
		}
	}
}