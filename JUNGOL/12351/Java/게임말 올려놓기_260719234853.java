// JUNGOL #12351 · 게임말 올려놓기
// https://jungol.co.kr/problem/12351
// Language: Java
// Execution Time: 236 ms
// Memory: 32.6 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		//int[][] map = new int[N][M];
		int answer = 0;

		int[] dn = {-1, -1, 1, 1};
		int[] dm = {1, 1, -1, -1};

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < M ; j++){
				for(int k = 0 ; k < 4 ; k++){
					int nn = i+dn[k];
					int nm = j+dm[k];

					if(nn >= 0 && nn < N && nm >= 0 && nm < M){
						answer++;
					}
				}
			}
		}


		System.out.print(answer/2);
	}
}