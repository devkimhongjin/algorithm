// JUNGOL #1831 · 품평회 행사
// https://jungol.co.kr/problem/1831
// Language: Java
// Execution Time: 307 ms
// Memory: 39.3 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Work {
        int start;
        int end;

        Work(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        Work[] works = new Work[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            works[i] = new Work(start, start + length);
        }

        // 종료 시간이 빠른 순
        // 종료 시간이 같다면 시작 시간이 빠른 순
        Arrays.sort(works, (a, b) -> {
            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });

        int count = 0;
        int lastEnd = 0;

        for (Work work : works) {
            if (work.start >= lastEnd) {
                count++;
                lastEnd = work.end;
            }
        }

        System.out.println(count);
    }
}