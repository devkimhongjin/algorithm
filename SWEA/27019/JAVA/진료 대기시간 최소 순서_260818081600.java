// SWEA #27019 · 진료 대기시간 최소 순서
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c1gqyEvHBITH
// Language: JAVA
// Execution Time: 99 ms
// Memory: 28032 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#" + tc + " ");
        	int N = Integer.parseInt(br.readLine());
        	int[] t = new int[N];
        	
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) {
            	t[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(t);
            int prefix = 0;
            int sum = 0;
            for(int i = 0 ; i < N-1 ; i++) {
            	prefix = prefix + t[i];
            	sum += prefix;
            }
            
            sb.append(sum)
              .append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}