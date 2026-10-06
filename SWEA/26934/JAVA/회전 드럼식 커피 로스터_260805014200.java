// SWEA #26934 · 회전 드럼식 커피 로스터
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpE4aHaXHBIQj
// Language: JAVA
// Execution Time: 88 ms
// Memory: 26368 KB

import java.io.*;
import java.util.*;

class Solution{
	
	static class Basket{
		int index;
		int moisture;
		public Basket(int index, int moisture) {
			this.index = index;
			this.moisture = moisture;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Basket[] baskets = new Basket[M];
			Deque<Basket> queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				baskets[i] = new Basket(i+1, Integer.parseInt(st.nextToken()));
				if(i < N) {
					queue.offer(baskets[i]);
				}
			}
			int waitingIndex = N;
			while(queue.size() > 1) {
				Basket currentBasket = queue.poll();
				currentBasket.moisture = currentBasket.moisture / 2;
				if(currentBasket.moisture > 0) {
					queue.offer(currentBasket);
				}
				if(queue.size() < N && waitingIndex < M) {
					queue.offer(baskets[waitingIndex++]);
				}
			}
			System.out.println("#" + tc + " " + queue.peek().index);
		}
	}
}