-- PROGRAMMERS #59412 · 입양 시각 구하기(1)
-- https://school.programmers.co.kr/learn/courses/30/lessons/59412
-- Solved At: 2026-11-03 15:32:48 KST
-- Language: MySQL

SELECT HOUR(DATETIME) HOUR, COUNT(*) COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR BETWEEN 9 AND 19
ORDER BY HOUR