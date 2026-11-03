-- PROGRAMMERS #59409 · 중성화 여부 파악하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59409
-- Solved At: 2026-11-03 15:41:15 KST
-- Language: MySQL

SELECT  ANIMAL_ID, NAME,
        CASE
            WHEN    SEX_UPON_INTAKE LIKE 'Neutered%'
                OR  SEX_UPON_INTAKE LIKE 'Spayed%'
            THEN 'O'
            ELSE 'X'
        END AS 중성화
FROM    ANIMAL_INS