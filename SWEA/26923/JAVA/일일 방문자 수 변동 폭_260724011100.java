// SWEA #26923 · 일일 방문자 수 변동 폭
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6woi46HXnHBIQj
// Language: JAVA
// Execution Time: 118 ms
// Memory: 31616 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());

                min = Math.min(min, value);
                max = Math.max(max, value);
            }

            int answer = max - min;

            System.out.println("#" + testCase + " " + answer);
        }
    }
}