CREATE TABLE IF NOT EXISTS `ordem_servico` (
  `id` bigint NOT NULL,
  `cliente_id` bigint NOT NULL,
  `descricao` text NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `status` varchar(20) NOT NULL,
  `data_abertura` datetime NOT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ordem_servico_cliente` (`cliente_id`),
  CONSTRAINT `fk_ordem_servico_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
);
