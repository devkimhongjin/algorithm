// SWEA #2805 · 농작물 수확하기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
// Language: Java
// Execution Time: 84 ms
// Memory: 26240 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	
        	int answer = 0;
        	int N = Integer.parseInt(br.readLine());
        	for(int i = 0 ; i < N ; i++) {
        		String line = br.readLine();
        		for(int j = 0 ; j < N ; j++) {
        			if(i <= N/2) {
        				if(j >= N/2 - i && j <= N/2 + i) {
        					answer += line.charAt(j) - '0';
        				}
        			}else {
        				if(j >= N/2 - (N - i - 1) && j <= N/2 + (N - i - 1)) {
        					answer += line.charAt(j) - '0';
        				}
        			}
        		}
        	}
        	
        	sb.append(answer)
        	  .append("\n");
        }

        System.out.print(sb);
    }
}