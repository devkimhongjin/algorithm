-- PROGRAMMERS #59410 · NULL 처리하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59410
-- Solved At: 2026-11-02 10:45:27 KST
-- Language: MySQL

-- 코드를 입력하세요
select animal_type, IFNULL(name, "No name") as name, sex_upon_intake
from animal_ins
order by animal_id