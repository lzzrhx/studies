
> [!info]
> [Emneplan](https://www.hvl.no/studier/studieprogram/emne/MAT101)
> **Studiepoeng:** 10
> **Vurdering:** Skoleeksamen, 03.12.2025 kl. 09:00

>[!todo]
>- [ ] Uke 33 - Kap. 1.2, 1.3
>- [ ] Uke 34 - Øvelse 1
>- [ ] Uke 34 - Kap. 2.1, 2.2, 2.3, 2.4
>- [ ] Obligatorisk oppgave 1
>- [ ] Uke 35 - Kap. 3.1, 3.2, 3.3, 3.4
>- [ ] Uke 37 - Kap. 6.1, 6.2, 6.3
>- [ ] Obligatorisk oppgave 2
>- [ ] Uke 38 - Kap. 8.1, 8.2, 8.3
>- [ ] Uke 39 - Kap. 7.1, 7.2, 7.3
>- [ ] Uke 41 - Kap. 5.1, 5.2, 5.3
>- [ ] Obligatorisk oppgave 3
>- [ ] Uke 42 - Kap. 5.6, 5.9
>- [ ] Uke 43 - Kap. 4.4, 4.5, 8.1, 8.3, 2.5
>- [ ] Uke 44 - Kap. 1.4, 10.1, 10.2, 10.3, 10.4, 10.5, 10.6

| Ukenr. | Emne/kapitler i lærebok                                           |
| ------ | ----------------------------------------------------------------- |
| 33     | Å snakke matematisk, delkapitler 1.2, 1.3 +  Haskell intro.       |
| 34     | Logikk, delkapitler 2.1, 2.2, 2.3, 2.4. (==oblig 1 ut==)          |
| 35     | Logikk, kvantorer, delkapitler 3.1, 3.2, 3.3, 3.4.                |
| 36     | Kvantorer                                                         |
| 37     | Mengder, delkapitler 6.1, 6.2, 6.3, kanskje 6.4?                  |
| 38     | Relasjoner, delkapitler 8.1, 8.2, 8.3, 8.5  (==oblig 2 ut)==      |
| 39     | Funksjoner, delkapitler 7.1, 7.2, 7.3, kanskje 7.4.               |
| 40     | Studieuke, bare øvelse                                            |
| 41     | Induksjon, delkapitler 5.1, 5.2, 5.3.                             |
| 42     | Rekursjon,  delkapitler 5.6, 5.9. (==oblig 3 ut==)                |
| 43     | Modulregning og talsystemer, delkapitler 4.4, 4.5, 8.1, 8.3, 2.5. |
| 44     | Grafer, delkapitler 1.4, 10.1, 10.2, 10.3, 10.4, 10.5, 10.6.      |
| 45     | Grafer                                                            |
| 46     | Eksamensforberedelse (==prøveeksamen som oblig 4==)               |
| 47     | Eksamensforberedelse                                              |
|        |                                                                   |

**Pensumliste:**
+ [Discrete mathematics with applications (5.utg.)](https://bibsys-xc.alma.exlibrisgroup.com/leganto/public/47BIBSYS_HIB/citation/10380570760002221?auth=SAML)

**Andre linker:**
- [List of logic symbols](https://www.wikiwand.com/en/articles/List_of_logic_symbols)
- [Haskel installasjon](https://www.haskell.org/ghcup/)
- [GHCi dokumentasjon](https://downloads.haskell.org/ghc/latest/docs/users_guide/ghci.html)
- [Haskell Documentation](https://www.haskell.org/documentation/)
- [(Video) Haskell Programming Full Course 2024](https://youtu.be/TklkNLihQ_A)

**Linux Haskel installasjon:**
`curl --proto '=https' --tlsv1.2 -sSf https://get-ghcup.haskell.org | sh`

**Kommandoer:**
Start a simple repl:
`ghci`

Start a new Haskell project in the current directory:
`cabal init --interactive`

Kompilere *.hs fil:
`ghc <filnavn>.hs -o <navn>

**ghci kommandoer:**
`:quit`

## Notater:
- - -

**Mengde (set):**
- Introdusert av Georg Kantor i 1879
- En samling objekter (elementer)
- Definert av dens elementer. *ikke* med rekkefølge/antall forekomster av elementer.
- Tom mengde skrives som $\emptyset$ (\emptyset) eller {} og er delmengde av alle mengde
	
	Element i: $\in$
	Element ikke i: $\notin$
	Delmengde (subset): $\subseteq$
	Ekte delmengde (proper subset): $\subset$
	Mengden av naturlige tall: $\mathbb{N} = \{0, 1, 2, 3, \dots\}$
	Mengden av alle heltall (med negative tall): $\mathbb{Z} = \{\dots, -3, -2, -1, 0, 1, 2, 3, \dots\}$
	Mengden av rasjonale tall (med divisjon (brøk)): $\mathbb{Q}$
	Mengden av irrasjonale tall (tall som ikke kan skrives som brøk): $\mathbb{I}$
	Mengden av reelle tall ($\mathbb{Q} \cup \mathbb{I}$): $\mathbb{R}$ 
	Mengdebygger (set builder):
		$A = \{x|x\text{ har egenskap }P\}$
		eks: $C = \{x|\in A \text{ og } x \in B\}$
	
	$A = {1, 2, 3}$
	$B = {3, 2, 1}C = {1, 3, 3, 2, 1, 2, 3, 2, 1}$
	$C = B = A$

**Tupler:**
- Tupler ligner mengde, men rekkefølge og antall forekomster av hvert objekt teller.
- 0-tuppel skrives som ()
- 2-tuppel kalles et *ordnet par (ordered pair)*
- To n-tuppler er like hvis de er komponentvis like: $(a, b, c) = (d, e, f)$ hvis a = $d, b = e, c = f$

**Det kartesiske produktet (cartesian product):**
- Kryssproduktet (cross-produkt) av n mengder
	$A = \{x, y\}$
	$B = \{1, 2, 3\}$
	$A \times B = \{(x,1),(x,2),(x,3),(y,1),(y,2),(y,3)\}$
	$A \times A = A^2 = \{(x,x),(x,y),(y,x),(y,y)\}$

**Relasjoner:**
- Relaterer to objekter på en spesiell måte
- Lik-relasjon på reelle tall: $2 = 2$
- Delmengderelasjon på mengder: $\{1,2,3,3\} \subseteq \{2,1,3\}$
- Binær relasjon (binary relation) - relasjon mellom to mengder: $R \subseteq A \times B$
		R er (binær) relasjon fra mengden A (definisjonsområdet (domain)) til mengden B (verdiområdet (codomain)).

	$A = \{1,2,3\}$
	$B = \{a,b\}$
	$R = \{(1,a),(1,b),(2,a)\}$

- Relasjonen $R$ på mengden $A$ er delmengde av $A \times A = A^2$
- Identitetsrelasjonen relaterer alle elementer til seg selv (refleksiv)
- Relasjon kan også defineres med funksjon
- n-ær relasjon (n-ary relasjon)

**Funksjoner:**
- Delmengde av en binær relasjon
- $f: A \rightarrow B$
- Mengden $A$ kalles definisjonsområdet (domain)
- Mengden $B$ kalles verdiområdet (codomain)
- Til hvert element $x \in A$ tilordner et entydig element $f(x) \in B$

**Logikk:**
- Deduktiv resonnement er en psykologisk prosess for å utføre trinn fra premisser til logiske konsekvenser
- Det første store avhandlingen om logikk ble skrevet av Aristoteles
- Gottfried Leibniz introduserte logiske symboler på det syttende århundre
- Logikk ble utvidet bidere på det nittende århundre av George Boole og Augustus De Morgan

**Utsagn (statement / proposition):**
- En påstand eller ytring som enter er sann eller usann
	- Eksempler:
		- "Jeg liker is"
		- 2+2=4
	- Eksempler på ting som ikke regnes som utsagn:
		- "Det er kaldt"
		- 2+2
		- "2+2 er et stort tall"
- Om noe er utsagn, i tillegg til sannhetsverdien, kan avhenge av konteksten
- Sammensatte utsagn kan bygges opp ved å bruke logiske bindeord kalt *konnektiver*.
	- Eksempler:
		- "Jorda er rund *OG* jeg liker is"
		- "2 + 2 = 4 *ELLER* 2 + 2 = 4"
		- p: jorda er rund, q: jeg liker is. p *OG* q
		- s: 2 + 2 = 4, t: 2 + 2 = 5. p *eller* t
- Symboler for de logiske konnektivene:
		$\land$ *og / konjuksjon*
		$\lor$ *eller / disjunksjon*
		$\sim$ *ikke / negasjon* (unær operasjon)
- En unær operasjon (unary operation) $f: A \rightarrow A$
- Eksempel:
		$x \in \mathbb{R}$
		$p: 0 < x$
		$q: x < 3$
		$r: x = 3$
		$x \le 3$ kan skrives som $g \lor r$
		$0 < x < 3$ kan skrives som $p \land q$
		$0 < x \leq 3$ kan skrives som $p \land (q \lor r)$

**Sannhetsverdier:**
- Utsagn har to mulige verdier, "sann" eller "usann". Vi bruker $T$ (true) og $F$ (false), eller $\top$ (sann) og $\bot$ (usann) eller $1$ (sann) og $0$ (usann).
- *Utsagnformer* er logisk ekvivalente hvis de har samme sannhetsverdi for hver mulig erstatning av variabel med utsagn.
	- Eksempel:
		$P \equiv P$
		$P \not\equiv \lnot P$
		$\lnot(P \lor Q) \equiv \lnot P \land \lnot Q$
		$P \equiv \lnot \lnot P$
- De Morgans lover: $\sim (p \land q) \equiv \sim p \ \lor \sim q, \sim (p \lor q) \equiv \sim p \ \land \sim q$
- En utsagnform er en tautologi hvis den alltid er sann
	- Eksempel:
			$P \lor \lnot P$
			$(P \rightarrow Q) \lor \lnot Q$
- En selvmotsigelse er en utsagnsform som alltid er usann
	- Eksempel:
			$P \land \lnot P$
			$P \oplus P$

**Betinget utsagn:**
- Implikasjon, kondisjonal
		$p \rightarrow q$ (hvis p (hypotesen), så q (konklusjon))
		Konvers (converse) av $p \rightarrow q$ er $q \rightarrow p$
		Invers (inverse) av $p \rightarrow q$ er $\sim p \rightarrow \sim q$
- Bikondisjonal, biimplikasjon
		$p \leftrightarrow q$ leses ofte som $p$ hvis og bare hvis $q$
		$p \leftrightarrow q \equiv (p \rightarrow q) \land (q \rightarrow p)$

**Rekkefølge av operasjoner:**
(Innholdet i parenteser tolkes først)
1. $\sim$
2. $\land$ og $\lor$
3. $\rightarrow$ og $\leftrightarrow$

**Logisk ekvivalens (logiske regler):**
Given any statement variables $p$, $q$, and $r$, a tautology $t$ and a contradiction $c$, the following logical equivalences hold:

| Logical Equivalences     |                                                          |                                                         |
| ------------------------ | -------------------------------------------------------- | ------------------------------------------------------- |
| Commutative laws:        | $p \land q \equiv q \land p$                             | $p \lor q \equiv q \lor p$                              |
| Associative laws:        | $(p \land q) \land r \equiv p \land (q \land r)$         | $(p \lor q) \lor r \equiv p \lor (q \lor r)$            |
| Distributive laws:       | $p \land (q \lor r) \equiv (p \land q) \lor (p \land r)$ | $p \lor (q \land r) \equiv (p \lor q) \land (p \lor r)$ |
| Identity laws:           | $p \land t \equiv p$                                     | $p \lor c \equiv p$                                     |
| Negation laws:           | $p \lor \sim p \equiv t$                                 | $p \land \sim p \equiv c$                               |
| Double negative law:     | $\sim (\sim p) \equiv p$                                 |                                                         |
| Idempotent laws:         | $p \land p \equiv p$                                     | $p \lor p \equiv p$                                     |
| Universal bound laws:    | $p \lor t \equiv t$                                      | $p \land c \equiv c$                                    |
| De Morgan's laws:        | $\sim (p \land q) \equiv \sim p \lor \sim q$             | $\sim (p \lor q) \equiv \sim p \land \sim q$            |
| Absoption laws:          | $p \lor (p \land q) \equiv p$                            | $p \land (p \lor q) \equiv p$                           |
| Negations of $t$ and $c$ | $\sim t \equiv c$                                        | $\sim c \equiv t$                                       |

- Vi kan bruke logiske lover (ekvivalens) for å bevise andre logiske ekvivalenser.

Eksempel på sannhetstabell (med beregning av en utsagnsvariabel $\land$):

| P   | Q   | $\land$ |
| --- | --- | ------- |
| T   | T   | T       |
| T   | F   | F       |
| F   | T   | F       |
| F   | F   | F       |


## Haskell notater:
- - -
- *Rent funksjonelt programmeringsspråk*
- *Lat programmeringsspråk*
- *Statisk typet*

**Datatyper:**
- *Int* - Små heltall
- *Integer* - Store heltall
- *Float* - Flytepunkt med single presisjon
- *Double* - Flytepunkt med dobbel presisjon
- *Bool* - Boolsk type
- *Char* - Karakter

**Lister:**
- Samling av objekter av samme type. Altså en *homogen datastruktur*. Der rekkefølgen av elementene er viktig.
Følgende tre kodeeksempler gir samme resultat, med en liste av heltall fra 1 til 4:
`let l = [1,2,3,4]`
`l = [1,2,3,4]`
`l = [1..4]`

*Data.List* inneholder nyttige funksjoner for å jobbe med lister.
`import qualified Data.List as L`
`L.head [a,b,c] -- Gir det første elementet fra listen`
`L.last [a,b,c] -- Gir det siste elementet fra listen`
`L.tail [a,b,c] -- Gir listen med alle elementer untatt det første`
`L.init [a,b,c] -- Gir listen med alle elementer untatt det siste`

**Tupler:**
- Ligner litt på lister, men kan inneholde objekter av forskjellige typer, og er altså en *ikke-homogen datastruktur*. Elementene i en tuppel kan ikke endres og tuppel kalles derfor en *uforanderlig datastruktur*.

`let t = (1,a,3,b) -- Tuppel med blanding av tall og bokstaver`
`t = (1,a,3,b) -- Kan også skrives uten "let"`

Modulen *Data.Tuple* inneholder predefinerte funksjoner for å jobbe med tupler.

**Mendger:**
- I Haskell er mengder litt annerledes enn i matematikk. En mengde er en samling objekter der alle elementene er unike, men i motsetning til i matematikk tas rekkefølgen av elementene i betraktning.

Modulen *Data.Set* brukes for å håndtere mengder i Haskell.

```
import qualified Data.Set as S -- Vi importerer modulen Data.Set og gir den navn S
let a = S.empty                -- På denne måten lager vi en tom mengde som vi kaller a
let b = S.singleton x          -- På denne måten lager vi en mengde b med bare et element x
let c = S.fromList [x, y]      -- På denne måten omgjør vi en liste [x, y] til en mengde {x, y})
```