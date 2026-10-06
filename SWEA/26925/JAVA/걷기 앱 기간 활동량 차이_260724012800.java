// SWEA #26925 · 걷기 앱 기간 활동량 차이
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCD6HYHHBIQj
// Language: JAVA
// Execution Time: 91 ms
// Memory: 26368 KB

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] steps = new int[N];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                steps[i] = value;
                if(i < M) {
                	sum += value;
                }
            }
            
            int min = sum;
            int max = sum;
            
            for(int i = M ; i < N ; i++) {
            	sum += steps[i] - steps[i-M];
            	min = Math.min(min, sum);
            	max = Math.max(max, sum);
            }

            int answer = max - min;

            System.out.println("#" + testCase + " " + answer);
        }
	}
}