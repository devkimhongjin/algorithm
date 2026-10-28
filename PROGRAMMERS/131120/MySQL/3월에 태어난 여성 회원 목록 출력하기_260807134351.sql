-- PROGRAMMERS #131120 · 3월에 태어난 여성 회원 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/131120
-- Solved At: 2026-08-07 13:43:51 KST
-- Language: MySQL

SELECT
    MEMBER_ID,
    MEMBER_NAME,
    GENDER,
    DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE SUBSTRING(DATE_OF_BIRTH, 6, 2) = '03'
AND GENDER = 'W'
AND TLNO != 'NULL'
ORDER BY MEMBER_ID