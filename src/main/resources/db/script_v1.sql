
CREATE SCHEMA IF NOT EXISTS nordic_motorhome;
USE nordic_motorhome ;

######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.accesories ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.accesories (
    id INT NOT NULL AUTO_INCREMENT,
    price FLOAT NULL,
    name VARCHAR(15) NULL,
    image_location VARCHAR(45) NULL,
    motorhomes_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (motorhomes_id)
    REFERENCES nordic_motorhome.motorhomes (id));

######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.customer ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.customer (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(15) NULL,
    last_name VARCHAR(15) NULL,
    address VARCHAR(45) NULL,
    email VARCHAR(45) NULL,
    PRIMARY KEY (id));

######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.delivery_point ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.delivery_point (
    id INT NOT NULL AUTO_INCREMENT,
    address VARCHAR(45) NULL,
    PRIMARY KEY (id));


######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.motorhomes ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.motorhomes (
    id INT NOT NULL AUTO_INCREMENT,
    model VARCHAR(45) NULL,
    brand VARCHAR(45) NULL,
    image_file VARCHAR(45) NULL,
    price FLOAT NULL,
    accesories_idaccesories INT NOT NULL,
    service_states_idservice_states INT NOT NULL,
    accesories_list VARCHAR(50) NULL,
    PRIMARY KEY (id, accesories_idaccesories, service_states_idservice_states));

######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.reservation ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.reservation (
    id INT NOT NULL AUTO_INCREMENT,
    start_date DATE NULL,
    end_date DATE NULL,
    customer_id INT NOT NULL,
    motorhomes_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id)
    REFERENCES nordic_motorhome.customer (id),
    FOREIGN KEY (motorhomes_id)
    REFERENCES nordic_motorhome.motorhomes (id));

######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.sales ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.sales (
    id INT NOT NULL AUTO_INCREMENT,
    amount FLOAT NULL,
    date DATETIME NULL,
    reservation_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (reservation_id)
    REFERENCES nordic_motorhome.reservation (id));

######################################################################################

DROP TABLE IF EXISTS nordic_motorhome.service_states ;

CREATE TABLE IF NOT EXISTS nordic_motorhome.service_states (
    id INT NOT NULL AUTO_INCREMENT,
    damages LONGTEXT NULL,
    oil FLOAT NULL,
    water FLOAT NULL,
    service_statescol VARCHAR(45) NULL,
    date DATE NULL,
    motorhomes_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (motorhomes_id)
    REFERENCES nordic_motorhome.motorhomes (id));

######################################################################################
