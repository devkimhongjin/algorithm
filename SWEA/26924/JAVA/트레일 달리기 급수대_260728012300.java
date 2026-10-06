// SWEA #26924 · 트레일 달리기 급수대
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wowZKHX3HBIQj
// Language: JAVA
// Execution Time: 79 ms
// Memory: 25344 KB

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] waters = new int[M + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                waters[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(waters, 0, M);
            waters[M] = N;

            int count = 0;
            int reachablePos = K;
            int lastWaterPos = 0;

            for (int currentPos : waters) {
                if (currentPos > reachablePos) {
                    reachablePos = lastWaterPos + K;
                    if (currentPos > reachablePos) {
                        count = 0;
                        break;
                    }
                    count++;
                }
                lastWaterPos = currentPos;
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}