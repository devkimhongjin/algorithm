// JUNGOL #5545 · 연필 공장
// https://jungol.co.kr/problem/5545
// Language: Java
// Execution Time: 123 ms
// Memory: 33.1 MB

import java.io.*;
import java.util.*;

public class Main {

	static long gcd(long a, long b) {
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
	static long lcm(long a, long b){
		return a / gcd(a,b) * b;
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());
		long P = Long.parseLong(st.nextToken())+1;
		long V = Long.parseLong(st.nextToken())+1;
		long K = Long.parseLong(st.nextToken());

		
		long B = K / lcm(P,V);
		long C = K / V - B;
		long D = K / P - B;

		long A = K - B - C - D;

        System.out.println(A + " " + B + " " + C + " " + D);
    }
}