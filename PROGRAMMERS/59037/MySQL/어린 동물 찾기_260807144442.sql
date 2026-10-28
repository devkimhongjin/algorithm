-- PROGRAMMERS #59037 · 어린 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
-- Solved At: 2026-08-07 14:44:42 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NOT INTAKE_CONDITION = 'Aged'