// SWEA #26956 · 행운의 구슬 팔찌
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpL76Hf3HBIQj
// Language: JAVA
// Execution Time: 83 ms
// Memory: 25600 KB

import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>(N + K);

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int index = 0;

            for (int i = 0; i < K; i++) {

                int size = list.size();
                index = (index + M - 1) % size + 1;

                int prevValue = list.get(index - 1);

                int nextValue;

                if (index < size) {
                    nextValue = list.get(index);
                }else {
                    nextValue = list.get(0);
                }

                list.add(index, prevValue + nextValue);

            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(tc).append(" ");

            for (int i = list.size() - 1;
                 i >= 0 && i >= list.size() - 10;
                 i--) {

                sb.append(list.get(i)).append(' ');
            }

            System.out.println(sb);
        }
    }
}