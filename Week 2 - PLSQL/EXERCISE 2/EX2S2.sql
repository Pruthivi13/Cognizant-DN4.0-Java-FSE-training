CREATE OR REPLACE PROCEDURE UpdateSalary (
  p_emp_id     IN NUMBER,
  p_percentage IN NUMBER
) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percentage / 100)
  WHERE EmployeeID = p_emp_id;

  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_emp_id || ' does not exist.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
    COMMIT;
  END IF;

EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Update failed: ' || SQLERRM);
END;
/

BEGIN
    UpdateSalary(1, 10);  -- 10% raise for Alice
END;

SELECT * FROM Employees WHERE EmployeeID = 1;