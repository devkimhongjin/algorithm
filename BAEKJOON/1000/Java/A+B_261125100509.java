// BAEKJOON #1000 · A+B
// https://acmicpc.net/problem/1000
// Solved At: 2026-11-25 10:05:09 KST
// Language: Java
// Execution Time: 104 ms
// Memory: 14712 KB

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		System.out.println(A+B);
	}
}