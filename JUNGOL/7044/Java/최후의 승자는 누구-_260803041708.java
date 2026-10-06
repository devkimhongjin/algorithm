// JUNGOL #7044 · 최후의 승자는 누구?
// https://jungol.co.kr/problem/7044
// Language: Java
// Execution Time: 392 ms
// Memory: 37.4 MB

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] cards = new int[N][];
		int[] scores = new int[N];

		for(int i = 0 ; i < N ; i++){
			int [] playerCards = new int[M];
			playerCards = Arrays.stream(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)
                          .sorted()
						  .toArray();
			cards[i] = playerCards;
		}

        for (int cardIndex = M - 1; cardIndex >= 0; cardIndex--) {
            int maxCard = Integer.MIN_VALUE;

            for (int player = 0; player < N; player++) {
                maxCard = Math.max(maxCard, cards[player][cardIndex]);
            }

            for (int player = 0; player < N; player++) {
                if (cards[player][cardIndex] == maxCard) {
                    scores[player]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        StringBuilder answer = new StringBuilder();

        for (int player = 0; player < N; player++) {
            if (scores[player] == maxScore) {
                answer.append(player + 1).append(' ');
            }
        }

        System.out.println(answer.toString());
	}
}