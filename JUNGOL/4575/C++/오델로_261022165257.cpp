// JUNGOL #4575 · 오델로
// https://jungol.co.kr/problem/4575
// Solved At: 2026-10-22 16:52:57 KST
// Language: C++
// Execution Time: 1 ms

#include <iostream>

using namespace std;

const int N = 8;
const int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};

int grid[N][N];

bool isValid(int r, int c) {
    if (grid[r][c] != 0) {
        return false;
    }

    for (int d = 0; d < 8; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
            continue;
        }

        if (grid[nr][nc] != 2) {
            continue;
        }

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (grid[nr][nc] == 0) {
                break;
            }

            if (grid[nr][nc] == 1) {
                return true;
            }

            nr += dr[d];
            nc += dc[d];
        }
    }

    return false;
}

int main() {
	for(int i = 0 ; i < N ; i++){
		for(int j = 0 ; j < N ; j++){
			cin >> grid[i][j];
		}
	}
	for(int i = 0 ; i < N ; i++){
		for(int j = 0 ; j < N ; j++){
			cout << (isValid(i, j)? 1 : 0) << " ";
		}
		cout << endl;
	}
	return 0;
}