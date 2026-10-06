// JUNGOL #4577 · 책 정리 로봇
// https://jungol.co.kr/problem/4577
// Language: Java
// Execution Time: 1554 ms
// Memory: 105.9 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Book {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        public void update(int n) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Book> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (!map.containsKey(input)) {
                map.put(input, new Book());
            }

            map.get(input).update(i);
        }

		Map<Integer, Book> sortedMap = new TreeMap<>(map);

        int prevLeft = 1;
        int prevRight = 1;

        long leftCost = 0;
        long rightCost = 0;

        for (Book book : sortedMap.values()) {

            int left = book.min;
            int right = book.max;

            long width = right - left;

            long nextLeft = Math.min(
                leftCost + Math.abs((long) prevLeft - right) + width,
                rightCost + Math.abs((long) prevRight - right) + width
            );

            long nextRight = Math.min(
                leftCost + Math.abs((long) prevLeft - left) + width,
                rightCost + Math.abs((long) prevRight - left) + width
            );

            leftCost = nextLeft;
            rightCost = nextRight;

            prevLeft = left;
            prevRight = right;
        }

        System.out.println(Math.min(leftCost, rightCost));
    }
}