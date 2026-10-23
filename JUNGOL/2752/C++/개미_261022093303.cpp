// JUNGOL #2752 · 개미
// https://jungol.co.kr/problem/2752
// Solved At: 2026-10-22 09:33:03 KST
// Language: C++
// Execution Time: 6 ms
// Memory: 1.4 MB

#include <iostream>
using namespace std;

int main() {
    int w, h, p, q, t;
    cin >> w >> h >> p >> q >> t;

    p = (p + t) % (2 * w);
    q = (q + t) % (2 * h);

    if (p > w) p = 2 * w - p;
    if (q > h) q = 2 * h - q;

    cout << p << " " << q;

    return 0;
}