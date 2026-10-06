// SWEA #5644 · [모의 SW 역량테스트] 무선 충전
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
// Language: JAVA
// Execution Time: 101 ms
// Memory: 27392 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	final static int BOARD_SIZE = 10;
	
	static Battery[] battery;
	
	static int[] moveA;
	static int[] moveB;
	
	static class Loc{
		int r;
		int c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static class Battery extends Loc{
		
		int C;
		int P;
		
		public Battery(int r, int c, int C, int P) {
			super(r, c);
			this.C = C;
			this.P = P;
		}
		public int getPower(Loc l) {
			if(canCharge(l)) {
				return P;
			}else {
				return 0;
			}
		}
		public boolean canCharge(Loc l) {
			int dist = Math.abs(this.r - l.r) + Math.abs(this.c - l.c);
			return dist <= C;
		}
	}
	
	static Loc locA;
	static Loc locB;
	static int power;
	
	static void move(Loc l, int command) {
		switch(command) {
			case 0:
				return;
			case 1:
				l.r = Math.max(0, l.r-1);
				break;
			case 2:
				l.c = Math.min(BOARD_SIZE -1, l.c+1);
				break;
			case 3:
				l.r = Math.min(BOARD_SIZE -1, l.r+1);
				break;
			case 4:
				l.c = Math.max(0, l.c-1);
				break;
		}
		return;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			moveA = new int[M];
			moveB = new int[M];
			battery = new Battery[A];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int ap = 0 ; ap < A ; ap++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				battery[ap] = new Battery(r-1, c-1, C, P);
				
			}
			
			locA = new Loc(0, 0);
			locB = new Loc(9, 9);
			power = 0;
			int powerA;
			int powerB;
			int T = 0;
			while(T <= M) {	
				int powerSum = 0;
				List<Integer> tempPower = new ArrayList<>();
                powerA = 0;
                powerB = 0;
				for(int i = 0 ; i < A ; i++) {
					if(battery[i].canCharge(locA) && battery[i].canCharge(locB)) {
						powerSum = Math.max(powerSum, battery[i].P);
						tempPower.add(battery[i].P);
						
					}else {
						powerA = Math.max(powerA, battery[i].getPower(locA));
						powerB = Math.max(powerB, battery[i].getPower(locB));
					}
				}
				
				for(int i = 0 ; i < tempPower.size() ; i++) {
					if(powerA < powerB) {
						powerA = Math.max(powerA, tempPower.get(i));
					}else {
						powerB = Math.max(powerB, tempPower.get(i));
					}
				}
				powerSum = Math.max(powerSum, powerA + powerB);
				power += powerSum;
				
				if(T == M) {
					break;
				}

				move(locA, moveA[T]);
				move(locB, moveB[T]);
				T++;
			}
			
			sb.append(power)
			  .append("\n");
			
		}
		System.out.print(sb);
	}
}
