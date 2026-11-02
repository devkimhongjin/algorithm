-- PROGRAMMERS #59041 · 동명 동물 수 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- Solved At: 2026-11-02 10:39:37 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT NAME, COUNT(*) AS 'COUNT'
FROM ANIMAL_INS
WHERE NAME is not null
GROUP BY NAME
HAVING COUNT(*) >= 2
ORDER BY NAME;