SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
CREATE SCHEMA IF NOT EXISTS `android_control` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;
USE `android_control` ;

-- -----------------------------------------------------
-- Table `android_control`.`listaacao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `android_control`.`listaacao` (
  `id` INT(2) NOT NULL AUTO_INCREMENT ,
  `acao` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `android_control`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `android_control`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(30) NOT NULL ,
  `senha` VARCHAR(32) NOT NULL ,
  `nome` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `android_control`.`log`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `android_control`.`log` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `id_usuario` INT(11) NOT NULL ,
  `data` DATETIME NOT NULL ,
  `listaacao_id` INT(2) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_usuario` (`id_usuario` ASC) ,
  INDEX `fk_log_listaacao1_idx` (`listaacao_id` ASC) ,
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario` )
    REFERENCES `android_control`.`usuario` (`id` ),
  CONSTRAINT `fk_log_listaacao1`
    FOREIGN KEY (`listaacao_id` )
    REFERENCES `android_control`.`listaacao` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 456
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `android_control`.`dispositivo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `android_control`.`dispositivo` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `usuario_id` INT(11) NOT NULL ,
  `codigo` VARCHAR(12) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_dispositivo_usuario1_idx` (`usuario_id` ASC) ,
  CONSTRAINT `fk_dispositivo_usuario1`
    FOREIGN KEY (`usuario_id` )
    REFERENCES `android_control`.`usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
