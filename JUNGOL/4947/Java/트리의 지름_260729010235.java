// JUNGOL #4947 · 트리의 지름
// https://jungol.co.kr/problem/4947
// Language: Java
// Execution Time: 520 ms
// Memory: 62.6 MB

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        List<Node> children = new ArrayList<>();

        int depth;

        public void insertNode(Node child) {
        	
            children.add(child);
        }
    }

    static int maxDiameter = 0;

    static int calculateDepth(Node current) {
        if (current == null) {
            return -1;
        }
        int childrenSize = current.children.size();
        int maxDepth = 0;
        int secondMaxDepth = 0;
        
        for(int i = 0 ; i < childrenSize ; i++) {
        	int depth = calculateDepth(current.children.get(i));
        	if (depth > maxDepth) {
                secondMaxDepth = maxDepth;
                maxDepth = depth;
            } else if (depth > secondMaxDepth) {
                secondMaxDepth = depth;
            }
        }

        int currentDiameter = maxDepth + secondMaxDepth;

        maxDiameter = Math.max(maxDiameter, currentDiameter);

        current.depth = maxDepth + 1;

        return current.depth;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            nodes[parent].insertNode(nodes[child]);
        }

        calculateDepth(nodes[1]);

        System.out.println(maxDiameter);
    }
}