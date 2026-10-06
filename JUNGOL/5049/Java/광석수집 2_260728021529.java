// JUNGOL #5049 · 광석수집 2
// https://jungol.co.kr/problem/5049
// Language: Java
// Execution Time: 149 ms
// Memory: 33.6 MB

import java.io.*;

class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int pointer = 0;
        private int length = 0;

        private int read() throws IOException {
            if (pointer >= length) {
                length = in.read(buffer);
                pointer = 0;

                if (length == -1) {
                    return -1;
                }
            }

            return buffer[pointer++];
        }

        int nextInt() throws IOException {
            int c;
            int value = 0;
            int sign = 1;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();
        int M = fs.nextInt();

        int[] dp = new int[M];

        for (int c = 0; c < M; c++) {
            dp[c] = -1;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                int current = fs.nextInt();

                if (current == 1) {
                    dp[c] = -1;
                    continue;
                }

                if (r == 0 && c == 0) {
                    dp[c] = current == 2 ? 1 : 0;
                    continue;
                }

                int fromUp = dp[c];

                int fromLeft = c > 0 ? dp[c - 1] : -1;

                int best = Math.max(fromUp, fromLeft);

                if (best == -1) {
                    dp[c] = -1;
                    continue;
                }

                dp[c] = best;

                if (current == 2) {
                    dp[c]++;
                }
            }
        }

        System.out.println(Math.max(dp[M - 1], 0));
    }
}