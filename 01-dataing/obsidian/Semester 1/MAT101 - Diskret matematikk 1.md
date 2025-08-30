
> [!info]
> [Emneplan](https://www.hvl.no/studier/studieprogram/emne/MAT101)
> **Studiepoeng:** 10
> **Vurdering:** Skoleeksamen, 03.12.2025 kl. 09:00

>[!todo]
>- [ ] Se video - Haskell Programming Full Course
>- [ ] Uke 33 - Kap. 1.2, 1.3
>- [ ] Uke 34 - Øvelse 1
>- [ ] Uke 34 - Kap. 2.1, 2.2, 2.3, 2.4
>- [ ] Uke 35 - Kap. 3.1, 3.2, 3.3, 3.4
>- [ ] Uke 35 - Øvelse 2
>- [ ] Obligatorisk oppgave 1
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
- [(YouTube spilleliste) Trefor Bazett - Discrete Math (Full Course)](https://www.youtube.com/playlist?list=PLHXZ9OQGMqxersk8fUxiUMSIx0DBqsKZS)
- [(Video) Haskell Programming Full Course 2024](https://youtu.be/TklkNLihQ_A)

**Linux Haskel installasjon:**
`curl --proto '=https' --tlsv1.2 -sSf https://get-ghcup.haskell.org | sh`

**Kommandoer:**
Start a simple repl:
`ghci`

Start a new Haskell project in the current directory:
`cabal init --interactive`

Kompilere *.hs fil:
`ghc <filnavn>.hs -o <navn>`

**ghci kommandoer:**
`:quit`

```
Norsk / Engelsk ordliste:
heltall                            integer
boolsk                             boolean
variabel                           variable
uttrykk                            expression
ledd                               term
element                            element
mengde                             set
mengdebygger                       set-builder / set comprehension
delmengde                          subset
union                              union
snitt                              intersection
verdimengde / rekkevidde           range
tuppel                             tuple
funksjon                           function
produkt                            product
kartesisk produkt / kryssprodukt   cartesian product / cross-product
binær relasjon                     binary relation
definisjonsområdet / domene        domain
verdiområdet / kodomene            codomain
funksjon                           function
argument                           argument
utsagn                             statement / proposition
konnektiv / logisk operator        logical connective / logical operator
konjunksjon / og                   conjunction / and
disjunksjon / eller                disjunction / or
negasjon / ikke                    negation / not
unær operasjon                     unary operation
sann                               true
usann                              false
sammensatt utsagn                  compound proposition
sannhetsverdi                      truth value
utsagnsform                        statement form / propositional form
sannhetstabell                     truth table
logisk ekvivalent                  logically equivalent
tautologi                          tautology
selvmotsigelse                     contradiction
eksklusiv eller                    exclusive OR (XOR)
implikasjon                        implication
kontraposisjon                     contraposition
konverse                           converse
inverse                            inverse
bikondisjonal / biimplikasjon      biconditional / biimplication
grunnutsagn                        simple proposition
kontrapositive                     contrapositive
boolsk notasjon                    boolean notation
disjunktiv normalform              disjunctive normal form
injektiv / en-til-en               injective
surjective / på                    surjective
bijektiv                           bijective
sammensetning                      composition
følge                              sequence
predikat                           predicate
sannhetsmengde                     truth set
∀ allkvantor                       universal quantifier
∃ eksistenskvantoren               existential quantifier
bundet variabel                    bounded variable
skopet                             scope

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Symboler:
∈    \in              element i
∉    \nin             element ikke i
⊆    \subseteq        delmengde
⊂    \subset          ekte delmengde
⊆    \not\subseteq    ikke delmengde av
∅    \emptyset        den tomme mengden
ℕ    \mathbb{N}       mengden av naturlige tall
ℤ    \mathbb{Z}       mengden av alle heltall
ℚ    \mathbb{Q}       mengden av rasjonale tall
-    \mathbb{I}       mengden av irrasjonale tall
ℝ    \mathbb{R}       mengden av reelle tall
{}   \{\}             mengde
⟨⟩   \lange \rangle   tuppel
×    \times           kryssprodukt
≡    \equiv           ekvivalens
≢   \not\equiv       ikke ekvivalens
⊕    \oplus           xor
∧    \land             og (konkjuksjon)
∨    \lor              eller (disjunksjon)
¬    \neg              ikke
~    \sim              ikke
→    \rightarrow       implikasjon
↔    \leftrightarrow   biimplikasjon
⇒   \Rightarrow       logisk konsekvens
⇔   \Leftrightarrow   logisk ekvivalens
⊤    \top              sann
⊥    \bot              usann
T    T                 sann
F    F                 usann
1    1                 sann
0    0                 usann
∀    \forall           allkvantoren
∃    \exists           eksistenskvantoren
∪    \cup              union
∩     \cap             snitt
∴    \therefore       gyldig argument

```


## Notater fra "Discrete Math (Full Course)" av Trefor Bazett:
- - - 
**Set-Roster Notation:**
	{0,2,4,5,...}

**Set-Builder Notation:**
	{x | P(x)}

**Cartesion Product of two sets:**
	The Cartesian Product $A \times B$ is the set of all ordered pairs $(a, b)$ where $a \in A$ and $b \in B$

**Relations:**
	A relation R between $A$ and $B$ is a subset of $A \times B$

**Functions:**
	A function $F$ between $A$ and $B$ is a relation between $A$ and $B$ such that:
	1. For every element $x \in A$ there is an element $y \in B$ such that $(x,y) \in F$
	2. If $(x, y) \in F$ and $(x,z) \in F$ then $y = z$

**Logical equivalence of two statements:**
	Two statements are logically equivalent if they have the same truth table

**Tautologies and contradictions:**
	A tautology $t$ is a statement that is always true
	A contradiction $c$ is a statement that is always false

**DeMorgan's laws:**
	$\sim (p \lor q) \equiv (\sim p) \land (\sim q)$
	$\sim (p \land q) \equiv (\sim p) \lor (\sim q)$

**Double negative law:**
	$\sim (\sim p) \equiv p$

**Identity laws:**
	$p \lor c \equiv p$
	$p \land t \equiv p$

**Universal Bound laws:**
	$p \lor t \equiv t$
	$p \land c \equiv c$

**Vacuously true statements:**
	When the hypothesis is false, the statement is vacuously true

**Conditional statements:**
	$p \rightarrow q$ means: "if $p$ is TRUE then $q$ is TRUE
	$p \rightarrow q \equiv \sim p \lor q$

**Negating a conditional statement:**
	$\sim (p \rightarrow q) \equiv p \land \sim q$

**Contrapositive of a conditional statement:**
	$p \rightarrow q \equiv \sim q \rightarrow \sim p$

**Biconditional statements:**
	The biconditional $p \leftrightarrow q$ means that both $p \rightarrow q$ and $q \rightarrow p$.

**The converse and inverse of a conditional statement:**
	The converse of the statement $p \rightarrow q$ is the statement $q \rightarrow p$.
	The inverse of the statement $p \rightarrow q$ is the statement $\sim p \rightarrow \sim q$.
	The converse and inverse are logically equivalent to each other but NOT logically equivalent to the original statement.

**Logical arguments:**
	A valid argument is a list of premises from which the conclusion follows.

**Modus Ponens is an argument of the form:**
	if $p$, then $q$.
	$p$.
	Therefore, $q$.

**Modus Tollens is an argument of the form:**
	if $p$, then $q$.
	$\sim q$.
	Therefore, $\sim p$.

**Generalization is an argument of the form:**
	$p$.
	Therefore, $p \lor q$.

**Specialization is an argument of the form:**
	$p \land q$.
	Therefore, $p$.

**Contradiction is an argument of the form:**
	$\sim p \rightarrow c$.
	Therefore, $p$.

**Statements:**
	A statement is either TRUE or FALSE.
	Example: $3 > 2$ is TRUE

**Predicates:**
	A predicate is a sentence depending on variables which becomes a statement upon substituting values in the domain. The truth set of a predicate  is a set of all the values $x$ in the domain where $P(x)$ is TRUE.: $\{ x \in D | P(x)\}$
	Examples:
		$P(x)$: $x$ is a factor of 12 with domain $\mathbb{Z}^{+}$
		$P(6)$ is TRUE
		$P(5)$ is FALSE
		$P(\frac{1}{3})$ is nonsense! since $\frac{1}{3} \not \in \mathbb{Z}^{+}$
		The truth set of $P(x)$ is $TS = \{1,2,3,4,6,12\}$
		$TS \subseteq \mathbb{Z}^{+}$

**The Universal Quantifier $\forall$ means "for all":**
	Main use: "quantifying" predicates.
	$\forall x \in D, P(x)$
	For all $x$ in the domain $D$, $P(x)$ is TRUE.

**The Existential Quantifier $\exists$ means "there exists":**
	Main use: "quantifying" predicates.
	$\exists x \in D, P(x)$
	There exists $x$ in the domain, such that $P(x)$ is TRUE.

**Statements, predicates and quantifiers:**
	Logical statements are TRUE or FALSE, but predicates depend on the input variable. By putting a quantifier before a predicate it is turned into a logical statement.
	Statement: $P:$ "Roofus is a mammal"
	Predicate: $P(x):$ "$x$ is a mammal"
	Statement: $Q: \forall x \in D, P(x):$ "Every dog is a mammal

**Negating the Universal Quantifier:**
	$\sim ( \forall x \in D, P(x) ) \equiv \exists x \in D, \sim P(x)$

**Negating the Existential Quantifier:**
	$\sim ( \exists x \in D, P(x) ) \equiv \forall x \in D, \sim P(x)$

**Negating Logical Statements with Multiple Quantifiers:**
	$\sim (\forall x \in D, \exists y \in D, y > x ) \equiv \exists x \in D, \forall y \in D, y \le x$
	$\sim ( \exists x \in D, \forall y \in D, x \ge y ) \equiv \forall x \in D, \exists y \in D, x < y$ 

**Universal-Conditionals $P(x)$ implies $Q(x)$:**
	$P(x) \Rightarrow Q(x)$ means $\forall x \in D, P(x) \rightarrow Q(x)$

**Sufficient condition:**
	$A(x):$ $x$ is a square
	$B(x):$ $x$ is a rectangle
	"All squares are rectangles"
	Or written as: if $x$ is a square, then $x$ is a rectangle
	Or written as: If $A(x)$, then $B(x)$
	$A(x)$ is a sufficient condition for $B(x)$
	Or in other words: $x$ being a square is sufficient to conclude $x$ is a rectangle.

**Necessary condition (sufficient condition in the contrapositive form):**
	$B(x):$ $x$ is a rectangle
	$C(x):$ $x$ is a quadrilateral
	If $x$ is a rectangle, then $x$ is a quadrilateral
	Or written as: If $B(x)$, then $C(x)$
	The contrapositive is: If $x$ is not a quadrilateral then $x$ is not a rectangle
	Or written as: If $\sim C(x)$, then $\sim B(x)$
	$C(x)$ is a necessary condition for $B(x)$

**Nested conditions:**
	$A(x):$ $x$ is a square
	$B(x):$ $x$ is a rectangle
	$C(x):$ $x$ is a quadrilateral
	$A(x) \Rightarrow B(x) \Rightarrow C(x)$
	Sufficient to have $A(x)$ if we want $B(x)$ but necessary to have $C(x)$
	$A(x)$ is a sufficient condition for $B(x)$
	$B(x)$ is a necessary condition for $A(x)$

**Formal definitions:**
	Even integers:
		Informal definition: $n$ is an even integer if $n$ can be written as twice an integer.
		Formal definition: $n$ is an even integer if $\exists k \in \mathbb{Z}$ such that $n = 2k$.
	Odd integers:
		Informal definition: $n$ is an odd integer if $n$ is an integer that is not even.
		Formal definition: $n$ is an odd integer if $\exists k \in \mathbb{Z}$ such that $n = 2k + 1$

**Proving math theorems, "Even + odd = odd" direct proof example:**
	Theorem: 
		An even integer plus an odd integer is another odd integer.
	Proof:
		Suppose $m$ is even and $n$ is odd.
		$\exists k_1 \in \mathbb{Z}$ and $\exists k_2 \in \mathbb{Z}$ so that $m = 2k_1$ and $n = 2k_2 + 1$.
		Then, $m + n = (2k_1) + (2k_2 + 1) = 2(k_1 + k_2) + 1$
		Let $k_3 = k_1 + k_2$, and note it is an integer.
		Hence, $\exists k_3 \in \mathbb{Z}$ so that $m + n = 2k_3 + 1$
		Thus $m + n$ is odd. $\blacksquare$
	Structure in the proof:
		1) State the assumption
		2) Formally define the assumptions
		3) Manipulate
		4) Arrive at definition of conclusion
		5) State the conclusion

