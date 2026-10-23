// JUNGOL #8675 · 고도 상승량
// https://jungol.co.kr/problem/8675
// Solved At: 2026-10-22 16:37:24 KST
// Language: C++
// Execution Time: 477 ms
// Memory: 5.4 MB

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> A(N);
    for (int &x : A) cin >> x;

    int result = 0;
    int start = 0;

    for (int i = 1; i <= N; i++) {
        if (i == N || A[i] <= A[i - 1]) {
            result = max(result, A[i - 1] - A[start]);
            start = i;
        }
    }

    cout << result;
}