CREATE TABLE transacao (
    id SERIAL PRIMARY KEY,
    valor NUMERIC(19, 2) NOT NULL,
    destino_id BIGINT NOT NULL,
    remetente_id BIGINT NOT NULL,
    data_transacao TIMESTAMP NOT NULL,
    CONSTRAINT fk_destino FOREIGN KEY (destino_id) REFERENCES usuario(id) ON DELETE CASCADE,
    CONSTRAINT fk_remetente FOREIGN KEY (remetente_id) REFERENCES usuario(id) ON DELETE CASCADE
);