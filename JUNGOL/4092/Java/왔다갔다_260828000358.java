// JUNGOL #4092 · 왔다갔다
// https://jungol.co.kr/problem/4092
// Language: Java
// Execution Time: 397 ms
// Memory: 35.6 MB

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> store1;
    static List<Integer> store2;
    static Set<Integer> set;

    static void dfs(int depth, int sum) {

        if (depth == 4) {
            set.add(sum);
            return;
        }

        Set<Integer> used = new HashSet<>();

        if (depth % 2 == 0) {


            for (int i = 0; i < store1.size(); i++) {

                int bucket = store1.get(i);

                if (!used.add(bucket)) {
                    continue;
                }

                store1.remove(i);
                store2.add(bucket);

                dfs(depth + 1, sum - bucket);

                store2.remove(store2.size() - 1);
                store1.add(i, bucket);
            }

        } else {
            for (int i = 0; i < store2.size(); i++) {

                int bucket = store2.get(i);

                if (!used.add(bucket)) {
                    continue;
                }

                store2.remove(i);
                store1.add(bucket);

                dfs(depth + 1, sum + bucket);

                store1.remove(store1.size() - 1);
                store2.add(i, bucket);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        store1 = new ArrayList<>();
        store2 = new ArrayList<>();
        set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            store1.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            store2.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);

        System.out.println(set.size());
    }
}