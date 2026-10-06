// SWEA #27022 · 하나 걸러 수확 최대
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c2Z6yFnHBITH
// Language: JAVA
// Execution Time: 93 ms
// Memory: 27008 KB

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#")
                .append(tc)
                .append(" ");
            int N = Integer.parseInt(br.readLine());

            int[] trees = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
            }
            
            
            if(N == 1){
                sb.append(trees[0])
                    .append("\n");
                continue;
            }
            int dp[] = new int[N];
            dp[0] = trees[0];
            dp[1] = Math.max(trees[0], trees[1]);
            
            for(int i = 2 ; i < N ; i++){
                dp[i] = Math.max(dp[i-2] + trees[i], dp[i-1]);
            }
            
            sb.append(dp[N-1])
                    .append("\n");
        }

        System.out.print(sb);
    }
}