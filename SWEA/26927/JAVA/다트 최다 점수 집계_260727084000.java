// SWEA #26927 · 다트 최다 점수 집계
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCyaHYnHBIQj
// Language: JAVA
// Execution Time: 165 ms
// Memory: 32128 KB

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1 ; testCase <= T ; testCase++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            String inputLine = br.readLine();
            for(int i = 0 ; i < N ; i++){
                int input = inputLine.charAt(i) - '0';
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
            
            Map.Entry<Integer, Integer> maxEntry =
            map.entrySet()
            .stream()
            .max(
                Map.Entry.<Integer, Integer>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey())
            )
            .orElse(null);
            
            System.out.println("#"+testCase+" "+maxEntry.getKey()+" " + maxEntry.getValue());
        }
	}
}
