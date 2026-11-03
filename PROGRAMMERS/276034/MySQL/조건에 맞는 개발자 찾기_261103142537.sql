-- PROGRAMMERS #276034 · 조건에 맞는 개발자 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/276034
-- Solved At: 2026-11-03 14:25:37 KST
-- Language: MySQL

SELECT  ID, EMAIL, FIRST_NAME, LAST_NAME
FROM    DEVELOPERS
WHERE   SKILL_CODE & (
                        SELECT CODE
                        FROM SKILLCODES
                        WHERE   NAME='Python'
                    )
OR      SKILL_CODE & (
                        SELECT CODE
                        FROM SKILLCODES
                        WHERE   NAME='C#'
                    )
ORDER BY    ID