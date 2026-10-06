// JUNGOL #3699 · 변장
// https://jungol.co.kr/problem/3699
// Language: Java
// Execution Time: 172 ms
// Memory: 33.4 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 0 ; tc < T ; tc++){
			Map<String, List<String>> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < N ; i++){
				st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String type = st.nextToken();
				if(!map.containsKey(type)){
					map.put(type, new ArrayList<String>());
				}
				map.get(type).add(item);
			}
			if(map.size() == 1){
				System.out.println(map.values().iterator().next().size());
				continue;
			}
			int multi = 1;
			for (List<String> list : map.values()) {
				int size = list.size();
				multi *= (size+1);
			}

			System.out.println(--multi);
		}
	}
}