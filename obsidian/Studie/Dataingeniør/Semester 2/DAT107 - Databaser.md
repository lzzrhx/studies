> [!info]
> **Lenker:** [Emneplan](https://www.hvl.no/studier/studieprogram/emne/DAT107)
> **Engelsk emnetittel:** Database Systems
> **Studiepoeng:** 10
> **Vurdering:** -

>[!todo]
>- [x] Les kapittel 1
>- [x] Les kapittel 2
>- [x] Les kapittel 3
>- [x] Les kapittel 4
>- [ ] Les kapittel 5
>- [ ] Les kapittel 6
>- [ ] Les kapittel 7
>- [ ] Les kapittel 8
>- [ ] Les kapittel 8
>- [ ] Les kapittel 10

**Pensumliste:**
- [Databasesystemer (5. utg.)](https://bibsys-xc.alma.exlibrisgroup.com/leganto/public/47BIBSYS_HIB/citation/9786782060002221?auth=SAML)

**Andre lenker:**
- www.nettressurser.no/databasesystemer


## Notater fra "Databasesystemer":
- - -
### Kapittel 1 - Introduksjon
En database er en samling logisk relaterte ting som brukes for et bestemt formål. I relasjonsdatabaser er data alltid organisert i tabeller.

Livsløpet til et databasesystem:
Forstudie->Analyse->Design->Implementasjon->Testing->Produksjon

I designfasen kan det brukes et visuelt språk kalt ER (Entity Relationship) for å utvikle en visuell modell av databasen i form av en datamodell. Alternativt kan UML (Unified Modeling Language), som er et mer omfattende modelleringsspråk, brukes istedet.

I testfasen gjennomføres enhetstesting for å sjekke at hver enkel del oppfører seg som forventet, mens integrasjonstester sjekker at de ulike delene fungerer sammen. Stresstest brukes for å sjekke at systemet fungerer med realistisk datamengde og antall brukere. En godkjenningstest er en avsluttende test av det ferdige systemet.

Et databasehåndteringssystem (DBHS) er et program som kan utføre alle slags operasjoner mot databasen.

SQL-spørringer kan brytes ned i tre operasjoner: Parsering (sjekker at koden er lovling) -> Optimalisering (finner den mest effektive måten å utføre spørringen på og gir en eksekveringsplan som resultat) -> Utøfring av den mest effektive planen (eksekveringsplanen).

Operasjoner som brukere utfører mot databasen, kalles transaksjoner. En transaksjon kan bestå av flere deloperasjoner.

Nettstedet db-engines.com publiserer en rangert liste med de mest brukte databasehåndteringssystemene.

Her er en liste av noen av disse:
- Oracle
- DB2 (IMB)
- SQL Server (Microsoft)
- Access (Microsoft)
- MySQL
- MariaDB
- PostgreSQL (åpen kildekode)

Eksempel på NoSQL-databaser:
- MongoDB (dokumentdatabase)
- Neo4j (grafdatabase)

En database er en samling logisk relaterte data som brukes for et bestemt formål. Et databasehåndteringssystem (DBHS) er et program for å definere, administere, og bruke databaser. Et databasesystem er en database styrt av et DBHS.

Et databasesystem har som oppgave å lagre store mengder data over lang tid på en sikker måte, og å tilby hensiktsmessige mekanismer for å gjenfinne data effektivt og korrekt, selv når et stort antall brukere jobber mot databasen samtidig.

I relasjonsdatabaser blir data lagret i tabeller. Hierarkiske databaser, nettverksdatabaser, objektdatabaser, objektrelasjonelle databaser, logiske databaser og NoSQL-databaser er eksempler på andre typer databaser.

SQL er et språk for å jobbe med databaser. SQL-spørringer blir tolket og utført av DBHS.

En databaseadministrator (DBA) har et overordnet ansvar for databasen. Utviklere og sluttbrukere er to andre viktige brukergrupper.

Metadata er "data om data". Systemkatalogen i en database inneholder metadata, blant annet beskrivelser av tabellene.

Et databasesystem er en del av et større informasjonssystem, som også består av datamaskiner, nettverk, applikasjoner, mennesker og rutiner.

Livsløpet til et informasjonssystem kan deles inn i analyse, design, implementasjon, testing og produksjon. Smidige metoder legger opp til en iterativ prosess med vekt på testing og tilbakemelding fra brukere.

Databasedesign innebærer å finne fram til en hensiktsmessig tabellstruktur, gjerne beskrevet med en datamodell (ER-diagram).

En datamaskin består i prinsippet av CPU (prosessor), minne og disk, inn-enheter og ut-enheter.

Data er den fysiske representasjonen av informasjon. Digitale data består av symboler fra et endelig tengsett.

Den minste lagringsenheten i en datamaskin er en bit. En bit kan være i én av to mulige tilstander (0 og 1). En byte består av 8 biter. Alle slags data (tall, tekst, tabeller, bilder, video) kan bygges opp fra biter og byte.

Tall kan representeres både tekstlig og binært. Binært kan en byte representere 2^8=256 forskjellige verdier.
- - -
### Kapittel 2 - Spørring med én tabell

Uttrykk er på en av fire former:
1. Literaler - f.eks. 5, 'Hund', 16.00
2. Kolonnenavn - f.eks. VNr, Pris
3. Operatoruttrykk - f.eks. Pris\*1.25, Pris<10, Kategori = 'Fiske'
4. Funksjonsapplikasjoner - f.eks. ROUND(12.3456789)

SNavn på tabeller og kolonner kalles identifikatorer og skrives vanligvis enten med CamelCase eller snake_case.

Operatorprioritet:
1. - (unær minus)
2. * / %
3. + -
4. < <= > >= = <>
5. **NOT**
6. **AND**
7. **OR**

En tabell består av verdier organisert i rader og kolonner.

Alle verdier i samme kolonne tilhører samme datatype. SQL har datatyper for blant annet heltall, kommatall, tekster, datoer og klokkeslett.

En primærnøkkel er en (eller flere) kolonne(r) som brukes for å indentifisere en rad. Primærnøkler kan ikke inneholde duplikater eller nullmerker.

En utvalgsspørring (**SELECT**) henter ut data fra en eller flere tabeller og gir et spørreresultat.

Man velger ut kolonner ved å liste opp kolonnene i **SELECT**-delen. Det er også lov å bruke uttrykk i **SELECT**-delen.

Kolonnene i et spørreresultat kan omnavnes med **AS**.

Man velger ut rader ved å skrive betingelser i **WHERE**-delen.

Duplikater kan fjernes ved å skrive **DISTINCT** i **SELECT**-delen.

Man sorterer radene ved å bruke **ORDER BY**. **ASC** gir stigende sortering, **DESC** gir synkende.

Man grupperer data ved å bruke **GROUP BY** og mengdefunksjoner (**COUNT, MIN, MAX, SUM, AVG**).

**HAVING** brukes for å velge ut grupper med en gruppebetingelse.

Uttrykk bygges opp fra literaler, kolonnenavn, funksjoner og operatorer. Til hver datatype hører det bestemte funksjoner og operatorer.

Operatorene kan delen inn i aritmetiske operatorer, sammenligningsoperatorer, logiske operatorer og dessuten noen spesielle operatorer som f.eks. **BETWEEN** for intervallsøk.

Tegnene % og _ brukes for mønstersammenligning (jokernotasjon) med operatoren **LIKE**. I Access med standardoppsett brukes * og ?.
- - -
### Kapittel 3 - Lage og bruke tabeller

Datatyper:
- Tekststrenger:
	- CHAR(n)
		- Brukes hvis antall tegn er samme i alle rader
		- n = antall tegn
	- VARCHAR(n)
		- Brukes hvis antall tegn varierer
		- n = maks antall tegn
- Heltall:
	- SMALLINT
		- 2 byte (16-bit)
		- Fra -32 768 til 32 767
	- INTEGER
		- 4 byte (32-bit)
		- Fra -2 147 483 648 til 2 147 483 647
	- BIGINT
- Eksakte kommatall:
	- NUMERIC(p, s)
		- p = totalt antall sifre
		- s = antall desimaler
	- DECIMAL(p, s)
		- Lik NUMERIC men kan i noen systemer lagre tall med større presisjon enn det som er spesifisert.
- Flyttall:
	- FLOAT
		- 32-bit flyttal
	- DOUBLE
		- 64-bit flyttal
- Dato, tidspunkter:
	- DATE
		- Brukes for å lagre en dato
	- TIME
		- Brukes for å lagre et klokkeslett
	- TIMESTAMP
		- Brukes for å lagre en kombinasjon av dato og klokkeslett (inkluderer info om tidssone)
- Intervaller
	- INTERVAL
		- Brukes for å lagre avstand i tid mellom to tidspunkter
- Sannhetsverdier:
	- BOOLEAN
		- Brukes for å lagre sannhetsverdiene TRUE eller FALSE
- Store datamengder:
	- CLOB(n)
		- Character Large OBject - Inneholder et stort antall tegn (eks. tekstdokument)
		- n = maksimalstørrelse (K - kilobyte / M - megabyte / G - gigabyte, eks. 10K, 20G)
	- BLOB(n)
		- Binary Large OBject - inneholder en sekvens av tall på binær form

Tabeller blir definert i SQL-setningen **CREATE TABLE**, som blant annet bestemmer navn og datatype for hver av kolonnene til tabellen.

Standard datatyper i SQL inkluderer **CHAR** og **VARCHAR** for tekst. **BOOLEAN** for sannhetsverdier. **SMALLINT**, **INTEGER** og **BIGINT** for heltall. **NUMERIC**, **DECIMAL**, **FLOAT** og **DOUBLE** for desimaltall. **DATE**, **TIME** og **TIMESTAMP** for tidspunkter. **INTERVAL** for tidsrom. **CLOB** og **BLOB** for store datamengder. Listen av datatyper kan variere fra system til system.

Det er mulig å forby nullmerker i en kolonne (**NOT NULL**), forby repitisjoner (**UNIQUE**), og bestemme en stadardverdi (**DEFAULT**).

Primærnøkkelen (**PRIMARY KEY**) består av en eller flere kolonner og brukes for å identifisere rader i tabellen. Enhver tabell bør ha nøyaktig en primærnøkkel. En primærnøkkel kan ikke inneholde nullmerker eller repitisjoner.

Primærnøkler er ofte autonummererte.

En fremmednøkkel (**FOREIGN KEY**) består av en eller flere kolonner og "peker" alltid på en primærnøkkel (typisk i en annen tabell). Alle verdier i fremmednøkkelen må eksistere i tilhørende primærnøkkel.

Fremmednøkkeldefinisjoner kan utvides med angivelse av massesletting og masseoppdatering (**CASCADE**).

Prefiksede kolonnenavn brukes for å skille mellom like kolonnenavn i to tabeller.

En forretningsregel (valideringsregel) blir definert ved en betingelse som alle rader må tilfresstille (**CHECK**).

En innsettingsspørring (**INSERT**) setter inn én ny rad (**VALUES**), eller mange rader fra en annen tabell (**SELECT**).

En slettespørring (**DELETE**) sletter alle rader som oppfyller en gitt betingelse.

En oppdateringsspørring (**UPDATE**) endrer verdiene i spesifiserte kolonner for alle rader som oppfyller en gitt betingelse.

**CSV** (Comma Separated Values) er et tekstlig overføringsformat. De fleste databasesystemer kan importere og eksportere data til CSV-filer.

Et SQL-skript er en tekstfil som inneholder en sekvens med SQL-kommandoer.

- - -
### Kapittel 4 - Spørringer mot flere tabeller
- - -
### Kapittel 5 - Avanserte spørringer
- - -
### Kapittel 6 - Relasjonsmodellen
- - -
### Kapittel 7 - Datamodellering med ER
- - -
### Kapittel 8 - Fra modell til database
- - -
### Kapittel 9 - Filer og indekser
- - -
### Kapittel 10 - Transaksjoner
- - -
### Eksempler
```
2.2.1 Velge ut kolonner:
	DISTINCT kan brukes for å unngå duplikater:
		SELECT DISTINCT Kategori
		FROM Vare
	
	* Kan brukes for å vise samtlige kolonner fra en tabell:
		SELECT *
		FROM Vare
	
2.2.2 Velge ut rader:
	Betingelser (boolske uttrykk) kan legges til en utvalgsspørring:
		SELECT *
		FROM Vare
		WHERE Kategori = 'Fiske'

2.3.4 Logiske operatorer:
	SELECT *
	FROM Vare
	WHERE (Pris<100) AND (Kategori='Fiske')
	
	SELECT *
	FROM Vare
	WHERE NOT (Pris<100)
	
	SELECT *
	FROM Vare
	WHERE (Kategori='Bøker') OR (Kategori='Keramikk')

2.3.6 Uttrykk i SELECT-delen:
	SELECT VNr, Betegnelse, ROUND(Pris*1.25,2) AS PrisInklMva, LEFT(Hylle,1) AS Seksjon 
	FROM Vare
	WHERE Pris<100 AND Hylle IS NOT NULL

2.3.7 Intervallskø og jokernotasjon:
	Nøkkelordet BETWEEN brukes til intervallsøk.
		SELECT *
		FROM Vare
		WHERE Pris BETWEEN 50 AND 100
	
	Tegnet % står for en vilkårlig sekvens av tegn (også tom tekststreng):
		SELECT *
		FROM Vare
		WHERE UPPER(Betegnelse) LIKE '%MARSIPAN%'
	
	Tegnet _ står for et vikårlig tegn:
		SELECT *
		FROM Vare
		WHERE Hylle LIKE 'E1_'

2.4 Sortering:
	SELECT *
	FROM Vare
	ORDER BY Kategori ASC, Pris DESC
	
	SELECT *
	FROM Vare
	ORDER BY CHAR_LENGTH(Betegnelse)

2.5 Gruppering og mengdefunksjoner:
	AVG() gir gjennomsnitt, MIN() gir minste verdi og MAX() gir største verdi:
		SELECT Kategori, AVG(Pris) AS Gjennomsnittspris, MIN(Pris) AS Billigste, MAX(Pris) AS Dyreste
		FROM Vare
		GROUP BY Kategori
	
	COUNT(*) teller antall rader (med nullmerker):
		SELECT COUNT(*) AS AS AntallBlomsterVarer
		FROM Vare
		WHERE Kategori='Blomsterfrø' OR Kategori='Blomsterløker'
		
	COUNT(<kolonnenavn>) teller antall rader der <kolonnenavn> ikke er nullmerke:
		SELECT COUNT(Hylle) AS AntallPlasserte
		FROM Vare

2.5.1 Gruppebetingelser:
	SELECT Kategori, COUNT(*) AS Antall
	FROM Vare
	GROUP BY Kategori
	HAVING COUNT(*) > 1

3.2 Opprette nye tabeller
	CREATE TABLE Vare
	(
		VNr CHAR(5),
		Betegnelse VARCHAR(50),
		Pris DECIMAL(8,2),
		KatNr SMALLINT,
		Antall INTEGER,
		Hylle CHAR(3),
		CONSTRAINT VarePN PRIMARY KEY (VNr)
	)

3.2.1 Primærnøkler
	CREATE TABLE Ordrelinje
	(
		OrdreNr INTEGER,
		VNr CHAR(5),
		PrisPrEnhet DECIMAL(8,2),
		Antall INTEGER,
		CONTRAINT OrdrelinjePN PRIMARY KEY (OrdreNr, VNr)
	)

3.2. Autonummerering av primærnøkler:
	Det er naturlig å la surrogatnøkler være autonummererte.
		CREATE TABLE Kategori
		(
			KatNr SMALLINT AUTO_INCREMENT
			Navn VARCHAR(50),
			CONTRAINT KategoriPN PRIMARY_KEY (KatNr)
		)

3.2.3 Nullmerker:
	Det er mulig å forby nullmerker for utvalgte kolonner:
		...
		Pris DECIMAL(8,2) NOT NULL
		...

3.2.4 Unike kolonner
	Primærnøkkelen til en tabell er alltid unik, men andre kolonner kan også deklareres som unike:
		...
		Epost VARCHAR(100) UNIQUE
		...
	
	UNIQUE kan kombineres med NOT NULL. Dette gir en mulig primærnøkkel som kalles kandidatnøkkel:
		...
		Betegnelse VARCHAR(50) UNIQUE NOT NULL
		...

3.2.5 Standardverdier:
	...
	Antall INTEGER DEFAULT 0
	...

3.2.6 Fremmednøkler:
	CREATE TABLE Ordrelinje
	(
		OrdreNr INTEGER,
		CNr CHAR(5),
		PrisPrEnhet DECIMAL(8,2),
		Antall INTEGER,
		CONSTRAINT OrdreLinjePN PRIMARY_KEY (OrdreNr, VNr)
		CONSTRAINT OrfreLinjeOrdreFN FOREIGN_KEY (OrdreNr) REFERENCES Ordre (OrdreNr)
		CONSTRAINT OrdrelinjeVareFN FOREIGN_KEY (VNr) REFERENCES Vare (VNr)
	)

3.2.7 Massesletting og masseoppdatering:
	Slett alle når fremmednøkkelen slettes:
	CONSTRAINT OrdrelinjeVareFN FOREIGN_KEY (VNr) REFERENCES Vare (VNr) ON DELETE CASCADE
	
	Oppdater alle når fremmednøkkelen oppdateres:
	CONSTRAINT OrdrelinjeVareFN FOREIGN_KEY (VNr) REFERENCES Vare (VNr) ON UPDATE CASCADE
	
	CASCADE kan erstattes SET NULL for å sette nullmerke:
	CONSTRAINT OrdrelinjeVFN FOREIGN_KEY (VNr) REFERENCES Vare (VNr) ON DELETE SET NULL

3.2.8 Forretningsreger:
	CONSTRAINT Prisregel CHECK (Pris>0 AND Pris<10000)
	CONSTRAINT Fargeregel CHECK (Farge IN ('rød','blå','gul'))

3.3.1 Innsettingsspørringer:
	INSERT INTO Vare (VNr,Betegnelse,Pris) VALUES ('44304','Gul',29.50)
	INSERT INTO Vare VALUES ('44304','Gul',29.50,NULL,53)
	
	Kopiere fra en tabell til en annen:
		INSERT INTO Kategori (KatNr) SELECT DISTINCT KatNr FROM Vare
	
	Kopiering av gamle data til historiske tabeller:
		INSERT INTO GamleOrdre SELECT * FROM Ordre WHERE YEAR(OrdreDato)<2020

3.3.2 Slettespørringer
	Slett alle rader:
		DELETE FROM Vare
	
	Selektiv sletting:
		DELETE FROM Vare WHERE KatNr = 3 AND Pris > 100

3.3.3 Oppdateringsspørringer
	Oppdater alle rader:
		UPDATE Vare SET Antall = 0
	
	Selektiv oppdatering
		UPDATE Vare SET Antall = 0, Pris = Pris*1.05 WHERE KatNr = 3

3.3.4 Import, eksport og overføringsformater
	Import av CSV-fil:
		LOAD DATA INFILE 'kunde.csv'
		INTO TABLE Kunde
		FIELDS TERMINATED BY ';'
		LINES TERMINATED BY '\r\n'
		IGNORE 1 ROWS;
	
	Eksportere til CSV-fil:
		SELECT *
		INTO OUTFILE 'kunde.csv'
		FIELDS TERMINATED BY ';'
		LINES TERMINATED BY '\r\n'
		FROM Kunde;

3.3.5 Transaksjoner
	START TRANSACTION
	UPDATE Vare SET KatNr = 16 WHERE KatNr = 15;
	UPDATE Kategori SET Navn = 'Blomsterfrø og blomsterløker' WHERE KatNr = 16;
	DELETE FROM Kategori WHERE KatNr = 15;
	COMMIT;

3.4.1 Endre og slette tabeller
	Endre:
		ALTER TABLE Vare ADD COLUMN Farge CHAR(15);
		ALTER TABLE Ordrelinje DROP COLUMN PrisPrEnhet;
		ALTER TABLE Vare ADD CONTRAINT Makspris CHECK (Pris<10000);
		ALTER TABLE Vare DROP CONSTRAINT Makspris;
		
	Slette:
		DROP TABLE Vare

3.4.2 Databaser og databaseobjekter:
	Opprette:
		CREATE DATABASE Hobbyhuset;
	
	Slette:
		DROP DATABASE Hobbyhuset;
	
	Velge database (MySQL):
		USE Hobbyhuset;
	
	Indekser er datastrukturer som brukes til å effektivisere søk:
		CREATE INDEX EtternavnIdx ON Kunde (Etternavn)
	
	Views er virtuelle tabeller:
		CREATE VIEW Maling AS
			SELECT *
			FROM Vare
			WHERE KatNr = 2


```
