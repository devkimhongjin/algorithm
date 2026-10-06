// JUNGOL #4520 · 햄버거 분배
// https://jungol.co.kr/problem/4520
// Language: Java
// Execution Time: 213 ms
// Memory: 33.4 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		char[] arr = br.readLine().toCharArray();

		int count = 0;
		for(int i = 0 ; i < N ; i++){
			char c = arr[i];
			if(c == 'P'){
				for(int j = Math.max(0, i-k) ; j < Math.min(N, i+k+1) ; j++){
					if(arr[j] == 'H'){
						arr[j] = 'N';
						count++;
						break;
					}
				}
			}
		}
		sb.append(count);
        System.out.print(sb);
    }
}