CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    loan_amount IN NUMBER,
    annual_interest_rate IN NUMBER, -- in percentage e.g., 8 for 8%
    duration_years IN NUMBER
) RETURN NUMBER IS
    monthly_rate NUMBER;
    total_months NUMBER;
    emi NUMBER;
BEGIN
    monthly_rate := (annual_interest_rate / 12) / 100;
    total_months := duration_years * 12;
    
    IF monthly_rate = 0 THEN
        emi := loan_amount / total_months;
    ELSE
        emi := loan_amount * monthly_rate * POWER(1 + monthly_rate, total_months) / 
               (POWER(1 + monthly_rate, total_months) - 1);
    END IF;
    
    RETURN ROUND(emi, 2);
END;
/