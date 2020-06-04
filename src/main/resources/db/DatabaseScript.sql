
CREATE DATABASE IF NOT EXISTS motorhomedb;
USE motorhomedb ;

CREATE TABLE accesories
(
    accessories_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    price          float       DEFAULT NULL,
    name           varchar(16) DEFAULT NULL,
    image_location varchar(45) DEFAULT NULL,
    PRIMARY KEY (accessories_id)
);

CREATE TABLE accessories_to_motorhomes
(
    motorhome_id   int(11) unsigned NOT NULL,
    accessories_id int(11) unsigned NOT NULL,
    PRIMARY KEY (motorhome_id, accessories_id),
    KEY accessories_id_idx (accessories_id),
    KEY motorhome_id_idx (motorhome_id),
    CONSTRAINT accessories_id FOREIGN KEY (accessories_id) REFERENCES accesories (accessories_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT motorhome_id FOREIGN KEY (motorhome_id) REFERENCES motorhomes (motorhome_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE contact
(
    contact_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    firstName  varchar(45)      NOT NULL,
    lastName   varchar(24)      NOT NULL,
    email      varchar(45)      NOT NULL,
    phone      varchar(12)      NOT NULL,
    PRIMARY KEY (contact_id)
) AUTO_INCREMENT=1;

CREATE TABLE motorhomes
(
    motorhome_id int(11) unsigned NOT NULL AUTO_INCREMENT,
    model        varchar(24) DEFAULT NULL,
    brand        varchar(16) DEFAULT NULL,
    price        float       DEFAULT NULL,
    licenseplate varchar(9)  DEFAULT NULL,
    type         varchar(16) DEFAULT NULL,
    PRIMARY KEY (motorhome_id)
) AUTO_INCREMENT=1;

CREATE TABLE reservations
(
    reservation_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    location       varchar(45) DEFAULT NULL,
    kmFromOffice   double      DEFAULT NULL,
    startDate      date        DEFAULT NULL,
    endDate        date        DEFAULT NULL,
    numberOfDays   int(11)     DEFAULT NULL,
    motorhome_id   int(10)          NOT NULL,
    contact_id     int(10)          NOT NULL,
    PRIMARY KEY (reservation_id)
)  AUTO_INCREMENT= 1;

CREATE TABLE reservations_has_accessories
(
    reservation_id int(10) unsigned NOT NULL,
    accessories_id int(10) unsigned NOT NULL,
    PRIMARY KEY (reservation_id, accessories_id),
    KEY acc_id_idx (accessories_id),
    KEY res_id_idx (reservation_id),
    CONSTRAINT acc_id FOREIGN KEY (accessories_id) REFERENCES accesories (accessories_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT res_id FOREIGN KEY (reservation_id) REFERENCES reservations (reservation_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) COMMENT='Junction table';

CREATE TABLE sales
(
    reservation_id int(10) unsigned NOT NULL,
    date           date  DEFAULT NULL,
    amount         float DEFAULT NULL,
    PRIMARY KEY (reservation_id),
    KEY sales_res_id_idx (reservation_id),
    CONSTRAINT sales_res_id FOREIGN KEY (reservation_id) REFERENCES reservations (reservation_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE service_states
(
    service_states_id int(10) unsigned NOT NULL AUTO_INCREMENT,
    motorhome_id      int(10) unsigned NOT NULL,
    damages           mediumtext,
    oil               float DEFAULT NULL,
    water             float DEFAULT NULL,
    date_checked      date  DEFAULT NULL,
    PRIMARY KEY (service_states_id),
    KEY service_motor_id_idx (motorhome_id),
    CONSTRAINT service_motor_id FOREIGN KEY (motorhome_id) REFERENCES motorhomes (motorhome_id) ON DELETE CASCADE ON UPDATE CASCADE
);