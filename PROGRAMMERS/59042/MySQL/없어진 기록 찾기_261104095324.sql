-- PROGRAMMERS #59042 · 없어진 기록 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59042
-- Solved At: 2026-11-04 09:53:24 KST
-- Language: MySQL

SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS O
WHERE NOT EXISTS(
    SELECT 1
    FROM ANIMAL_INS I
    WHERE O.ANIMAL_ID=I.ANIMAL_ID
)
ORDER BY ANIMAL_ID;