// JUNGOL #1314 · 문자사각형2
// https://jungol.co.kr/problem/1314
// Language: Java
// Execution Time: 155 ms
// Memory: 33.6 MB

import java.io.*;
import java.util.*;

public class Main {

	static char intToChar(int num){
		return (char)('A' + (num-1)  % ('Z' - 'A' + 1));
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
		StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		for(int r = 1 ; r <= n ; r++){
			for(int c = 1 ; c <= n ; c++){
				if(c % 2 == 1){
					sb.append(intToChar(r + n * (c-1))).append(" ");
				}else{
					sb.append(intToChar(n*c -r + 1)).append(" ");
				}
				
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}