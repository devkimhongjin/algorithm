-- PROGRAMMERS #284527 · 조건에 맞는 사원 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/284527
-- Solved At: 2026-11-03 14:10:24 KST
-- Language: MySQL

SELECT
    SUM(SCORE) AS SCORE,
    E.EMP_NO,
    EMP_NAME,
    POSITION,
    EMAIL
FROM HR_EMPLOYEES E
JOIN HR_GRADE G ON E.EMP_NO=G.EMP_NO 
GROUP BY EMP_NO
ORDER BY SCORE DESC
LIMIT 1