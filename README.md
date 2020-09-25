# TechWeb

Criando tabelas Tasks e Users no mysql:

CREATE TABLE Tasks (
  id int NOT NULL AUTO_INCREMENT,
  user varchar(32) NOT NULL,
  task varchar(32) NOT NULL,
  tag varchar(32) NOT NULL,
  creDate timestamp,
  PRIMARY KEY (id)
)

CREATE TABLE Users (
  id int NOT NULL AUTO_INCREMENT,
  user varchar(32) NOT NULL,
  pwd varchar(32) NOT NULL,
  PRIMARY KEY (id)
)