**Proving math theorems, "Product of two evens is even" example:**
	Formal definition of an even number:
		For $n$ an integer: $n$ is even $\Leftrightarrow \exists k \in \mathbb{Z}$ such that $n = 2k$.
	Theorem:
		An even integer times an even integer is another even integer.
	Theorem stated formally:
		$\forall m, n \in \mathbb{Z}$, if $m$, $n$ are even, then $mn$ is even.
	Proof:
		Suppose $m$ and $n$ are even integers.
		As $m$, $n$ are even, $\exists r$ and $\exists s$ so that $m = 2r$ and $n = 2s$.
		Then,  $mn = (2r)(2s) = 2(2rs)$.
		Let $t=2rs$, and not it is an integer.
		Hence, $\exists t \in \mathbb{Z}$ so that $mn = 2t$.
		Thus $mn$ is even. $\blacksquare$
	Steps:
		1) Define terms
		2) State theorem formally
		3) Play around!
		4) Formal proof:
			1) Start with assumptions
			2) Apply definitions
			3) Manipulate
			4) Deduce conclusion

**Rational numbers definition:**
	Informal definition:
		$n$ is a rational number if it is a fraction. Ex: $\frac{3}{7}$
	Formal definition:
		$n$ is a rational number if $\exists p \in \mathbb{Z}, \exists q \in \mathbb{Z} \setminus \{0\}$ such that $n = \frac{p}{q}$
	Informal theorem:
		The sum of two rational numbers is another rational number.
	Formal theorem:
		...
	Proof:
		Suppose $m$ and $n$ are rational.
		$\exists p_1, p_2 \in \mathbb{Z}$ and $\exists q_1, q_2 \in \mathbb{Z} \setminus\{0\}$ so that $m = \frac{p_1}{q_1}$ and $n = \frac{p_2}{q_2}$
		Then, $m + n = \frac{p_1}{q_1} + \frac{p_2}{q_2} = \frac{p_1 q_2 + p_2 q_1}{q_1 q_2}$
		Let $p_3 = p_1 q_2 + p_2 q_1$ and $q_3 = q_1 q_2$
		Hence, $\exists p_3 \in \mathbb{Z}, \exists q_3 \in \mathbb{Z} \setminus\{0\}$ so $m + n = \frac{p_3}{q_3}$
		Thus $m + n$ is rational. $\blacksquare$


