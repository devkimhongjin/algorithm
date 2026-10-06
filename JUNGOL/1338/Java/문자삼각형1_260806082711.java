// JUNGOL #1338 · 문자삼각형1
// https://jungol.co.kr/problem/1338
// Language: Java
// Execution Time: 368 ms
// Memory: 33.3 MB


import java.io.*;

public class Main {

	static char intToChar(int num){
		return (char)('A' + (num-1)  % ('Z' - 'A' + 1));
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int r = 1; r <= N; r++) {
            answer.append("  ".repeat(N - r));

            int number = r;

            for (int c = 1; c <= r; c++) {
                answer.append(intToChar(number));

                if (c < r) {
                    answer.append(" ");
                }

                number += N - c;
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}
   