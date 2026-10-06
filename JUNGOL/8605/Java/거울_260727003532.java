// JUNGOL #8605 · 거울
// https://jungol.co.kr/problem/8605
// Language: Java
// Execution Time: 720 ms
// Memory: 66.6 MB

import java.io.*;
import java.util.*;

public class Main {

	public static long Flip(long a, int b){
		return 2*b-a;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		Deque<Integer> mirrors = new LinkedList<>();

		boolean leftStart = N % 2 == 0? true : false;

		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++){
			mirrors.offerLast(Integer.parseInt(st.nextToken()));
		}
		while(!mirrors.isEmpty()){
			if(leftStart){
				s = Flip(s, mirrors.pollFirst());
				leftStart = false;
			}
			else
			{
				s = Flip(s, mirrors.pollLast());
				leftStart = true;
			}
		}
		System.out.print(s);
	}
}