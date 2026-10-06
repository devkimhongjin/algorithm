// SWEA #9229 · 한빈이와 Spot Mart
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
// Language: JAVA
// Execution Time: 115 ms
// Memory: 31076 KB

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] weights = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weights);
			
			
			if(weights[0] + weights[1] > M) {
				sb.append(-1)
				  .append("\n");
				continue;
			}
			int answer = -1;
			int left = 0;
			int right = N-1;
			boolean maxFound = false;
			
			while(left < right) {
				int leftWeight = weights[left];
				int rightWeight = weights[right];
				
				int weight = leftWeight + rightWeight;
				if(weight == M) {
					sb.append(weight)
					  .append("\n");
					maxFound = true;
					break;
				}else if(weight < M) {
					answer = Math.max(answer, weight);
				}else {
					right--;
					continue;
				}
				if(weights[right] > M) {
					right--;
				}else {
					left++;
				}
				
			}
			if(!maxFound) {
				sb.append(answer)
				  .append("\n");
			}
			
		}
		System.out.print(sb);
	}
}