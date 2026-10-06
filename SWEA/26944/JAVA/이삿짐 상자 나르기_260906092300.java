// SWEA #26944 · 이삿짐 상자 나르기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpH8aHc3HBIQj
// Language: JAVA
// Execution Time: 88 ms
// Memory: 27008 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	
        	StringTokenizer st =
                    new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int[] boxes = new int[N];
        	int M = Integer.parseInt(st.nextToken());
        	int[] workers = new int[M];
        	
        	st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) {
            	boxes[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(boxes);
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < M ; i++) {
            	workers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(workers);
            
            int sum = 0;
            int boxIndex = N-1;
            int workerIndex = M-1;
            while(boxIndex >= 0 && workerIndex >= 0) {
            	if(workers[workerIndex] >= boxes[boxIndex]) {
            		sum += boxes[boxIndex];
            		workerIndex--;
            	}
            	boxIndex--;
            }
            
            
            sb.append(sum)
              .append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}