
-- 2.1 
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
/
--Task – Select all records from the Employee table where last name is King.=
SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.LASTNAME = 'King';
/
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE EMPLOYEE.FIRSTNAME = 'Andrew' AND EMPLOYEE.REPORTSTO IS NULL;
/
-- 2.2
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY ALBUM.TITLE DESC;
/
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CUSTOMER.CITY ASC;
/
-- 2.3
--Task – Insert two new records into Genre table 
INSERT INTO GENRE VALUES(26, 'Groove Metal');
INSERT INTO GENRE VALUES(27, 'Avant-Garde Metal');
/
--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(9, 'Bowie', 'David', 'Goblin King', NULL, TO_DATE('01-08-1947 00:00:00','mm-dd-yyyy hh24:mi:ss'), TO_DATE('6-27-1986 00:00:00','mm-dd-yyyy hh24:mi:ss'), 'That Castle', 'Labyrinth', 'LB', 'Goblin Kingdom', 'H4N SL0', '+1 (234) 567-8910', NULL, 'Jareth@GoblinKing.com'); 
INSERT INTO EMPLOYEE VALUES(10,'Hayden', 'Nicky', 'World Champion', NULL, TO_DATE('07-30-1981 00:00:00','mm-dd-yyyy hh24:mi:ss'), TO_DATE('05-22-2017 00:00:00','mm-dd-yyyy hh24:mi:ss'), '123 Racetrack Way', 'Owensboro', 'KY', 'Kentucky', 'FST 0NE', '+1 (109) 876-5432', NULL, 'Nicky@RC51.com'); 
/
--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER VALUES(60, 'Ernest', 'World', NULL, '123 Money Way','Modesto', 'CA', 'USA', 95356, '+1 (222) 222-2223', NULL, 'dude@bro.com', 2);
INSERT INTO CUSTOMER VALUES(61, 'Michael', 'Scott', NULL, '1 Dumb Guy','Scranton', 'PA', 'USA', 18503, '+1 (444) 555-6666', NULL, 'michaelscott@dundermifflin.com', 3);
/
-- 2.4
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMER.FIRSTNAME='Aaron' AND CUSTOMER.LASTNAME='Mitchell';
/
-Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE ARTIST.NAME = 'Creedence Clearwater Revival';
/
-- 2.5
--Task – Select all invoices with a billing address like “T%” 
SELECT INVOICEID
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/
--2.6
--Task – Select all invoices that have a total between 15 and 50
SELECT INVOICEID
FROM INVOICE
WHERE TOTAL BETWEEN 15 and 50;
/
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT EMPLOYEEID
FROM EMPLOYEE
WHERE HIREDATE 
BETWEEN TO_DATE('03/JUN/01', 'YY/MON/DD') AND TO_DATE ('04/MAR/01', 'YY/MON/DD');
/
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE
FROM INVOICELINE
WHERE INVOICEID IN (
    SELECT INVOICEID
    FROM INVOICE
    WHERE CUSTOMERID IN (
        SELECT CUSTOMERID
        FROM CUSTOMER
        WHERE CUSTOMER.FIRSTNAME='Robert' AND CUSTOMER.LASTNAME='Walter'));
/ 
DELETE
FROM INVOICE
WHERE CUSTOMERID IN (
    SELECT CUSTOMERID
    FROM CUSTOMER
    WHERE CUSTOMER.FIRSTNAME='Robert' AND CUSTOMER.LASTNAME='Walter');
/
DELETE
FROM CUSTOMER
WHERE CUSTOMER.FIRSTNAME='Robert' AND CUSTOMER.LASTNAME='Walter';
/
--3.1
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION FN_CURRENT_TIME
RETURN VARCHAR2 IS
CT VARCHAR2(100);
BEGIN
    CT := CURRENT_TIMESTAMP;
    RETURN CT;
END FN_CURRENT_TIME;
/
DECLARE
    MYTIME VARCHAR2(100);
