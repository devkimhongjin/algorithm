// JUNGOL #2689 · 폭탄 (EKSPLOZIJA)
// https://jungol.co.kr/problem/2689
// Language: Java
// Execution Time: 333 ms
// Memory: 46 MB

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		String string = br.readLine();
		String bomb = br.readLine();

		StringBuilder answer = new StringBuilder();
		int bombLength = bomb.length();

		for (char c : string.toCharArray()) {
			// 현재 문자를 결과의 마지막에 추가
			answer.append(c);

			// 현재 결과가 폭발 문자열보다 짧으면 비교할 수 없음
			if (answer.length() < bombLength) {
				continue;
			}

			// answer의 마지막 부분이 bomb와 같은지 확인
			boolean isBomb = true;
			int start = answer.length() - bombLength;

			for (int i = 0; i < bombLength; i++) {
				if (answer.charAt(start + i) != bomb.charAt(i)) {
					isBomb = false;
					break;
				}
			}

			// 마지막 substring이 폭발 문자열이면 제거
			if (isBomb) {
				answer.delete(start, answer.length());
			}
		}

		if (answer.length() == 0) {
			System.out.print("FRULA");
		} else {
			System.out.print(answer);
		}
	}
}