// SWEA #1267 · [S/W 문제해결 응용] 10일차 - 작업순서
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18TrIqIwUCFAZN
// Language: JAVA
// Execution Time: 106 ms
// Memory: 29440 KB

import java.io.*;
import java.util.*;

class Solution {
	
	static boolean[] visited;
	static List<Integer> process;
	
	static class Node{
		boolean isRoot = true;
		int num;
		List<Node> prevNode;
		List<Node> nextNode;
		public Node(int num) {
			this.num = num;
			prevNode = new ArrayList<>();
			nextNode = new ArrayList<>();
		}
		public boolean canProcess() {
			if(isRoot) {
				return true;
			}else {
				for(int i = 0 ; i < prevNode.size() ; i++) {
					if(!visited[prevNode.get(i).num]) {
						return false;
					}
				}
			}
			return true;
		}
		public void process() {
			if(visited[num]) {
		        return;
		    }

		    if(!canProcess()) {
		        return;
		    }

		    visited[num] = true;
		    process.add(num);
		}
	}
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	
        	Node[] nodes = new Node[V+1];
        	visited = new boolean[V+1];
        	process = new ArrayList<>();
        	for(int i = 1 ; i <= V ; i++) {
        		nodes[i] = new Node(i);
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0 ; i < E ; i++) {
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		
        		nodes[from].nextNode.add(nodes[to]);
        		nodes[to].prevNode.add(nodes[from]);
        		nodes[to].isRoot = false;
        	}
        	
        	while(process.size() < V) {
        		for(int i = 1 ; i <= V ; i++) {
        			nodes[i].process();
        		}
        	}
        	
        	for(int i = 0 ; i < process.size() ; i++) {
        		sb.append(process.get(i))
        		  .append(" ");
        	}
        	sb.append("\n");
        }

        System.out.print(sb);
    }
}