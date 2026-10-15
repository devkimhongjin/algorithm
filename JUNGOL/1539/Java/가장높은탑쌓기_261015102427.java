// JUNGOL #1539 · 가장높은탑쌓기
// https://jungol.co.kr/problem/1539
// Solved At: 2026-10-15 10:24:27 KST
// Language: Java
// Execution Time: 229 ms
// Memory: 33672 MB


import java.io.*;
import java.util.*;

class Brick implements Comparable<Brick> {
    int width;
    int height;
    int weight;
    int idx;

    public Brick(int width, int height, int weight, int idx) {
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.idx = idx;
    }

    @Override
    public int compareTo(Brick o) {
        return Integer.compare(o.width, this.width);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bricks[i] = new Brick(width, height, weight, i + 1);
        }

        Arrays.sort(bricks);

        int[] dp = new int[N];
        int[] prev = new int[N];
        Arrays.fill(prev, -1);

        int maxHeight = 0;
        int maxIdx = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = bricks[i].height;

            for (int j = 0; j < i; j++) {
                if (bricks[j].weight > bricks[i].weight
                        && dp[i] < dp[j] + bricks[i].height) {

                    dp[i] = dp[j] + bricks[i].height;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxHeight) {
                maxHeight = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        while (maxIdx != -1) {
            result.add(bricks[maxIdx].idx);
            maxIdx = prev[maxIdx];
        }

        System.out.println(result.size());
        for (int idx : result) {
            System.out.println(idx);
        }
    }
}
