# SWEA #2001 · 파리 퇴치
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
# Language: Python
# Execution Time: 59 ms
# Memory: 53376 KB



def solution():
    N, M = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(N)]

    prefix_sum = [[0]* (N+1) for _ in range(N+1)]

    for r in range(1, N + 1):
        for c in range(1, N + 1):
            prefix_sum[r][c] = (
                    matrix[r - 1][c - 1] + prefix_sum[r - 1][c] + prefix_sum[r][c - 1] - prefix_sum[r - 1][c - 1]
            )

    max_sum = float("-inf")

    for r in range(M, N + 1):
        for c in range(M, N + 1):
            current_sum = prefix_sum[r][c] -  prefix_sum[r - M][c] -  prefix_sum[r][c - M] +  prefix_sum[r - M][c - M]

            if current_sum > max_sum:
                max_sum = current_sum

    return max_sum


T = int(input())

for test_case in range(1, T+1):
    result = solution()
    print(f"#{test_case} {result}")