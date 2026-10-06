// SWEA #6782 · 현주가 좋아하는 제곱근 놀이
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgqsAlKr9sDFAW0
// Language: JAVA
// Execution Time: 141 ms
// Memory: 40192 KB



import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean canRoot(long N) {
		return Math.sqrt(N) == (long)Math.sqrt(N);
	}
	
	static final int MAX_N_ROOT = 1000000;
	
	static long[] squares;
	static long findNextSquare(long N) {
		int left = 0;
		int right = MAX_N_ROOT;
		while(left <= right) {
		    int mid = left + (right - left) / 2;

		    if(squares[mid] == N) {
		        return squares[mid];

		    } else if(squares[mid] < N) {

		        if(mid < MAX_N_ROOT && N < squares[mid + 1]) {
		            return squares[mid+1];
		        }

		        left = mid + 1;

		    } else {

		        if(mid > 0 && N > squares[mid - 1]) {
		            return squares[mid];
		        }

		        right = mid - 1;
		    }
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		StringBuilder sb = new StringBuilder();

		squares = new long[MAX_N_ROOT+1];
		squares[0] = 2;

		for(int i = 1 ; i <= MAX_N_ROOT ; i++) {
			squares[i] = (long)(i+1) * (i+1);
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			long N = Long.parseLong(br.readLine());
			
			int cnt = 0;
			while(N != 2) {
				if(canRoot(N)) {
					cnt++;
					N = (long)Math.sqrt(N);
				}else {
					long nextSquare = findNextSquare(N);
					cnt += nextSquare - N;
					N = nextSquare;
				}
			}
			sb.append(cnt)
			  .append("\n");
			
		}
		
		System.out.print(sb);
	}
}