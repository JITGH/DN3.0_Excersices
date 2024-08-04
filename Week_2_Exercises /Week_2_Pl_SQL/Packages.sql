/*
                                 Exercise 7: Packages

Scenario 1: Group all customer-related procedures and functions into a package.
o	Question: Create a package CustomerManagement with procedures for adding a new customer, updating customer details, and a function to get customer balance.
*/

DELIMITER //
CREATE PACKAGE CustomerManagement
AS
    PROCEDURE AddCustomer(p_CustomerID INT, p_Name VARCHAR(100), p_DOB DATE, p_Balance DECIMAL(10,2));
    PROCEDURE UpdateCustomerDetails(p_CustomerID INT, p_Name VARCHAR(100), p_DOB DATE);
    FUNCTION GetCustomerBalance(p_CustomerID INT) RETURNS DECIMAL(10,2);
END CustomerManagement;

CREATE PACKAGE BODY CustomerManagement
AS
    PROCEDURE AddCustomer(p_CustomerID INT, p_Name VARCHAR(100), p_DOB DATE, p_Balance DECIMAL(10,2))
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, CURRENT_DATE());
    END;

    PROCEDURE UpdateCustomerDetails(p_CustomerID INT, p_Name VARCHAR(100), p_DOB DATE)
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, LastModified = CURRENT_DATE()
        WHERE CustomerID = p_CustomerID;
    END;

    FUNCTION GetCustomerBalance(p_CustomerID INT) RETURNS DECIMAL(10,2)
    BEGIN
        RETURN (SELECT Balance FROM Customers WHERE CustomerID = p_CustomerID);
    END;
END CustomerManagement  //
DELIMITER ;
/*
Scenario 2: Create a package to manage employee data.
o	Question: Write a package EmployeeManagement with procedures to hire new employees, update employee details, and a function to calculate annual salary.
*/

DELIMITER //
CREATE PACKAGE EmployeeManagement
AS
    PROCEDURE HireEmployee(p_EmployeeID INT, p_Name VARCHAR(100), p_Position VARCHAR(50), p_Salary DECIMAL(10,2), p_Department VARCHAR(50), p_HireDate DATE);
    PROCEDURE UpdateEmployeeDetails(p_EmployeeID INT, p_Name VARCHAR(100), p_Position VARCHAR(50), p_Salary DECIMAL(10,2), p_Department VARCHAR(50));
    FUNCTION CalculateAnnualSalary(p_EmployeeID INT) RETURNS DECIMAL(10,2);
END EmployeeManagement;

CREATE PACKAGE BODY EmployeeManagement
AS
    PROCEDURE HireEmployee(p_EmployeeID INT, p_Name VARCHAR(100), p_Position VARCHAR(50), p_Salary DECIMAL(10,2), p_Department VARCHAR(50), p_HireDate DATE)
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
    END;

    PROCEDURE UpdateEmployeeDetails(p_EmployeeID INT, p_Name VARCHAR(100), p_Position VARCHAR(50), p_Salary DECIMAL(10,2), p_Department VARCHAR(50))
    BEGIN
        UPDATE Employees
        SET Name = p_Name, Position = p_Position, Salary = p_Salary, Department = p_Department
        WHERE EmployeeID = p_EmployeeID;
    END;

    FUNCTION CalculateAnnualSalary(p_EmployeeID INT) RETURNS DECIMAL(10,2)
    BEGIN
        RETURN (SELECT Salary * 12 FROM Employees WHERE EmployeeID = p_EmployeeID);
    END;
END EmployeeManagement //
DELIMITER ;

/*
Scenario 3: Group all account-related operations into a package.
o	Question: Create a package AccountOperations with procedures for opening a new account, closing an account, and a function to get the total balance of a customer across all accounts.
*/
DELIMITER //
CREATE PACKAGE AccountOperations
AS
    PROCEDURE OpenAccount(p_AccountID INT, p_CustomerID INT, p_AccountType VARCHAR(20), p_Balance DECIMAL(10,2));
    PROCEDURE CloseAccount(p_AccountID INT);
    FUNCTION GetTotalBalance(p_CustomerID INT) RETURNS DECIMAL(10,2);
END AccountOperations;

CREATE PACKAGE BODY AccountOperations
AS
    PROCEDURE OpenAccount(p_AccountID INT, p_CustomerID INT, p_AccountType VARCHAR(20), p_Balance DECIMAL(10,2))
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, CURRENT_DATE());
    END;

    PROCEDURE CloseAccount(p_AccountID INT)
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;
    END;

    FUNCTION GetTotalBalance(p_CustomerID INT) RETURNS DECIMAL(10,2)
    BEGIN
        RETURN (SELECT SUM(Balance) FROM Accounts WHERE CustomerID = p_CustomerID);
    END;
END AccountOperations //
DELIMITER ;
