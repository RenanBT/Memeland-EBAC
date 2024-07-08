
CREATE SEQUENCE sequence_meme START WITH 1 INCREMENT BY 50;

CREATE TABLE meme (
  id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   url VARCHAR(255) NOT NULL,
   registry_date TIMESTAMP NOT NULL,
   categoria_meme_id BIGINT NOT NULL,
   usuario_id BIGINT NOT NULL,
   CONSTRAINT pk_meme PRIMARY KEY (id)
);
