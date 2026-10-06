# SWEA #26502 · 쉬운 삼각형
# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZz7DObKASzHBIRj
# Language: Python
# Execution Time: 86 ms
# Memory: 59520 KB

# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''




'''
아래의 구문은 input.txt 를 read only 형식으로 연 후,
앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
아래 구문을 사용하기 위해서는 import sys가 필요합니다.
단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
'''
#import sys
#sys.stdin = open("input.txt", "r")

def solution():
    N = int(input())

    points = [tuple(map(int, input().split())) for _ in range(N)]

    max_area_twice = 0

    for x3, y3 in points:
        max_dx = 0
        max_dy = 0

        for x, y in points:
            if y == y3:
                max_dx = max(max_dx, abs(x - x3))
            if x == x3:
                max_dy = max(max_dy, abs(y - y3))

        if max_dx > 0 and max_dy > 0:
            current_area_twice = max_dx * max_dy
            max_area_twice = max(max_area_twice, current_area_twice)

    return max_area_twice


T = int(input())

for test_case in range(1, T + 1):
    result = solution()
    print(result)
