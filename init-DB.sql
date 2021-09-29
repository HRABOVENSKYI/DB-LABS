-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Hrabovenskyi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hrabovenskyi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hrabovenskyi` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema hrabovenskyi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hrabovenskyi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hrabovenskyi` DEFAULT CHARACTER SET utf8 ;
USE `Hrabovenskyi` ;

-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`reporter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`reporter` (
  `phone_number` VARCHAR(12) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `name` VARCHAR(40) NULL,
  PRIMARY KEY (`phone_number`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`call_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`call_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(100) NOT NULL,
  `city_or_village` VARCHAR(100) NOT NULL,
  `street` VARCHAR(45) NULL,
  `building` VARCHAR(45) NULL,
  `flat` VARCHAR(45) NULL,
  `place` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `city_or_village_idx` (`city_or_village` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`call`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`call` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reporter_phone_number` VARCHAR(12) NOT NULL,
  `short_description` VARCHAR(255) NOT NULL,
  `detailed_description` VARCHAR(3000) NULL,
  `call_address_id` INT NOT NULL,
  `call_time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_call_reporter_idx` (`reporter_phone_number` ASC) VISIBLE,
  INDEX `fk_call_call_address1_idx` (`call_address_id` ASC) VISIBLE,
  CONSTRAINT `fk_call_reporter`
    FOREIGN KEY (`reporter_phone_number`)
    REFERENCES `Hrabovenskyi`.`reporter` (`phone_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_call_address1`
    FOREIGN KEY (`call_address_id`)
    REFERENCES `Hrabovenskyi`.`call_address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`rescue_vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`rescue_vehicle` (
  `number` VARCHAR(8) NOT NULL,
  `characteristics` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`number`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`call_has_rescue_vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`call_has_rescue_vehicle` (
  `call_id` INT NOT NULL,
  `rescue_vehicle_number` VARCHAR(8) NOT NULL,
  `departure_time` DATETIME(6) NOT NULL,
  `return_time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`call_id`, `rescue_vehicle_number`),
  INDEX `fk_call_has_rescue_vehicles_rescue_vehicles1_idx` (`rescue_vehicle_number` ASC) VISIBLE,
  INDEX `fk_call_has_rescue_vehicles_call1_idx` (`call_id` ASC) VISIBLE,
  CONSTRAINT `fk_call_has_rescue_vehicles_call1`
    FOREIGN KEY (`call_id`)
    REFERENCES `Hrabovenskyi`.`call` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_has_rescue_vehicles_rescue_vehicles1`
    FOREIGN KEY (`rescue_vehicle_number`)
    REFERENCES `Hrabovenskyi`.`rescue_vehicle` (`number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`rescuer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`rescuer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(50) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `is_present` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `surname_idx` (`surname` ASC) INVISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`hospital` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`injury`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`injury` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NOT NULL,
  `diagnosis` VARCHAR(255) NOT NULL,
  `hospital_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_injury_hospital1_idx` (`hospital_id` ASC) VISIBLE,
  CONSTRAINT `fk_injury_hospital1`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `Hrabovenskyi`.`hospital` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hrabovenskyi`.`call_has_rescuer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hrabovenskyi`.`call_has_rescuer` (
  `call_id` INT NOT NULL,
  `rescuer_id` INT NOT NULL,
  `injury_id` INT NULL,
  PRIMARY KEY (`call_id`, `rescuer_id`),
  INDEX `fk_call_has_rescuer_rescuer1_idx` (`rescuer_id` ASC) VISIBLE,
  INDEX `fk_call_has_rescuer_call1_idx` (`call_id` ASC) VISIBLE,
  INDEX `fk_call_has_rescuer_injury1_idx` (`injury_id` ASC) VISIBLE,
  UNIQUE INDEX `injury_id_UNIQUE` (`injury_id` ASC) VISIBLE,
  CONSTRAINT `fk_call_has_rescuer_call1`
    FOREIGN KEY (`call_id`)
    REFERENCES `Hrabovenskyi`.`call` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_has_rescuer_rescuer1`
    FOREIGN KEY (`rescuer_id`)
    REFERENCES `Hrabovenskyi`.`rescuer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_call_has_rescuer_injury1`
    FOREIGN KEY (`injury_id`)
    REFERENCES `Hrabovenskyi`.`injury` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `hrabovenskyi` ;

-- -----------------------------------------------------
-- Table `hrabovenskyi`.`call_address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`call_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(100) NOT NULL,
  `city_or_village` VARCHAR(100) NOT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `building` VARCHAR(45) NULL DEFAULT NULL,
  `flat` VARCHAR(45) NULL DEFAULT NULL,
  `place` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`reporter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`reporter` (
  `phone_number` VARCHAR(12) NOT NULL,
  `surname` VARCHAR(50) NULL DEFAULT NULL,
  `name` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`phone_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`call`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`call` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `reporter_phone_number` VARCHAR(12) NOT NULL,
  `short_description` VARCHAR(255) NOT NULL,
  `detailed_description` VARCHAR(3000) NULL DEFAULT NULL,
  `call_address_id` INT NOT NULL,
  `call_time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_call_reporter_idx` (`reporter_phone_number` ASC) VISIBLE,
  INDEX `fk_call_call_address1_idx` (`call_address_id` ASC) VISIBLE,
  CONSTRAINT `fk_call_call_address1`
    FOREIGN KEY (`call_address_id`)
    REFERENCES `hrabovenskyi`.`call_address` (`id`),
  CONSTRAINT `fk_call_reporter`
    FOREIGN KEY (`reporter_phone_number`)
    REFERENCES `hrabovenskyi`.`reporter` (`phone_number`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`rescue_vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`rescue_vehicle` (
  `number` VARCHAR(8) NOT NULL,
  `characteristics` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`call_has_rescue_vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`call_has_rescue_vehicle` (
  `call_id` INT NOT NULL,
  `rescue_vehicle_number` VARCHAR(8) NOT NULL,
  `departure_time` DATETIME(6) NOT NULL,
  `return_time` DATETIME(6) NOT NULL,
  PRIMARY KEY (`call_id`, `rescue_vehicle_number`),
  INDEX `fk_call_has_rescue_vehicles_rescue_vehicles1_idx` (`rescue_vehicle_number` ASC) VISIBLE,
  INDEX `fk_call_has_rescue_vehicles_call1_idx` (`call_id` ASC) VISIBLE,
  CONSTRAINT `fk_call_has_rescue_vehicles_call1`
    FOREIGN KEY (`call_id`)
    REFERENCES `hrabovenskyi`.`call` (`id`),
  CONSTRAINT `fk_call_has_rescue_vehicles_rescue_vehicles1`
    FOREIGN KEY (`rescue_vehicle_number`)
    REFERENCES `hrabovenskyi`.`rescue_vehicle` (`number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`hospital` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`injury`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`injury` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NOT NULL,
  `diagnosis` VARCHAR(255) NOT NULL,
  `hospital_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_injury_hospital1_idx` (`hospital_id` ASC) VISIBLE,
  CONSTRAINT `fk_injury_hospital1`
    FOREIGN KEY (`hospital_id`)
    REFERENCES `hrabovenskyi`.`hospital` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`rescuer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`rescuer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(50) NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `is_present` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hrabovenskyi`.`call_has_rescuer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hrabovenskyi`.`call_has_rescuer` (
  `call_id` INT NOT NULL,
  `rescuer_id` INT NOT NULL,
  `departure_time` DATETIME(6) NOT NULL,
  `return_time` DATETIME(6) NOT NULL,
  `injury_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`call_id`, `rescuer_id`),
  UNIQUE INDEX `injury_id_UNIQUE` (`injury_id` ASC) VISIBLE,
  INDEX `fk_call_has_rescuer_rescuer1_idx` (`rescuer_id` ASC) VISIBLE,
  INDEX `fk_call_has_rescuer_call1_idx` (`call_id` ASC) VISIBLE,
  INDEX `fk_call_has_rescuer_injury1_idx` (`injury_id` ASC) VISIBLE,
  CONSTRAINT `fk_call_has_rescuer_call1`
    FOREIGN KEY (`call_id`)
    REFERENCES `hrabovenskyi`.`call` (`id`),
  CONSTRAINT `fk_call_has_rescuer_injury1`
    FOREIGN KEY (`injury_id`)
    REFERENCES `hrabovenskyi`.`injury` (`id`),
  CONSTRAINT `fk_call_has_rescuer_rescuer1`
    FOREIGN KEY (`rescuer_id`)
    REFERENCES `hrabovenskyi`.`rescuer` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
