// SWEA #6808 · 규영이와 인영이의 카드게임
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// Language: JAVA
// Execution Time: 1424 ms
// Memory: 26752 KB

import java.io.*;
import java.util.*;

class Solution {

    static final int CARDS = 18;
    static final int MAXSCORE = 171;
    static int[] firstCards;
    static int[] secondCards;
    static int[] factorial;
    static boolean[] visited;
    static int win;
    static int lose;
    
    static void dfs(int depth, int firstScore) {
    	if(depth == CARDS/2) {
    		if(firstScore > MAXSCORE/2) {
    			win++;
    		}
    		return;
    	}
    	if(firstScore > MAXSCORE/2) {
    		win+= factorial[CARDS/2 - depth];
    		return;
    	}

    	for(int i = 0 ; i < 9 ; i++) {
    		if(visited[i]) {
    			continue;
    		}
    		visited[i] = true;
    		int score = firstCards[depth] + secondCards[i];
    		if(firstCards[depth] > secondCards[i]) {
    			dfs(depth+1, firstScore + score);
    		}else {
    			dfs(depth+1, firstScore);
    		}
    		visited[i] = false;
    	}
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            firstCards = new int[CARDS/2];
            secondCards = new int[CARDS/2];

            boolean[] used = new boolean[CARDS + 1];
            factorial = new int[CARDS/2+1];
            int fact = 1;
            for (int i = 0; i < CARDS/2; i++) {
                int card = Integer.parseInt(st.nextToken());

                fact *= i+1;
                factorial[i+1] = fact;
                firstCards[i] = card;
                used[card] = true;
            }

            int idx = 0;

            for (int card = 1; card <= CARDS; card++) {
                if (!used[card]) {
                    secondCards[idx++] = card;
                }
            }
            
            visited = new boolean[CARDS/2];
            win = 0; lose = 0;
            dfs(0, 0);
            
            sb.append(win)
              .append(" ")
              .append(factorial[CARDS/2] - win)
              .append("\n");
        }

        System.out.print(sb);
    }
}