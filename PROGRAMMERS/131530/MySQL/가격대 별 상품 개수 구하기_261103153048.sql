-- PROGRAMMERS #131530 · 가격대 별 상품 개수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131530
-- Solved At: 2026-11-03 15:30:48 KST
-- Language: MySQL

SELECT
    10000 * (PRICE DIV 10000) PRICE_GROUP,
    COUNT(*) PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY PRICE_GROUP