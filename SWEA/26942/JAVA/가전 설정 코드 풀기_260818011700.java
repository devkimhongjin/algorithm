// SWEA #26942 · 가전 설정 코드 풀기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpHWKHcXHBIQj
// Language: JAVA
// Execution Time: 122 ms
// Memory: 30916 KB

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
        	
            StringTokenizer st =
                    new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int i = 0 ; i < N ; i++) {
            	sb.append(
            			String.format("%4s",
            					Integer.toBinaryString(
            							Integer.parseInt(
            							String.valueOf(s.charAt(i)), 16))
            							).replace(' ', '0'));
                        		
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}