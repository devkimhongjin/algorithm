// JUNGOL #1002 · 최대공약수, 최소공배수
// https://jungol.co.kr/problem/1002
// Language: Java
// Execution Time: 138 ms
// Memory: 32.9 MB

import java.io.*;
import java.util.*;

public class Main {

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    static long lcm(long a, long b) {
        return Math.abs(a / gcd(a, b) * b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

		int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
		long gcd = Integer.parseInt(st.nextToken());
		long lcm = gcd;

		for(int i = 1 ; i < N ; i++){
			int n = Integer.parseInt(st.nextToken());
			gcd = gcd(gcd, n);
			lcm = lcm(lcm, n);
		}
        

        System.out.println(gcd + " " +lcm);
    }
}