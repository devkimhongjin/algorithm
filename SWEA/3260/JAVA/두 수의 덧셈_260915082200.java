// SWEA #3260 · 두 수의 덧셈
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBC1lOad9IDFAWr
// Language: JAVA
// Execution Time: 109 ms
// Memory: 28160 KB

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int test_case = 1 ; test_case <= T ; test_case++) {
			 sb.append("#")
			   .append(test_case)
			   .append(" ");
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 BigInteger a = new BigInteger(st.nextToken());
		     BigInteger b = new BigInteger(st.nextToken());
			 
			 sb.append(a.add(b))
			   .append("\n");
		 }
		 System.out.print(sb);
    }
}