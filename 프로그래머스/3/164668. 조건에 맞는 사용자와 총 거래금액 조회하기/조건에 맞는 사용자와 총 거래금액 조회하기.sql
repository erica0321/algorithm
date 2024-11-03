-- 코드를 입력하세요
SELECT b.USER_ID, b.NICKNAME, SUM(a.PRICE) as TOTAL_SALES
FROM USED_GOODS_BOARD as a
JOIN USED_GOODS_USER as b
ON a.WRITER_ID = b.USER_ID
WHERE a.STATUS = 'DONE'
GROUP BY b.USER_ID
HAVING SUM(a.PRICE) >= 700000
ORDER BY TOTAL_SALES ASC