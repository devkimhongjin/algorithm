-- PROGRAMMERS #293258 · 잔챙이 잡은 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/293258
-- Solved At: 2026-11-02 17:23:25 KST
-- Language: MySQL

select count(*) as fish_count
from fish_info
where length is null;