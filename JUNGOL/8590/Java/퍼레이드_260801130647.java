// JUNGOL #8590 · 퍼레이드
// https://jungol.co.kr/problem/8590
// Language: Java
// Execution Time: 328 ms
// Memory: 33.9 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int x = 0;
		HashSet<Integer> xSet = new HashSet<>();
		int y = 0;
		HashSet<Integer> ySet = new HashSet<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < D ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			char dircection = st.nextToken().charAt(0);
			int distance = Integer.parseInt(st.nextToken());
			if(dircection == 'N'){
				xSet.add(x);
				y += distance;
			}else if(dircection == 'S'){
				xSet.add(x);
				y -= distance;
			}else if(dircection == 'E'){
				ySet.add(y);
				x += distance;
			}else if(dircection == 'W'){
				ySet.add(y);
				x -= distance;
			}
		}
		System.out.println(xSet.size() + ySet.size());
	}
}