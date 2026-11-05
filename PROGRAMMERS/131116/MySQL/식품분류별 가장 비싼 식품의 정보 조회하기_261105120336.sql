-- PROGRAMMERS #131116 · 식품분류별 가장 비싼 식품의 정보 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131116
-- Solved At: 2026-11-05 12:03:36 KST
-- Language: MySQL

SELECT CATEGORY, PRICE, PRODUCT_NAME 
FROM FOOD_PRODUCT 
WHERE (CATEGORY, PRICE) IN (
    SELECT CATEGORY, MAX(PRICE) 
    FROM FOOD_PRODUCT 
    WHERE CATEGORY IN ('과자', '국', '김치', '식용유') 
    GROUP BY CATEGORY 
) 
ORDER BY PRICE DESC;