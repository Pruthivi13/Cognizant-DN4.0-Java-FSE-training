CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_acc_id NUMBER,
        p_cust_id NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_acc_id NUMBER
    );

    FUNCTION GetTotalBalance(
        p_cust_id NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/



CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_acc_id NUMBER,
        p_cust_id NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_acc_id, p_cust_id, p_type, p_balance, SYSDATE);
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_acc_id NUMBER
    ) IS
    BEGIN
        UPDATE Accounts
        SET Balance = 0,
            LastModified = SYSDATE
        WHERE AccountID = p_acc_id;
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_cust_id NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER := 0;
    BEGIN
        SELECT NVL(SUM(Balance), 0)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_cust_id;

        RETURN v_total;
    END GetTotalBalance;

END AccountOperations;
/



BEGIN
    -- Open an account for customer 3
    AccountOperations.OpenAccount(301, 3, 'Savings', 15000);

    -- Close account 301
    AccountOperations.CloseAccount(301);

    -- Get total balance for customer 3
    DBMS_OUTPUT.PUT_LINE('Total Balance: ?' || AccountOperations.GetTotalBalance(3));
END;
/