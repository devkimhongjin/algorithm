// JUNGOL #2942 · 정삼각형 변의 길이
// https://jungol.co.kr/problem/2942
// Language: Java
// Execution Time: 107 ms
// Memory: 32.8 MB

import java.util.*;
import java.io.*;

public class Main {

	static long[] PN = new long[100];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if(N <= 3){
			System.out.print(1);
			return;
		}
		PN[0] = 1 ; PN[1] = 1 ; PN[2] = 1;
		for(int i = 3 ; i < N ; i++){
			PN[i] = PN[i-3] + PN[i-2];
		}

		System.out.print(PN[N-1]);

	}
}