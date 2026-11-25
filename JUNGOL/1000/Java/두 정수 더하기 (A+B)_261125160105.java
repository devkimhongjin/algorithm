// JUNGOL #1000 · 두 정수 더하기 (A+B)
// https://jungol.co.kr/problem/1000
// Solved At: 2026-11-25 16:01:05 KST
// Language: Java
// Execution Time: 182 ms
// Memory: 33464 KiB

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.print(a+b);
	}
}