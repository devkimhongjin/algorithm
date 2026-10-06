// JUNGOL #4977 · 실수의 이진수
// https://jungol.co.kr/problem/4977
// Language: Java
// Execution Time: 152 ms
// Memory: 33.1 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		double N = Double.parseDouble(br.readLine());
		int integer = (int) N;
		double decimal = N - integer;

		sb.append(Integer.toBinaryString(integer));
		sb.append(".");

		for (int i = 0; i < 4; i++) {
			decimal *= 2;

			if (decimal >= 1) {
				sb.append(1);
				decimal -= 1;
			} else {
				sb.append(0);
			}
		}

		System.out.print(sb);
	}
}