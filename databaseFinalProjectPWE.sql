-- MySQL Script generated by MySQL Workbench
-- Fri Jun 28 14:37:18 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema finalprojectpwe
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `finalprojectpwe` ;

-- -----------------------------------------------------
-- Schema finalprojectpwe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finalprojectpwe` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
SHOW WARNINGS;
USE `finalprojectpwe` ;

-- -----------------------------------------------------
-- Table `movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movie` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `movie` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `movieTitle` VARCHAR(60) NULL DEFAULT NULL,
  `movieDirector` VARCHAR(60) NULL DEFAULT NULL,
  `movieGenre` VARCHAR(60) NULL DEFAULT NULL,
  `movieAssessment` INT NULL DEFAULT NULL,
  `movieQtdAssessment` INT NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `sys_admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sys_admin` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `sys_admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(60) NULL DEFAULT NULL,
  `email` VARCHAR(80) NULL DEFAULT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;