-- 코드를 작성해주세요
SELECT count(*) as FISH_COUNT FROM FISH_INFO as fi
JOIN FISH_NAME_INFO as fn ON fi.FISH_TYPE = fn.FISH_TYPE
WHERE FISH_NAME = "BASS" or FISH_NAME = "SNAPPER"