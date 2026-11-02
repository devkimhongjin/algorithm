-- PROGRAMMERS #151138 · 자동차 대여 기록에서 장기/단기 대여 구분하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/151138
-- Solved At: 2026-11-02 17:09:14 KST
-- Language: MySQL

select  history_id,
        car_id,
        start_date,
        end_date,
        case    when datediff(end_date, start_date) + 1 >= 30 then '장기 대여'
                else '단기 대여'
        end as rent_type
from car_rental_company_rental_history
where start_date like '2022-09-%'
order by history_id desc