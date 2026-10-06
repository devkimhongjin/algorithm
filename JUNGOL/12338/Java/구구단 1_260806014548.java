// JUNGOL #12338 · 구구단 1
// https://jungol.co.kr/problem/12338
// Language: Java
// Execution Time: 182 ms
// Memory: 33.3 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		if(A <= B){
			for(int i = A ; i <= B ; i++){
			for(int j = 1 ; j <= 9 ; j++){
				answer.append(i).append(" * ").append(j).append (" = ").append(i*j).append("\n");
			}
			answer.append("\n");
		}
		}else{
			for(int i = A ; i >= B ; i--){
				for(int j = 1 ; j <= 9 ; j++){
					answer.append(i).append(" * ").append(j).append (" = ").append(i*j).append("\n");
				}
				answer.append("\n");
			}
		}

		
		System.out.print(answer);
	}
}