-- PROGRAMMERS #59414 · DATETIME에서 DATE로 형 변환
-- https://school.programmers.co.kr/learn/courses/30/lessons/59414
-- Solved At: 2026-11-02 10:49:34 KST
-- Language: MySQL

-- 코드를 입력하세요
select animal_id, name, date_format(datetime, "%Y-%m-%d") as 날짜
from animal_ins
order by animal_id
