-- PROGRAMMERS #301646 · 특정 형질을 가지는 대장균 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/301646
-- Solved At: 2026-11-02 16:57:40 KST
-- Language: MySQL

-- 코드를 작성해주세요
select count(*)
from ecoli_data
where (genotype & 2) = 0
and ((genotype & 1) > 0 or (genotype & 4) > 0);