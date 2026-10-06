// JUNGOL #8140 · 에너지 교환
// https://jungol.co.kr/problem/8140
// Language: Java
// Execution Time: 809 ms
// Memory: 57.7 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        char[] command = br.readLine().toCharArray();

        long[] capacity = new long[N];

        st = new StringTokenizer(br.readLine());

        long answer = 0;

        for (int i = 0; i < N; i++) {
            capacity[i] = Long.parseLong(st.nextToken());
            answer += capacity[i];
        }

        // 모든 방향이 같으면 모든 거북이가
        // 매분 1을 주고 1을 받으므로 에너지가 전혀 줄지 않는다.
        int boundary = -1;

        for (int i = 0; i < N; i++) {
            int next = (i + 1) % N;

            if (command[i] == 'R' && command[next] == 'L') {
                boundary = i;
                break;
            }
        }

        if (boundary == -1) {
            System.out.println(answer);
            return;
        }

        /*
         * boundary:
         *
         * R -> L
         * ^    ^
         * i   i+1
         *
         * 여기서 L부터 순회하면
         *
         * LLL... RRR... LLL... RRR...
         *
         * 형태로 모든 run을 편하게 처리할 수 있다.
         */
        int start = (boundary + 1) % N;

        int processed = 0;
        int index = start;

        while (processed < N) {

            char dir = command[index];

            long runSum = 0;

            int first = index;
            int last = index;

            while (processed < N && command[index] == dir) {

                runSum += capacity[index];

                last = index;

                index = (index + 1) % N;
                processed++;
            }

            long movableEnergy;

            if (dir == 'L') {

                /*
                 * L run:
                 *
                 * R ↔ L <- L <- L
                 *
                 * 첫 번째 L은 2-cycle에 포함되므로 제외
                 */
                movableEnergy = runSum - capacity[first];

            } else {

                /*
                 * R run:
                 *
                 * R -> R -> R ↔ L
                 *
                 * 마지막 R은 2-cycle에 포함되므로 제외
                 */
                movableEnergy = runSum - capacity[last];
            }

            answer -= Math.min(M, movableEnergy);
        }

        System.out.println(answer);
    }
}