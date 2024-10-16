-- 코드를 입력하세요
SELECT p.MEMBER_NAME, r.REVIEW_TEXT, DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM MEMBER_PROFILE p 
JOIN (
    SELECT MEMBER_ID, REVIEW_TEXT, REVIEW_DATE
    FROM REST_REVIEW
    WHERE MEMBER_ID = (
        SELECT MEMBER_ID 
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        ORDER BY COUNT(*) DESC
        LIMIT 1
          )) as r
          ON p.MEMBER_ID = r.MEMBER_ID
          order by REVIEW_DATE asc, REVIEW_TEXT