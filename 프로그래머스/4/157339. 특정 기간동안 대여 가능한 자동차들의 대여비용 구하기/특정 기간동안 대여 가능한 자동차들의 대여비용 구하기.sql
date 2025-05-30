SELECT 
    DISTINCT(C.CAR_ID), 
    C.CAR_TYPE,
    ROUND(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) / 100) * 30 AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON 
    P.DURATION_TYPE = '30일 이상' 
    AND C.CAR_TYPE = P.CAR_TYPE
WHERE 
    C.CAR_TYPE IN ('SUV', '세단')
    AND NOT EXISTS(
        SELECT 1
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
        WHERE 
            C.CAR_ID = H.CAR_ID
            AND (YEAR(END_DATE) = 2023 OR MONTH(END_DATE) IN (11, 12))
    )
    AND ROUND(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) / 100) * 30 BETWEEN 500000 AND 1999999
ORDER BY 
    FEE DESC,
    C.CAR_TYPE ASC,
    C.CAR_ID DESC 