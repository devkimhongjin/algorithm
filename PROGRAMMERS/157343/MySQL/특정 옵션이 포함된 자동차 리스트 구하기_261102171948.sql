-- PROGRAMMERS #157343 · 특정 옵션이 포함된 자동차 리스트 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/157343
-- Solved At: 2026-11-02 17:19:48 KST
-- Language: MySQL

select car_id, car_type, daily_fee, options
from car_rental_company_car
where options like '%네비게이션%'
order by car_id desc