// JUNGOL #1073 · 삼각형둘레
// https://jungol.co.kr/problem/1073
// Language: Java
// Execution Time: 261 ms
// Memory: 34156 MB

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		int n = Integer.parseInt(br.readLine());
		if(n < 3){
			return;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int sides[] = new int[n];
		for(int i = 0 ; i <  n ; i++){
			sides[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sides);

		int answer = 0;
		for(int i = 0 ; i < n ; i++){
			for(int j = i + 1 ; j< n ; j++){
				for(int k = j+1 ; k < n ; k++){
					int x = sides[i];
					int y = sides[j];
					int z = sides[k];
					if(x+y > z){
						answer = Math.max(answer, x+y+z);
					}
				}
			}
		}
		System.out.print(answer);

	}
}