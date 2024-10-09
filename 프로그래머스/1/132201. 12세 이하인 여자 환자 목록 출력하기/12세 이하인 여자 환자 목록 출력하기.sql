-- 코드를 입력하세요
SELECT PT_NAME, PT_NO,  GEND_CD, AGE, if(TLNO is NULL, 'NONE', TLNO)  TLNO
from PATIENT
where GEND_CD = "W" and AGE <= 12
oRDER by age desc, PT_NAME asc