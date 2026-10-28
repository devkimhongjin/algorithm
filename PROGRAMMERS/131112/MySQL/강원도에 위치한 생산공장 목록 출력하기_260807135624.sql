-- PROGRAMMERS #131112 · 강원도에 위치한 생산공장 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131112
-- Solved At: 2026-08-07 13:56:24 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT
    FACTORY_ID,
    FACTORY_NAME,
    ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID