-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DB_BATE_PONTO
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DB_BATE_PONTO
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_BATE_PONTO` DEFAULT CHARACTER SET utf8 ;
USE `DB_BATE_PONTO` ;

-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_EMPRESA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_EMPRESA` (
  `id_empresa` INT NOT NULL,
  `nome_empresa` VARCHAR(255) NULL,
  `razao_social` VARCHAR(255) NULL,
  `cnpj` VARCHAR(14) NULL,
  PRIMARY KEY (`id_empresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_FUNCIONARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_FUNCIONARIO` (
  `id_funcionario` INT NOT NULL,
  `id_empresa` INT NOT NULL,
  `func_nome` VARCHAR(255) NULL,
  `departamento` VARCHAR(255) NULL,
  `cargo` VARCHAR(255) NULL,
  `banco` VARCHAR(4) NULL,
  `agencia` VARCHAR(10) NULL,
  `conta` VARCHAR(10) NULL,
  `data_admissao` DATE NULL,
  `ctps` VARCHAR(45) NULL,
  `telefone_1` VARCHAR(15) NULL,
  `telefone_2` VARCHAR(15) NULL,
  `cpf` VARCHAR(14) NULL,
  PRIMARY KEY (`id_funcionario`),
  CONSTRAINT `fk_TBL_FUNCIONARIO_TBL_EMPRESA`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `DB_BATE_PONTO`.`TBL_EMPRESA` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_FUNCIONARIO_TBL_EMPRESA_idx` ON `DB_BATE_PONTO`.`TBL_FUNCIONARIO` (`id_empresa` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_TIPO_REGISTRO_PONTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_TIPO_REGISTRO_PONTO` (
  `id_tipo_registro_ponto` INT NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id_tipo_registro_ponto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_REGISTRO_PONTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_REGISTRO_PONTO` (
  `id_registro_ponto` INT NOT NULL,
  `id_funcionario` INT NOT NULL,
  `data_hora_registro_ponto` DATETIME NULL,
  `latitude` DECIMAL(10,8) NULL,
  `longitude` DECIMAL(11,8) NULL,
  `id_tipo_registro_ponto` INT NOT NULL,
  PRIMARY KEY (`id_registro_ponto`),
  CONSTRAINT `fk_TBL_REGISTRO_PONTO_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `DB_BATE_PONTO`.`TBL_FUNCIONARIO` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_REGISTRO_PONTO_TBL_TIPO_REGISTRO_PONTO1`
    FOREIGN KEY (`id_tipo_registro_ponto`)
    REFERENCES `DB_BATE_PONTO`.`TBL_TIPO_REGISTRO_PONTO` (`id_tipo_registro_ponto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_REGISTRO_PONTO_TBL_FUNCIONARIO1_idx` ON `DB_BATE_PONTO`.`TBL_REGISTRO_PONTO` (`id_funcionario` ASC) VISIBLE;

CREATE INDEX `fk_TBL_REGISTRO_PONTO_TBL_TIPO_REGISTRO_PONTO1_idx` ON `DB_BATE_PONTO`.`TBL_REGISTRO_PONTO` (`id_tipo_registro_ponto` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_REGISTRO_FERIAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_REGISTRO_FERIAS` (
  `id_registro_ferias` INT NOT NULL,
  `id_funcionario` INT NOT NULL,
  `data_inicio` DATETIME NULL,
  `data_fim` DATETIME NULL,
  `qtde_dias` INT NULL,
  PRIMARY KEY (`id_registro_ferias`),
  CONSTRAINT `fk_TBL_REGISTRO_FERIAS_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `DB_BATE_PONTO`.`TBL_FUNCIONARIO` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_REGISTRO_FERIAS_TBL_FUNCIONARIO1_idx` ON `DB_BATE_PONTO`.`TBL_REGISTRO_FERIAS` (`id_funcionario` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_TIPO_REMUNERACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_TIPO_REMUNERACAO` (
  `id_tipo_remuneracao` INT NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id_tipo_remuneracao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_FUNC_REMUNERACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_FUNC_REMUNERACAO` (
  `id_func_remuneracao` INT NOT NULL,
  `id_funcionario` INT NOT NULL,
  `vigencia` VARCHAR(10) NULL,
  `id_tipo_remuneracao` INT NOT NULL,
  `base` VARCHAR(45) NULL,
  `unidade` INT NULL,
  `proventos` DECIMAL NULL,
  `descontos` DECIMAL NULL,
  PRIMARY KEY (`id_func_remuneracao`),
  CONSTRAINT `fk_TBL_FUNC_REMUNERACAO_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `DB_BATE_PONTO`.`TBL_FUNCIONARIO` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_FUNC_REMUNERACAO_TBL_TIPO_REMUNERACAO1`
    FOREIGN KEY (`id_tipo_remuneracao`)
    REFERENCES `DB_BATE_PONTO`.`TBL_TIPO_REMUNERACAO` (`id_tipo_remuneracao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_FUNC_REMUNERACAO_TBL_FUNCIONARIO1_idx` ON `DB_BATE_PONTO`.`TBL_FUNC_REMUNERACAO` (`id_funcionario` ASC) VISIBLE;

CREATE INDEX `fk_TBL_FUNC_REMUNERACAO_TBL_TIPO_REMUNERACAO1_idx` ON `DB_BATE_PONTO`.`TBL_FUNC_REMUNERACAO` (`id_tipo_remuneracao` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_TIPO_LICENCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_TIPO_LICENCA` (
  `id_tipo_licenca` INT NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id_tipo_licenca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_FUNC_LICENSA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_FUNC_LICENSA` (
  `id_func_licensa` INT NOT NULL,
  `id_funcionario` INT NOT NULL,
  `data_inicio` DATE NULL,
  `data_fim` DATE NULL,
  `id_tipo_licenca` INT NOT NULL,
  PRIMARY KEY (`id_func_licensa`),
  CONSTRAINT `fk_TBL_FUNC_LICENSA_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `DB_BATE_PONTO`.`TBL_FUNCIONARIO` (`id_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_FUNC_LICENSA_TBL_TIPO_LICENCA1`
    FOREIGN KEY (`id_tipo_licenca`)
    REFERENCES `DB_BATE_PONTO`.`TBL_TIPO_LICENCA` (`id_tipo_licenca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_FUNC_LICENSA_TBL_FUNCIONARIO1_idx` ON `DB_BATE_PONTO`.`TBL_FUNC_LICENSA` (`id_funcionario` ASC) VISIBLE;

CREATE INDEX `fk_TBL_FUNC_LICENSA_TBL_TIPO_LICENCA1_idx` ON `DB_BATE_PONTO`.`TBL_FUNC_LICENSA` (`id_tipo_licenca` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_EMPR_TELF`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_EMPR_TELF` (
  `id_telefone_emp` INT NOT NULL,
  `telefone` VARCHAR(15) NULL,
  `cod_operadora` VARCHAR(2) NULL,
  `id_empresa` INT NOT NULL,
  PRIMARY KEY (`id_telefone_emp`),
  CONSTRAINT `fk_TBL_EMPRESA_TEL_TBL_EMPRESA1`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `DB_BATE_PONTO`.`TBL_EMPRESA` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_EMPRESA_TEL_TBL_EMPRESA1_idx` ON `DB_BATE_PONTO`.`TBL_EMPR_TELF` (`id_empresa` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `DB_BATE_PONTO`.`TBL_EMPR_ENDC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_BATE_PONTO`.`TBL_EMPR_ENDC` (
  `id_endereco` INT NOT NULL,
  `logradouro` VARCHAR(255) NULL,
  `numero` VARCHAR(10) NULL,
  `cep` VARCHAR(20) NULL,
  `bairro` VARCHAR(255) NULL,
  `cidade` VARCHAR(255) NULL,
  `pais` VARCHAR(255) NULL,
  `id_empresa` INT NOT NULL,
  PRIMARY KEY (`id_endereco`),
  CONSTRAINT `fk_TBL_EMPR_ENDC_TBL_EMPRESA1`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `DB_BATE_PONTO`.`TBL_EMPRESA` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_EMPR_ENDC_TBL_EMPRESA1_idx` ON `DB_BATE_PONTO`.`TBL_EMPR_ENDC` (`id_empresa` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
