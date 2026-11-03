-- PROGRAMMERS #59046 · 루시와 엘라 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59046
-- Solved At: 2026-11-03 15:43:21 KST
-- Language: MySQL

SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN
    ('Lucy', 'Ella', 'Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID