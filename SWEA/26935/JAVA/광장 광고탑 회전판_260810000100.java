// SWEA #26935 · 광장 광고탑 회전판
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpFLaHanHBIQj
// Language: JAVA
// Execution Time: 74 ms
// Memory: 25472 KB

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int index = M % N;
			
			System.out.println("#" + tc + " " + br.readLine().split(" ")[index]);
		}
	}
}