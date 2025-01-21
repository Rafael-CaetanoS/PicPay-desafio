CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    primeiro_nome VARCHAR(255) NOT NULL,
    ultimo_nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    caixa NUMERIC(19, 2) NOT NULL,
    tipo_usuario VARCHAR(255) NOT NULL
);
