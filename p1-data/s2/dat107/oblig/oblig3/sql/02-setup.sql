DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET SEARCH_PATH TO oblig3;
CREATE TABLE ansatt (
    id          SERIAL PRIMARY KEY,
    brukernavn  VARCHAR(4) UNIQUE,
    fornavn     VARCHAR(50),
    etternavn   VARCHAR(50),
    startdato   DATE,
    stilling    VARCHAR(50),
    lonn        INTEGER,
    avdeling    INTEGER NOT NULL
);
CREATE TABLE avdeling (
    id          SERIAL PRIMARY KEY,
    navn        VARCHAR(100),
    sjef        INTEGER NOT NULL
);
CREATE TABLE prosjekt (
    id          SERIAL PRIMARY KEY,
    navn        VARCHAR(50),
    beskrivelse VARCHAR(200)
);
CREATE TABLE arbeid (
    prosjekt    INTEGER NOT NULL,
    ansatt      INTEGER NOT NULL,
    rolle       VARCHAR(50),
    timer       INTEGER,
    PRIMARY KEY (prosjekt, ansatt)
);
ALTER TABLE ansatt ADD CONSTRAINT fk_avdeling FOREIGN KEY (avdeling) REFERENCES avdeling (id) ON DELETE RESTRICT;
ALTER TABLE avdeling ADD CONSTRAINT fk_sjef FOREIGN KEY (sjef) REFERENCES ansatt (id) ON DELETE RESTRICT DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE arbeid
    ADD CONSTRAINT fk_prosjekt FOREIGN KEY (prosjekt) REFERENCES prosjekt (id) ON DELETE RESTRICT,
    ADD CONSTRAINT fk_ansatt FOREIGN KEY (ansatt) REFERENCES ansatt (id) ON DELETE RESTRICT;

BEGIN;
INSERT INTO avdeling (navn, sjef) VALUES ('Institutt for datateknologi, elektroteknologi og realfag', 0);
INSERT INTO ansatt ( brukernavn, fornavn, etternavn, startdato, stilling, lonn, avdeling)
    VALUES 
    (
        'sd',
        'Siri',
        'Daleid',
        TO_DATE('01-04-2026', 'DD-MM-YYYY'),
        'Instituttleder',
        52100,
        1
    ), 
    (
        'te',
        'Tonje',
        'Espeland',
        TO_DATE('02-04-2026', 'DD-MM-YYYY'),
        'Assisterende instituttleder',
        45800,
        1
    ),
    (
        'pk',
        'Per',
        'Knutsen',
        TO_DATE('04-04-2026', 'DD-MM-YYYY'),
        'Førsteamanuensis',
        44200,
        1
    ),
    (
        'kf',
        'Kornelius',
        'Fjørvåg',
        TO_DATE('04-04-2026', 'DD-MM-YYYY'),
        'Førsteamanuensis',
        42400,
        1
    );
UPDATE avdeling SET sjef = 1 WHERE id = 1;
COMMIT;

BEGIN;
INSERT INTO avdeling (navn, sjef) VALUES ('Institutt for maskin- og maritime studium', 0);
INSERT INTO ansatt ( brukernavn, fornavn, etternavn, startdato, stilling, lonn, avdeling)
    VALUES 
    (
        'dv',
        'Dag',
        'Våge',
        TO_DATE('02-04-2026', 'DD-MM-YYYY'),
        'Instituttleder',
        51080,
        2
    ), 
    (
        'sg',
        'Signe',
        'Gryskog',
        TO_DATE('02-04-2026', 'DD-MM-YYYY'),
        'Assisterende instituttleder',
        45300,
        2
    ),
    (
        'ft',
        'Fabian',
        'Thyssen',
        TO_DATE('04-04-2026', 'DD-MM-YYYY'),
        'Førsteamanuensis',
        41000,
        2
    );
UPDATE avdeling SET sjef = 5 WHERE id = 2;
COMMIT;

