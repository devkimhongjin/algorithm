// JUNGOL #1997 · 떡 먹는 호랑이
// https://jungol.co.kr/problem/1997
// Solved At: 2026-10-23 11:34:38 KST
// Language: C++
// Execution Time: 9 ms

#include <iostream>
using namespace std;

int main() {
    int D, K;
    cin >> D >> K;

    int fibonacci[D+1];
    fibonacci[1] = 1;
    fibonacci[2] = 1;

    for (int i = 3; i <= D; i++) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    int A = fibonacci[D - 2];
    int B = fibonacci[D - 1];

    for (int a = 1; a <= K; a++) {
        int remain = K - A * a;

        if (remain > 0 && remain % B == 0) {
            int b = remain / B;

            if (a <= b) {
                cout << a << '\n' << b;
                break;
            }
        }
    }

    return 0;
}