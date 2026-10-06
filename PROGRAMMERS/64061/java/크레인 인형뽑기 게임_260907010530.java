// PROGRAMMERS #64061 · 크레인 인형뽑기 게임
// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// Language: java

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int N = board.length;
        int M = board[0].length;
        int[] length = new int[M];
        for(int c = 0 ; c < M ; c++){
            for(int r = 0 ; r < N ; r++){
                if(board[r][c] != 0){
                    length[c]++;
                }
            }
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int move : moves){
            move--;
            if(length[move] == 0){
                continue;
            }
            
            int doll = board[N - length[move]][move];
            length[move]--;
            
            if(stack.isEmpty()){
                stack.push(doll);
            }else{
                int top = stack.peek();
                if(top == doll){
                    answer += 2;
                    stack.pop();
                }else{
                    stack.push(doll);
                }
            } 
        }
        return answer;
    }
}