## Notater fra "Discrete mathematics with applications":
- - -
**Kapittel 1 - ...:**
 
...

- - -

**Kapittel 2 - ...:**

...


## Notater fra forelesninger:
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
- En påstand eller ytring som enten er *sann* eller u*sann*
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
		$p \rightarrow q \equiv \sim p \lor q$
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

**Tilstrekkelig og nødvendig betingelse:**
- $r$ er tilstrekkelig betingelse for $s$ betyr hvis $r$ så $s$ ($r \rightarrow s$)
- $s$  er en nødvendig betingelse for $r$ betyr hvis ikke $s$ så ikke $r$ ($\sim s \rightarrow \sim r \equiv r \rightarrow s$ fra kontraposisjon)
- $r \rightarrow s:r$ tilstrekkelig for $s$, $s$ nødvendig for $r$
	- Eksempel:
		$x > 5 \rightarrow x > 3$
		$x > 5$ er tilstrekkelig for at $x > 3$. Det er ikke nødvendig
		$x > 3$ er nødvendig for $x>5$ det kan ikke være $x >5$ uten at $x > 3$

**Gyldig og ikke gyldig argument:**
- Et *argument* er rekkefølge av utsagn
- Et *argument form*, er rekkefølge av utsagnsformer
- Alle utsagn i et argument og alle utsagnsformer i et argument form er kalt premisser, hypoteser, untatt den siste som er kalt konklusjon. Tegner $\therefore$ brukes.
- Argument form er *gyldig* når konklusjon er sann alltid premisser er sanne. Hvis det ikke holder sier vi at argument for er *ikke gyldig*.
- Feilslutning er en feil i rersonnementet som resulterer i et ugyldig argument

