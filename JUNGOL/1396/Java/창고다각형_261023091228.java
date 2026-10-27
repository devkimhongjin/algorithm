// JUNGOL #1396 · 창고다각형
// https://jungol.co.kr/problem/1396
// Solved At: 2026-10-23 09:12:28 KST
// Language: Java
// Execution Time: 264 ms
// Memory: 33.6 MB

import java.io.*;
import java.util.*;

class Stick implements Comparable<Stick> {
	int l;
	int h;
	public Stick(int l, int h) {
		this.l = l;
		this.h = h;
	}
	@Override
	public int compareTo(Stick o) {
		return Integer.compare(this.l, o.l);
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Stick[] sticks = new Stick[N];
		int maxH = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, H);
			sticks[i] = new Stick(L, H);
		}
		Arrays.sort(sticks);

		// 가장 높은 기둥 중 가장 왼쪽 / 가장 오른쪽 인덱스
		int left = 0, right = N - 1;
		while (sticks[left].h != maxH) left++;
		while (sticks[right].h != maxH) right--;

		int area = 0;

		// 왼쪽: 처음 ~ left 까지, 구간마다 지금까지의 최대 높이 적용
		int curH = 0;
		for (int i = 0; i < left; i++) {
			curH = Math.max(curH, sticks[i].h);
			area += curH * (sticks[i + 1].l - sticks[i].l);
		}

		// 오른쪽: 끝 ~ right 까지, 구간마다 오른쪽에서의 최대 높이 적용
		curH = 0;
		for (int i = N - 1; i > right; i--) {
			curH = Math.max(curH, sticks[i].h);
			area += curH * (sticks[i].l - sticks[i - 1].l);
		}

		// 가장 높은 기둥 구간 (+1 은 기둥 자체의 너비)
		area += maxH * (sticks[right].l - sticks[left].l + 1);

		System.out.println(area);
	}
}