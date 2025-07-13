CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
END;
/