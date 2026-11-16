// JUNGOL #5383 · 우유는 순서대로 (Livestock Lineup)
// https://jungol.co.kr/problem/5383
// Solved At: 2026-11-16 09:11:16 KST
// Language: Java
// Execution Time: 493 ms
// Memory: 34236 KiB

import java.io.*;
import java.util.*;

public class Main {

    static final String[] COWS = {
        "Bessie", "Buttercup", "Belinda", "Beatrice",
        "Bella", "Blue", "Betsy", "Sue"
    };

    static String[][] conditions;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());

        conditions = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String X = st.nextToken();

            for (int j = 0; j < 4; j++) {
                st.nextToken();
            }

            String Y = st.nextToken();

            conditions[i][0] = X;
            conditions[i][1] = Y;
        }

        Arrays.sort(COWS);
		
		while (nextPermutation()){
			if (check()) {
                for (String cow : COWS) {
                    System.out.println(cow);
                }
                return;
            }
		}

    }

    static boolean check() {

        for (int i = 0; i < N; i++) {

            String X = conditions[i][0];
            String Y = conditions[i][1];

            int indexX = -1;
            int indexY = -1;

            for (int j = 0; j < 8; j++) {
                if (COWS[j].equals(X)) {
                    indexX = j;
                }

                if (COWS[j].equals(Y)) {
                    indexY = j;
                }
            }

            if (Math.abs(indexX - indexY) != 1) {
                return false;
            }
        }

        return true;
    }

    static boolean nextPermutation() {

        int i = 7;

        while (i > 0 && COWS[i - 1].compareTo(COWS[i]) >= 0) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = 7;

        while (COWS[i - 1].compareTo(COWS[j]) >= 0) {
            j--;
        }

        String temp = COWS[i - 1];
        COWS[i - 1] = COWS[j];
        COWS[j] = temp;

        j = 7;

        while (i < j) {
            temp = COWS[i];
            COWS[i] = COWS[j];
            COWS[j] = temp;

            i++;
            j--;
        }

        return true;
    }
}
