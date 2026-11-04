-- PROGRAMMERS #284529 · 부서별 평균 연봉 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/284529
-- Solved At: 2026-11-04 15:51:20 KST
-- Language: MySQL

SELECT
    D.DEPT_ID,
    D.DEPT_NAME_EN,
    ROUND(AVG(E.SAL)) AVG_SAL
FROM HR_DEPARTMENT D
JOIN HR_EMPLOYEES E
    ON D.DEPT_ID=E.DEPT_ID
GROUP BY E.DEPT_ID
ORDER BY AVG_SAL DESC