BEGIN
    MYTIME := FN_CURRENT_TIME();
    DBMS_OUTPUT.PUT_LINE(MYTIME||' IS CURRENT TIME');
END;
/
--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION FN_LONGEST_NAME
RETURN NUMBER
AS ANSWER NUMBER;
BEGIN
   SELECT MAX(LENGTH(MEDIATYPE.NAME))
    INTO ANSWER
    FROM MEDIATYPE;
    RETURN (ANSWER);
END;
/
SELECT FN_LONGEST_NAME() FROM DUAL; -- NOTE TO SELF DUAL IS SUPER USEFUL
/
--3.2
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION FN_AVERAGE_INVOICE_TOTAL
RETURN NUMBER 
IS AVERAGE NUMBER(12,2);
BEGIN
    SELECT AVG(TOTAL) 
    INTO AVERAGE
    FROM INVOICE;
    RETURN AVERAGE;
END;
/
SELECT FN_AVERAGE_INVOICE_TOTAL() FROM DUAL; 
/
--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION FN_GET_MOST_EXPENSIVE_TRACK
RETURN NUMBER
IS ANSWER NUMBER(12,2);
BEGIN
    SELECT MAX(UNITPRICE) 
    INTO ANSWER
    FROM TRACK;
    RETURN ANSWER;
END;
/

SELECT FN_GET_MOST_EXPENSIVE_TRACK() FROM DUAL;
/
--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION FN_GET_AVG_INVOICELINE_PRICE
RETURN NUMBER
AS ANSWER NUMBER(12,2);
BEGIN
    SELECT AVG(UNITPRICE)
    INTO ANSWER
    FROM INVOICELINE;
    RETURN ANSWER;
END;
/
SELECT FN_GET_AVG_INVOICELINE_PRICE() FROM DUAL;
/

--3.4 ????
--Task – Create a function that returns all employees who are born after 1968.


