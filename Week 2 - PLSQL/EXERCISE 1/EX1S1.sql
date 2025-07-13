BEGIN
  FOR cust IN (SELECT CustomerID FROM Customers WHERE MONTHS_BETWEEN(SYSDATE, DOB)/12 > 60) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = cust.CustomerID;
  END LOOP;
  COMMIT;
END;