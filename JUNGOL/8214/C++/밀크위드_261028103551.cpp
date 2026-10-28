// JUNGOL #8214 · 밀크위드
// https://jungol.co.kr/problem/8214
// Solved At: 2026-10-28 10:35:51 KST
// Language: C++
// Execution Time: 12 ms
// Memory: 1.5 MB

#include <iostream>
#include <queue>
using namespace std;


int X, Y, Mx, My;
char grid[101][101];
int dist[101][101];


int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

int main() {
    cin >> X >> Y >> Mx >> My;

    for(int i = 0; i < Y; i++){
        for(int j = 0; j < X; j++){
            cin >> grid[i][j];
        }
    }

    int r = Y - My;
    int c = Mx - 1;

    queue<pair<int, int>> q;
    q.push({r, c});
    dist[r][c] = 1;
    grid[r][c] = '*';

    int answer = 1;

    while(!q.empty()){
        auto [x, y] = q.front();
        q.pop();

        for(int d = 0; d < 8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= Y || ny < 0 || ny >= X)
                continue;

            if(grid[nx][ny] == '*')
                continue;

            grid[nx][ny] = '*';
            dist[nx][ny] = dist[x][y] + 1;

            answer = max(answer, dist[nx][ny]);
            q.push({nx, ny});
        }
    }

    cout << answer - 1 << '\n';

    return 0;
}