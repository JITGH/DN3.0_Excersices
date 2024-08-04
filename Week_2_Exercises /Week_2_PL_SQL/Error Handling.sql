/*                       Exercise 2: Error Handling

Scenario 1: Handle exceptions during fund transfers between accounts.
o	Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.
*/
DELIMITER //
CREATE PROCEDURE SafeTransferFunds(
    IN from_account INT, 
    IN to_account INT, 
    IN amount DECIMAL(10, 2))
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Error during funds transfer.');
    END;

    START TRANSACTION;

    IF (SELECT Balance FROM Accounts WHERE AccountID = from_account) < amount THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient funds';
    END IF;
    
    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;
    
    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;

    COMMIT;
END //
DELIMITER ;
CALL SafeTransferFunds(1, 2, 500);


/*Scenario 2: Manage errors when updating employee salaries.
o	Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.
*/
DELIMITER //
CREATE PROCEDURE UpdateSalary(
    IN emp_id INT, 
    IN percentage DECIMAL(5, 2))
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Error updating salary.');
    END;

    IF (SELECT COUNT(*) FROM Employees WHERE EmployeeID = emp_id) = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Employee ID does not exist';
    ELSE
        UPDATE Employees
        SET Salary = Salary + (Salary * percentage / 100)
        WHERE EmployeeID = emp_id;
    END IF;
END //
DELIMITER ;
CALL UpdateSalary(1, 10);

/*Scenario 3: Ensure data integrity when adding a new customer.
o Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.
*/
DELIMITER //
CREATE PROCEDURE AddNewCustomer(
    IN cust_id INT, 
    IN name VARCHAR(100), 
    IN dob DATE, 
    IN balance DECIMAL(10, 2))
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN

        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Error adding new customer.');
    END;

    IF (SELECT COUNT(*) FROM Customers WHERE CustomerID = cust_id) > 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Customer ID already exists';
    ELSE

        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (cust_id, name, dob, balance, NOW());
    END IF;
END //

DELIMITER ;
CALL AddNewCustomer(3, 'Alice Johnson', '1982-04-23', 2000);
