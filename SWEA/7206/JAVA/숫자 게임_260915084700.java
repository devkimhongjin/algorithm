// SWEA #7206 · 숫자 게임
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWlGyBQqaEgDFASG
// Language: JAVA
// Execution Time: 2518 ms
// Memory: 151064 KB

import java.io.*;
import java.util.*;

class Solution
{
	static int maxTurn;
	
	static int[] divideNum(String s, int index){
		int length = s.length();
		int[] result = new int[2];
		
		List<Character> left = new ArrayList<>();
		List<Character> right = new ArrayList<>();
		for(int i = 0 ; i < length ; i++) {
			if(i < index) {
				left.add(s.charAt(i));
			}else {
				if(i == index && s.charAt(i) == '0') {
					continue;
				}
				right.add(s.charAt(i));
			}
		}
		
		int mult = 1;
		for(int i = left.size()-1 ; i >= 0 ; i--) {
			result[0] += (left.get(i) - '0') * mult;
			mult *= 10;
		}
		mult = 1;
		for(int i = right.size()-1 ; i >= 0 ; i--) {
			result[1] += (right.get(i) - '0') * mult;
			mult *= 10;
		}
		
		return result;
	}
	
	static void dfs(int turn, int left, int right) {
		
		int current = left * right;
		if(current < 10) {
			maxTurn = Math.max(maxTurn, turn);
			return;
		}
		int numLength = Integer.valueOf(current).toString().length();
		
		for(int i = 1 ; i < numLength ; i++) {
			int[] divided = divideNum(Integer.valueOf(current).toString(), i);
			left = divided[0];
			dfs(turn+1, divided[0], divided[1]);
			if(Integer.valueOf(divided[1]).toString().length() > 1) {
				for(int j = 1 ; j < Integer.valueOf(divided[1]).toString().length() ; j++) {
					divided = divideNum(Integer.valueOf(divided[1]).toString(), j);
					dfs(turn+1, left * divided[0], divided[1]);
				}
			}
		}
	}
	
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)
		);
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++){
			sb.append("#")
			  .append(tc)
			  .append(" ");
			
			Integer N = Integer.parseInt(br.readLine());
			
			maxTurn = 0;
			for(int i = 1 ; i <= N.toString().length() ; i++) {
				int[] divided = divideNum(N.toString(), i);
				if(divided[0] * divided[1] < 10) {
					break;
				}
				dfs(1, divided[0], divided[1]);
			}
			
			
			sb.append(maxTurn)
			  .append("\n");
		}
		
		System.out.print(sb);
	}
}
