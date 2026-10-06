// SWEA #26941 · 토너먼트 점수 합산
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AZ6wpHCaHcHHBIQj
// Language: JAVA
// Execution Time: 100 ms
// Memory: 25472 KB

import java.io.*;
import java.util.*;

class Solution {

	static Node[] nodes;

	static class Node{
		int index;
		int score;
		int leftNode;
		int rightNode;
		
		public Node(int index) {
			this.index = index;
		}
		public int calcScore() {
			if(leftNode != 0) {
				score += nodes[leftNode].calcScore();
			}
			if(rightNode != 0) {
				score += nodes[rightNode].calcScore();
			}
			return score;
		}
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int L = Integer.parseInt(st.nextToken());
        	
        	nodes = new Node[N+1];
        	for(int i = 1 ; i <= N ; i++) {
        		nodes[i] = new Node(i);
        	}
        	
        	for (int i = 1; i <= N; i++) {
        	    if (2 * i <= N) {
        	        nodes[i].leftNode = 2 * i;
        	    }

        	    if (2 * i + 1 <= N) {
        	        nodes[i].rightNode = 2 * i + 1;
        	    }
        	}
        	
        	for(int i = 0 ; i < M ; i++) {
        		st = new StringTokenizer(br.readLine());
        		int index = Integer.parseInt(st.nextToken());
            	int score = Integer.parseInt(st.nextToken());
            	nodes[index].score = score;
        	}

        	System.out.println("#" + tc + " " + nodes[L].calcScore());
        }
    }
}