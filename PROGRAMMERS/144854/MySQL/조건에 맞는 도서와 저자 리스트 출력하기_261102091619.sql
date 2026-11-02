-- PROGRAMMERS #144854 · 조건에 맞는 도서와 저자 리스트 출력하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/144854
-- Solved At: 2026-11-02 09:16:19 KST
-- Language: MySQL

-- 코드를 입력하세요
select book_id, author_name, published_date
from book
join author
    on book.author_id = author.author_id
where category='경제'
order by published_date