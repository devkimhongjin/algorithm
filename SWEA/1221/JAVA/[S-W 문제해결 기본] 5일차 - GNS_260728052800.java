// SWEA #1221 · [S/W 문제해결 기본] 5일차 - GNS
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
// Language: JAVA
// Execution Time: 164 ms
// Memory: 46780 KB

import java.util.*;
import java.io.*;

class Solution {
	
	static int[] count;
	static StringBuilder answer;
	
	public static void appendString(int n, String S) {
		for(int i = 0 ; i < count[n] ; i++) {
    		answer.append(S + " ");
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

    	            count = new int[10];
    	            st = new StringTokenizer(br.readLine());
    	            for(int i = 0 ; i < N ; i++) {
    	            	String s = st.nextToken();
    	            	switch(s) {
	    	            	case("ZRO"):{
	    	            		count[0]++;
                                break;
	    	            	}
	    	            	case("ONE"):{
	    	            		count[1]++;
                                break;
	    	            	}
	    	            	case("TWO"):{
	    	            		count[2]++;
                                break;
	    	            	}
	    	            	case("THR"):{
	    	            		count[3]++;
                                break;
	    	            	}
	    	            	case("FOR"):{
	    	            		count[4]++;
                                break;
	    	            	}
	    	            	case("FIV"):{
	    	            		count[5]++;
                                break;
	    	            	}
	    	            	case("SIX"):{
	    	            		count[6]++;
                                break;
	    	            	}
	    	            	case("SVN"):{
	    	            		count[7]++;
                                break;
	    	            	}	
	    	            	case("EGT"):{
	    	            		count[8]++;
                                break;
	    	            	}
	    	            	case("NIN"):{
	    	            		count[9]++;
                                break;
	    	            	}
    	            	}
    	            }
    	            answer = new StringBuilder();
    	            answer.append(testCaseNumber).append('\n');
    	            
    	            appendString(0, "ZRO");
    	            appendString(1, "ONE");
    	            appendString(2, "TWO");
    	            appendString(3, "THR");
    	            appendString(4, "FOR");
    	            appendString(5, "FIV");
    	            appendString(6, "SIX");
    	            appendString(7, "SVN");
    	            appendString(8, "EGT");
    	            appendString(9, "NIN");

    	            System.out.println(answer);
    	        }
	}
}