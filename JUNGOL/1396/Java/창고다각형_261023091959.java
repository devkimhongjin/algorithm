// JUNGOL #1396 · 창고다각형
// https://jungol.co.kr/problem/1396
// Solved At: 2026-10-23 09:19:59 KST
// Language: Java
// Execution Time: 307 ms
// Memory: 33.7 MB

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

		int left = 0, right = N - 1;
		while (sticks[left].h != maxH) left++;
		while (sticks[right].h != maxH) right--;

		int area = 0;

		int curH = 0;
		for (int i = 0; i < left; i++) {
			curH = Math.max(curH, sticks[i].h);
			area += curH * (sticks[i + 1].l - sticks[i].l);
		}

		curH = 0;
		for (int i = N - 1; i > right; i--) {
			curH = Math.max(curH, sticks[i].h);
			area += curH * (sticks[i].l - sticks[i - 1].l);
		}

		area += maxH * (sticks[right].l - sticks[left].l + 1);

		System.out.println(area);
	}
}