--4.1 STORED PROCEDURES
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE SP_GET_FNAME_LNAME_EMPLOYEES (CUR OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN CUR FOR
    SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE;
END;
/
DECLARE
CUR SYS_REFCURSOR;
FNAME EMPLOYEE.FIRSTNAME%TYPE;
LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SP_GET_FNAME_LNAME_EMPLOYEES(CUR);
        LOOP
            FETCH CUR
            INTO FNAME,LNAME;
            EXIT WHEN CUR%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE(FNAME||' '||LNAME);
        END LOOP;
    CLOSE CUR;
END;
/            

--4.2
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE SP_UPDATE_EMPLOYEE(
EMPID IN EMPLOYEE.EMPLOYEEID%TYPE,
LNAME IN EMPLOYEE.LASTNAME%TYPE,
FNAME IN EMPLOYEE.FIRSTNAME%TYPE,
TITLL IN EMPLOYEE.TITLE%TYPE,
REPTO IN EMPLOYEE.REPORTSTO%TYPE,
BIDAY IN EMPLOYEE.BIRTHDATE%TYPE,
HIDAY IN EMPLOYEE.HIREDATE%TYPE,
ADRES IN EMPLOYEE.ADDRESS%TYPE,
CITYY IN EMPLOYEE.CITY%TYPE,
CNTRY IN EMPLOYEE.COUNTRY%TYPE,
PCODE IN EMPLOYEE.POSTALCODE%TYPE,
PHONN IN EMPLOYEE.PHONE%TYPE,
FAXX  IN EMPLOYEE.FAX%TYPE,
MAILL IN EMPLOYEE.EMAIL%TYPE) 
IS
BEGIN
    UPDATE EMPLOYEE SET 
    FIRSTNAME = FNAME,
    LASTNAME = LNAME,
    TITLE = TITLL,
    REPORTSTO = REPTO,
    BIRTHDATE = BIDAY,
    HIREDATE = HIDAY,
    ADDRESS = ADRES,
    CITY = CITYY,
    COUNTRY = CNTRY,
    POSTALCODE = PCODE,
    PHONE = PHONN,
    FAX = FAXX,
    EMAIL = MAILL
    WHERE EMPLOYEEID = EMPID;
    COMMIT;
END;
/

DECLARE
BEGIN
    SP_UPDATE_EMPLOYEE(1, 'Max', 'Mad', 'Road Warrior', null, '03-JAN-56', '21-MAY-82', '123 Wasteland Dr.', 'Melbourne', 'AUS', '66666', '+1 (209) 568-3237', '+1 (234) 987-5432', 'mad@max.com');
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE SP_GET_EMP_MANAGERS(
EMPID IN EMPLOYEE.EMPLOYEEID%TYPE,
MANID OUT EMPLOYEE.EMPLOYEEID%TYPE,
MANFNAME OUT EMPLOYEE.FIRSTNAME%TYPE,
MANLNAME OUT EMPLOYEE.LASTNAME%TYPE)

AS
BEGIN
    SELECT EMPLOYEE.EMPLOYEEID, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME
    INTO MANID, MANFNAME, MANLNAME
    FROM EMPLOYEE
    WHERE EMPLOYEE.EMPLOYEEID IN (
        SELECT EMPLOYEE.REPORTSTO
        FROM EMPLOYEE
        WHERE EMPID = EMPLOYEE.EMPLOYEEID);
END;
/
DECLARE
    MANID NUMBER;
    MANFNAME VARCHAR(150);
    MANLNAME VARCHAR(150);
BEGIN
    SP_GET_EMP_MANAGERS(6, MANID, MANFNAME, MANLNAME);
    DBMS_OUTPUT.PUT_LINE(MANID||' '||MANFNAME||' '||MANLNAME);
END;
/

--4.3
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE SP_GET_CUST_NAME_COMPANY(
CUSTID IN CUSTOMER.CUSTOMERID%TYPE,
CUSTFN OUT CUSTOMER.FIRSTNAME%TYPE,
CUSTLN OUT CUSTOMER.LASTNAME%TYPE,
CUSTCO OUT CUSTOMER.COMPANY%TYPE)
AS
BEGIN
    SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, CUSTOMER.COMPANY
    INTO CUSTFN, CUSTLN, CUSTCO
    FROM CUSTOMER
    WHERE CUSTOMER.CUSTOMERID = CUSTID;
END;
/
DECLARE
CUSTFNAME VARCHAR(150);
CUSTLNAME VARCHAR(150);
CUSTCO VARCHAR(150);
BEGIN
    SP_GET_CUST_NAME_COMPANY(5, CUSTFNAME, CUSTLNAME, CUSTCO);
    DBMS_OUTPUT.PUT_LINE('CUSTOMER NAME: '|| CUSTFNAME||' '||CUSTLNAME||' COMPANY: '||CUSTCO);
END;
/
--5.0
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--6.1
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_EMP_INSERT
AFTER
INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee Inserted.');
END;
/
INSERT INTO EMPLOYEE VALUES (11, 'Escobar', 'Pablol', 'Kingpin', 1, '01-DEC-49', '02-DEC-93', '123 Mexico St.', 'Mexico City', 'ME', 'Mexico', '12345', '+1 (100) 200-2000', '+1 (111) 111-1111', 'pablo@escobar.com');
COMMIT;
/
        
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_ALB_UPDATE
AFTER
UPDATE ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album Updated.');
END;
/

UPDATE ALBUM SET ALBUM.TITLE = 'Master of Reality' WHERE ALBUM.TITLE = 'Paranoid';
COMMIT; -- NOTE TRIGGER DOES NOT FIRE UNLESS CHANGES ARE COMMITED
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_CUSTOMER_DELETED
AFTER
DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer Deleted.');
END;
/
DELETE FROM CUSTOMER
WHERE CUSTOMER.CUSTOMERID = 60;
COMMIT;
--7.1
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER 
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/
--7.2
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER 
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
/
--7.3
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;
/
--7.4
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST CROSS JOIN ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME ASC;
/
--7.5
--Task – Perform a self-join on the employee table, joining on the reportsto column
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;
/