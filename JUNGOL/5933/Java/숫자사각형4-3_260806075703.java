// JUNGOL #5933 · 숫자사각형4-3
// https://jungol.co.kr/problem/5933
// Language: Java
// Execution Time: 158 ms
// Memory: 33.4 MB

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
				sb.append(r*c).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}