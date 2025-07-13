DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans;

    v_new_rate NUMBER;
BEGIN
    FOR loan_rec IN loan_cursor LOOP
        IF loan_rec.LoanAmount > 1000000 THEN
            v_new_rate := loan_rec.InterestRate + 1;
        ELSE
            v_new_rate := loan_rec.InterestRate + 0.5;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = loan_rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || loan_rec.LoanID ||
                             ' | Old Rate: ' || loan_rec.InterestRate ||
                             '% → New Rate: ' || v_new_rate || '%');
    END LOOP;

    COMMIT;
END;
/