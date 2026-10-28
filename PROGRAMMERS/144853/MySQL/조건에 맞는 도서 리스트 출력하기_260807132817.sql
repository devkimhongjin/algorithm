-- PROGRAMMERS #144853 · 조건에 맞는 도서 리스트 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
-- Solved At: 2026-08-07 13:28:17 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT BOOK_ID, PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = '인문'
AND PUBLISHED_DATE LIKE '2021%'
ORDER BY PUBLISHED_DATE