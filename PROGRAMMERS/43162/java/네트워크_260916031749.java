// PROGRAMMERS #43162 · 네트워크
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
// Language: java

class Solution {
    
    static int[] parent;
    
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n + 1];
        
        // 처음에는 각 컴퓨터가 자기 자신을 대표로 가짐
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 대칭 행렬이므로 절반만 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (computers[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        // 루트의 개수 = 네트워크의 개수
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                answer++;
            }
        }

        return answer;
    }
}