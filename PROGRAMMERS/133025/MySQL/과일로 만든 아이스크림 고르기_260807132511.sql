-- PROGRAMMERS #133025 · 과일로 만든 아이스크림 고르기
-- https://school.programmers.co.kr/learn/courses/30/lessons/133025
-- Solved At: 2026-08-07 13:25:11 KST
-- Language: MySQL

SELECT F.FLAVOR
FROM FIRST_HALF F
JOIN ICECREAM_INFO I
    ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER >= 3000
  AND I.INGREDIENT_TYPE = 'fruit_based';