// SWEA #9229 · 한빈이와 Spot Mart
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
// Language: JAVA
// Execution Time: 139 ms
// Memory: 30080 KB

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
			
			// 과자의 개수 N, 허용 가능한 최대 무게 M 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 각 과자의 무게 입력
			int[] weights = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			// 투 포인터 탐색을 위해 무게를 오름차순 정렬
			Arrays.sort(weights);
			
			// 가장 가벼운 두 물건의 합도 M을 초과하면
			// 조건을 만족하는 두 물건을 선택할 수 없음
			if(weights[0] + weights[1] > M) {
				sb.append(-1)
				  .append("\n");
				continue;
			}
			
			// M 이하인 두 물건 무게 합의 최댓값
			int answer = -1;
			
			// 양 끝에서 시작하는 투 포인터
			int left = 0;
			int right = N-1;
			
			// 정확히 M인 조합을 찾았는지 여부
			boolean maxFound = false;
			
			while(left < right) {
				
				// 현재 두 포인터가 가리키는 물건의 무게
				int leftWeight = weights[left];
				int rightWeight = weights[right];
				
				// 두 물건의 무게 합
				int weight = leftWeight + rightWeight;
				
				// 합이 정확히 M이면 가능한 최댓값이므로 탐색 종료
				if(weight == M) {
					sb.append(weight)
					  .append("\n");
					maxFound = true;
					break;
					
				// 합이 M보다 작으면 현재 값을 최댓값 후보로 저장
				}else if(weight < M) {
					answer = Math.max(answer, weight);
					
				// 합이 M보다 크면 큰 무게를 줄이기 위해 right 이동
				}else {
					right--;
					continue;
				}
				
				// 현재 right의 물건 하나만으로도 M보다 크다면
				// 더 작은 물건을 사용하도록 right 이동
				if(rightWeight > M) {
					right--;
				}else {
					// 현재 합이 M보다 작으므로
					// 더 큰 합을 만들기 위해 left 이동
					left++;
				}
			}
			
			// 정확히 M인 값을 찾지 못했다면
			// M 이하에서 찾은 최대 무게 합 출력
			if(!maxFound) {
				sb.append(answer)
				  .append("\n");
			}
			
		}
		
		// 전체 테스트 케이스 결과 출력
		System.out.print(sb);
	}
}