// JUNGOL #4178 · 순열정복 2
// https://jungol.co.kr/problem/4178
// Language: Java
// Execution Time: 203 ms
// Memory: 36 MB

import java.io.*;
import java.util.*;
import java.util.*;

class Main{
	static int N;
	static int M;
	
	static void permutation(StringBuilder sb, int count, boolean[] visited) {

		if (count == M) {
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				continue;
			}

			int length = sb.length();

			visited[i] = true;
			sb.append(i).append(' ');

			permutation(sb, count + 1, visited);

			visited[i] = false;
			sb.setLength(length);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		permutation(new StringBuilder(),0, new boolean[N+1]);
	}
}