// JUNGOL #1291 · 구구단 4
// https://jungol.co.kr/problem/1291
// Language: Java
// Execution Time: 222 ms
// Memory: 38.5 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder answer = new StringBuilder();

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int direction = A<=B ? 1 : -1;

			if(A < 2 || B < 2 || A > 9 || B > 9){
				System.out.println("INPUT ERROR!");
				continue;
			}

			for (int j = 1; j <= 9; j++) {
				for (int i = A; ; i += direction) {
					answer.append(i)
						.append(" * ")
						.append(j)
						.append(" = ")
						.append(String.format("%2d", i * j))
						.append("   ");
					if (i == B) {
						break;
					}
				}
				answer.append("\n");
			}
			System.out.print(answer);
			break;
		}
		
	}
}