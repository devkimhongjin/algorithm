// SWEA #26953 · 화물 입고 코드 점검
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpK9aHfHHBIQj
// Language: JAVA
// Execution Time: 91 ms
// Memory: 26752 KB

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String args[]) throws Exception{
        HashMap<Character, Integer> count;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1 ; testCase <= T ; testCase++){
            count = new HashMap<>();
            for(char c: br.readLine().toCharArray()){
                if(!count.containsKey(c)){
                    count.put(c, 0);
                }
            }
            for(char c: br.readLine().toCharArray()){
                if(count.containsKey(c)){
                    count.put(c, count.get(c)+1);
                }
            }
            
            System.out.println("#"+testCase+" "+Collections.max(count.values()));
        }
	}
}