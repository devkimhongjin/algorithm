-- PROGRAMMERS #299305 · 대장균들의 자식의 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/299305
-- Solved At: 2026-11-04 16:02:52 KST
-- Language: MySQL

SELECT
    D1.ID,
    COUNT(D2.PARENT_ID) CHILD_COUNT
FROM ECOLI_DATA D1
LEFT JOIN ECOLI_DATA D2
    ON D1.ID=D2.PARENT_ID
GROUP BY D1.ID
ORDER BY D1.ID