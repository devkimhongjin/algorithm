// JUNGOL #1067 · 종이자르기
// https://jungol.co.kr/problem/1067
// Solved At: 2026-10-15 09:27:05 KST
// Language: Java
// Execution Time: 217 ms
// Memory: 33 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());

		List<Integer> cut_h = new ArrayList<>();
		List<Integer> cut_v = new ArrayList<>();
		for(int i = 0 ; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if(dir == 0)
				cut_h.add(idx);
			else
				cut_v.add(idx);
		}
		Collections.sort(cut_h);
		Collections.sort(cut_v);
		
		int maxH;
		if(cut_h.size() == 0){
			maxH = H;
		}else{
			maxH = cut_h.get(0);
			cut_h.add(H);
			for(int i = 1 ; i < cut_h.size() ; i++){
				maxH = Math.max(maxH, cut_h.get(i) - cut_h.get(i-1));
			}
		}

		int maxW;
		if(cut_v.size() == 0){
			maxW = W;
		}else{
			maxW = cut_v.get(0);
			cut_v.add(W);
			for(int i = 1 ; i < cut_v.size() ; i++){
				maxW = Math.max(maxW, cut_v.get(i) - cut_v.get(i-1));
			}
		}
		
		System.out.println(maxW * maxH);
	}
}