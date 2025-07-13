BEGIN
  FOR loan IN (
    SELECT L.LoanID, C.Name
    FROM Loans L JOIN Customers C ON L.CustomerID = C.CustomerID
    WHERE L.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan.LoanID || ' for customer ' || loan.Name || ' is due soon.');
  END LOOP;
END;