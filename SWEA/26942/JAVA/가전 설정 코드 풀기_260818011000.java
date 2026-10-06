// SWEA #26942 · 가전 설정 코드 풀기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpHWKHcXHBIQj
// Language: JAVA
// Execution Time: 126 ms
// Memory: 30336 KB

import java.io.*;
import java.util.*;

class Solution {
	static int hexToInt(char c) {
		if (c >= '0' && c <= '9') return c - '0';
	    if (c >= 'A' && c <= 'F') return c - 'A' + 10;
	    return c - 'a' + 10;
	}
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
            					Integer.toBinaryString(hexToInt(s.charAt(i))))
                        		.replace(' ', '0'));
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}