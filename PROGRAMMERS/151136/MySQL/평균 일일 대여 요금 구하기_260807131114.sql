-- PROGRAMMERS #151136 · 평균 일일 대여 요금 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
-- Solved At: 2026-08-07 13:11:14 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE)) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = "SUV"