// JUNGOL #3926 · COW
// https://jungol.co.kr/problem/3926
// Language: Java
// Execution Time: 134 ms
// Memory: 34.1 MB

import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		br.readLine();
		char[] input = br.readLine().toCharArray();

		long cCount = 0;
		long coCount = 0;
		long answer = 0;

		for (char c : input) {
			if (c == 'C') {
				cCount++;
			} else if (c == 'O') {
				coCount += cCount;
			} else if (c == 'W') {
				answer += coCount;
			}
		}

		System.out.print(answer);
	}
}