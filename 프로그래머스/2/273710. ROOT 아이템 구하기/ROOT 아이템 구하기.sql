-- 코드를 작성해주세요
SELECT a.ITEM_ID, a.ITEM_NAME
FROM ITEM_INFO as a
JOIN ITEM_TREE as b ON a.ITEM_ID = b.ITEM_ID
WHERE b.PARENT_ITEM_ID IS NULL