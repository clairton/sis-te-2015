CREATE TABLE teste 
( 
  id integer NOT NULL,
  nome character varying(100),
  nascido_em date,
  genero character,
  CONSTRAINT teste_pkey PRIMARY KEY (id)
);

--INSERT INTO teste (id,nome,nascido_em) VALUES(1,'José','2015-01-01');

--INSERT INTO teste (id,nome,nascido_em) VALUES(2,'Pedro','2012-02-28');