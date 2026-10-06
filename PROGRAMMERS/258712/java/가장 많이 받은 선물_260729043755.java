// PROGRAMMERS #258712 · 가장 많이 받은 선물
// https://school.programmers.co.kr/learn/courses/30/lessons/258712
// Language: java

import java.io.*;
import java.util.*;

class Solution { 
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[][] check = new int[n][n];
        int[] presentPoint = new int[n];
        int[] aditionalPresent = new int[n];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(friends[i], i);
        }
        StringTokenizer st;
        for(String gift : gifts){
            st = new StringTokenizer(gift);
            
            int a = map.get(st.nextToken());
            int b = map.get(st.nextToken());
            
            check[a][b]++;
            check[b][a]--;
        }
        for(int i = 0 ; i< n ; i++){
            int sum = 0;
            for(int j = 0 ; j < n ; j++){
                sum += check[i][j];
            }
            presentPoint[i] = sum;
        }
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(check[i][j] == 0){
                    if(i != j){
                        if(presentPoint[i] > presentPoint[j]){
                            aditionalPresent[i]++;
                        }
                        else if(presentPoint[i] < presentPoint[j]){
                            aditionalPresent[j]++;
                        }
                    }
                }else if(check[i][j] > 0){
                    aditionalPresent[i]++;
                }else{
                    aditionalPresent[j]++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, aditionalPresent[i]);
        }
        
        return max / 2;
    }
}