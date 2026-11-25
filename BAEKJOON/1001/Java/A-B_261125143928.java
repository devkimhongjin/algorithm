// BAEKJOON #1001 · A-B
// https://acmicpc.net/problem/1001
// Solved At: 2026-11-25 14:39:28 KST
// Language: Java
// Execution Time: 100 ms
// Memory: 14532 KB

import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		System.out.println(A-B);
	}
}