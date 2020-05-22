CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8 ;
USE mydb ;

-- -----------------------------------------------------
-- Table mydb.accesories
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.accesories (
  idaccesories INT NOT NULL,
  price FLOAT NULL,
  name VARCHAR(15) NULL,
  image_location VARCHAR(45) NULL,
  PRIMARY KEY (idaccesories))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.customer
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.customer (
  idcustomer INT GENERATED ALWAYS AS () VIRTUAL,
  first_name VARCHAR(15) NULL,
  last_name VARCHAR(15) NULL,
  reservation_idreservation INT NOT NULL,
  reservation_delivery_point_iddelivery INT NOT NULL,
  reservation_delivery_point_motorhomes_idmotorhomes INT NOT NULL,
  reservation_delivery_point_motorhomes_accesories_idaccesories INT NOT NULL,
  reservation_delivery_point_motorhomes_reservation_idreservation INT NOT NULL,
  address VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  PRIMARY KEY idcustomer
  CONSTRAINT fk_customer_reservation1
    FOREIGN KEY (reservation_idreservation , reservation_delivery_point_iddelivery , reservation_delivery_point_motorhomes_idmotorhomes , reservation_delivery_point_motorhomes_accesories_idaccesories , reservation_delivery_point_motorhomes_reservation_idreservation)
    REFERENCES mydb.reservation (idreservation , delivery_point_iddelivery , delivery_point_motorhomes_idmotorhomes , delivery_point_motorhomes_accesories_idaccesories , delivery_point_motorhomes_reservation_idreservation)



-- -----------------------------------------------------
-- Table mydb.delivery_point
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.delivery_point (
  iddelivery INT NOT NULL,
  motorhomes_idmotorhomes INT NOT NULL,
  motorhomes_accesories_idaccesories INT NOT NULL,
  motorhomes_reservation_idreservation INT NOT NULL,
  address VARCHAR(45) NULL,
  PRIMARY KEY (iddelivery, motorhomes_idmotorhomes, motorhomes_accesories_idaccesories, motorhomes_reservation_idreservation))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.motorhomes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.motorhomes (
  idmotorhomes INT GENERATED ALWAYS AS () VIRTUAL,
  model VARCHAR(45) NULL,
  brand VARCHAR(45) NULL,
  price VARCHAR(45) NULL,
  motorhomescol FLOAT NULL,
  accesories_idaccesories INT NOT NULL,
  reservation_idreservation INT NOT NULL,
  service_states_idservice_states INT NOT NULL,
  PRIMARY KEY (idmotorhomes, accesories_idaccesories, reservation_idreservation, service_states_idservice_states),
  INDEX fk_motorhomes_accesories_idx (accesories_idaccesories ASC) VISIBLE,
  INDEX fk_motorhomes_reservation1_idx (reservation_idreservation ASC) VISIBLE,
  INDEX fk_motorhomes_service_states1_idx (service_states_idservice_states ASC) VISIBLE,
  CONSTRAINT fk_motorhomes_accesories
    FOREIGN KEY (accesories_idaccesories)
    REFERENCES mydb.accesories (idaccesories)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_motorhomes_reservation1
    FOREIGN KEY (reservation_idreservation)
    REFERENCES mydb.reservation (idreservation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_motorhomes_service_states1
    FOREIGN KEY (service_states_idservice_states)
    REFERENCES mydb.service_states (idservice_states)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.reservation
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.reservation (
  idreservation INT NOT NULL,
  delivery_point_iddelivery INT NOT NULL,
  delivery_point_motorhomes_idmotorhomes INT NOT NULL,
  delivery_point_motorhomes_accesories_idaccesories INT NOT NULL,
  delivery_point_motorhomes_reservation_idreservation INT NOT NULL,
  date DATE NULL,
  PRIMARY KEY (idreservation, delivery_point_iddelivery, delivery_point_motorhomes_idmotorhomes, delivery_point_motorhomes_accesories_idaccesories, delivery_point_motorhomes_reservation_idreservation),
  INDEX fk_reservation_delivery_point1_idx (delivery_point_iddelivery ASC, delivery_point_motorhomes_idmotorhomes ASC, delivery_point_motorhomes_accesories_idaccesories ASC, delivery_point_motorhomes_reservation_idreservation ASC) VISIBLE,
  CONSTRAINT fk_reservation_delivery_point1
    FOREIGN KEY (delivery_point_iddelivery , delivery_point_motorhomes_idmotorhomes , delivery_point_motorhomes_accesories_idaccesories , delivery_point_motorhomes_reservation_idreservation)
    REFERENCES mydb.delivery_point (iddelivery , motorhomes_idmotorhomes , motorhomes_accesories_idaccesories , motorhomes_reservation_idreservation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.sales
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.sales (
  idsales INT NOT NULL,
  reservation_idreservation INT NOT NULL,
  amount FLOAT NULL,
  date DATETIME NULL,
  PRIMARY KEY (idsales, reservation_idreservation),
  INDEX fk_sales_reservation1_idx (reservation_idreservation ASC) VISIBLE,
  CONSTRAINT fk_sales_reservation1
    FOREIGN KEY (reservation_idreservation)
    REFERENCES mydb.reservation (idreservation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.service_states
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.service_states (
  idservice_states INT NOT NULL,
  damages LONGTEXT NULL,
  oil FLOAT NULL,
  water FLOAT NULL,
  service_statescol VARCHAR(45) NULL,
  date DATE NULL,
  PRIMARY KEY (idservice_states))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
