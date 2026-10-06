// SWEA #26928 · 사전 펼치기 시합
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpDFaHY3HBIQj
// Language: JAVA
// Execution Time: 86 ms
// Memory: 25984 KB

import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Pa = Integer.parseInt(st.nextToken());
			int Pb = Integer.parseInt(st.nextToken());
			
			int left = 1;
			int right = P;
			int aCnt = 0;
			while(left <= right) {
				aCnt++;
				int mid = (left+right) / 2;
				if(mid == Pa) {
					break;
				}
				else if(Pa < mid) {
					right = mid;
				}
				else {
					left = mid;
				}
			}
            left = 1;
			right = P;
			int bCnt = 0;
			while(left <= right) {
				bCnt++;
				int mid = (left+right) / 2;
				if(mid == Pb) {
					break;
				}
				else if(Pb < mid) {
					right = mid;
				}
				else {
					left = mid;
				}
			}
			
			StringBuilder result = new StringBuilder("#" + testCase + " ");
			if(aCnt == bCnt) {
				result.append(0);
			}
			else if(bCnt > aCnt) {
				result.append("A");
			}
			else {
				result.append("B");
			}
			System.out.println(result);
		}
    }
}