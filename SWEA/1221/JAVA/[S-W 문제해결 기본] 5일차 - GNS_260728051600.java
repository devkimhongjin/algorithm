// SWEA #1221 · [S/W 문제해결 기본] 5일차 - GNS
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
// Language: JAVA
// Execution Time: 173 ms
// Memory: 47164 KB

import java.util.*;
import java.io.*;

class Solution {
	
	static HashMap<String, Integer> map;
	static StringBuilder answer;
	
	public static void appendString(String s) {
		if(map.containsKey(s)) {
        	int n = map.get(s);
        	for(int i = 0 ; i < n ; i++) {
        		answer.append(s + " ");
        	}
        }
	}
	
	public static void main(String[] args) throws Exception {
    	        BufferedReader br = new BufferedReader(
    	                new InputStreamReader(System.in)
    	        );

    	        int T = Integer.parseInt(br.readLine());

    	        for (int tc = 1; tc <= T; tc++) {
    	            StringTokenizer st = new StringTokenizer(br.readLine());

    	            String testCaseNumber = st.nextToken();
    	            int N = Integer.parseInt(st.nextToken());

    	            map = new HashMap<>();
    	            st = new StringTokenizer(br.readLine());
    	            for(int i = 0 ; i < N ; i++) {
    	            	String s = st.nextToken();
    	            	map.put(s, map.getOrDefault(s, 0)+1);
    	            }
    	            answer = new StringBuilder();
    	            answer.append(testCaseNumber).append('\n');
    	            
    	            appendString("ZRO");
    	            appendString("ONE");
    	            appendString("TWO");
    	            appendString("THR");
    	            appendString("FOR");
    	            appendString("FIV");
    	            appendString("SIX");
    	            appendString("SVN");
    	            appendString("EGT");
    	            appendString("NIN");

    	            System.out.println(answer);
    	        }
	}
}