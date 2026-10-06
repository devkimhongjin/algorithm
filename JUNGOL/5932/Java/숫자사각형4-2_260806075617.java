// JUNGOL #5932 · 숫자사각형4-2
// https://jungol.co.kr/problem/5932
// Language: Java
// Execution Time: 126 ms
// Memory: 33.3 MB

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
			if(r % 2 == 1){
				for(int c = 1 ; c <= n ; c++){
					sb.append(c).append(" ");
				}
			}else{
				for(int c = n ; c >= 1 ; c--){
					sb.append(c).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);
    }
}