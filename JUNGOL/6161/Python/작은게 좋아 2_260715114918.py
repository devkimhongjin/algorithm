# JUNGOL #6161 · 작은게 좋아 2
# https://jungol.co.kr/problem/6161
# Language: Python
# Execution Time: 896 ms
# Memory: 123.4 MB

import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

stack = []
ans = []

for x in arr:
    while stack and stack[-1] >= x:
        stack.pop()
    ans.append(str(stack[-1] if stack else 0))
    stack.append(x)

print(' '.join(ans))