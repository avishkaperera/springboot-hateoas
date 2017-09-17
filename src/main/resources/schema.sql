CREATE TABLE CUSTOMERS(
  CUSTOMER_ID INT PRIMARY KEY,
  CUSTOMER_NAME VARCHAR(100)
);

CREATE TABLE ORDERS(
  ORDER_ID INT PRIMARY KEY,
  PRICE INT,
  QUANTITY INT,
  CUSTOMER_ID INT,
  FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID)
);