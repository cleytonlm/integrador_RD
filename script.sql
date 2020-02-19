DROP DATABASE IF EXISTS projetointegrador;
CREATE DATABASE projetointegrador;

USE projetointegrador;

CREATE TABLE IF NOT EXISTS produtos(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(35) NOT NULL,
descricao VARCHAR(80),
valor_litro DECIMAL(2,2) NOT NULL,
quantidade_estoque INT
);

CREATE TABLE IF NOT EXISTS pedidos(
id INT AUTO_INCREMENT PRIMARY KEY,
valor DECIMAL(6,2) NOT NULL,
situacao VARCHAR(10) NOT NULL,
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE IF NOT EXISTS produtos_pedidos(
id_produto INT,
id_pedido INT,
valor_unit_prod DECIMAL(3,2),
quantidade INT NOT NULL,
FOREIGN KEY (id_produto) REFERENCES produtos(id),
FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
FOREIGN KEY (valor_unit_prod) REFERENCES produtos(valor_litro)
);

CREATE TABLE IF NOT EXISTS enderecos(
id INT AUTO AUTO_INCREMENT PRIMARY KEY,
estado VARCHAR(20) NOT NULL,
cidade VARCHAR(50) NOT NULL,
cep VARCHAR(9) NOT NULL,
bairro VARCHAR(30) NOT NULL,
rua_avenida VARCHAR(100) NOT NULL,
numero INT NOT NULL,
complemento VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS fornecedores(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(30) NOT NULL,
cnpj VARCHAR(11) NOT NULL
endereco INT,
FOREIGN KEY (endereco) REFERENCES enderecos(id)
);


CREATE TABLE IF NOT EXISTS produtos_fornecedores(
id_produto INT,
id_fornecedor INT,
FOREIGN KEY (id_produto) REFERENCES produtos(id),
FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id) 
);

CREATE TABLE IF NOT EXISTS clientes(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(45) NOT NULL,
sobrenome VARCHAR(60) NOT NULL,
email VARCHAR(80) NOT NULL,
senha VARCHAR(45) NOT NULL,
id_endereco INT,
FOREIGN KEY (id_endereco) REFERENCES enderecos(id)
);

CREATE TABLE notas_saida(
id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
valor_final DECIMAL(10,2),
data_saida DATETIME,
);
