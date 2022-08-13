DROP DATABASE IF EXISTS carRentalDB;

CREATE DATABASE carRentalDB;

USE carRentalDB;


-- ----------------------------------------------------------------------------------------------------------------
-- ROLES
-- users roles
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS roles
(
    id   INTEGER     NOT NULL,
    name VARCHAR(10) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (name)
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- USERS
-- users information
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS users
(
    id         INTEGER     NOT NULL AUTO_INCREMENT,
    login      VARCHAR(25) NOT NULL,
    password   VARCHAR(10) NOT NULL,
    email      VARCHAR(25) NOT NULL,
    first_name VARCHAR(25) NOT NULL,
    last_name  VARCHAR(25) NOT NULL,
    passport   VARCHAR(10) DEFAULT NULL,
    role_id    INTEGER     NOT NULL,
    is_enable  BOOLEAN DEFAULT false,

    PRIMARY KEY (id),
    UNIQUE (login, email),

    FOREIGN KEY (role_id)
        REFERENCES roles (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- CAR CLASSIFICATION
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS car_classifications
(
    id               INTEGER     NOT NULL,
    name             VARCHAR(25) NOT NULL,
    seating_capacity INTEGER     NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (name)
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- CARS
-- cars information
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS cars
(
    id                    INTEGER              NOT NULL,
    automobile_factory    VARCHAR(25)          NOT NULL,
    model                 VARCHAR(25)          NOT NULL,
    year                  INTEGER(4)           NOT NULL,
    price                 INTEGER              NOT NULL,
    available_for_booking BOOLEAN DEFAULT true NOT NULL,
    car_classification_id INTEGER              NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (car_classification_id)
        REFERENCES car_classifications (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- ORDER STATUS
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS order_status
(
    id   INTEGER     NOT NULL,
    name VARCHAR(20) NOT NULL,

    PRIMARY KEY (id)
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- ORDERS
-- orders information
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS orders
(
    id              INTEGER NOT NULL AUTO_INCREMENT,
    order_number    INTEGER NOT NULL,
    user_id         INTEGER NOT NULL,
    order_status_id INTEGER NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT,
    FOREIGN KEY (order_status_id)
        REFERENCES order_status (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
) DEFAULT CHARSET utf8;


-- --------------------------------------------------------------
-- ORDERS_CAR
-- relation between order and car
-- --------------------------------------------------------------
CREATE TABLE IF NOT EXISTS order_car
(
    order_id INTEGER NOT NULL,
    car_id   INTEGER NOT NULL,

    INDEX (order_id),
    FOREIGN KEY (order_id)
        REFERENCES orders (id),

    INDEX (car_id),
    FOREIGN KEY (car_id)
        REFERENCES cars (id)
) DEFAULT CHARSET utf8;


/*==================================================INSERT QUERIES==================================================*/

INSERT INTO roles (id, name) VALUE (1, 'admin');
INSERT INTO roles (id, name) VALUE (2, 'manager');
INSERT INTO roles (id, name) VALUE (3, 'user');

INSERT INTO order_status
VALUES (0, 'opened');
INSERT INTO order_status
VALUES (1, 'confirmed');
INSERT INTO order_status
VALUES (2, 'paid');
INSERT INTO order_status
VALUES (3, 'closed');
