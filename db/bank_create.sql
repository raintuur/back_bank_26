-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA public CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA public
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-14 09:17:49.891

-- tables
-- Table: account
CREATE TABLE account (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         number varchar(50)  NOT NULL,
                         description varchar(255)  NOT NULL,
                         status char(1)  NOT NULL,
                         balance bigint  NOT NULL,
                         CONSTRAINT account_ak_1 UNIQUE (number) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                         CONSTRAINT account_pk PRIMARY KEY (id)
);

-- Table: address
CREATE TABLE address (
                         id serial  NOT NULL,
                         city_id int  NOT NULL,
                         customer_id int  NULL,
                         location_id int  NULL,
                         street_name varchar(255)  NOT NULL,
                         start date  NOT NULL DEFAULT now(),
                         "end" date  NULL,
                         longitude decimal(6,2)  NULL,
                         latitude decimal(6,2)  NULL,
                         CONSTRAINT address_pk PRIMARY KEY (id)
);

-- Table: atm
CREATE TABLE atm (
                     id serial  NOT NULL,
                     location_id int  NOT NULL,
                     serial_number varchar(255)  NOT NULL,
                     status char(1)  NOT NULL DEFAULT 'A',
                     CONSTRAINT atm_pk PRIMARY KEY (id)
);

-- Table: atm_service
CREATE TABLE atm_service (
                             id serial  NOT NULL,
                             name varchar(255)  NOT NULL,
                             CONSTRAINT atm_service_pk PRIMARY KEY (id)
);

-- Table: atm_service_relation
CREATE TABLE atm_service_relation (
                                      id serial  NOT NULL,
                                      atm_id int  NOT NULL,
                                      atm_service_id int  NOT NULL,
                                      CONSTRAINT atm_service_relation_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT city_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         customer_id int  NOT NULL,
                         telephone varchar(255)  NOT NULL,
                         email varchar(255)  NOT NULL,
                         start date  NOT NULL DEFAULT now(),
                         "end" date  NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: customer
CREATE TABLE customer (
                          id serial  NOT NULL,
                          user_id int  NOT NULL,
                          first_name varchar(255)  NOT NULL,
                          last_name varchar(255)  NOT NULL,
                          personal_code varchar(255)  NOT NULL,
                          CONSTRAINT customer_ak_1 UNIQUE (personal_code) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                          CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          city_id int  NOT NULL,
                          name varchar(255)  NOT NULL,
                          status char(1)  NOT NULL DEFAULT 'A',
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      type varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: transaction
CREATE TABLE transaction (
                             id serial  NOT NULL,
                             account_id int  NOT NULL,
                             sender varchar(50)  NOT NULL,
                             receiver varchar(50)  NOT NULL,
                             description varchar(50)  NOT NULL,
                             amount bigint  NOT NULL,
                             direction char(1)  NOT NULL,
                             balance bigint  NOT NULL,
                             timestamp timestamp  NOT NULL,
                             CONSTRAINT transaction_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        username varchar(50)  NOT NULL,
                        password varchar(50)  NOT NULL,
                        CONSTRAINT user_ak_2 UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
                           id serial  NOT NULL,
                           user_id int  NOT NULL,
                           role_id int  NOT NULL,
                           CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: account_user (table: account)
ALTER TABLE account ADD CONSTRAINT account_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: address_city (table: address)
ALTER TABLE address ADD CONSTRAINT address_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: address_customer (table: address)
ALTER TABLE address ADD CONSTRAINT address_customer
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: address_location (table: address)
ALTER TABLE address ADD CONSTRAINT address_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: atm_location (table: atm)
ALTER TABLE atm ADD CONSTRAINT atm_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: atm_service_relation_atm (table: atm_service_relation)
ALTER TABLE atm_service_relation ADD CONSTRAINT atm_service_relation_atm
    FOREIGN KEY (atm_id)
        REFERENCES atm (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: atm_service_relation_atm_service (table: atm_service_relation)
ALTER TABLE atm_service_relation ADD CONSTRAINT atm_service_relation_atm_service
    FOREIGN KEY (atm_service_id)
        REFERENCES atm_service (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: contact_customer (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_customer
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: customer_user (table: customer)
ALTER TABLE customer ADD CONSTRAINT customer_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        ON DELETE  CASCADE
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_city (table: location)
ALTER TABLE location ADD CONSTRAINT location_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: statement_account (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT statement_account
    FOREIGN KEY (account_id)
        REFERENCES account (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

