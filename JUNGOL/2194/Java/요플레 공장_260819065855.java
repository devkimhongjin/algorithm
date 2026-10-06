// JUNGOL #2194 · 요플레 공장
// https://jungol.co.kr/problem/2194
// Language: Java
// Execution Time: 249 ms
// Memory: 43.9 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long C = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());

		long minCost = C * Y;
		long bestCost = C;

		for(int i = 1 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			bestCost = Math.min(bestCost + S, C);
			minCost += bestCost * Y;
		}
        
		sb.append(minCost);
        System.out.print(sb);
    }
}