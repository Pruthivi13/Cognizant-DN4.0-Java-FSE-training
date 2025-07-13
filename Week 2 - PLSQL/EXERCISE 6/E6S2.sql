DECLARE
    CURSOR cust_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;

    v_fee CONSTANT NUMBER := 500;
BEGIN
    FOR cust_rec IN cust_cursor LOOP
        UPDATE Customers
        SET Balance = Balance - v_fee
        WHERE CustomerID = cust_rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ₹' || v_fee || 
                             ' applied to Customer ID: ' || cust_rec.CustomerID);
    END LOOP;

    COMMIT;
END;
/