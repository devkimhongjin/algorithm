// SWEA #1221 · [S/W 문제해결 기본] 5일차 - GNS
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
// Language: JAVA
// Execution Time: 146 ms
// Memory: 39460 KB

import java.io.*;
import java.util.*;

class Solution {

    static final String[] NUMBERS = {
        "ZRO", "ONE", "TWO", "THR", "FOR",
        "FIV", "SIX", "SVN", "EGT", "NIN"
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String testCaseNumber = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            int[] count = new int[10];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                String number = st.nextToken();

                switch (number) {
                    case "ZRO":
                        count[0]++;
                        break;
                    case "ONE":
                        count[1]++;
                        break;
                    case "TWO":
                        count[2]++;
                        break;
                    case "THR":
                        count[3]++;
                        break;
                    case "FOR":
                        count[4]++;
                        break;
                    case "FIV":
                        count[5]++;
                        break;
                    case "SIX":
                        count[6]++;
                        break;
                    case "SVN":
                        count[7]++;
                        break;
                    case "EGT":
                        count[8]++;
                        break;
                    case "NIN":
                        count[9]++;
                        break;
                }
            }

            result.append(testCaseNumber).append('\n');

            for (int i = 0; i < NUMBERS.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    result.append(NUMBERS[i]).append(' ');
                }
            }

            result.append('\n');
        }

        System.out.print(result);
    }
}