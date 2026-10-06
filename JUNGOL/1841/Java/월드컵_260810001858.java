// JUNGOL #1841 · 월드컵
// https://jungol.co.kr/problem/1841
// Language: Java
// Execution Time: 244 ms
// Memory: 33.1 MB

import java.io.*;
import java.util.*;

public class Main {

    static int[][] result = new int[6][3];
    static int[][] matches = new int[15][2];
    static boolean possible;

    static void dfs(int game) {
        if (game == 15) {
            possible = true;
            return;
        }

        int a = matches[game][0];
        int b = matches[game][1];

        if (result[a][0] > 0 && result[b][2] > 0) {
            result[a][0]--;
            result[b][2]--;

            dfs(game + 1);

            result[a][0]++;
            result[b][2]++;

            if (possible) return;
        }

        if (result[a][1] > 0 && result[b][1] > 0) {
            result[a][1]--;
            result[b][1]--;

            dfs(game + 1);

            result[a][1]++;
            result[b][1]++;

            if (possible) return;
        }

        if (result[a][2] > 0 && result[b][0] > 0) {
            result[a][2]--;
            result[b][0]--;

            dfs(game + 1);

            result[a][2]++;
            result[b][0]++;

            if (possible) return;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[index][0] = i;
                matches[index][1] = j;
                index++;
            }
        }

        for (int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean valid = true;

            for (int i = 0; i < 6; i++) {
                int sum = 0;

                for (int j = 0; j < 3; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                    sum += result[i][j];
                }

                if (sum != 5) {
                    valid = false;
                }
            }

            possible = false;

            if (valid) {
                dfs(0);
            }

            sb.append(possible ? 1 : 0).append(" ");
        }

        System.out.print(sb);
    }
}