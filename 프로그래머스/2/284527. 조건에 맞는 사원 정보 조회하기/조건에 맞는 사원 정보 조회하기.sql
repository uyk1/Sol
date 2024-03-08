SELECT SUM(G.SCORE) SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM HR_GRADE G
    INNER JOIN HR_EMPLOYEES E
    ON G.EMP_NO = E.EMP_NO
GROUP BY G.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;