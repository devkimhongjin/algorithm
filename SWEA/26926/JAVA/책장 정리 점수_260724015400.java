// SWEA #26926 · 책장 정리 점수
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCW6HYXHBIQj
// Language: JAVA
// Execution Time: 76 ms
// Memory: 25984 KB

import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());

			int[][] score = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				score[i][0] = Integer.parseInt(st.nextToken());
				for(int j = i ; j >= 0 ; j--) {
					if(score[j][0] > score[i][0])
					{
						score[j][1]++;
					}
				}
			}
			int maxScore = 0;
			for (int i = 0; i < N; i++) {
				maxScore = Math.max(maxScore, score[i][1]);
			}

			System.out.println("#" + testCase + " " + maxScore);
		}
	}
}