-- PROGRAMMERS #273711 · 업그레이드 된 아이템 구하기
-- https://school.programmers.co.kr/learn/courses/30/lessons/273711
-- Solved At: 2026-11-03 14:33:49 KST
-- Language: MySQL

SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (
                    SELECT T.ITEM_ID
                    FROM ITEM_INFO I
                    JOIN ITEM_TREE T
                        ON I.ITEM_ID=T.PARENT_ITEM_ID
                    WHERE RARITY='RARE'
                )
ORDER BY ITEM_ID DESC;