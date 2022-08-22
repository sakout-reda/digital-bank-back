CREATE SEQUENCE Customer_Seq START 1 INCREMENT 1;
CREATE SEQUENCE AccountOperation_Seq START 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS customer (
        id  bigserial NOT NULL PRIMARY KEY,
        adress varchar(255),
        birthday timestamp,
        email varchar(255),
        full_name varchar(255),
        phone_number varchar(255));

CREATE TABLE IF NOT EXISTS bank_account (
        id varchar(255) NOT NULL PRIMARY KEY,
        type varchar(4) NOT NULL,
        balance float8 NOT NULL,
        created_at timestamp,
        status varchar(255),
        over_draft float8,
        interest_rate float8,
        customer_id int8);
CREATE TABLE IF NOT EXISTS account_operation (
        id  bigserial NOT NULL PRIMARY KEY,
        amount float8 NOT NULL,
        description varchar(255),
        operation_date timestamp,
        type varchar(255),
        bank_account_id varchar(255));

ALTER TABLE bank_account
ADD CONSTRAINT customer_id_FK
FOREIGN KEY (customer_id) REFERENCES customer;

ALTER TABLE account_operation
ADD CONSTRAINT bank_account_id_FK
FOREIGN KEY (bank_account_id) REFERENCES bank_account;
