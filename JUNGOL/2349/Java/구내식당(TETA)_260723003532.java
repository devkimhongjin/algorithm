// JUNGOL #2349 · 구내식당(TETA)
// https://jungol.co.kr/problem/2349
// Language: Java
// Execution Time: 111 ms
// Memory: 33.5 MB

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int cost = 0;

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int K = Integer.parseInt(br.readLine());
        int[] costs = new int[K + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= K; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int S = Integer.parseInt(br.readLine());

        int[] setMenus = new int[4];
        Map<Integer, Integer> setMenuIndex = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            setMenus[i] = Integer.parseInt(st.nextToken());
            setMenuIndex.put(setMenus[i], i);
        }

        int T = Integer.parseInt(br.readLine());
        int[] setMenuCount = new int[4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < T; i++) {
            int menu = Integer.parseInt(st.nextToken());

            if (setMenuIndex.containsKey(menu)) {
                int index = setMenuIndex.get(menu);
                setMenuCount[index]++;
            } else {
                cost += costs[menu];
            }
        }

        boolean remains = true;

        while (remains) {
            remains = false;
            int currentSetCost = 0;

            for (int i = 0; i < 4; i++) {
                if (setMenuCount[i] > 0) {
                    currentSetCost += costs[setMenus[i]];
                    setMenuCount[i]--;
                    remains = true;
                }
            }

            if (remains) {
                cost += Math.min(currentSetCost, S);
            }
        }

        System.out.println(cost);
    }
}