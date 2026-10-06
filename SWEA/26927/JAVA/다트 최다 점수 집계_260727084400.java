// SWEA #26927 · 다트 최다 점수 집계
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpCyaHYnHBIQj
// Language: JAVA
// Execution Time: 71 ms
// Memory: 25600 KB

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String args[]) throws Exception{
        int[] count;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1 ; testCase <= T ; testCase++){
            count = new int[10];
            int N = Integer.parseInt(br.readLine());
            String inputLine = br.readLine();
            for(int i = 0 ; i < N ; i++){
                int input = inputLine.charAt(i) - '0';
                count[input]++;
            }
            int maxNum = 0;
            int maxCount = count[0];
            for(int i = 1 ; i < 10 ; i++){
                if(count[i] >= maxCount){
                    maxNum = i;
                    maxCount = count[i];
                }
            }

            System.out.println("#"+testCase+" "+maxNum+" " + maxCount);
        }
	}
}
