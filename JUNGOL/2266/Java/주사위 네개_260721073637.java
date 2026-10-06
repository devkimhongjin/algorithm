// JUNGOL #2266 · 주사위 네개
// https://jungol.co.kr/problem/2266
// Language: Java
// Execution Time: 323 ms
// Memory: 35.9 MB

import java.io.*;
import java.util.*;

public class Main {

    static int calcPrize(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int kindCount = countMap.size();

        // 모두 같은 경우
        if (kindCount == 1) {
            int number = nums[0];
            return 50000 + number * 5000;
        }

        // 3개 + 1개 또는 2개 + 2개
        if (kindCount == 2) {
            int pairSum = 0;

            for (int number : countMap.keySet()) {
                int count = countMap.get(number);

                if (count == 3) {
                    return 10000 + number * 1000;
                }

                if (count == 2) {
                    pairSum += number;
                }
            }

            return 2000 + pairSum * 500;
        }

        // 2개 + 1개 + 1개
        if (kindCount == 3) {
            for (int number : countMap.keySet()) {
                if (countMap.get(number) == 2) {
                    return 1000 + number * 100;
                }
            }
        }

        // 모두 다른 경우
        return Collections.max(countMap.keySet()) * 100;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine());
        int maxPrize = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] dices = new int[4];

            for (int j = 0; j < 4; j++) {
                dices[j] = Integer.parseInt(st.nextToken());
            }

            maxPrize = Math.max(maxPrize, calcPrize(dices));
        }

        System.out.println(maxPrize);
    }
}