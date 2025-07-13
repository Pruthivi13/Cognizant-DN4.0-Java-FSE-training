CREATE OR REPLACE PROCEDURE AddNewCustomer (
  p_id      IN NUMBER,
  p_name    IN VARCHAR2,
  p_dob     IN DATE,
  p_balance IN NUMBER
) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_id || ' already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Insert failed: ' || SQLERRM);
END;
/

EXEC AddNewCustomer(3, 'Ravi Kumar', TO_DATE('1980-01-01', 'YYYY-MM-DD'), 12000);

SELECT * FROM Customers;

BEGIN
  ProcessMonthlyInterest;
END;
/