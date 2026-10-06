// JUNGOL #5931 · 숫자사각형4-1
// https://jungol.co.kr/problem/5931
// Language: Java
// Execution Time: 131 ms
// Memory: 33.2 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
		StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for(int r = 1 ; r <= n ; r++){
			for(int c = 1 ; c <= n ; c++){
				sb.append(r).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}