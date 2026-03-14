SET search_path TO ex;
CREATE TABLE person (id integer NOT NULL, navn VARCHAR(30) NOT NULL, PRIMARY KEY (id));
INSERT INTO person(id, navn) VALUES (1001, 'Per'), (1002, 'Atle'), (1003, 'Donald');
