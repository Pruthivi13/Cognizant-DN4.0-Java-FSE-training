DECLARE
    CURSOR txn_cursor IS
        SELECT AccountID, TransactionDate, Amount, TransactionType
        FROM Transactions
        WHERE TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY AccountID, TransactionDate;
BEGIN
    FOR txn_rec IN txn_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || txn_rec.AccountID);
        DBMS_OUTPUT.PUT_LINE('Date: ' || txn_rec.TransactionDate || 
                             ', Type: ' || txn_rec.TransactionType || 
                             ', Amount: ' || txn_rec.Amount);
        DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
    END LOOP;
END;
/