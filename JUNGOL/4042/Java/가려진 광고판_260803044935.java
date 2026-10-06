// JUNGOL #4042 · 가려진 광고판
// https://jungol.co.kr/problem/4042
// Language: Java
// Execution Time: 241 ms
// Memory: 39.6 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] field = new boolean[2001][2001];
		int count = 0;

		for(int i = 0 ; i < 2 ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) + 1000;
			int y1 = Integer.parseInt(st.nextToken()) + 1000;
			int x2 = Integer.parseInt(st.nextToken()) + 1000;
			int y2 = Integer.parseInt(st.nextToken()) + 1000;

			for(int x = x1 ; x < x2 ; x++){
				for(int y = y1 ; y < y2 ; y++){
					field[x][y] = true;
					count++;
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) + 1000;
		int y1 = Integer.parseInt(st.nextToken()) + 1000;
		int x2 = Integer.parseInt(st.nextToken()) + 1000;
		int y2 = Integer.parseInt(st.nextToken()) + 1000;

		for(int x = x1 ; x < x2 ; x++){
			for(int y = y1 ; y < y2 ; y++){
				if(field[x][y] == true){
					count--;
				}
				
			}
		}
		System.out.println(count);
	}
}