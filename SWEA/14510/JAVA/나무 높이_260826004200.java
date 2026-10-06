// SWEA #14510 · 나무 높이
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AYFofW8qpXYDFAR4
// Language: JAVA
// Execution Time: 83 ms
// Memory: 25728 KB

import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        
        for(int test_case = 1 ; test_case <= T ; test_case++){
            sb.append("#"+test_case+" ");
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Integer[] trees = new Integer[N];
            int one = 0 ; int two = 0;
            for(int i = 0 ; i < N ; i++){
                trees[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(trees, Collections.reverseOrder());
            int maxHeight = trees[0];
            for(int i = 1 ; i < N ; i++){
                one += (maxHeight - trees[i]) % 2;
                two += (maxHeight - trees[i]) / 2;
            }
            int answer = 0;
            if(one == two){
                answer = one + two;
            }
            else if(one > two){
                answer = one * 2 - 1;
            }
            else{
                answer = one + two +(two-one-1) / 3 +  1;
            }
            sb.append(answer)
               .append("\n");
        }
        System.out.print(sb);
	}
}