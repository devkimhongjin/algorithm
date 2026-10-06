// JUNGOL #3786 · Cows in a Row
// https://jungol.co.kr/problem/3786
// Language: Java
// Execution Time: 337 ms
// Memory: 33.9 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());

        int[] cows = new int[N];
        Set<Integer> breeds = new HashSet<>();

        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine());
            breeds.add(cows[i]);
        }

        int answer = 0;

        for (int removeBreed : breeds) {

            int prevBreed = -1;
            int count = 0;

            for (int breed : cows) {

                if (breed == removeBreed) {
                    continue;
                }

                if (breed == prevBreed) {
                    count++;
                } else {
                    prevBreed = breed;
                    count = 1;
                }

                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }
}