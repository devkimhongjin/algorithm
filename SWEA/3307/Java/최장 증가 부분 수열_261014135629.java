// SWEA #3307 · 최장 증가 부분 수열
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
// Solved At: 2026-10-14 13:56:29 KST
// Language: Java
// Execution Time: 134 ms
// Memory: 34988 KB


import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] lis = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            int maxLength = 1;
            for(int i = 0 ; i < N ; i++) {
            	lis[i] = 1;
            	for(int j = 0 ; j < i ; j++) {
            		if(arr[j] < arr[i] && lis[i] < lis[j]+1) {
            			lis[i] = lis[j] + 1;
            		}
            	}
            	maxLength = Math.max(maxLength, lis[i]);
            }
            sb.append("#")
              .append(tc)
              .append(" ")
              .append(maxLength)
              .append("\n");
        }

        System.out.print(sb);
    }
}
