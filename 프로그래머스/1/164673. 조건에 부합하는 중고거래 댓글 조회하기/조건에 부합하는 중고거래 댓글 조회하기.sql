-- 코드를 입력하세요
SELECT UB.TITLE, UB.BOARD_ID, UR.REPLY_ID, UR.WRITER_ID,  UR.CONTENTS, DATE_FORMAT(UR.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
FROM USED_GOODS_BOARD AS UB, USED_GOODS_REPLY AS UR
WHERE UB.CREATED_DATE LIKE '2022-10%' and UB.BOARD_ID = UR.BOARD_ID
ORDER BY UR.created_date, UB.title