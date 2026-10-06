// SWEA #26956 · 행운의 구슬 팔찌
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpL76Hf3HBIQj
// Language: JAVA
// Execution Time: 187 ms
// Memory: 32764 KB

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			int index = 0;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				int bead = Integer.parseInt(st.nextToken());
				list.add(bead);
			}
			ListIterator<Integer> it = list.listIterator();
			for(int i = 0 ; i < K ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(!it.hasNext()) {
						it = list.listIterator();
					}
					it.next();
				}
				
				int prevValue = it.previous();
				it.next();
				int nextValue;
				if(it.hasNext()) {
					nextValue = it.next();
					it.previous();
				}else {
					nextValue = list.get(0);
				}
				
				
			    it.add(prevValue + nextValue);
			    it.previous();
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+ tc + " ");
			
			Iterator<Integer> descIt = list.descendingIterator();

			int cnt = 0;
			while (descIt.hasNext() && cnt < 10) {
			    sb.append(descIt.next()).append(' ');
			    cnt++;
			}

			System.out.println(sb);
		}
	}
}