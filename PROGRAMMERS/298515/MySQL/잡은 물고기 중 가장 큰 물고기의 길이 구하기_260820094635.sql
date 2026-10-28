-- PROGRAMMERS #298515 · 잡은 물고기 중 가장 큰 물고기의 길이 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/298515
-- Solved At: 2026-08-20 09:46:35 KST
-- Language: MySQL

SELECT CONCAT(MAX(LENGTH), "cm") AS MAX_LENGTH
FROM FISH_INFO