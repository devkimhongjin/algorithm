// SWEA #4012 · [모의 SW 역량테스트] 요리사
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
// Language: JAVA
// Execution Time: 151 ms
// Memory: 28992 KB

import java.io.*;
import java.util.*;

class Solution {
	
	static int N;
	static int[][] synergy;
	static int minDiff;
	
	// 두 음식에 들어갈 식재료 번호를 저장
	static List<Integer> firstGroup;
	static List<Integer> secondGroup;
	
	// cur번째 식재료를 첫 번째 음식 또는 두 번째 음식에 배정
	// first : 첫 번째 음식에 선택된 식재료 개수
	// second : 두 번째 음식에 선택된 식재료 개수
	static void dfs(int cur, int first, int second) {
		
		// 한쪽 음식에 N/2개보다 많은 식재료가 들어간 경우 탐색 중단
		if(first > N/2 || second > N/2) {
			return;
		}
		
		// 두 음식에 각각 N/2개의 식재료를 모두 배정한 경우
		if(first == N/2 && second == N/2) {
			int firstTaste = 0;
			int secondTaste = 0;
			
			// 첫 번째 음식의 시너지 합 계산
			// 선택된 두 식재료 i, j에 대해 S[i][j] + S[j][i]를 더함
			for(int i = 0 ; i < N/2 - 1 ; i++) {
				for(int j = i ; j<N/2 ; j++) {
					firstTaste += synergy[firstGroup.get(i)][firstGroup.get(j)]
							+ synergy[firstGroup.get(j)][firstGroup.get(i)];
				}
			}
			
			// 두 번째 음식의 시너지 합 계산
			for(int i = 0 ; i < N/2 - 1 ; i++) {
				for(int j = i ; j<N/2 ; j++) {
					secondTaste += synergy[secondGroup.get(i)][secondGroup.get(j)]
							+ synergy[secondGroup.get(j)][secondGroup.get(i)];
				}
			}
			
			// 두 음식의 맛 차이의 최솟값 갱신
			minDiff = Math.min(minDiff, Math.abs(firstTaste - secondTaste));
		}
		
		// 현재 식재료를 첫 번째 음식에 배정
		firstGroup.add(cur);
		dfs(cur+1, first + 1, second);
		
		// 백트래킹을 위해 현재 식재료 제거
		firstGroup.remove(first);
		
		// 현재 식재료를 두 번째 음식에 배정
		secondGroup.add(cur);
		dfs(cur+1, first, second+1);
		
		// 백트래킹을 위해 현재 식재료 제거
		secondGroup.remove(second);
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#" + tc + " ");
        	
        	// 식재료의 개수
        	N = Integer.parseInt(br.readLine());
        	
        	// 식재료 간 시너지 정보
        	synergy = new int[N][N];
        	
        	// 최소 맛 차이 초기화
        	minDiff = Integer.MAX_VALUE;
        	
        	// 시너지 배열 입력
        	for(int i = 0 ; i < N ; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j = 0 ; j < N ; j++) {
        			synergy[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	firstGroup = new ArrayList<>();
        	secondGroup = new ArrayList<>();
        	
        	// 두 음식의 순서만 바뀐 경우는 동일한 조합이므로
        	// 0번 식재료를 첫 번째 음식에 고정하여 중복 탐색 방지
        	firstGroup.add(0);
        	
        	// 1번 식재료부터 두 그룹 중 하나에 배정
        	dfs(1, 1, 0);
        	
        	// 최소 맛 차이 출력
        	sb.append(minDiff)
        	  .append("\n");
        }
        
        System.out.print(sb);
    }
}