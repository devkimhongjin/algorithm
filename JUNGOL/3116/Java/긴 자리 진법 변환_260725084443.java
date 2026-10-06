// JUNGOL #3116 · 긴 자리 진법 변환
// https://jungol.co.kr/problem/3116
// Language: Java
// Execution Time: 556 ms
// Memory: 52.3 MB

import java.io.*;
import java.util.*;

public class Main {

    static int charToInt(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }

        return c - 'A' + 10;
    }

    static char intToChar(int value) {
        if (value < 10) {
            return (char) ('0' + value);
        }

        return (char) ('A' + value - 10);
    }

    static void convert(String number, int fromBase, int toBase) {
        int length = number.length();
        int[] digits = new int[length];

        for (int i = 0; i < length; i++) {
            digits[i] = charToInt(
                    Character.toUpperCase(number.charAt(i))
            );
        }

        char[] result = new char[1100];
        int resultSize = 0;
        int start = 0;

        while (start < length) {
            int remainder = 0;

            for (int i = start; i < length; i++) {
                int current = remainder * fromBase + digits[i];

                digits[i] = current / toBase;
                remainder = current % toBase;
            }

            result[resultSize++] = intToChar(remainder);

            while (start < length && digits[start] == 0) {
                start++;
            }
        }

        for (int i = resultSize - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        while (true) {
            String input = br.readLine();

            if (input == null) {
                break;
            }

            input = input.trim();

            if (input.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input);

            int A = Integer.parseInt(st.nextToken());
            String N = st.nextToken();
            int B = Integer.parseInt(st.nextToken());

            convert(N, A, B);
        }
    }
}