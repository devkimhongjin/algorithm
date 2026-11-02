-- PROGRAMMERS #301649 · 대장균의 크기에 따라 분류하기 2
-- https://school.programmers.co.kr/learn/courses/30/lessons/301649
-- Solved At: 2026-11-02 09:54:13 KST
-- Language: MySQL

WITH RankedEcoli AS (
    SELECT 
        ID,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS quartile
    FROM 
        ECOLI_DATA
)
SELECT 
    ID,
    CASE 
        WHEN quartile = 1 THEN 'CRITICAL'
        WHEN quartile = 2 THEN 'HIGH'
        WHEN quartile = 3 THEN 'MEDIUM'
        WHEN quartile = 4 THEN 'LOW'
    END AS COLONY_NAME
FROM 
    RankedEcoli
ORDER BY 
    ID ASC;
