// SWEA #1225 · [S/W 문제해결 기본] 7일차 - 암호생성기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
// Solved At: 2026-09-01 09:24:00 KST
// Language: JAVA
// Execution Time: 90 ms
// Memory: 27648 KB

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		 final int T = 10;
		 
		 for(int test_case = 1 ; test_case <= T ; test_case++) {
			 sb.append("#")
			   .append(test_case)
			   .append(" ");
			 br.readLine();
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 Deque<Integer> queue = new ArrayDeque<>();
			 for(int i = 0 ; i < 8 ; i++) {
				 int input = Integer.parseInt(st.nextToken());
				 queue.offer(input);
			 }
			 
			 int pop = -1;
			 int dec= 1;
			 while(pop != 0) {
				 pop = queue.poll();
				 pop = Math.max(0, pop-dec);
				 queue.offer(pop);
				 dec = dec % 5 + 1;
			 }
			 
			 while(!queue.isEmpty()) {
				 sb.append(queue.poll())
				   .append(" ");
			 }
			 
			 sb.append("\n");
		 }
		 System.out.print(sb);
    }
}