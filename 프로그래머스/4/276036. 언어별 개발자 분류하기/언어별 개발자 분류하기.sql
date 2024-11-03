WITH t AS (
    SELECT (
        CASE
            WHEN ID IN (
                SELECT DISTINCT(ID)
                FROM DEVELOPERS as D, SKILLCODES as S
                WHERE (D.SKILL_CODE & S.CODE) > 0 
                    AND SKILL_CODE & (SELECT S.CODE FROM SKILLCODES S WHERE NAME = 'Python') > 0
                    AND S.CATEGORY = 'Front End'
                GROUP BY ID
            ) THEN 'A'
            WHEN ID IN (
                SELECT DISTINCT(ID)
                FROM DEVELOPERS as D, SKILLCODES as S
                WHERE (D.SKILL_CODE & S.CODE) > 0
                    AND S.NAME = 'C#'
                GROUP BY ID
            ) THEN 'B'
            WHEN ID IN (
                SELECT DISTINCT(ID)
                FROM DEVELOPERS as D, SKILLCODES as S
                WHERE (D.SKILL_CODE & S.CODE) > 0
                    AND S.CATEGORY = 'Front End'
                GROUP BY ID
            ) THEN 'C' END
    ) as GRADE, ID, EMAIL
    FROM DEVELOPERS D
    GROUP BY ID, EMAIL
)

SELECT * FROM t
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID