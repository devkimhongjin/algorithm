// JUNGOL #5517 · 끝말잇기
// https://jungol.co.kr/problem/5517
// Solved At: 2026-10-14 17:31:38 KST
// Language: Java
// Execution Time: 190 ms
// Memory: 33852 MB

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[] words;
    static boolean[] visited;

    static int maxDepth;
    static List<String> best;
    static List<String> path;

    static void dfs(int idx) {
        if (path.size() > maxDepth) {
            maxDepth = path.size();
            best = new ArrayList<>(path);
        }

        char last = words[idx].charAt(words[idx].length() - 1);

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (words[i].charAt(0) != last) continue;

            visited[i] = true;
            path.add(words[i]);

            dfs(i);

            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        N = Integer.parseInt(br.readLine());
        words = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            words[i] = st.nextToken();
        }

        Arrays.sort(words);

        visited = new boolean[N];
        path = new ArrayList<>();
        best = new ArrayList<>();
        maxDepth = 0;

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            path.add(words[i]);

            dfs(i);

            path.remove(path.size() - 1);
            visited[i] = false;
        }

        for (String word : best) {
            System.out.print(word + " ");
        }
    }
}