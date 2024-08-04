/*            Exercise 1: Control Structures

Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
o Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
*/
DELIMITER //
CREATE PROCEDURE ApplyDiscountToSeniorCustomers()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE customer_id INT;
    DECLARE current_interest_rate DECIMAL(5, 2);
    DECLARE age INT;

    DECLARE customer_cursor CURSOR FOR
        SELECT id, loan_interest_rate, TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) AS age
        FROM customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN customer_cursor;

    read_loop: LOOP
        FETCH customer_cursor INTO customer_id, current_interest_rate, age;
        IF done THEN
            LEAVE read_loop;
        END IF;

        IF age > 60 THEN
            SET current_interest_rate = current_interest_rate - (current_interest_rate * 0.01);
            UPDATE customers
            SET loan_interest_rate = current_interest_rate
            WHERE id = customer_id;
        END IF;
    END LOOP;

    CLOSE customer_cursor;
END //
DELIMITER ;
CALL ApplyDiscountToSeniorCustomers();
DELIMITER //

/*Scenario 2: A customer can be promoted to VIP status based on their balance.
--o Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
*/

CREATE PROCEDURE PromoteToVIP()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE customer_id INT;
    DECLARE balance DECIMAL(10, 2);

    DECLARE customer_cursor CURSOR FOR
        SELECT CustomerID, Balance FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN customer_cursor;

    read_loop: LOOP
        FETCH customer_cursor INTO customer_id, balance;
        IF done THEN
            LEAVE read_loop;
        END IF;

        IF balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = customer_id;
        END IF;
    END LOOP;

    CLOSE customer_cursor;
END //
DELIMITER ;
CALL PromoteToVIP();
DELIMITER //


/*Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
o	Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.
*/


CREATE PROCEDURE SendLoanReminders()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE loan_id INT;
    DECLARE customer_id INT;
    DECLARE due_date DATE;
    DECLARE loan_cursor CURSOR FOR
        SELECT LoanID, CustomerID, EndDate
        FROM Loans
        WHERE EndDate BETWEEN CURDATE() AND CURDATE() + INTERVAL 30 DAY;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    OPEN loan_cursor;
    read_loop: LOOP
        FETCH loan_cursor INTO loan_id, customer_id, due_date;
        IF done THEN
            LEAVE read_loop;
        END IF;
        SELECT CONCAT('Reminder: Customer ', customer_id, ', your loan ', loan_id, ' is due on ', due_date) AS ReminderMessage;
    END LOOP;

    CLOSE loan_cursor;
END //
DELIMITER ;
CALL SendLoanReminders();

