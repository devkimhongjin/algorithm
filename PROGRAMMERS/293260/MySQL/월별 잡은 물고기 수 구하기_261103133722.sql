-- PROGRAMMERS #293260 · 월별 잡은 물고기 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/293260
-- Solved At: 2026-11-03 13:37:22 KST
-- Language: MySQL

SELECT COUNT(*) AS FISH_COUNT, MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH
ORDER BY MONTH