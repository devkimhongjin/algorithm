-- PROGRAMMERS #299305 · 대장균들의 자식의 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/299305
-- Solved At: 2026-11-04 16:04:45 KST
-- Language: MySQL

SELECT 
    ID,
    (SELECT COUNT(*)
     FROM ECOLI_DATA
     WHERE PARENT_ID = D.ID
    ) AS CHILD_COUNT
FROM ECOLI_DATA D
ORDER BY ID;