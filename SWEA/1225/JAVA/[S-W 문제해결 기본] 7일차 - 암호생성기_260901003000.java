// SWEA #1225 · [S/W 문제해결 기본] 7일차 - 암호생성기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
// Language: JAVA
// Execution Time: 75 ms
// Memory: 24832 KB

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

				// 테스트 케이스는 총 10개로 고정
				final int T = 10;
				
				for(int test_case = 1 ; test_case <= T ; test_case++) {
						sb.append("#")
							.append(test_case)
							.append(" ");
						
						// 입력으로 주어지는 테스트 케이스 번호는 사용하지 않음
						br.readLine();
						
						// 초기 암호를 구성하는 8개의 숫자 입력
						StringTokenizer st = new StringTokenizer(br.readLine());
						
						int[] numbers = new int[8];
						int min = Integer.MAX_VALUE;

						for(int i = 0; i < 8; i++) {
								numbers[i] = Integer.parseInt(st.nextToken());
    						min = Math.min(min, numbers[i]);
						}

						// 40번의 연산 = 모든 원소에서 15씩 감소
						int subtractValue = ((min - 1) / 15) * 15;

						// 맨 앞의 값을 꺼내고 맨 뒤에 다시 넣는 작업을 반복하므로 Deque 사용
						Deque<Integer> queue = new ArrayDeque<>();

						for(int number : numbers) {
								queue.offer(number - subtractValue);
						}
						
						// 가장 최근에 감소시킨 값
						// 0이 만들어지면 암호 생성 종료
						int pop = -1;
						
						// 현재 숫자에서 뺄 값
						int dec = 1;
						
						while(pop != 0) {
								// 큐의 맨 앞 숫자를 꺼냄
								pop = queue.poll();
								
								// 현재 감소값만큼 빼되, 결과가 음수라면 0으로 처리
								pop = Math.max(0, pop - dec);
								
								// 감소시킨 값을 큐의 맨 뒤에 삽입
								queue.offer(pop);
								
								// 감소값을 1~5 범위에서 순환
								dec = dec % 5 + 1;
						}
						
						// 완성된 8자리 암호 출력
						while(!queue.isEmpty()) {
								sb.append(queue.poll())
									.append(" ");
						}
						
						sb.append("\n");
				}
				
				System.out.print(sb);
	}

}
