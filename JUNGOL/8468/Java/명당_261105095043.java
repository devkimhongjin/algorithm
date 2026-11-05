// JUNGOL #8468 · 명당
// https://jungol.co.kr/problem/8468
// Solved At: 2026-11-05 09:50:43 KST
// Language: Java
// Execution Time: 982 ms
// Memory: 58220 KiB


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int answer = 0;

        for (int right = 0; right < N; right++) {
            while (!maxDeque.isEmpty() &&
                   heights[maxDeque.peekLast()] <= heights[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() &&
                   heights[minDeque.peekLast()] >= heights[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (heights[maxDeque.peekFirst()]
                   - heights[minDeque.peekFirst()] > K) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
    }
}
