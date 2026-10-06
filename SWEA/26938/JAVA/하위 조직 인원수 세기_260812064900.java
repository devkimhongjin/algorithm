// SWEA #26938 · 하위 조직 인원수 세기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpGHaHbXHBIQj
// Language: JAVA
// Execution Time: 96 ms
// Memory: 28544 KB

import java.io.*;
import java.util.*;

class Solution {

	static int[][] check;
    
	static int countChildren(int n) {
		if(check[n] == null) {
			return 1;
		}
        int count = 1;
		if(check[n][0] != 0) {
			count += countChildren(check[n][0]);
		}
		if(check[n][1] != 0) {
			count += countChildren(check[n][1]);
		}
        return count;
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int E = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	
        	check = new int[E+2][];
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0 ; i < E ; i++) {
        		int E1 = Integer.parseInt(st.nextToken());
        		int E2 = Integer.parseInt(st.nextToken());

        		if(check[E1] == null) {
        			check[E1] = new int[2];
        			check[E1][0] = E2;
        		}else {
        			check[E1][1] = E2;
        		}
        	}
        	
        	int answer = countChildren(N);
        	
        	System.out.println("#" + tc + " " + answer);
        }
    }
}