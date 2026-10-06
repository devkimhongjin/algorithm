// SWEA #27024 · 줄 서기 앞뒤 삽입
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87xb8K9IPHBIOQ
// Language: JAVA
// Execution Time: 100 ms
// Memory: 28160 KB

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();
			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int id = Integer.parseInt(st.nextToken());
				if(c == 1) {
					deque.offerFirst(id);
				}else if(c == 2) {
					deque.offerLast(id);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+ tc + " ");
			for (int n : deque) {
			    sb.append(n).append(' ');
			}

			System.out.println(sb);
		}
	}
}