**Applikasjon: digitale logiske kretser:**
- Det er en analogi mellom logiske konnektiver og svitsje enheter
- Hvis vi vet innganger og utganger for en gitt krets, men ikke vet hva som foregår i selve kretsen kalles det en *black box*.
- *Disjunktiv normal form* er disjunksjon av konjunksjoner av utsagnsvariabler eller deres negasjoner.
- En *gjenkjenner* er en krets som gir ut en 1 for nøyaktig en bestemt kombinasjon av inngangssignaler og utganger 0 for alle andre kombinasjoner
- To logiske kretser er ekvivalente hvis og bare hvis inngang og utgang tabellene er identiske

- Eksempel på bevis av ekvivalens av to utsagnsformer: $( (p \land \sim q) \lor (p \land  q) ) \land q \equiv p \land q$
		Distributivlov: $(p \land \sim q) \lor (p \land  q) \land q \equiv p \land (\sim q \lor q) \land q$
		Kommutativlov: $p \land (\sim q \lor q) \land q \equiv p \land (q \lor \sim q) \land q$
		Negasjonlov: $p \land (q \lor \sim q) \land q \equiv p \land t \land q$
		Identitetslov: $p \land t \land q \equiv p \land q$

$(p \rightarrow q) \rightarrow r \equiv (\sim p \rightarrow r) \land (q \rightarrow r)$

