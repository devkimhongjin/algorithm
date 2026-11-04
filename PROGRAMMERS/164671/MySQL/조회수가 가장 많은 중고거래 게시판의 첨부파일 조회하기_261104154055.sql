-- PROGRAMMERS #164671 · 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/164671
-- Solved At: 2026-11-04 15:40:55 KST
-- Language: MySQL

SELECT
    CONCAT(
        '/home/grep/src/',
        BOARD_ID, '/',
        FILE_ID,
        FILE_NAME,
        FILE_EXT
    )AS FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID = (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)
ORDER BY FILE_ID DESC