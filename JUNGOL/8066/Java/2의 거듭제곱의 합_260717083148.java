// JUNGOL #8066 · 2의 거듭제곱의 합
// https://jungol.co.kr/problem/8066
// Language: Java
// Execution Time: 222 ms
// Memory: 35.5 MB

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        int first = -1;
        int second = -1;

        for (int position = 0; position < 63; position++) {
            if ((N & (1L << position)) != 0) {
                if (first == -1) {
                    first = position;
                } else {
                    second = position;
                }
            }
        }

        // 1이 하나만 있는 경우
        if (second == -1) {
            System.out.println((first - 1) + " " + (first - 1));
        }
        // 1이 두 개 있는 경우
        else {
            System.out.println(first + " " + second);
        }
	}
}