$\sim (\sim p \lor q) \lor r \equiv (\sim (\sim p \lor r) \lor r) \land (\sim q \lor r)$

**Kvantorer:**
- *Predikat* er en setning som inneholder endelig mange variabler som blir sann eller usann når spesifikke verdier erstattes med variabler. Domene eller definisjonsområdet av et predikat variabel er mengden av alle verdier som kan erstattes i stedet for variabelen.
- *Sannheten mengde*. Hvis $P(x)$ er et predikat og $x$ har domenet $D$, sannheten mengden av $P(x)$ er mengden med alle elementer fra $D$ som $P(x)$ er sant for.
- $\forall$ *allkvantoren*, for alle, for enhver. $\forall x \in D, Q(x)$
- $\exists$ *eksistenskvantoren*, det finnes, det ekisterer. $\exists x \in D, Q(x)$
- *Bundet variabel* og *skopet*. Variabelen $x$ er bundet med kvantoren som påvirker den. Variabelen er innen skopet av kvantoren.

**Eksempeler på oppgave med bruk av logiske ekvivalenser (lover):**
1.
	$\sim (p \lor \sim q) \lor (\sim p \land \sim q) \lor (p \land q) \equiv \sim p \lor q$
	$(\sim p \lor \sim (\sim q)) \lor (\sim p \land \sim q) \lor (p \land q) \equiv$ (De Morgans lov)
	$(\sim p \lor q) \lor (\sim p \land \sim q) \lor (p \land q) \equiv$ (Dobbel nagasjon lov)
	$\sim p \land (q \lor \sim q) \lor (p \land q) \equiv$ (Distrubitiv lov)
	$(\sim p \land T) \lor (p \land q) \equiv$ (Negasjon lov)
	$\sim p \lor (p \land q) \equiv$ (Identitets lov)
	$(\sim p \lor p) \land (\sim p \lor q) \equiv$ (Distributiv lov)
	$T \land (\sim p \lor q) \equiv$ (Negasjon lov)
	$\sim p \lor q \equiv$ (Identitets lov)

2.
	$p \lor \sim q \rightarrow r \lor q \equiv (r \lor q) \lor (\sim p \land q)$
	$\sim (p \lor \sim q) \lor (r \lor q) \equiv$ (Implikasjon til disjunksjon)
	$(\sim p \land \sim (\sim q)) \lor (r \lor q) \equiv$ (De Morgans lov)
	$(\sim p \land q) \lor (r \lor q) \equiv$ (Dobbel negasjon lov)
	$(r \lor q) \lor (\sim p \land q) \equiv$ (Kommutativ lov)

Eksempel på Haskell implementasjon av implikasjon:
$p \rightarrow q \equiv \sim p \lor q$
`implikasjon :: Bool -> Bool -> Bool`
`implikasjon p q = (not p) || q`

**Negasjon av kvantifiserte utsagn:**
- Eksempel:
	- "Alle studenter liker matematikk"
	- Negasjon: "Det eksisterer minst en student som ikke liker matematikk"
- Negasjon av utsagn med formen: $\forall x \in D, Q(x)$ er logisk ekvivalent med utsagnet med formen: $\exists x \in D, \sim Q(x)$
	$\sim(\forall x \in D, Q(x)) \equiv \exists x \in D, \sim Q(x)$
