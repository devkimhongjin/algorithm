// JUNGOL #2912 · 벨트
// https://jungol.co.kr/problem/2912
// Language: Java
// Execution Time: 143 ms
// Memory: 33.9 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws Exception {
		BitSet bitset = new BitSet();
		double rpm = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());


		for(int i = 0 ; i < M ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			rpm = rpm / a * b;
			if(s == 1){
				bitset.flip(0);
			}
		}
		System.out.print(bitset.get(0)?1:0);
		System.out.println(" " + (int)rpm);
	}
}