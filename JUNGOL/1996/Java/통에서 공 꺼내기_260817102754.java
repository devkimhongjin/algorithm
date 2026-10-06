// JUNGOL #1996 · 통에서 공 꺼내기
// https://jungol.co.kr/problem/1996
// Language: Java
// Execution Time: 311 ms
// Memory: 32.9 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] balls = new int[15][15];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 1;
        for (int r = 1; r <= 10; r++) {
            for (int c = 1; c <= r; c++) {
                if (count <= N) {
                    balls[r][c] = Integer.parseInt(st.nextToken());
                    count++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int step = 0; step < N; step++) {
            sb.append(balls[1][1]).append(" ");
            balls[1][1] = 0; 
            
            int r = 1;
            int c = 1;
            
            while(true) {
                int left_r = r + 1;
                int left_c = c;
                int right_r = r + 1;
                int right_c = c + 1;
                
                if (balls[left_r][left_c] == 0 && balls[right_r][right_c] == 0) {
                    break;
                }
                
                int l_sum = 0;
                for (int i = 0; r + 1 + i <= 10; i++) {
                    l_sum += balls[r + 1 + i][c];
                }
                
                int r_sum = 0;
                for (int i = 0; r + 1 + i <= 10; i++) {
                    r_sum += balls[r + 1 + i][c + 1 + i];
                }
                
                if (l_sum > r_sum) {
                    balls[r][c] = balls[left_r][left_c];
                    balls[left_r][left_c] = 0;
                    r = left_r;
                    c = left_c;
                } else {
                    balls[r][c] = balls[right_r][right_c];
                    balls[right_r][right_c] = 0;
                    r = right_r;
                    c = right_c;
                }
            }
        }

        System.out.print(sb);
    }
}