- Negasjon av utsagn med formen: $\exists x \in D, Q(x)$  er logisk ekvivalent med utsagnet med formen: $\forall x \in D, \sim Q(x)$
	$\sim (\exists x \in D, Q(x) \equiv \forall x \in D, \sim Q(x))$

**Negasjon av universale kondisjonale utsagn:**
	$\sim (\forall x, P(x) \rightarrow Q(x)) \equiv \exists x, \sim (P(x) \rightarrow Q(x))$
	$P(x) \rightarrow Q(x) \equiv \sim P(x) \lor Q(x)$ så $\sim (P(x) \rightarrow Q(x)) \equiv P(x) \land \sim Q(x)$

**Relasjon av $\forall$, $\exists$, $\land$, $\lor$:
- Negasjon av $\forall$ *(for all)* er $\exists$ *(det finns en)*
- Negasjon av $\exists$ *(det finns en)* er $\forall$ *(for all)*
- De Morgans lover:
	- Negasjon av $\land$ *(og)* er $\lor$ *(eller)*
	- Negasjon av $\lor$ *(eller)* er $\land$ *(og)*
- $\forall x \in D, Q(x)$ betyr at $Q(x_1) \land Q(x_2) \land Q(x_3) \land \dots \land Q(x_n)$, hvor $D = \{x_1, x_2,\dots, x_n\}$
- $\exists x \in D, Q(x)$ betyr at $Q(x_1) \lor Q(x_2) \lor Q(x_3) \lor \dots \lor Q(x_n)$, hvor $D = \{x_1, x_2,\dots, x_n\}$

**Den tomme sannheten:**
- $\forall$ i en tom mengde $\emptyset$ er sann

**Varianter av universal kondisjonelle utsagn:**
- Vurdering av utsagnet med formen $\forall x \in D, P(x) \rightarrow Q(x)$
	- Kontraposisjon (contraposision): $\forall x \in D, \sim Q(x) \rightarrow \sim P(x)$
	- Omvendt (converse) utsagn: $\forall x \in D, Q(x) \rightarrow P(x)$
	- Invers (invers) utsagn: $\forall x \in D, \sim P(x) \rightarrow \sim Q(x)$

**Eksempler på oppgaver:**
Q2 - I den oppgaven skal du vise at den følgende utsangslogiske formelen er en tautologi: $(\lnot Q \land (P \rightarrow Q)) \rightarrow \lnot P$

a) Vis at formelen er en tautologi ved å benytte sannhetsverditabell:

| $P$ | $Q$ | $\sim P$ | $\lnot Q$ | $P \rightarrow Q$ | $\lnot Q \land (P \rightarrow Q)$ | $(\lnot Q \land (P \rightarrow Q)) \rightarrow \lnot P$ |
| --- | --- | -------- | --------- | ----------------- | --------------------------------- | ------------------------------------------------------- |
| T   | T   | F        | F         | T                 | F                                 | T                                                       |
| T   | F   | F        | T         | F                 | F                                 | T                                                       |
| F   | T   | T        | F         | T                 | F                                 | T                                                       |
| F   | F   | T        | T         | T                 | T                                 | T                                                       |

Øvelse 2:

Q1
h - "john er sunn"
w - "john er rik"
s - "john er klok"
1.a) $\lnot h \land w \land \lnot s$
1.b) $\lnot w \land h \land s$
1.c) $\lnot (h \land w \land s)$
1.d) $\lnot (w \land s) \land h$

Q2
2.a)

| $P$ | $Q$ | $(P \lor Q)$ | ($\lnot P \lor \lnot Q)$ | $(P \lor Q) \land (\lnot P \lor \lnot Q)$ |
| --- | --- | ------------ | ------------------------ | ----------------------------------------- |
| T   | F   | T            | T                        |                                           |
| F   | T   | T            | T                        |                                           |

a.b)



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

**Mengder:**
- I Haskell er mengder litt annerledes enn i matematikk. En mengde er en samling objekter der alle elementene er unike, men i motsetning til i matematikk tas rekkefølgen av elementene i betraktning.

Modulen *Data.Set* brukes for å håndtere mengder i Haskell.

```
import qualified Data.Set as S -- Vi importerer modulen Data.Set og gir den navn S
let a = S.empty                -- På denne måten lager vi en tom mengde som vi kaller a
let b = S.singleton x          -- På denne måten lager vi en mengde b med bare et element x
let c = S.fromList [x, y]      -- På denne måten omgjør vi en liste [x, y] til en mengde {x, y})
```