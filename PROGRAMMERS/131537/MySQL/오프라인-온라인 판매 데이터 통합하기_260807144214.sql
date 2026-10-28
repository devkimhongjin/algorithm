-- PROGRAMMERS #131537 · 오프라인/온라인 판매 데이터 통합하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131537
-- Solved At: 2026-08-07 14:42:14 KST
-- Language: MySQL

SELECT
    SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM (
    SELECT
        SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
    FROM ONLINE_SALE
    
    UNION ALL

    SELECT
        SALES_DATE,
        PRODUCT_ID,
        NULL AS USER_ID,
        SALES_AMOUNT
    FROM OFFLINE_SALE
) S WHERE SALES_DATE LIKE '2022-03%'
ORDER BY
    SALES_DATE,
    PRODUCT_ID,
    USER_ID