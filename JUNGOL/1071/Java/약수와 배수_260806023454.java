// JUNGOL #1071 · 약수와 배수
// https://jungol.co.kr/problem/1071
// Language: Java
// Execution Time: 125 ms
// Memory: 33.2 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++){
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		int divisor = 0;
		int multiple = 0;

		for(int number : numbers){
			if(m % number == 0){
				divisor += number;
			}
			if(number % m == 0){
				multiple += number;
			}
		}

		System.out.println(divisor);
		System.out.println(multiple);
		
	}
}