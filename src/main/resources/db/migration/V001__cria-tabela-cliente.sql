CREATE TABLE IF NOT EXISTS cliente (
	id BIGINT auto_increment NOT NULL,
	nome varchar(60) NOT NULL,
	email varchar(255) NOT NULL,
	telefone varchar(20) NOT NULL,
	primary key (id)
);