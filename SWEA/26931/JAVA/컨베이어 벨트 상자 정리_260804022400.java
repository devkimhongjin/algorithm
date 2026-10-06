// SWEA #26931 · 컨베이어 벨트 상자 정리
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpD-qHZnHBIQj
// Language: JAVA
// Execution Time: 84 ms
// Memory: 24832 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : br.readLine().toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            System.out.println("#" + tc + " " + stack.size());
        }
    }
}