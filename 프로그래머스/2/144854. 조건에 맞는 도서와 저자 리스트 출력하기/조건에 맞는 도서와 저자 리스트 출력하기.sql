-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK as B JOIN AUTHOR as A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = "경제"
ORDER BY PUBLISHED_DATE;