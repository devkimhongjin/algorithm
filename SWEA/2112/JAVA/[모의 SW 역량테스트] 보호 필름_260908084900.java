// SWEA #2112 · [모의 SW 역량테스트] 보호 필름
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
// Language: JAVA
// Execution Time: 3031 ms
// Memory: 116052 KB

import java.io.*;
import java.util.*;

class Solution {

	static int D;
	static int W;
	static int K;
	static int[][] film;

	// -1 : 약품 미투입
	//  0 : A 약품 투입
	//  1 : B 약품 투입
	static int[] visited;

	// 현재까지 찾은 최소 약품 투입 횟수
	static int minDepth;


	/*
	 * 모든 열이 성능 검사 조건을 만족하는지 확인
	 *
	 * 각 열마다 같은 값이 K개 이상 연속되는 구간이
	 * 하나 이상 존재해야 통과한다.
	 */
	static boolean isValid(int[][] film) {

		// K가 1이면 모든 필름이 무조건 통과
		if(K == 1) {
			return true;
		}

		for(int i = 0 ; i < W ; i++) {

			int b = film[0][i];
			int streak = 1;
			boolean validCol = false;

			for(int j = 1 ; j < D ; j++) {

				if(film[j][i] == b) {
					streak++;
				}else {
					streak = 1;
					b = film[j][i];
				}

				// K개 이상 연속되면 해당 열은 통과
				if(streak >= K) {
					validCol = true;
					break;
				}

				/*
				 * 현재 연속 개수에 남은 모든 행을 더해도
				 * K에 도달할 수 없으면 더 볼 필요 없음
				 */
				if(streak + (D - 1 - j) < K) {
					break;
				}
			}

			// 하나의 열이라도 조건을 만족하지 못하면 실패
			if(!validCol) {
				return false;
			}
		}

		return true;
	}


	/*
	 * visited에 기록된 약품 투입 상태를
	 * 원본 필름의 복사본에 적용한 뒤 검사한다.
	 */
	static boolean checkFilm() {

		int[][] newFilm = new int[D][W];

		for(int i = 0 ; i < D ; i++) {

			// 2차원 배열이므로 각 행을 따로 복사
			newFilm[i] = film[i].clone();

			// 약품이 투입된 행이면 전체 값을 변경
			if(visited[i] != -1) {
				Arrays.fill(newFilm[i], visited[i]);
			}
		}

		return isValid(newFilm);
	}


	/*
	 * 약품을 투입할 행을 조합으로 선택
	 *
	 * start : 다음에 선택할 수 있는 행의 시작 위치
	 * depth : 현재까지 약품을 투입한 횟수
	 *
	 * start를 사용하기 때문에
	 *
	 * 0 -> 3
	 * 3 -> 0
	 *
	 * 처럼 같은 조합을 순서만 바꿔서
	 * 중복 탐색하지 않는다.
	 */
	static void dfs(int start, int depth) {

		/*
		 * 현재 투입 횟수가 이미 찾은 최소값 이상이면
		 * 더 깊게 탐색할 필요 없음
		 */
		if(depth >= minDepth) {
			return;
		}

		/*
		 * 약품을 1개 이상 투입한 경우부터 검사
		 */
		if(depth >= 1) {

			if(checkFilm()) {
				minDepth = depth;
				return;
			}
		}

		/*
		 * i번째 행을 선택하면
		 * 다음에는 i + 1 이후의 행만 선택한다.
		 *
		 * 따라서 순열이 아니라 조합으로 탐색한다.
		 */
		for(int i = start ; i < D ; i++) {

			// i번째 행에 A 약품 투입
			visited[i] = 0;
			dfs(i + 1, depth + 1);


			// i번째 행에 B 약품 투입
			visited[i] = 1;
			dfs(i + 1, depth + 1);


			// 백트래킹
			visited[i] = -1;
		}
	}


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int tc = 1 ; tc <= T ; tc++) {

			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];

			// 필름 입력
			for(int i = 0 ; i < D ; i++) {

				st = new StringTokenizer(br.readLine());

				for(int j = 0 ; j < W ; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}


			/*
			 * 약품을 넣지 않아도 이미 통과하면 정답은 0
			 */
			if(isValid(film)) {
				sb.append(0)
				  .append("\n");
				continue;
			}


			// 모든 행을 약품 미투입 상태로 초기화
			visited = new int[D];
			Arrays.fill(visited, -1);

			// 최악의 경우 모든 행에 약품을 넣는다고 가정
			minDepth = D;


			/*
			 * DFS 한 번으로 모든 조합 탐색
			 *
			 * minDepth가 갱신될수록
			 * 그 이상의 깊이는 자동으로 가지치기된다.
			 */
			dfs(0, 0);


			sb.append(minDepth)
			  .append("\n");
		}

		System.out.print(sb);
	}
}