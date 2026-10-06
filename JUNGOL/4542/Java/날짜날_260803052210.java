// JUNGOL #4542 · 날짜날
// https://jungol.co.kr/problem/4542
// Language: Java
// Execution Time: 426 ms
// Memory: 34.6 MB

import java.io.*;

public class Main {

    static boolean isLeapYear(int year) {
        return year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        int[] days = {
                0,
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        for (int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            int year = Integer.parseInt(input);

            int month = Integer.parseInt(
                    "" + input.charAt(3) + input.charAt(2)
            );

            int day = Integer.parseInt(
                    "" + input.charAt(1) + input.charAt(0)
            );
			
            days[2] = isLeapYear(year) ? 29 : 28;

            if (month >= 1 && month <= 12
                    && day >= 1 && day <= days[month]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}