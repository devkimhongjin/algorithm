// SWEA #1979 · 어디에 단어가 들어갈 수 있을까
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq
// Language: JAVA
// Execution Time: 78 ms
// Memory: 25216 KB

import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(
			 new InputStreamReader(System.in)
		 );
		 StringBuilder sb = new StringBuilder();
		 int T = Integer.parseInt(br.readLine());
		 for(int test_case = 1 ; test_case <= T ; test_case++) {
			 sb.append("#")
			   .append(test_case)
			   .append(" ");
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(st.nextToken());
			 int K = Integer.parseInt(st.nextToken());
			 
			 int[][] board = new int[N][N];
			 for(int r = 0 ; r < N ; r++) {
				 st = new StringTokenizer(br.readLine());
				 for(int c = 0 ; c < N ; c++) {
					 board[r][c] = Integer.parseInt(st.nextToken());
				 }
			 }
			 
			 int count = 0;
			 
			 for(int r = 0 ; r < N ; r++) {
				 int streak = 0;
				 for(int c = 0 ; c < N ; c++) {
					 if(board[r][c] == 0) {
						 if(streak == K) {
							 count++;
						 }
						 streak = 0;
						 if(N-c <= K) {
							 break;
						 }
					 }else if(board[r][c] == 1) {
						 streak++;
					 }
					 
				 }
				 if(streak == K) {
					 count++;
				 }
			 }
			 
			 for(int c = 0 ; c < N ; c++) {
				 int streak = 0;
				 for(int r = 0 ; r < N ; r++) {
					 if(board[r][c] == 0) {
						 if(streak == K) {
							 count++;
						 }
						 streak = 0;
						 if(N-r <= K) {
							 break;
						 }
					 }else if(board[r][c] == 1) {
						 streak++;
					 }
				 }
				 if(streak == K) {
					 count++;
				 }
			 }
			 
			 sb.append(count)
			   .append("\n");
			 
		 }
		 System.out.print(sb);
	}
}