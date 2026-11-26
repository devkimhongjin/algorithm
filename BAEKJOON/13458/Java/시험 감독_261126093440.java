// BAEKJOON #13458 · 시험 감독
// https://acmicpc.net/problem/13458
// Solved At: 2026-11-26 09:34:40 KST
// Language: Java
// Execution Time: 424 ms
// Memory: 94400 KB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long answer = N;
        for(int i = 0 ; i < N ; i++) {
        	A[i] = Math.max(A[i] - B, 0);
        	if(A[i]>0) {
        		if(A[i] <= C) {
        			answer++;
        		}else {
        			answer += A[i]/C + (A[i]%C==0?0:1);
        		}
        	}
        }
        System.out.println(answer);
        
    }
}
