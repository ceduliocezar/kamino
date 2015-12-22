CREATE TABLE `despesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(11) NOT NULL,
  `mes` int(11) NOT NULL,
  `senador` varchar(1000) NOT NULL,
  `tipo_despesa` varchar(1000) NOT NULL,
  `cnpj_cpf` varchar(1000) NOT NULL,
  `fornecedor` varchar(1000) NOT NULL,
  `documento` varchar(1000) NOT NULL,
  `data` date NOT NULL,
  `detalhamento` varchar(5000) NOT NULL,
  `valor_reembolsado` double NOT NULL,
  `ops_data_processamento` datetime NOT NULL,
  PRIMARY KEY (`id`)
)