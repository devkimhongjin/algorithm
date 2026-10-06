// PROGRAMMERS #77485 · 행렬 테두리 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// Language: java

class Solution {

    int[] answer;

    // 오른쪽 → 아래 → 왼쪽 → 위
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    // 전달받은 map 배열을 직접 회전시킨다.
    private void rotateMap(int[][] map, int[] query, int index) {

        int minNum = Integer.MAX_VALUE;

        // 1-based 좌표를 0-based 좌표로 변환
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        // 직사각형 테두리에 포함된 칸의 개수
        int rotateNum = 2 * ((x2 + y2) - (x1 + y1));

        int dir = 0;

        // 왼쪽 위에서 시작
        int x = x1;
        int y = y1;

        // 왼쪽 위 칸에는 바로 아래 칸의 값이 들어온다.
        int prevNum = map[x + 1][y];

        for (int i = 0; i < rotateNum; i++) {

            // 덮어쓰기 전에 현재 값을 임시 저장
            int temp = map[x][y];

            // 회전에 포함된 값 중 최솟값 갱신
            minNum = Math.min(minNum, temp);

            // 이전 위치의 값을 현재 위치에 저장
            map[x][y] = prevNum;

            // 현재 위치의 기존 값을 다음 위치로 전달
            prevNum = temp;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나면 방향 전환
            if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                dir++;

                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        answer[index] = minNum;
    }

    public int[] solution(int rows, int columns, int[][] queries) {

        answer = new int[queries.length];

        int[][] map = new int[rows][columns];

        int num = 1;

        // 배열에 1부터 순서대로 값 저장
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = num++;
            }
        }

        // map은 참조형이므로 메서드에서 직접 수정된다.
        for (int i = 0; i < queries.length; i++) {
            rotateMap(map, queries[i], i);
        }

        return answer;
    }
}