// JUNGOL #4101 · Mountain View
// https://jungol.co.kr/problem/4101
// Solved At: 2026-10-13 17:19:14 KST
// Language: Java
// Execution Time: 595 ms
// Memory: 57052 MB

import java.io.*;
import java.util.*;

class Mnt implements Comparable<Mnt> {
    long left, right;

    public Mnt(long x, long y) {
        this.left = x - y;
        this.right = x + y;
    }

    @Override
    public int compareTo(Mnt o) {
        if (left != o.left)
            return Long.compare(left, o.left);

        return Long.compare(o.right, right);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int N = Integer.parseInt(br.readLine());
        Mnt[] mountains = new Mnt[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            mountains[i] = new Mnt(x, y);
        }

        Arrays.sort(mountains);

        int count = 0;
        long maxRight = Long.MIN_VALUE;

        for (Mnt m : mountains) {
            if (m.right > maxRight) {
                count++;
                maxRight = m.right;
            }
        }

        System.out.println(count);
    }
}