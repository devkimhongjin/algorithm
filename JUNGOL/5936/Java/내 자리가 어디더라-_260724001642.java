// JUNGOL #5936 · 내 자리가 어디더라?
// https://jungol.co.kr/problem/5936
// Language: Java
// Execution Time: 301 ms
// Memory: 35.9 MB

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);

		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];
		int[] students = new int[N];
		int size = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 번호가 큰 학생부터 처리
		for (int i = N - 1; i >= 0; i--) {
			int studentNum = i + 1;
			int insertIndex = X[i];

			// insertIndex 이후 원소를 오른쪽으로 한 칸 이동
			for (int j = size; j > insertIndex; j--) {
				students[j] = students[j - 1];
			}

			students[insertIndex] = studentNum;
			size++;
		}
		for (int j = 0; j < size; j++) {
			System.out.print(students[j] + " ");
		}
	}
}