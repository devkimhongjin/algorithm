-- PROGRAMMERS #132202 · 진료과별 총 예약 횟수 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132202
-- Solved At: 2026-11-03 15:19:58 KST
-- Language: MySQL

SELECT
    MCDP_CD 진료과코드,
    COUNT(*) 5월예약건수
FROM APPOINTMENT
WHERE APNT_YMD LIKE '2022-05-%'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, 진료과코드