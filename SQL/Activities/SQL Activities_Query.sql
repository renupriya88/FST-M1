Activity1
----------
CREATE TABLE salesman (salesman_id int,salesman_name varchar2(20),salesman_city varchar2(20),commission int);
DESCRIBE salesman;

Activity2
------------
INSERT ALL
INTO salesman VALUES (5001,'James Hoog','New York',15)
INTO salesman VALUES (5002,'Nail Knite','Paris',13)
INTO salesman VALUES (5005,'Pit Alex','London',11)
INTO salesman VALUES (5006,'McLyon','Paris',14)
INTO salesman VALUES (5007,'Paul Adam','Rome',13)
INTO salesman VALUES (5003,'Lauson Hen','San Jose',12)
SELECT 1 FROM DUAL;

SELECT * from salesman;

Activity3
---------
SELECT salesman_id,salesman_city from salesman;
SELECT * from salesman WHERE salesman_city = 'Paris';
SELECT salesman_id,commission FROM salesman WHERE salesman_name = 'Paul Adam';

Activity4
----------
ALTER TABLE salesman
ADD (GRADE int);
DESCRIBE salesman;
UPDATE salesman
SET GRADE = 100;
SELECT * from salesman;

Activity5
----------------
UPDATE salesman
SET GRADE = 200
WHERE salesman_city = 'Rome';
UPDATE salesman
SET GRADE = 300
WHERE salesman_name = 'James Hoog';
UPDATE salesman
SET salesman_name = 'Pierre'
WHERE salesman_name = 'McLyon';
SELECT * from salesman;

Activity6Pre
----------------
create table orders(order_no int primary key, purchase_amount float, order_date date,customer_id int, salesman_id int);
INSERT ALL
INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;

Activity6
----------------
SELECT DISTINCT salesman_id from orders;
SELECT order_no, order_date from orders ORDER BY order_date ASC;
SELECT order_no from orders ORDER BY purchase_amount DESC;
SELECT * FROM orders WHERE purchase_amount < 500;
SELECT * FROM orders WHERE purchase_amount BETWEEN 1000 AND 2000;

Activity7
-------
SELECT SUM(purchase_amount) total_purchase 
from orders;

SELECT AVG(purchase_amount) average_purchase 
from orders;

SELECT MAX(purchase_amount) maximum_purchase 
from orders;

SELECT MIN(purchase_amount) minimum_purchase 
from orders;

SELECT COUNT(*) number_of_salesmen 
from orders;

SELECT COUNT(distinct salesman_id) number_of_salesmen 
from orders;


Activity8
----------
SELECT customer_id, MAX(purchase_amount) maximum_purchase 
from orders 
GROUP BY customer_id,purchase_amount;

SELECT customer_id, MAX(purchase_amount) maximum_purchase 
from orders 
GROUP BY customer_id;

SELECT customer_id, MAX(purchase_amount) maximum_purchase 
from orders 
GROUP BY customer_id, purchase_amount;

SELECT salesman_id, order_date, MAX(purchase_amount) max_purchase 
from orders 
HAVING order_date = TO_DATE('2012/08/17', 'YYYY/MM/DD') 
GROUP BY salesman_id, order_date;

SELECT customer_id, order_date, MAX(purchase_amount) max_purchase 
from orders 
HAVING MAX(purchase_amount) in (2030, 3450, 5760, 6000) 
GROUP BY customer_id, order_date;

Activity9Prep
    ----
create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);
INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

Activity9
-----------------
SELECT * FROM salesman 
INNER JOIN customers 
on salesman.SALESMAN_ID = customers.SALESMAN_ID;

SELECT * FROM customers 
INNER JOIN salesman 
on salesman.SALESMAN_ID = customers.SALESMAN_ID 
WHERE customers.GRADE < 300
ORDER BY customers.GRADE ASC;

SELECT * FROM customers 
INNER JOIN salesman 
on salesman.SALESMAN_ID = customers.SALESMAN_ID 
WHERE salesman.commission >12 
ORDER BY salesman.commission;

SELECT orders.order_no, orders.order_date, orders.PURCHASE_AMOUNT, customers.CUSTOMER_ID, salesman.SALESMAN_ID, 
salesman.COMMISSION 
FROM orders 
INNER JOIN salesman on orders.SALESMAN_ID = salesman.SALESMAN_ID 
INNER JOIN customers on orders.SALESMAN_ID = customers.SALESMAN_ID;

Activity10
----------------------
SELECT * from orders where SALESMAN_ID IN (SELECT distinct SALESMAN_ID from orders where CUSTOMER_ID = 3007);

SELECT * from orders where SALESMAN_ID IN (SELECT SALESMAN_ID from salesman where SALESMAN_CITY = 'New York');

SELECT GRADE, count(*) FROM customers GROUP BY GRADE HAVING GRADE > (SELECT AVG(GRADE) from customers where CITY = 'New York');

SELECT * FROM 
orders
WHERE SALESMAN_ID IN (SELECT SALESMAN_ID from salesman
WHERE COMMISSION IN (SELECT MAX(COMMISSION) from salesman));