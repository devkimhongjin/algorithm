// JUNGOL #1430 · 숫자의 개수
// https://jungol.co.kr/problem/1430
// Language: Java
// Execution Time: 118 ms
// Memory: 33.1 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int[] count = new int[10];
		long multiply = A * B * C;
		for(char c : Long.toString(multiply).toCharArray()){
			count[c - '0']++;
		}
		for(int n : count){
			System.out.println(n);
		}
		
	}
}