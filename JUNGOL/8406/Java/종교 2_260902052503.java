// JUNGOL #8406 · 종교 2
// https://jungol.co.kr/problem/8406
// Language: Java
// Execution Time: 968 ms
// Memory: 53.3 MB

import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] size;

    // 루트 찾기
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 두 그룹 연결
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 이미 같은 그룹
        if (rootA == rootB) {
            return;
        }

        // 작은 그룹을 큰 그룹에 연결
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }

    // x와 연결된 정점 개수
    static int countLinkedGraph(int x) {
        return size[find(x)];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        size = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int y = Integer.parseInt(st.nextToken());

                union(x, y);

            } else if (command == 2) {

                sb.append(countLinkedGraph(x))
                  .append('\n');
            }
        }

        System.out.print(sb);
    }
}