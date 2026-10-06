// JUNGOL #3116 · 긴 자리 진법 변환
// https://jungol.co.kr/problem/3116
// Language: Java
// Execution Time: 239 ms
// Memory: 38.4 MB

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input == null || input.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);

            int A = Integer.parseInt(st.nextToken());
            String N = st.nextToken();
            int B = Integer.parseInt(st.nextToken());

            BigInteger number = new BigInteger(N, A);

            String result = number.toString(B).toUpperCase();

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}