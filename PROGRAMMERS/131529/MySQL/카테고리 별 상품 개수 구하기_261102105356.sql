-- PROGRAMMERS #131529 · 카테고리 별 상품 개수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131529
-- Solved At: 2026-11-02 10:53:56 KST
-- Language: MySQL

-- 코드를 입력하세요
select substr(product_code, 1, 2) as category, count(*) as products
from product
group by category
order by category
