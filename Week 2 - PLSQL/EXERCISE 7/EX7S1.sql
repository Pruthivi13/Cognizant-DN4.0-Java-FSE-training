CREATE SEQUENCE customer_seq START WITH 4 INCREMENT BY 1;

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER,
        p_isvip VARCHAR2
    );

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_isvip VARCHAR2
    );

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER,
        p_isvip VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, ISVIP)
        VALUES (customer_seq.NEXTVAL, p_name, p_dob, p_balance, SYSDATE, p_isvip);
    END;

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_isvip VARCHAR2
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            ISVIP = p_isvip,
            LastModified = SYSDATE
        WHERE CustomerID = p_id;
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_id;
        RETURN v_balance;
    END;

END CustomerManagement;
/

BEGIN
  CustomerManagement.AddCustomer('Priya Mehta', TO_DATE('1994-09-10', 'YYYY-MM-DD'), 18000, 'NO');
END;
/