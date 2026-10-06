// SWEA #27022 · 하나 걸러 수확 최대
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ87c2Z6yFnHBITH
// Language: JAVA
// Execution Time: 86 ms
// Memory: 26624 KB

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            if(N == 1){
                sb.append(Integer.parseInt(st.nextToken()))
                    .append("\n");
                continue;
            }
            int dp[] = new int[N];

            for (int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());
                if(i == 0){
                    dp[0] = input;
                }else if(i == 1){
                     dp[1] = Math.max(dp[0], input);
                }else{
                    dp[i] = Math.max(dp[i-2] + input, dp[i-1]);
                }
            }
            
            sb.append(dp[N-1])
                    .append("\n");
        }

        System.out.print(sb);
    }
}