-- PROGRAMMERS #132201 · 12세 이하인 여자 환자 목록 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- Solved At: 2026-08-07 13:36:06 KST
-- Language: MySQL

-- 코드를 입력하세요
SELECT 
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE GEND_CD = 'W'
AND AGE <= 12
ORDER BY AGE DESC, PT_NAME