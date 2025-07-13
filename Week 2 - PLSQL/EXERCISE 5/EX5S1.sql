CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

UPDATE Customers
SET Name = 'John D.'
WHERE CustomerID = 1;

SELECT LastModified FROM Customers WHERE CustomerID = 1;