// SWEA #4796 · 의석이의 우뚝 선 산
// https://swexpertacademy.com/main/code/problem/problemList.do
// Solved At: 2026-09-10 00:00:00 KST
// Language: Java
// Execution Time: 680 ms
// Memory: 101164 (unit unknown)

// BufferedReader 사용 시 런타임 에러 나오는 문제라 Scanner 사용함. BufferedReader에서 trim으로 잘 처리하면 더 빨리 되긴 할듯
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        // 줄바꿈과 상관없이 정수를 순서대로 입력받기 위해 Scanner 사용
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            // 지형의 개수
            int N = sc.nextInt();

            // 정답
            int answer = 0;

            // 현재 봉우리 기준 왼쪽 오르막 길이
            int left = 0;

            // 현재 봉우리 기준 오른쪽 내리막 길이
            int right = 0;

            // 이전 높이
            int prevH = -1;

            // 현재 오르막 구간인지 여부
            boolean up = true;

            // N개의 높이를 순서대로 확인
            for (int i = 0; i < N; i++) {
                int h = sc.nextInt();

                if (up) {
                    // 이전보다 높으면 오르막 구간 계속 진행
                    if (h > prevH) {
                        left++;
                    } else {
                        // 높이가 낮아지기 시작하면 봉우리를 지나 내리막으로 전환
                        up = false;

                        // 봉우리 자체는 왼쪽 길이에 포함하지 않도록 1 감소
                        left--;

                        // 첫 번째 내리막 구간
                        right++;
                    }
                } else {
                    // 이전보다 낮으면 내리막 구간 계속 진행
                    if (h < prevH) {
                        right++;
                    } else {
                        // 다시 높아지기 시작하면 하나의 산 구간이 끝남
                        up = true;

                        // 왼쪽에서 선택 가능한 위치 수 × 오른쪽에서 선택 가능한 위치 수
                        answer += left * right;

                        // 현재 높이는 새로운 오르막의 두 번째 지점이므로 2부터 시작
                        left = 2;

                        // 새로운 산을 찾기 위해 오른쪽 길이 초기화
                        right = 0;
                    }
                }

                // 현재 높이를 다음 비교를 위한 이전 높이로 저장
                prevH = h;
            }

            // 마지막 구간이 내리막으로 끝난 경우 결과 반영
            answer += left * right;

            sb.append(answer)
              .append("\n");
        }

        System.out.print(sb);

        // Scanner 자원 해제
        sc.close();
    }
}