CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2,
        p_hiredate DATE
    );

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/


CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2,
        p_hiredate DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_dept, p_hiredate);
    END HireEmployee;

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_position VARCHAR2,
        p_salary NUMBER,
        p_dept VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Position = p_position,
            Salary = p_salary,
            Department = p_dept
        WHERE EmployeeID = p_id;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_id;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/


BEGIN
    -- Hire new employee
    EmployeeManagement.HireEmployee(101, 'Sneha R', 'Analyst', 50000, 'IT', TO_DATE('2024-06-01', 'YYYY-MM-DD'));

    -- Update employee
    EmployeeManagement.UpdateEmployee(101, 'Sneha Raj', 'Senior Analyst', 60000, 'IT');

    -- Show annual salary
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ?' || EmployeeManagement.CalculateAnnualSalary(101));
END;
/