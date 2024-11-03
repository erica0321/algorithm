-- 코드를 입력하세요
SELECT b.INGREDIENT_TYPE, SUM(a.TOTAL_ORDER) as TOTAL_ORDER
FROM FIRST_HALF as a
JOIN ICECREAM_INFO as b
ON a.FLAVOR = b.FLAVOR
GROUP BY b.INGREDIENT_TYPE
ORDER BY TOTAL_ORDER asc