// JUNGOL #8040 · 소 주사위
// https://jungol.co.kr/problem/8040
// Language: Java
// Execution Time: 299 ms
// Memory: 33.8 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		int s3 = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 1 ; i <= s1 ; i++){
			for(int j = 1 ; j <= s2 ; j++){
				for(int k = 1 ; k <= s3 ; k++){
					int sum = i + j + k;
            		map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
		}
		int answer = 0;
		int maxCount = Integer.MIN_VALUE;
		for (int key : map.keySet()) {
			int value = map.get(key);

			if (value > maxCount || (value == maxCount && key < answer)) {
				maxCount = value;
				answer = key;
			}
		}

		System.out.println(answer);
	}
}