// PROGRAMMERS #42861 · 섬 연결하기
// https://school.programmers.co.kr/learn/courses/30/lessons/42861
// Language: Java

import java.util.*;


class Solution {
    
    static int[] parent;
    
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB){
            return;
        }
        parent[rootA] = rootB;
    }
    
    public int solution(int n, int[][] costs) {
        int cost = 0;
        
        parent = new int[n];
        for(int i  = 0 ; i < n ; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2)
                    -> Integer.compare(o1[2], o2[2]));
        
        for(int i = 0 ; i < costs.length ; i++){
            if(find(costs[i][0]) == find(costs[i][1])){
                continue;
            }
            union(costs[i][0], costs[i][1]);
            cost += costs[i][2];
        }
        return cost;
    }
}