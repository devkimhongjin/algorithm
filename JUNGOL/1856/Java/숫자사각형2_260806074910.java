// JUNGOL #1856 · 숫자사각형2
// https://jungol.co.kr/problem/1856
// Language: Java
// Execution Time: 212 ms
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
		int m = Integer.parseInt(st.nextToken());

		for(int r = 1 ; r <= n ; r++){
			if(r % 2 == 1){
				for(int c = 1 ; c <= m ; c++){
					sb.append(c + (r-1) * m).append(" ");
				}
			}else{
				for(int c = m ; c >= 1 ; c--){
					sb.append(c + (r-1) * m).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}