-- PROGRAMMERS #77487 · 헤비 유저가 소유한 장소
-- https://school.programmers.co.kr/learn/courses/30/lessons/77487
-- Solved At: 2026-11-04 10:02:17 KST
-- Language: MySQL

SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(ID) >= 2
)
ORDER BY ID;