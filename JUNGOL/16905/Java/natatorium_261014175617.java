// JUNGOL #16905 · natatorium
// https://jungol.co.kr/problem/16905
// Solved At: 2026-10-14 17:56:17 KST
// Language: Java
// Execution Time: 683 ms
// Memory: 57.4 MB

import java.io.*;
import java.util.*;

public class Main {
	
	static long[] P;
	
	static boolean isInArray(long p) {
		int left = 0;
		int right = P.length - 1;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(P[mid] == p) {
				return true;
			}else if(P[mid] > p) {
				right = mid-1;
			}else {
				left = mid + 1;
			}
		}
		return false;
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        long C = Long.parseLong(br.readLine());
        int M = Integer.parseInt(br.readLine());
        P = new long[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
        	P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        long p1 = 0;
        long p2 = 0;
        for(int i = 0 ; i < M-1 ; i++) {
        	if(C % P[i] == 0) {
        		p1 = P[i];
        		p2 = C / p1;
        		if(isInArray(p2)) {
        			break;
        		}
        	}
        }
        System.out.println(p1 +" " + p2);
    }
}