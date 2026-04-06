DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET SEARCH_PATH TO oblig3;
CREATE TABLE ansatt (
    id          SERIAL PRIMARY KEY,
    brukernavn  VARCHAR(4),
    fornavn     VARCHAR(50),
    etternavn   VARCHAR(50),
    startdato   DATE,
    stilling    VARCHAR(50),
    lonn        INTEGER,
    avdeling    SERIAL NOT NULL
);
CREATE TABLE avdeling (
    id          SERIAL PRIMARY KEY,
    navn        VARCHAR(50),
    sjef        SERIAL NOT NULL
);
CREATE TABLE prosjekt (
    id          SERIAL PRIMARY KEY,
    navn        VARCHAR(50),
    beskrivelse VARCHAR(200)
);
CREATE TABLE arbeid (
    prosjekt    SERIAL NOT NULL,
    ansatt      SERIAL NOT NULL,
    rolle       VARCHAR(50),
    timer       INTEGER,
    PRIMARY KEY (prosjekt, ansatt)
);
ALTER TABLE ansatt ADD CONSTRAINT fk_avdeling FOREIGN KEY (avdeling) REFERENCES avdeling (id);
ALTER TABLE avdeling ADD CONSTRAINT fk_sjef FOREIGN KEY (sjef) REFERENCES ansatt (id);
ALTER TABLE arbeid
    ADD CONSTRAINT fk_prosjekt FOREIGN KEY (prosjekt) REFERENCES prosjekt (id),
    ADD CONSTRAINT fk_ansatt FOREIGN KEY (ansatt) REFERENCES ansatt (id);
