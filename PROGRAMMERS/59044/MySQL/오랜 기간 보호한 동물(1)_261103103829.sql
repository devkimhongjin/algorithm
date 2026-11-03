-- PROGRAMMERS #59044 · 오랜 기간 보호한 동물(1)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59044
-- Solved At: 2026-11-03 10:38:29 KST
-- Language: MySQL

SELECT NAME, DATETIME
FROM ANIMAL_INS I
WHERE NOT EXISTS(
    SELECT 1
    FROM ANIMAL_OUTS O
    WHERE I.ANIMAL_ID=O.ANIMAL_ID
)
ORDER BY DATETIME
LIMIT 3