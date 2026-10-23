// PROGRAMMERS #77485 · 행렬 테두리 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// Solved At: 2026-07-22 12:18:00 KST
// Language: java

class Solution {
    
    int[] answer;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    private int[][] getRotatedMap(int[][] map, int[] querie, int index){
        int[][] rotatedMap = map.clone();
        int minNum = Integer.MAX_VALUE;
        int x1 = querie[0]-1; int y1 = querie[1]-1;
        int x2 = querie[2]-1; int y2 = querie[3]-1;
        int rotateNum = 2 * ((x2+y2)-(x1+y1));
        int dir = 0;
        
        int x = x1; int y = y1;
        int prevNum = map[x+1][y];
        for(int i = 0 ; i < rotateNum ; i++){
            int temp = rotatedMap[x][y];
            minNum = Math.min(minNum, temp);
            rotatedMap[x][y] = prevNum;
            prevNum = temp;
                
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < x1 || nx > x2 || ny < y1 || ny > y2){
                dir++;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        
        
        answer[index] = minNum;
        return rotatedMap;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int length = queries.length;
        answer = new int[length];
        int[][] map = new int[rows][columns];
        int num = 1;
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < columns ; c++){
                map[r][c] = num;
                num++;
            }
        }
        for(int i = 0 ; i < length ; i++){
            map = getRotatedMap(map, queries[i], i);
        }
        
        return answer;
    }
}