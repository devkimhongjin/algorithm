// JUNGOL #11236 · 팰린드롬 유형
// https://jungol.co.kr/problem/11236
// Solved At: 2026-11-02 17:39:29 KST
// Language: Java
// Execution Time: 629 ms
// Memory: 34204 KiB


import java.io.*;

public class Main {

    static int minDelete(String s, int left, int right, int count) {

        if (count > 3) {
            return Integer.MAX_VALUE;
        }

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // 왼쪽 문자 삭제
                int a = minDelete(s, left + 1, right, count + 1);

                // 오른쪽 문자 삭제
                int b = minDelete(s, left, right - 1, count + 1);

                return Math.min(a, b);
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String line = br.readLine();

        int result = minDelete(line, 0, line.length() - 1, 0);

        if (result > 3) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
