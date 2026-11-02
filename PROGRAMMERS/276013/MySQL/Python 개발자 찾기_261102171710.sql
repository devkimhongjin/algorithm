-- PROGRAMMERS #276013 · Python 개발자 찾기
-- https://school.programmers.co.kr/learn/courses/30/lessons/276013
-- Solved At: 2026-11-02 17:17:10 KST
-- Language: MySQL

select id, email, first_name, last_name
from developer_infos
where
        skill_1='Python'
    or  skill_2='Python'
    or  skill_3='Python'
order by id
