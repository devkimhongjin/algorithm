-- PROGRAMMERS #293261 · 물고기 종류 별 대어 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/293261
-- Solved At: 2026-08-20 09:43:20 KST
-- Language: MySQL

WITH RankedFish AS (
    SELECT 
        ID,
        FISH_TYPE,
        LENGTH,
        RANK() OVER (PARTITION BY FISH_TYPE ORDER BY LENGTH DESC) AS rank_num
    FROM FISH_INFO
)
SELECT 
    R.ID,
    I.FISH_NAME,
    R.LENGTH
FROM RankedFish R
JOIN FISH_NAME_INFO I 
  ON R.FISH_TYPE = I.FISH_TYPE
WHERE R.rank_num = 1;