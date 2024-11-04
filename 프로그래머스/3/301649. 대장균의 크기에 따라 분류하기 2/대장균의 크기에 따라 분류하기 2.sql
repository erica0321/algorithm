SELECT A.ID, (CASE
                WHEN A.PER <= 0.25 THEN 'CRITICAL'
                WHEN A.PER <= 0.5 THEN 'HIGH'
                WHEN A.PER <= 0.75 THEN 'MEDIUM'
                ELSE 'LOW' END
             ) as COLONY_NAME
FROM (
    SELECT ID, PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) as PER
    FROm ECOLI_DATA
    ) as A
ORDER BY A.ID