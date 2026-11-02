-- PROGRAMMERS #298517 · 가장 큰 물고기 10마리 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/298517
-- Solved At: 2026-11-02 17:00:06 KST
-- Language: MySQL

-- 코드를 작성해주세요
select id, length
from fish_info
where length>10
order by length desc, id
limit 10;

