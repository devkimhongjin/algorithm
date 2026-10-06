// SWEA #26930 · 코드 편집기의 괄호 짝 검사
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpDrqHZXHBIQj
// Language: JAVA
// Execution Time: 79 ms
// Memory: 25856 KB

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

            char quote = 0; 
            boolean valid = true;

            for (char c : br.readLine().toCharArray()) {
                if (quote != 0) {
                    if (c == quote) {
                        quote = 0;
                    }
                    continue;
                }
                if (c == '\'' || c == '"') {
                    quote = c;
                    continue;
                }
                if (c == '(' || c == '{') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        valid = false;
                        break;
                    }
                }
                else if (c == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        valid = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                valid = false;
            }

            System.out.println("#" + tc + " " + (valid ? 1 : 0));
        }
    }
}