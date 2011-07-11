SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `lcbotoolsdb`.`dataset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lcbotoolsdb`.`dataset` ;

CREATE  TABLE IF NOT EXISTS `lcbotoolsdb`.`dataset` (
  `id_dataset` INT NOT NULL ,
  `total_products` INT UNSIGNED NULL ,
  `total_stores` INT UNSIGNED NULL ,
  `csv_location` VARCHAR(200) NOT NULL ,
  `created_dt` DATETIME NULL ,
  `updated_dt` DATETIME NULL ,
  PRIMARY KEY (`id_dataset`) ,
  UNIQUE INDEX `id dataset_UNIQUE` (`id_dataset` ASC) ,
  UNIQUE INDEX `csv_location_UNIQUE` (`csv_location` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lcbotoolsdb`.`new_products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lcbotoolsdb`.`new_products` ;

CREATE  TABLE IF NOT EXISTS `lcbotoolsdb`.`new_products` (
  `id_new_products` INT NOT NULL AUTO_INCREMENT ,
  `cspc` VARCHAR(45) NOT NULL ,
  `producer_name` VARCHAR(200) NULL ,
  `name` VARCHAR(200) NULL ,
  `description` VARCHAR(1000) NULL ,
  `alcohol_content` INT NULL ,
  `is_discontinued` BIT(1) NULL DEFAULT 0 ,
  `is_dead` BIT(1) NULL DEFAULT 0 ,
  `stock_type` VARCHAR(45) NULL ,
  `price_in_cents` INT NULL ,
  `origin` VARCHAR(200) NULL ,
  `primary_category` VARCHAR(45) NULL ,
  `secondary_category` VARCHAR(45) NULL ,
  `released_on` DATETIME NULL ,
  `inventory_count` INT NULL ,
  `updated_at` DATETIME NULL ,
  `created_dt` DATETIME NULL ,
  `updated_dt` DATETIME NULL ,
  PRIMARY KEY (`id_new_products`) ,
  UNIQUE INDEX `cspc_UNIQUE` (`cspc` ASC) )
ENGINE = InnoDB;

USE `lcbotoolsdb`;

DELIMITER $$

USE `lcbotoolsdb`$$
DROP TRIGGER IF EXISTS `lcbotoolsdb`.`dataset_insert_timestamp` $$
USE `lcbotoolsdb`$$












CREATE TRIGGER dataset_insert_timestamp BEFORE INSERT ON dataset 
FOR EACH ROW
BEGIN
    SET NEW.created_dt = NOW();
    SET NEW.updated_dt = NOW();
END;

CREATE TRIGGER dataset_update_timestamp BEFORE UPDATE ON dataset 
FOR EACH ROW
SET NEW.updated_dt = NOW();
$$


DELIMITER ;

DELIMITER $$

USE `lcbotoolsdb`$$
DROP TRIGGER IF EXISTS `lcbotoolsdb`.`new_products_insert_timestamp` $$
USE `lcbotoolsdb`$$




CREATE TRIGGER new_products_insert_timestamp BEFORE INSERT ON new_products 
FOR EACH ROW
BEGIN
    SET NEW.created_dt = NOW();
    SET NEW.updated_dt = NOW();
END;

CREATE TRIGGER new_products_update_timestamp BEFORE UPDATE ON new_products 
FOR EACH ROW
SET NEW.updated_dt = NOW();

$$


DELIMITER ;

;
CREATE USER `scotch` IDENTIFIED BY 'scotch';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
