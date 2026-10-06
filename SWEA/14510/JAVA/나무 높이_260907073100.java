// SWEA #14510 · 나무 높이
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AYFofW8qpXYDFAR4
// Language: JAVA
// Execution Time: 86 ms
// Memory: 26368 KB

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

            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int maxHeight = 0;

            // 나무 높이 입력 및 최대 높이 탐색
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            // 홀수 날(+1)에 필요한 작업 횟수
            int one = 0;

            // 짝수 날(+2)에 필요한 작업 횟수
            int two = 0;

            // 각 나무가 최대 높이에 도달하기 위해 필요한 작업 계산
            for (int height : trees) {
                int diff = maxHeight - height;

                one += diff % 2;
                two += diff / 2;
            }

            int answer;

            if (one > two) {
                // +1 작업이 많으면 홀수 날을 기다려야 하므로
                // 마지막 작업 이후의 불필요한 하루를 제외
                answer = one * 2 - 1;

            } else if (one == two) {
                // +1, +2 작업을 번갈아 쉬지 않고 처리 가능
                answer = one + two;

            } else {
                // +2 작업 일부를 +1 작업 두 번으로 바꾸어
                // 홀수 날과 짝수 날 작업의 균형을 맞춤
                answer = one + two + (int) Math.ceil((two - one) / 3.0);
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}