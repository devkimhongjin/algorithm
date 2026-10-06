// SWEA #5648 · [모의 SW 역량테스트] 원자 소멸 시뮬레이션
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
// Language: JAVA
// Execution Time: 2368 ms
// Memory: 142832 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static final int GRID_SIZE = 2001;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Atom {
		int r;
		int c;
		int dir;
		int K;
		
		public Atom(int r, int c, int dir, int k) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			K = k;
		}
		
		public void move() {
			r = r + dr[dir];
			c = c + dc[dir];
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			int total_K = 0;
			int N = Integer.parseInt(br.readLine());
			
			List<Atom> atoms = new ArrayList<>();
			boolean[][] exist = new boolean[GRID_SIZE * 2][GRID_SIZE * 2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken()) + GRID_SIZE / 2;
				int r = Integer.parseInt(st.nextToken()) + GRID_SIZE / 2;
				int dir = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				
				atoms.add(new Atom(r * 2, c * 2, dir, K));
				exist[r * 2][c * 2] = true;
			}
			
			for (int i = 0; i < GRID_SIZE * 2; i++) {
				
				if (atoms.isEmpty()) {
					break;
				}
				
				// 모든 원자의 기존 위치를 먼저 제거
				for (Atom atom : atoms) {
					exist[atom.r][atom.c] = false;
				}
				
				List<int[]> collisionPoint = new ArrayList<>();
				
				for (int j = 0; j < atoms.size();) {
					
					Atom cur = atoms.get(j);
					
					// 기존 위치 제거는 위에서 이미 전부 처리
					cur.move();
					
					// 범위를 벗어난 원자 제거
					if (cur.r < 0 || cur.r >= GRID_SIZE * 2 ||
						cur.c < 0 || cur.c >= GRID_SIZE * 2) {
						
						atoms.remove(j);
						continue;
					}
					
					// 아직 아무 원자도 도착하지 않은 위치
					if (!exist[cur.r][cur.c]) {
						exist[cur.r][cur.c] = true;
						j++;
					}
					// 이미 다른 원자가 도착한 위치 -> 충돌
					else {
						collisionPoint.add(new int[] {cur.r, cur.c});
						total_K += cur.K;
						atoms.remove(j);
					}
				}
				
				// 충돌 위치에 가장 먼저 도착했던 원자 제거
				if (!collisionPoint.isEmpty()) {
					for (int[] point : collisionPoint) {
						
						for (int j = 0; j < atoms.size(); j++) {
							Atom atom = atoms.get(j);
							
							if (atom.r == point[0] && atom.c == point[1]) {
								total_K += atom.K;
								atoms.remove(j);
								break;
							}
						}
						
						exist[point[0]][point[1]] = false;
					}
				}
			}
			
			sb.append(total_K)
			  .append("\n");
		}
		
		System.out.print(sb);
	}
}