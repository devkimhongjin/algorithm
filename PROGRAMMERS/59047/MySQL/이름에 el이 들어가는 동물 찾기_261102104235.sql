-- PROGRAMMERS #59047 · 이름에 el이 들어가는 동물 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/59047
-- Solved At: 2026-11-02 10:42:35 KST
-- Language: MySQL

-- 코드를 입력하세요
select animal_id, name
from animal_ins
where 
    animal_type = "Dog"
    and name like "%el%"
order by name ,animal_id