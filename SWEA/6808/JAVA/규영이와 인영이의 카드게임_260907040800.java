// SWEA #6808 · 규영이와 인영이의 카드게임
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
// Language: JAVA
// Execution Time: 1013 ms
// Memory: 26752 KB

import java.io.*;
import java.util.*;

class Solution {

    static final int CARDS = 18;
    static final int MAXSCORE = CARDS * (CARDS + 1) / 2;
    static int[] firstCards;
    static int[] secondCards;
    static int[] factorial;
    static boolean[] visited;
    static int win;
    static int lose;
    
    static void dfs(int depth, int firstScore, int secondScore) {
    	if(firstScore > MAXSCORE/2) {
    		win += factorial[CARDS/2-depth];
    		return;
    	}
    	if(secondScore > MAXSCORE/2) {
    		lose += factorial[CARDS/2-depth];
    		return;
    	}
    	for(int i = 0 ; i < 9 ; i++) {
    		if(visited[i]) {
    			continue;
    		}
    		visited[i] = true;
    		int score = firstCards[depth] + secondCards[i];
    		if(firstCards[depth] > secondCards[i]) {
    			dfs(depth+1, firstScore + score, secondScore);
    		}else {
    			dfs(depth+1, firstScore, secondScore + score);
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
        
        factorial = new int[CARDS/2+1];
        factorial[0] = 1;
        for (int i = 1; i <= CARDS/2; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            firstCards = new int[CARDS/2];
            secondCards = new int[CARDS/2];

            boolean[] used = new boolean[CARDS + 1];

            for (int i = 0; i < CARDS/2; i++) {
                int card = Integer.parseInt(st.nextToken());

                firstCards[i] = card;
                used[card] = true;
            }

            int idx = 0;

            for (int card = CARDS; card >= 1; card--) {
                if (!used[card]) {
                    secondCards[idx++] = card;
                }
            }
            
            visited = new boolean[CARDS/2];
            win = 0; lose = 0;
            dfs(0, 0, 0);
            
            sb.append(win)
              .append(" ")
              .append(lose)
              .append("\n");
        }

        System.out.print(sb);
    }
}