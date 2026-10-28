-- PROGRAMMERS #131115 · 가격이 제일 비싼 식품의 정보 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131115
-- Solved At: 2026-08-20 09:27:34 KST
-- Language: MySQL

SELECT *
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);