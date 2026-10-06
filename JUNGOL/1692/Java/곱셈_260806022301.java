// JUNGOL #1692 · 곱셈
// https://jungol.co.kr/problem/1692
// Language: Java
// Execution Time: 153 ms
// Memory: 33.3 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());

		System.out.println(A * (B%100%10));
		System.out.println(A * (B%100/10));
		System.out.println(A * (B/100));
		System.out.println(A * B);
		
	}
}