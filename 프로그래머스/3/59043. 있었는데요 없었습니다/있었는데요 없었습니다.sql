-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS as i
JOIN ANIMAL_OUTS as o
ON i.ANIMAL_ID = o.ANIMAL_id
WHERE i.DATETIME > o.DATETIME
ORDER BY i.DATETIME asc