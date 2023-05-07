DROP DATABASE IF EXISTS carRentalDB;

CREATE DATABASE carRentalDB;

USE carRentalDB;


-- ----------------------------------------------------------------------------------------------------------------
-- ROLES
-- users roles
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS role
(
    id   INTEGER     NOT NULL AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (name)
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- PRIVILEGE
-- users privileges
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS privilege
(
    id   INTEGER     NOT NULL AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (name)
) DEFAULT CHARSET utf8;


-- --------------------------------------------------------------
-- ROLES_PRIVILEGES
-- relation between roles and privileges
-- --------------------------------------------------------------
CREATE TABLE IF NOT EXISTS roles_privileges
(
    role_id      INTEGER NOT NULL,
    privilege_id INTEGER NOT NULL,

    INDEX (role_id),
    FOREIGN KEY (role_id)
        REFERENCES role (id),

    INDEX (privilege_id),
    FOREIGN KEY (privilege_id)
        REFERENCES privilege (id)
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- USERS
-- users information
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS user
(
    id              INTEGER     NOT NULL AUTO_INCREMENT,
    first_name      VARCHAR(25) NOT NULL,
    last_name       VARCHAR(25) NOT NULL,
    password        VARCHAR(60) NOT NULL,
    email           VARCHAR(25) NOT NULL,
    phone_number    VARCHAR(13) ,
    passport_number VARCHAR(10) DEFAULT NULL,
    is_enable       BOOLEAN     DEFAULT false,

    PRIMARY KEY (id),
    UNIQUE (email)
) DEFAULT CHARSET utf8;


-- --------------------------------------------------------------
-- USERS_ROLES
-- relation between users and roles
-- --------------------------------------------------------------
CREATE TABLE IF NOT EXISTS users_roles
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,

    INDEX (user_id),
    FOREIGN KEY (user_id)
        REFERENCES user (id),

    INDEX (role_id),
    FOREIGN KEY (role_id)
        REFERENCES role (id)
) DEFAULT CHARSET utf8;

-- ----------------------------------------------------------------------------------------------------------------
-- CAR CLASSIFICATION
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS car_classification
(
    id               INTEGER     NOT NULL AUTO_INCREMENT,
    name             VARCHAR(25) NOT NULL,
    seating_capacity INTEGER     NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (name)
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- CARS
-- cars information
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS car
(
    id                    INTEGER              NOT NULL AUTO_INCREMENT,
    automobile_factory    VARCHAR(25)          NOT NULL,
    model                 VARCHAR(25)          NOT NULL,
    year                  INTEGER(4)           NOT NULL,
    price                 INTEGER              NOT NULL,
    available_for_booking BOOLEAN DEFAULT true NOT NULL,
    car_classification_id INTEGER              NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (car_classification_id)
        REFERENCES car_classification (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
) DEFAULT CHARSET utf8;


-- ----------------------------------------------------------------------------------------------------------------
-- ORDER STATUS
-- ----------------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS order_status
(
    id   INTEGER     NOT NULL AUTO_INCREMENT,
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
        REFERENCES user (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT,
    FOREIGN KEY (order_status_id)
        REFERENCES order_status (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
) DEFAULT CHARSET utf8;


-- --------------------------------------------------------------
-- ORDERS_CAR
-- relation between orders and car
-- --------------------------------------------------------------
CREATE TABLE IF NOT EXISTS orders_cars
(
    order_id INTEGER NOT NULL,
    car_id   INTEGER NOT NULL,

    INDEX (order_id),
    FOREIGN KEY (order_id)
        REFERENCES orders (id),

    INDEX (car_id),
    FOREIGN KEY (car_id)
        REFERENCES car (id)
) DEFAULT CHARSET utf8;
