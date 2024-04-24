
-- -----------------------------------------------------
-- Schema DB_REP
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `TBL_TELEFONE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_TELEFONE` (
  `id_telefone` CHAR(36) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `cod_operadora` VARCHAR(2) NOT NULL,
  `whatsapp` TINYINT NOT NULL,
  PRIMARY KEY (`id_telefone`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_USUARIO` (
  `id_usuario` CHAR(36) NOT NULL,
  `user_login` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  `user_email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_EMPRESA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_EMPRESA` (
  `id_empresa` CHAR(36) NOT NULL,
  `num_seq_registro` INT NOT NULL,
  `nome_empresa` VARCHAR(150) NOT NULL,
  `razao_social` VARCHAR(150) NOT NULL,
  `tipo_idef_empregador` VARCHAR(1) NOT NULL COMMENT 'Tipo de identificador do empregador: - \"1\": CNPJ; - \"2\": CPF.',
  `cnpj` DECIMAL(14) NULL,
  `cpf` VARCHAR(14) NULL,
  `cod_idef_cei` VARCHAR(11) NULL,
  `cod_idef_caepf` DECIMAL(14) NULL,
  `cod_idef_cno` DECIMAL(14) NULL,
  `data_hora_inclusao_alteracao` DATETIME NOT NULL,
  `tipo_operacao_inclusao_alteracao` VARCHAR(1) NOT NULL COMMENT 'Tipo de operação: \n- \n\"I\": inclusão; \n- \n\"A\": alteração; \n- \n\"E\": exclusão.',
  `id_telefone` VARCHAR(36) NOT NULL,
  `id_usuario_inclusao_alteracao` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_empresa`),
  CONSTRAINT `fk_TBL_EMPRESA_TBL_EMPR_TELF1`
    FOREIGN KEY (`id_telefone`)
    REFERENCES `TBL_TELEFONE` (`id_telefone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_EMPRESA_TBL_USUARIO1`
    FOREIGN KEY (`id_usuario_inclusao_alteracao`)
    REFERENCES `TBL_USUARIO` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_EMPR_ENDC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_EMPR_ENDC` (
  `id_endereco` CHAR(36) NOT NULL,
  `logradouro` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `cep` VARCHAR(9) NOT NULL,
  `bairro` VARCHAR(50) NULL,
  `cidade` VARCHAR(100) NOT NULL,
  `pais` VARCHAR(50) NOT NULL,
  `excluido` TINYINT NOT NULL,
  `id_empresa` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  CONSTRAINT `fk_TBL_EMPR_ENDC_TBL_EMPRESA1`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `TBL_EMPRESA` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_HORARIO_CONTRATUAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_HORARIO_CONTRATUAL` (
  `cod_hora_contratual` INT NOT NULL,
  `duracao_jornada` INT NOT NULL COMMENT 'Duração da jornada, convertida em minutos.',
  `hora_primeira_entrada` TIME NOT NULL,
  `hora_primeira_saida` TIME NOT NULL,
  `hora_segunda_entrada` TIME NOT NULL,
  `hora_segunda_saida` TIME NOT NULL,
  PRIMARY KEY (`cod_hora_contratual`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_EMPREGADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_EMPREGADO` (
  `id_empregado` CHAR(36) NOT NULL,
  `num_seq_registro` INT NOT NULL,
  `emp_nome` VARCHAR(52) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `data_admissao` DATE NOT NULL,
  `email` VARCHAR(255) NULL,
  `departamento` VARCHAR(52) NULL,
  `cargo` VARCHAR(52) NULL,
  `banco` VARCHAR(4) NULL,
  `agencia` VARCHAR(4) NULL,
  `conta` VARCHAR(7) NULL,
  `cod_idef_ctps` VARCHAR(45) NULL,
  `cod_idef_caepf` VARCHAR(14) NULL,
  `cod_idef_cno` VARCHAR(12) NULL,
  `cod_matricula_esocial` VARCHAR(30) NULL,
  `excluido` TINYINT NOT NULL,
  `id_empresa_endereco` VARCHAR(36) NOT NULL,
  `cod_horario_contratual` INT NOT NULL,
  `id_telefone` VARCHAR(36) NOT NULL,
  `id_empresa` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_empregado`),
  CONSTRAINT `fk_TBL_FUNCIONARIO_TBL_EMPRESA`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `TBL_EMPRESA` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_EMPREGADO_TBL_EMPR_ENDC1`
    FOREIGN KEY (`id_empresa_endereco`)
    REFERENCES `TBL_EMPR_ENDC` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_EMPREGADO_TBL_HORARIO_CONTRATUAL1`
    FOREIGN KEY (`cod_horario_contratual`)
    REFERENCES `TBL_HORARIO_CONTRATUAL` (`cod_hora_contratual`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_EMPREGADO_TBL_TELEFONE1`
    FOREIGN KEY (`id_telefone`)
    REFERENCES `TBL_TELEFONE` (`id_telefone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_TIPO_MARCACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_TIPO_MARCACAO` (
  `cod_tipo_marcacao` VARCHAR(1) NOT NULL COMMENT 'Tipo da marcação: \n\n- \"E\": marcação de entrada; \n\n- \"S\": marcação de saída; \n\n- \"D\": marcação desconsiderada.',
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cod_tipo_marcacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_COLETOR_REGISTRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_COLETOR_REGISTRO` (
  `cod_idef_coletor_registro` INT NOT NULL COMMENT 'Identificador do coletor da marcação: \n\"01\": aplicativomobile; \n\"02\":browser(navegador internet); \n\"03\": aplicativodesktop; \n\"04\": dispositivo eletrônico; \n\"05\": outro dispositivo eletrônico não especificado acima.',
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cod_idef_coletor_registro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_FONTE_MARCACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_FONTE_MARCACAO` (
  `cod_fonte_marcacao` VARCHAR(1) NOT NULL COMMENT 'Fonte da marcação: \n\n- \"O\": marcação original do REP; \n\n- \"I \": marcação incluída manualmente; \n\n- \"P\": marcação pré-assinalada; \n\n- \"X\": ponto por exceção; \n\n- \"T \": outras fontes de marcação.',
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cod_fonte_marcacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_REGISTRO_PONTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_REGISTRO_PONTO` (
  `id_registro_ponto` CHAR(36) NOT NULL,
  `num_seq_registro` INT NOT NULL,
  `num_seq_es_registro` INT NOT NULL COMMENT 'Número sequencial do par entrada/saída.',
  `data_marcacao_ponto` DATE NOT NULL,
  `hora_marcacao_ponto` TIME NOT NULL,
  `fuso_horario_marcacao` VARCHAR(50) NOT NULL,
  `fuso_horario_registro` VARCHAR(50) NOT NULL,
  `data_hora_inclusao_registro` DATETIME NOT NULL,
  `marcacao_online` TINYINT NOT NULL,
  `cpf_funcionario` VARCHAR(14) NOT NULL,
  `hash_registro` VARBINARY(64) NOT NULL,
  `latitude` DECIMAL(10,8) NULL,
  `longitude` DECIMAL(11,8) NULL,
  `motivo_marcacao` VARCHAR(150) NULL COMMENT 'Motivo da desconsideração ou inclusão da marcação. Campo obrigatório quando tpMarc for igual a \"D\" ou fonteMarc for igual a \"I\"',
  `cod_idef_coletor` INT NOT NULL,
  `cod_tipo_marcao` VARCHAR(1) NOT NULL,
  `cod_fonte_marcacao` VARCHAR(1) NOT NULL,
  `id_empregado` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_registro_ponto`),
  CONSTRAINT `fk_TBL_REGISTRO_PONTO_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_empregado`)
    REFERENCES `TBL_EMPREGADO` (`id_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_REGISTRO_PONTO_TBL_TIPO_REGISTRO_PONTO1`
    FOREIGN KEY (`cod_tipo_marcao`)
    REFERENCES `TBL_TIPO_MARCACAO` (`cod_tipo_marcacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_REGISTRO_PONTO_tbl_coletor_registro1`
    FOREIGN KEY (`cod_idef_coletor`)
    REFERENCES `TBL_COLETOR_REGISTRO` (`cod_idef_coletor_registro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_REGISTRO_PONTO_TBL_FONTE_MARCACAO1`
    FOREIGN KEY (`cod_fonte_marcacao`)
    REFERENCES `TBL_FONTE_MARCACAO` (`cod_fonte_marcacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_REGISTRO_FERIAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_REGISTRO_FERIAS` (
  `id_registro_ferias` CHAR(36) NOT NULL,
  `data_inicio` DATETIME NULL,
  `data_fim` DATETIME NULL,
  `qtde_dias` INT NULL,
  `id_empregado` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_registro_ferias`),
  CONSTRAINT `fk_TBL_REGISTRO_FERIAS_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_empregado`)
    REFERENCES `TBL_EMPREGADO` (`id_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_TIPO_REMUNERACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_TIPO_REMUNERACAO` (
  `cod_tipo_remuneracao` INT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cod_tipo_remuneracao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_EMPREGADO_REMUNERACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_EMPREGADO_REMUNERACAO` (
  `id_emprg_remu` CHAR(36) NOT NULL,
  `vigencia` VARCHAR(10) NOT NULL,
  `base` VARCHAR(45) NULL,
  `unidade` INT NULL,
  `proventos` DECIMAL NULL,
  `descontos` DECIMAL NULL,
  `cod_tipo_remuneracao` INT NOT NULL,
  `id_empregado` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_emprg_remu`),
  CONSTRAINT `fk_TBL_FUNC_REMUNERACAO_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_empregado`)
    REFERENCES `TBL_EMPREGADO` (`id_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_FUNC_REMUNERACAO_TBL_TIPO_REMUNERACAO1`
    FOREIGN KEY (`cod_tipo_remuneracao`)
    REFERENCES `TBL_TIPO_REMUNERACAO` (`cod_tipo_remuneracao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_TIPO_LICENCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_TIPO_LICENCA` (
  `cod_tipo_licenca` INT NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cod_tipo_licenca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_EMPREGADO_LICENCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_EMPREGADO_LICENCA` (
  `id_emprg_licenca` CHAR(36) NOT NULL,
  `data_inicio` DATE NOT NULL,
  `data_fim` DATE NOT NULL,
  `id_empregado` VARCHAR(36) NOT NULL,
  `cod_tipo_licenca` INT NOT NULL,
  PRIMARY KEY (`id_emprg_licenca`),
  CONSTRAINT `fk_TBL_FUNC_LICENSA_TBL_FUNCIONARIO1`
    FOREIGN KEY (`id_empregado`)
    REFERENCES `TBL_EMPREGADO` (`id_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_FUNC_LICENSA_TBL_TIPO_LICENCA1`
    FOREIGN KEY (`cod_tipo_licenca`)
    REFERENCES `TBL_TIPO_LICENCA` (`cod_tipo_licenca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_HISTORICO_EMPREGADO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_HISTORICO_EMPREGADO` (
  `id_historico_empregado` CHAR(36) NOT NULL,
  `num_seq_registro` INT NOT NULL,
  `cpf_usuario_inclusao_alteracao` VARCHAR(12) NOT NULL,
  `tipo_operacao_inclusao_alteracao` VARCHAR(1) NOT NULL COMMENT 'Tipo de operação: \n\"I\": inclusão; \n\"A\": alteração; \n\"E\": exclusão.',
  `data_hora_inclusao_alteracao` DATETIME NOT NULL,
  `id_empregado` VARCHAR(36) NOT NULL,
  `id_usuario_inclusao_alteracao` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_historico_empregado`),
  CONSTRAINT `fk_TBL_HISTORICO_EMPREGADO_TBL_EMPREGADO1`
    FOREIGN KEY (`id_empregado`)
    REFERENCES `TBL_EMPREGADO` (`id_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_HISTORICO_EMPREGADO_TBL_USUARIO1`
    FOREIGN KEY (`id_usuario_inclusao_alteracao`)
    REFERENCES `TBL_USUARIO` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_INFO_PTRP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_INFO_PTRP` (
  `id_info_ptrp` CHAR(36) NOT NULL,
  `nome_ptrp` VARCHAR(255) NULL,
  `versao_ptrp` VARCHAR(45) NULL,
  `tipo_idef_desenvolvedor` VARCHAR(1) NULL,
  `cpf_cnpj_desenvolvedor` VARCHAR(45) NULL,
  `razao_social_desenvolvedor` VARCHAR(45) NULL,
  `email_desenvolvedor` VARCHAR(255) NULL,
  `assinatura` VARCHAR(255) NULL,
  PRIMARY KEY (`id_info_ptrp`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_REP_EVENTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_REP_EVENTOS` (
  `id_rep_evento` CHAR(36) NOT NULL,
  `num_seq_registros` INT NOT NULL AUTO_INCREMENT,
  `data_hora_inclusao` DATETIME NOT NULL,
  `tipo_registro` VARCHAR(2) NOT NULL COMMENT 'Tipo de evento:\n\"02\": retorno de energia (REP-C ou REP-P); \n\n\"07\": disponibilidade de serviço (somente para REP-P); \n\n\"08\": indisponibilidade de serviço (somente para REP-P).',
  `id_info_ptrp` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`num_seq_registros`, `id_rep_evento`),
  CONSTRAINT `fk_TBL_REP_EVENTOS_TBL_INFO_PTRP1`
    FOREIGN KEY (`id_info_ptrp`)
    REFERENCES `TBL_INFO_PTRP` (`id_info_ptrp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TBL_BANCO_HORAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TBL_BANCO_HORAS` (
  `id_banco_horas` CHAR(36) NOT NULL,
  `tipo_ausencia_compensacao` VARCHAR(1) NOT NULL COMMENT 'Código com tipo da ausência ou compensação: \n\n- \"1\": Descanso Semanal Remunerado (DSR); \n\n- \"2\": falta não justificada; \n\n- \"3\": movimento no banco de horas; \n\n- \"4\": folga compensatória de feriado',
  `data_ausencia_compensacao` DATE NOT NULL,
  `quantidade_minutos` INT NOT NULL COMMENT 'Quantidade de minutos. Campo obrigatório se tipoAusenOuComp for igual a \"3\".',
  `tipo_movimento_banco_horas` INT NULL COMMENT 'Tipo de movimento no banco de horas: \n\n- \"1\": inclusão de horas no banco de horas; \n\n- \"2\": compensação de horas do banco de horas.\n Campo obrigatório se tipoAusenOuComp for igual a \"3\".',
  `id_empregado` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id_banco_horas`),
  CONSTRAINT `fk_TBL_BANCO_HORAS_TBL_EMPREGADO1`
    FOREIGN KEY (`id_empregado`)
    REFERENCES `TBL_EMPREGADO` (`id_empregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

