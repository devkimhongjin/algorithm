// JUNGOL #1303 · 숫자사각형1
// https://jungol.co.kr/problem/1303
// Language: Java
// Execution Time: 128 ms
// Memory: 33 MB

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
		int m = Integer.parseInt(st.nextToken());

		for(int i = 1 ; i <= n * m ; i++){
			sb.append(i);
			if(i % m == 0){
				sb.append("\n");
			}
			else{
				sb.append(" ");
			}
		}

		System.out.print(sb);
    }
}