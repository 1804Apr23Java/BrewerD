--CREATE USER challenge2
--IDENTIFIED BY challenge2
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT connect to challenge2;
--GRANT resource to challenge2;
--GRANT create session TO challenge2;
--GRANT create table TO challenge2;
--GRANT create view TO challenge2;

conn challenge2/challenge2

CREATE TABLE EMPLOYEE (
EMPLOYEE_ID NUMBER PRIMARY KEY,
EMP_FIRSTNAME VARCHAR(100),
EMP_LASTNAME VARCHAR(100),
DEPARTMENT_ID NUMBER,
SALARY NUMBER,
EMP_EMAIL VARCHAR(100));
/
CREATE TABLE DEPARTMENT (
DEPARTMENT_ID NUMBER PRIMARY KEY,
DEPARTMENT_NAME VARCHAR(100));
/
ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_DEPARTMENT
FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID);
/

CREATE SEQUENCE SQ_EMPLOYEE_ID
START WITH 1
INCREMENT BY 1;
/
CREATE SEQUENCE SQ_DEPARTMENT_ID
START WITH 1
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER TR_EMP_INSERT
BEFORE
INSERT ON EMPLOYEE
FOR EACH ROW
    BEGIN
    SELECT SQ_EMPLOYEE_ID.NEXTVAL
    INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TR_DEP_INSERT
BEFORE
INSERT ON DEPARTMENT
FOR EACH ROW
    BEGIN
    SELECT SQ_DEPARTMENT_ID.NEXTVAL
    INTO :NEW.DEPARTMENT_ID FROM DUAL;
END;
/
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES ('Dave', 'Brewer', 1, 99999, 'dave.guido.brewer@revature.com');
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES ('Michael', 'Scott', 2, 45000, 'michael.scott@DunderMifflin.com');
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES ('Pam', 'Creed', 1, 1000000, 'pam@madeup.com');
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES ('Sara', 'Lynn', 2, 25000, 'email@spam.com');
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES ('Willam', 'Herst', 3, 5000, 'poor@dude.com');
INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES ('Some', 'Person', 3, 36000, 'anon@omous.com');
/
INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Sales');
INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('HR');
INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Management');

--CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE (DEP_ID IN DEPARTMENT.DEPARTMENT_ID%TYPE, NEWAVG OUT NUMBER)
--AS
--IDEXISTS NUMBER(1);
--BEGIN
--        SELECT * FROM DEPARTMENT
--        WHERE EXISTS(
--            SELECT DEPARTMENT.DEPARTMENT_ID
--            FROM DEPARTMENT
--            WHERE DEPARTMENT.DEPARTMENT_ID = IDEXISTS);
--            DBMS_OUTPUT.put_line('Is that a valid dep id?');
--            
--    FOR EACH ROW
--        
--END;