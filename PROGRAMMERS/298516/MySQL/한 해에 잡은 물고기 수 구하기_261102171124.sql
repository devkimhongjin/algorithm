-- PROGRAMMERS #298516 · 한 해에 잡은 물고기 수 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/298516
-- Solved At: 2026-11-02 17:11:24 KST
-- Language: MySQL

-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info
where year(time)=2021
