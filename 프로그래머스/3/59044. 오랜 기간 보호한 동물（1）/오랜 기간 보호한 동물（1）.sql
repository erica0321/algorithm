-- 코드를 입력하세요
SELECT i.NAME, i.DATETIME
FROM ANIMAL_INS as i
WHERE NOT EXISTS (SELECT ANIMAL_ID FROM ANIMAL_OUTS o WHERE i.ANIMAL_ID = o.ANIMAL_ID)
ORDER BY DATETIME
LIMIT 3;
