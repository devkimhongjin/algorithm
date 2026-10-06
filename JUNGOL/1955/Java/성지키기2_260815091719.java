// JUNGOL #1955 · 성지키기2
// https://jungol.co.kr/problem/1955
// Language: Java
// Execution Time: 344 ms
// Memory: 37 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[] row = new boolean[R];
        boolean[] col = new boolean[C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                char status = line.charAt(j);

                if (status == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int emptyRow = 0;
        int emptyCol = 0;

        for (int i = 0; i < R; i++) {
            if (!row[i]) {
                emptyRow++;
            }
        }

        for (int j = 0; j < C; j++) {
            if (!col[j]) {
                emptyCol++;
            }
        }

        System.out.println(Math.max(emptyRow, emptyCol));
    }
}