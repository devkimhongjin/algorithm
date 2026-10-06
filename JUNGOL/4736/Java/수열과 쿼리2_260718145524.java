// JUNGOL #4736 · 수열과 쿼리2
// https://jungol.co.kr/problem/4736
// Language: Java
// Execution Time: 209 ms
// Memory: 34 MB

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 0; testCase < T; testCase++) {
            int Q = Integer.parseInt(br.readLine().trim());

            TreeSet<Integer> sequence = new TreeSet<>();

            for (int q = 0; q < Q; q++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch (command) {
                    case "insert": {
                        int x = Integer.parseInt(st.nextToken());
                        sequence.add(x);
                        break;
                    }

                    case "erase": {
                        int x = Integer.parseInt(st.nextToken());
                        sequence.remove(x);
                        break;
                    }

                    case "update": {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());

                        if (sequence.contains(x) && !sequence.contains(y)) {
                            sequence.remove(x);
                            sequence.add(y);
                        }
                        break;
                    }

                    case "front": {
                        int c = Integer.parseInt(st.nextToken());

                        if (sequence.isEmpty()) {
                            answer.append("empty").append('\n');
                        } else {
                            ArrayList<Integer> list =
                                    new ArrayList<Integer>(sequence);

                            int index = Math.min(c, list.size()) - 1;
                            int value = list.get(index).intValue();

                            answer.append(value).append('\n');
                        }
                        break;
                    }

                    case "back": {
                        int c = Integer.parseInt(st.nextToken());

                        if (sequence.isEmpty()) {
                            answer.append("empty").append('\n');
                        } else {
                            ArrayList<Integer> list =
                                    new ArrayList<Integer>(sequence);

                            int index = Math.max(0, list.size() - c);
                            int value = list.get(index).intValue();

                            answer.append(value).append('\n');
                        }
                        break;
                    }
                }
            }
        }

        System.out.print(answer.toString());
    }
}