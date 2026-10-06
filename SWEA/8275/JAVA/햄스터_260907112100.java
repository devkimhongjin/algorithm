// SWEA #8275 · 햄스터
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWxQ310aOlQDFAWL
// Language: JAVA
// Execution Time: 480 ms
// Memory: 27648 KB

import java.io.*;
import java.util.*;

class Solution {

    static int N;            // 우리 개수
    static int X;            // 한 우리에 들어갈 수 있는 최대 햄스터 수
    static int M;            // 기록의 개수

    static Condition[] conditions;

    static int[] hamsters;   // 최종 정답
    static int maxHamster;   // 가장 많은 햄스터 수


    // 하나의 기록 조건
    static class Condition {
        int l;  // 시작 우리 번호
        int r;  // 끝 우리 번호
        int s;  // l ~ r 우리에 존재하는 햄스터 수

        public Condition(int l, int r, int s) {
            this.l = l;
            this.r = r;
            this.s = s;
        }

        // 현재 햄스터 배치가 조건을 만족하는지 확인
        boolean matchCondition(int[] comb) {
            int sum = 0;

            // 문제의 우리 번호는 1부터 시작하므로 배열에서는 i - 1 사용
            // l ~ r 범위를 모두 포함해야 하므로 <= r
            for (int i = l; i <= r; i++) {
                sum += comb[i - 1];

                // 이미 필요한 햄스터 수를 초과하면 더 확인할 필요 없음
                if (sum > s) {
                    return false;
                }
            }

            return sum == s;
        }
    }


    // 모든 햄스터 배치를 완전탐색
    static void makeComb(int index, int[] comb) {

        // 모든 우리에 햄스터 수를 정한 경우
        if (index == N) {

            // 모든 기록 조건을 만족하는지 확인
            for (int i = 0; i < M; i++) {
                if (!conditions[i].matchCondition(comb)) {
                    return;
                }
            }

            // 현재 배치의 전체 햄스터 수 계산
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += comb[i];
            }

            // 지금까지 찾은 경우보다 햄스터 수가 많으면 정답 갱신
            if (sum > maxHamster) {
                maxHamster = sum;
                hamsters = comb.clone();
            }

            return;
        }

        // 현재 우리에 0 ~ X마리까지 배치
        for (int i = 0; i <= X; i++) {
            comb[index] = i;
            makeComb(index + 1, comb);
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 기록 입력
            conditions = new Condition[M];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                conditions[i] = new Condition(l, r, s);
            }

            hamsters = new int[N];

            // -1이면 아직 조건을 만족하는 배치를 찾지 못했다는 의미
            maxHamster = -1;

            // 가능한 모든 햄스터 배치 탐색
            makeComb(0, new int[N]);

            // 가능한 배치가 없는 경우
            if (maxHamster == -1) {
                sb.append(-1);
            } else {
                // 가장 많은 햄스터를 배치할 수 있는 경우 출력
                for (int i = 0; i < N; i++) {
                    sb.append(hamsters[i]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}