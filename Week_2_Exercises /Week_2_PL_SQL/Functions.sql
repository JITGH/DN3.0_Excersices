/* 
                           Exercise 4: Functions

Scenario 1: Calculate the age of customers for eligibility checks.
o Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years.
*/

DELIMITER //
CREATE FUNCTION CalculateAge(dob DATE) RETURNS INT
    DETERMINISTIC
    READS SQL DATA
BEGIN
    DECLARE age INT;
    SET age = TIMESTAMPDIFF(YEAR, dob, CURDATE());
    RETURN age;
END //
DELIMITER ;
/*
Scenario 2: The bank needs to compute the monthly installment for a loan.
o	Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.
*/

DELIMITER //
CREATE FUNCTION CalculateMonthlyInstallment (loanAmount DECIMAL(10,2), interestRate DECIMAL(5,2), loanDurationYears INT) RETURNS DECIMAL(10,2)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE monthlyRate DECIMAL(5,2);
    DECLARE numberOfPayments INT;
    DECLARE monthlyInstallment DECIMAL(10,2);
    
	SET monthlyRate = interestRate / 1200;
    SET numberOfPayments = loanDurationYears * 12;
    SET monthlyInstallment = loanAmount * monthlyRate / (1 - POWER(1 + monthlyRate, -numberOfPayments));
    
    RETURN monthlyInstallment;
    END//
DELIMITER ;

/*
Scenario 3: Check if a customer has sufficient balance before making a transaction.
o Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.
*/
DELIMITER //
CREATE FUNCTION HasSufficientBalance(accountID INT, amount DECIMAL(10,2)) RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
DECLARE balance DECIMAL(10,2);
SET balance = (SELECT Balance FROM Accounts WHERE AccountID = accountID);
    RETURN balance >= amount;
END//
DELIMITER ;
