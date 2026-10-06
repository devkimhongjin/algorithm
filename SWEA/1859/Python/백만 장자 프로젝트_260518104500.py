# SWEA #1859 · 백만 장자 프로젝트
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc
# Language: Python
# Execution Time: 761 ms
# Memory: 200396 KB

def solution():
    # 1. N(날짜 수) 입력 받기
    N = int(input())

    # 2. N일 동안의 매매가를 리스트로 입력 받기
    prices = list(map(int, input().split()))

    max_price = 0
    profit = 0

    # 3. 배열을 뒤에서부터(역순으로) 탐색하며 이익 계산
    for i in range(N - 1, -1, -1):
        if prices[i] > max_price:
            # 현재 가격이 지금까지의 최대 가격보다 높으면 갱신
            max_price = prices[i]
        else:
            # 최대 가격보다 낮거나 같으면 차액만큼 이익 산출
            profit += max_price - prices[i]

    # 최종 계산된 이익 반환
    return profit

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = solution()
    print(f"#{test_case} {result}")
