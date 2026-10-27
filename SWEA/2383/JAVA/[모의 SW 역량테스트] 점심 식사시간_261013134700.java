// SWEA #2383 · [모의 SW 역량테스트] 점심 식사시간
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5-BEE6AK0DFAVl
// Solved At: 2026-10-13 13:47:00 KST
// Language: JAVA
// Execution Time: 105 ms
// Memory: 29088 KB

import java.io.*;
import java.util.*;

public class Solution {

    static class Person {
        int r, c;

        Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, P;
    static List<Person> people;
    static Person[] stairs;
    static int[] stairLength;
    static int[][] dist;
    static int[] selected;
    static int minTime;

    static int simulate(int stair) {
        List<Integer> arrivals = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            if (selected[i] == stair) {
                arrivals.add(dist[i][stair]);
            }
        }

        Collections.sort(arrivals);

        int size = arrivals.size();
        if (size == 0) return 0;

        int[] finish = new int[size];
        int K = stairLength[stair];

        for (int i = 0; i < size; i++) {
            int start = arrivals.get(i) + 1;

            if (i >= 3) {
                start = Math.max(start, finish[i - 3]);
            }

            finish[i] = start + K;
        }

        return finish[size - 1];
    }

    static void dfs(int depth) {
        if (depth == P) {
            int timeA = simulate(0);
            int timeB = simulate(1);

            minTime = Math.min(minTime,
                               Math.max(timeA, timeB));
            return;
        }

        selected[depth] = 0;
        dfs(depth + 1);

        selected[depth] = 1;
        dfs(depth + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            people = new ArrayList<>();
            stairs = new Person[2];
            stairLength = new int[2];

            int stairIdx = 0;

            for (int r = 0; r < N; r++) {
                StringTokenizer st =
                    new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    int value = Integer.parseInt(st.nextToken());

                    if (value == 1) {
                        people.add(new Person(r, c));
                    } else if (value > 1) {
                        stairs[stairIdx] = new Person(r, c);
                        stairLength[stairIdx] = value;
                        stairIdx++;
                    }
                }
            }

            P = people.size();
            dist = new int[P][2];
            selected = new int[P];

            for (int i = 0; i < P; i++) {
                Person p = people.get(i);

                for (int j = 0; j < 2; j++) {
                    dist[i][j] =
                        Math.abs(p.r - stairs[j].r)
                        + Math.abs(p.c - stairs[j].c);
                }
            }

            minTime = Integer.MAX_VALUE;
            dfs(0);

            sb.append("#").append(tc).append(" ")
              .append(minTime).append("\n");
        }

        System.out.print(sb);
    }
}