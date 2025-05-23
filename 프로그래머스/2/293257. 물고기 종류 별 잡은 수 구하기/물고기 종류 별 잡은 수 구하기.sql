SELECT COUNT(b.ID) as FISH_COUNT, a.FISH_NAME
FROM FISH_NAME_INFO as a
JOIN FISH_INFO as b
ON a.FISH_TYPE = b.FISH_TYPE
GROUP BY a.FISH_NAME
ORDER BY FISH_COUNT DESC