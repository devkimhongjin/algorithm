// JUNGOL #16763 · 부분수열의 개수
// https://jungol.co.kr/problem/16763
// Language: Java
// Execution Time: 382 ms
// Memory: 56.4 MB

import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 998244353;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        // pow2[i] = 2^i % MOD
        long[] pow2 = new long[N + 1];
        pow2[0] = 1;

        for (int i = 1; i <= N; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }

		long answer = 0;

		if(nums[N-1] <= nums[0] * 2L){
			answer = pow2[N]-1;
		}else{
			int right = 0;

			for (int left = 0; left < N; left++) {

				// right가 left보다 뒤처지지 않도록
				if (right < left) {
					right = left;
				}

				// nums[left]를 최솟값으로 할 때
				// nums[right] <= nums[left] * 2 인 최대 범위 탐색
				while (right + 1 < N &&
						nums[right + 1] <= nums[left] * 2L) {
					right++;
				}

				/*
					* nums[left]는 반드시 선택
					*
					* left + 1 ~ right에 있는 원소들은
					* 각각 선택 / 미선택 가능
					*
					* 따라서 경우의 수:
					* 2^(right - left)
					*/
				answer += pow2[right - left];
				answer %= MOD;
			}
		}

		//모든 원소 제거한 경우의 수 + 1
        System.out.print(answer+1);
    }
}