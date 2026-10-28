-- PROGRAMMERS #59036 · 아픈 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59036
-- Solved At: 2026-08-07 14:43:28 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT
    ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'