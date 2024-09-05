CREATE DATABASE testeInfuse;

use testeInfuse;

CREATE TABLE clientes
(
    id                      bigint(20) NOT NULL AUTO_INCREMENT,
    nome                    varchar(255)   NOT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE pedidos (
                         id bigint(20) NOT NULL AUTO_INCREMENT,
                         numero_controle bigint NOT NULL,
                         data_cadastro   datetime,
                         nome_produto   varchar(255)   NOT NULL,
                         valor_unitario  decimal(38, 2) NOT NULL,
                         quantidade int,
                         valor_total_pedido  decimal(38, 2) NOT NULL,
                         codigo_cliente   bigint(20) NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (codigo_cliente) REFERENCES clientes (id)
);

INSERT INTO clientes (nome) VALUES
                                    ('José'),
                                    ('Francisca'),
                                    ('Carlos'),
                                    ('Manoel'),
                                    ('Eduardo'),
                                    ('Fernanda'),
                                    ('Gustavo'),
                                    ('Helena'),
                                    ('Isabela'),
                                    ('João');

