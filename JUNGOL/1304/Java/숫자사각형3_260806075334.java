// JUNGOL #1304 · 숫자사각형3
// https://jungol.co.kr/problem/1304
// Language: Java
// Execution Time: 151 ms
// Memory: 33.5 MB

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
				sb.append(r + n * (c-1)).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}