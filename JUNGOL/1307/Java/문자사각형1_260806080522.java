// JUNGOL #1307 · 문자사각형1
// https://jungol.co.kr/problem/1307
// Language: Java
// Execution Time: 231 ms
// Memory: 33.6 MB

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

		for(int r = n ; r >= 1 ; r--){
			for(int c = n ; c >= 1 ; c--){
				sb.append((char)('A' + ((r + n * (c-1)) - 1) % ('Z' - 'A' + 1))).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}