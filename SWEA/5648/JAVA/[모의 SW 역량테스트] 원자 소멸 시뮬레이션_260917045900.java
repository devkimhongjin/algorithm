// SWEA #5648 · [모의 SW 역량테스트] 원자 소멸 시뮬레이션
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRFInKex8DFAUo
// Language: JAVA
// Execution Time: 176 ms
// Memory: 34616 KB

import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static Atom[] atoms;
	static List<Collision> collisions;
	
	// 0: 상, 1: 하, 2: 좌, 3: 우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Atom {
		int num;
		int x;
		int y;
		int dir;
		int K;
		boolean isCollided;
		
		public Atom(int num, int x, int y, int dir, int K) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.K = K;
			this.isCollided = false;
		}
	}
	
	static class Collision implements Comparable<Collision> {
		int time;	// 충돌 시간
		int x;		// 충돌 위치
		int y;
		Atom a;
		Atom b;
		
		public Collision(int time, int x, int y, Atom a, Atom b) {
			this.time = time;
			this.x = x;
			this.y = y;
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Collision o) {
			// 충돌 시간을 우선으로 정렬
			if(this.time != o.time) {
				return this.time - o.time;
			}
			
			// 같은 시간이라면 같은 위치의 충돌이 붙어 있도록 정렬
			if(this.x != o.x) {
				return this.x - o.x;
			}
			
			return this.y - o.y;
		}
	}
	
	// 두 원자가 충돌한다면 충돌 시간을 반환
	// 충돌하지 않는다면 -1 반환
	static int getCollisionTime(Atom a, Atom b) {
		
		int relativeX = dx[a.dir] - dx[b.dir];
		int relativeY = dy[a.dir] - dy[b.dir];
		
		int distanceX = b.x - a.x;
		int distanceY = b.y - a.y;
		
		int timeX = -1;
		int timeY = -1;
		
		// x축에서 두 원자가 만나는 시간 계산
		if(relativeX == 0) {
			// x축 이동 속도가 같은데 x좌표가 다르면 만날 수 없음
			if(distanceX != 0) {
				return -1;
			}
		}else {
			// 정수 시간에 만날 수 없는 경우
			if(distanceX % relativeX != 0) {
				return -1;
			}
			
			timeX = distanceX / relativeX;
			
			// 이미 지나간 시점에서 만나는 경우
			if(timeX <= 0) {
				return -1;
			}
		}
		
		// y축에서 두 원자가 만나는 시간 계산
		if(relativeY == 0) {
			if(distanceY != 0) {
				return -1;
			}
		}else {
			if(distanceY % relativeY != 0) {
				return -1;
			}
			
			timeY = distanceY / relativeY;
			
			if(timeY <= 0) {
				return -1;
			}
		}
		
		// x축과 y축에서 모두 이동해야 만나는 경우
		// 두 축에서 만나는 시간이 동일해야 실제 충돌
		if(timeX != -1 && timeY != -1) {
			if(timeX != timeY) {
				return -1;
			}
			
			return timeX;
		}
		
		// 한 축의 좌표가 처음부터 같았던 경우
		if(timeX != -1) {
			return timeX;
		}
		
		if(timeY != -1) {
			return timeY;
		}
		
		// 같은 방향으로 이동하는 등 서로 만날 수 없는 경우
		return -1;
	}
	
	// 모든 원자 쌍을 확인해서 충돌 가능성이 있는 이벤트 생성
	static void makeCollision() {
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = i + 1 ; j < N ; j++) {
				
				Atom a = atoms[i];
				Atom b = atoms[j];
				
				int time = getCollisionTime(a, b);
				
				if(time == -1) {
					continue;
				}
				
				// a의 위치를 이용해 충돌 좌표 계산
				int x = a.x + dx[a.dir] * time;
				int y = a.y + dy[a.dir] * time;
				
				collisions.add(
					new Collision(time, x, y, a, b)
				);
			}
		}
	}
	
	// 생성된 충돌 이벤트를 시간 순서대로 처리
	static int processCollision() {
		
		int totalK = 0;
		
		// 시간 -> x -> y 순서 정렬
		Collections.sort(collisions);
		
		int idx = 0;
		
		while(idx < collisions.size()) {
			
			Collision cur = collisions.get(idx);
			
			int time = cur.time;
			int x = cur.x;
			int y = cur.y;
			
			// 같은 시간, 같은 위치에서 만나는 원자를 하나의 집합으로 처리
			Set<Atom> collisionAtoms = new HashSet<>();
			
			int next = idx;
			
			while(next < collisions.size()) {
				Collision collision = collisions.get(next);
				
				// 다른 시간 또는 다른 위치라면 현재 충돌 그룹 종료
				if(collision.time != time ||
				   collision.x != x ||
				   collision.y != y) {
					break;
				}
				
				collisionAtoms.add(collision.a);
				collisionAtoms.add(collision.b);
				
				next++;
			}
			
			// 이미 이전 시간에 충돌해서 사라진 원자는 제외
			List<Atom> aliveAtoms = new ArrayList<>();
			
			for(Atom atom : collisionAtoms) {
				if(!atom.isCollided) {
					aliveAtoms.add(atom);
				}
			}
			
			// 현재 시점에 살아있는 원자가 2개 이상이라면 실제 충돌
			if(aliveAtoms.size() >= 2) {
				
				for(Atom atom : aliveAtoms) {
					atom.isCollided = true;
					totalK += atom.K;
				}
			}
			
			idx = next;
		}
		
		return totalK;
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			atoms = new Atom[N];
			collisions = new ArrayList<>();
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				
				// 0.5초 단위 충돌을 정수로 처리하기 위해 좌표를 2배
				int x = Integer.parseInt(st.nextToken()) * 2;
				int y = Integer.parseInt(st.nextToken()) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				
				atoms[i] = new Atom(i, x, y, dir, K);
			}
			
			// 모든 원자 쌍에서 충돌 후보 생성
			makeCollision();
			
			// 충돌을 시간순으로 처리
			int answer = processCollision();
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}