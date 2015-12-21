CREATE TABLE `ops_kamino`.`despesa` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `ano` INT NOT NULL COMMENT '',
  `mes` INT NOT NULL COMMENT '',
  `senador` VARCHAR(255) NOT NULL COMMENT '',
  `tipo_despesa` VARCHAR(255) NOT NULL COMMENT '',
  `cnpj_cpf` VARCHAR(255) NOT NULL COMMENT '',
  `fornecedor` VARCHAR(255) NOT NULL COMMENT '',
  `documento` VARCHAR(255) NOT NULL COMMENT '',
  `data` DATE NOT NULL COMMENT '',
  `detalhamento` VARCHAR(45) NOT NULL COMMENT '',
  `valor_reembolsado` DOUBLE NOT NULL COMMENT '',
  `ops_data_processamento` DATETIME NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

