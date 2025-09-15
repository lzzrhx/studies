
> [!info]
> [Emneplan](https://www.hvl.no/studier/studieprogram/emne/MAT101)
> **Studiepoeng:** 10
> **Vurdering:** Skoleeksamen, 03.12.2025 kl. 09:00

>[!todo]
>- [x] Se video - Haskell Programming Full Course
>- [x] Se videospilleliste - Discrete Math (Full Course)
>- [x] Uke 33 - Kap. 1.2, 1.3
>- [x] Uke 34 - Øvelse 1
>- [x] Uke 34 - Kap. 2.1, 2.2, 2.3, 2.4
>- [x] Uke 35 - Kap. 3.1, 3.2, 3.3, 3.4
>- [x] Uke 35 - Øvelse 2
>- [x] Uke 36 - Øvelse 3
>- [x] ==**Frist 12. September - Obligatorisk oppgave 1**==
>- [x] Uke 37 - Øvelse 4
>- [x] Uke 37 - Kap. 6.1, 6.2, 6.3
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
- [GHCi Documentation](https://downloads.haskell.org/ghc/latest/docs/users_guide/ghci.html)
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

ghci kommandoer:
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
\     \setminus        minus
∴    \therefore       gyldig argument

```


## Notater fra "Discrete mathematics with applications":
- - -
### Chapter 1 - Speaking Mathematically:

> Therefore O students study mathematics and do not build without foundations.
> - Leonardo da Vinci (1952-1519)

#### 1.1: Variables:

**Universal Conditional Statements:**
Universal statements contain some variation of the words "for every" and conditional statements contain versions of the words "if-then". A universal conditional statement is a statement that is both universal and conditional.
"For every animal $a$, if $a$ is a dog, then $a$ is a mammal.

**Universal Existential Statements:**
Universal because the first part says that certain property is true for all objects of a given type, and existential because the second part asserts the existence of something.
"Every real number has an additive inverse."

**Existential Universal Statements:**
First part asserts that a certain object exists and second part says that the object satisfies a certain property for all things of a certain kind.
"There is a positive integer that is less than or equal to every positive integer."


#### 1.2 - The Language of Sets:

"... when we attempt to express in mathematical symbols a condition proposed in words. First, we must understand thoroughly the condition. Second, we must be familiar with the forms of mathematical expression."
\- George Polyá (1987-1985)

The word set was introduced in 1879 by Georg Cantor. A set is a collection of objects. A set is completely determined by what its elements are - not the order in which they might be listed or the fact that some elements might be listen more than once.

**Set-Roster Notation:**
$S = \{1..100\}$
$x = 10$
$y = 200$
$x \in S$ - $x$ is an element of the set $S$
$y \not\in S$ - $y$ is not an element of the set $S$

**Frequently used sets:**
$\mathbb{R}$ - The set of all real numbers
$\mathbb{Z}$ - The set of all integers
$\mathbb{Q}$ - The set of all rational numbers, quotients of integers

Addition of a superscript + or - or the letters nonneg indicates only positive or negative or nonnegative elements of the set.
Ex.: $\mathbb{Z}^+$ is the set of all positive integers

**Set-Builder Notation:**
Let $S$ denote a set and let $P(x)$ be a property that that elements of $S$ may or may not satisfy.
$\{x \in S | P(x)\}$

**Subsets:**
If $A$ and $B$ are sets, then $A$ is called a subset of $B$, written $A \subseteq B$, if and only if, every element of $A$ is also an element of $B$. All sets are subsets of themselves. $A$ is a proper subset of $B$ if, and only if, very element of $A$ is in $B$ but there is at least one element of $B$ that is not in $A$. $A \not\subseteq B$ means that there is at least one element $x$ such that $x \in A$ and $x \notin B$.

**Ordered Pairs:**
Given elements $a$ and $b$, the symbol $(a, b)$ denotes the ordered pair consisting of $a$ and $b$ together with the specification that $a$ is the first element of the pair and $b$ is the second element. Two ordered pairs $(a,b)$ and $(c,d)$ are equal if, and only if, $a = c$ and $b = d$.

**Ordered n-tuples:**
Similar to ordered pairs, but with more elements.
Ex.: An ordered 3-tuple: $(a, b, c)$

**Cartesian Product:**
Given sets $A = \{a, b, c\}$ and $B = \{1, 2, 3\}$ the Cartesian product (also called the Cross-product) $A \times B$ is the set of all ordered 2-tuples $(a,b)$ where $a \in A$ and $b \in B$. $A \times B = \{(a,1),(a,2),(a,3),(b,1),(b,2),(b,3),(c,1),(c,2),(c,3)\}$
Symbolically: $A_1 \times A_2 \times \dots \times A_n = \{ ( a_1, a_2,\dots, a_n ) | a_1 \in A_1, a_2 \in A_2, \dots, a_n \in A_n$\}.


#### 1.3 - The Language of Relations and Functions:

> Mathematics is a language.
> - Josiah Willard Gibbs (1839-1903)

**Relations:**
Let $A$ and $B$ be sets. A relation $R$ from $A$ to $B$ is a subset of $A \times B$. Given an ordered pair $(x,y)$ in $A \times B$, $x$ is related to $y$ by $R$, written $x\ R\ y$, if and only if, $(x,y)$ is in $R$. The set $A$ is called the domain of $R$ and the set $B$ is called its co-domain.
The notation for a relation $R$ may be written symbolically as follows:
$x\ R\ y$ means that $(x, y) \in R$.
The notation $x\ \not R\ y$ means that $x$ is not related to $y$ by $R$:
$x\ \not R\ y$ means that $(x,y) \notin R$.

**Arrow Diagram of a Relation:**
Suppose $R$ is a relation from a set $A$ to a set $B$. Draw an arrow from $x$ to $y$ 
if, and only if, $x\ R\ y$
if, and only if, $(x,y) \in R$
Let $A = {1,2,3}$ and $B = {1,3,5}$ and relations $S$ and $T$ are defined as follows:
For every $(x, y) \in A \times B$,
$(x,y) \in S$ means that $x < y$ ($S$ is a "less than" relation)
$T = \{(2,1),(2,5)\}$.
Arrow diagrams of the relations $S$ and $T$:
![[screenshot_2025-09-01-193431.png]]
These example relations illustrate that is is possible to have several arrows coming out of the same element of $A$ pointing in different directions. Also, it is possible to have an element of $A$ that does not have an arrow coming out of it at all.

**Functions:**
A function $F$ from a set $A$ to a set $B$ is a relation with domain $A$ and co-domain $B$ that satisfies the following properties:
	1\. For every element $x$ in $A$, there is an element $y$ such that $(x,y) \in F$.
	2\. For all elements $x$ in $A$ and $y$ and $z$ in $B$, if $(x,y) \in F$ and $(x,z) \in F$, then $y = z$.
A less formal phrasing of the properties:
	1\. Every element of $A$ is the first element of an ordered pair of $F$.
	2\. No two distinct ordered pairs in $F$ have the same first element.
If $A$ and $B$ are sets and $F$ is a function from $A$ to $B$, then given any element $x$ in $A$, the unique element in $B$ that is related to $x$ by $F$ is denoted $F(x)$, which is read "$F$ of $x$."
Given the function $f$ and the function $g$ with the domain $A$, $f = g$, if, and only if, $f(x) = g(x)$ for all $x$ in $A$.

**Summary of definitions so far:**
- Ordered pairs can be defined in terms of sets.
- Cartesian products can be defined in terms of ordered pairs.
- Relations can be defined as subsets of Cartesian products.
- Functions can be defined as relations.


- - -

### Chapter 2 - The Logic of Compound Statements:

#### 2.1: Logical Form and Logical Equivalence:

> Logic is a science of the necessary laws of thought, without which no employment of the understanding and the reason takes place.
> - Immanuel Kant, 1785

**Statement:**
A statement (or proposition) is a sentence that is true or false but not both.

**Compound statements:**
Symbols used to build more complicated logical expressions:
$\sim$ denotes not. $\lnot$ can also be used.
$\land$ denotes and. $\lor$ denotes or.
The order of operations: First $\sim$, then $\land$ / $\lor$.
Translating from English to symbols:
$p$ but $q$ means $p$ and $q$.
neither $p$ nor $q$ means $\sim p$ and $\sim q$.

**Negation:**
If $p$ is a statement variable, the negation of $p$ is "not $p$" or "It is not the case that $p$" and is denoted $\sim p$. It has opposite truth value from $p$: if $p$ is true, $\sim p$ is false; if $p$ is false, $\sim p$ is true.

**Conjunction:**
If $p$ and $q$ are statement variables, the conjunction of $p$ and $q$ is "$p$ and $q$," denoted $p \land q$. It is true when, and only when, both $p$ and $q$ are true. If either $p$ or $q$ is false, or if both are false, $p \land q$ is false.

**Disjunction:**
if $p$ and $q$ are statement variables, the disjunction of $p$ and $q$ is "$p$ or $q$", denoted $p \lor q$. It is true when either $p$ is true, or $q$ is true, or both $p$ and $q$ are true; it is false only when both $p$ and $q$ are false.

**Statement forms:**
A statement form (or propositional form) is an expression made up of statement variables (such as $p$, $q$, and $r$) and logical connectives (such as $\sim$, $\land$, and $\lor$) that becomes a statement when actual statements are substituted for the component statement variables. The truth table for a given statement form displays the truth values that correspond to all possible combinations of truth values for its component statement variables.

**Exclusive or:**
When or is used in its exclusive sense, the statement "$p$ or $q$" means "$p$ or $q$ but not both", which translates into symbols as $(p \lor q) \land \sim (p \land q)$.
Exclusive or can be written with the symbol $\oplus$.

**Exclusive or truth table example:**

| $p$ | $q$ | $p \lor q$ | $p \land q$ | $\sim (p \land q)$ | $(p \lor q) \land \sim (p \land q)$ |
| --- | --- | ---------- | ----------- | ------------------ | ----------------------------------- |
| T   | T   | T          | T           | F                  | F                                   |
| T   | F   | T          | F           | T                  | T                                   |
| F   | T   | T          | F           | T                  | T                                   |
| F   | F   | F          | F           | T                  | F                                   |
The customary order to write truth tables involving two statements: TT, TF, FT, FF.

**Logical Equivalence:**
Two statement forms are called logically equivalent if, and only if, they have identical truth values for each possible substitution of statements for their statement variables. The logical equivalence of statement forms $P$ and $Q$ is denoted by writing $P \equiv Q$. To test whether two statement forms are logically equivalent a truth table can be used. If in each row the truth value of the two truth statements are the same, then they are logically equivalent.
Two statements are logically equivalent if, and only if, they have logically equivalent forms when identical component statement variables are used to replace identical component statements.

**Double negative property:**
$\sim (\sim p) \equiv p$

**Negations of And and Or: De Morgan's Laws:**
The negation of an and statement is logically equivalent to the or statement in which each component is negated.
Symbolically: $\sim (p \land q) \equiv \sim p\ \lor \sim q$
The negation of an or statement is logically equivalent to the and statement in which each component is negated.
Symbolically: $\sim (p \lor q) \equiv \sim p\ \land \sim q$

**Tautologies:**
Ex.: $p\ \lor \sim p$.
A tautology is a statement form that is always true regardless of the truth values of the individual statements substituted for its statement variables. A statement whose form is a tautology is a tautological statement. If $t$ is a tautology then $p \land t \equiv p$ and $p \lor t \equiv t$.

**Contradictions:**
Ex.: $p\ \land \sim p$.
A contradiction is a statement form that is always false regardless of the truth values of the individual statements substituted for its statement variables. A statement whose form is a contradiction is a contradictory statement. If $c$ is a tautology then $p \land c \equiv c$ and $p \lor c \equiv p$.

**Summary of logical Equivalences:**
![[screenshot_2025-09-02-184606.png]]


#### 2.2: Conditional Statements:

> ... hypotetical reasoning implies the subordination of the real to the realm of the possible ..
> - Jean Piaget, 1972

**Conditional Statements:**
If $p$ and $q$ are statement variables, the conditional of $q$ by $p$ is "If $p$ then $q$" or "$p$ implies $q$" and is denoted $p \rightarrow q$. It is false when $p$ is true and $q$ is false; otherwise it is true. $p \rightarrow q \equiv \sim p \lor q$. We call $p$ the hypothesis (or antecedent) of the conditional and $q$ the conclusion (or consequent). A conditional statement with a false hypothesis is considered true. In expressions that include $\rightarrow$ as well as other logical operators such as $\land$, $\lor$, and $\sim$, the order of operations is that $\rightarrow$ is performed last.

**The Negation of a Conditional Statement:**
The negation of "if $p$ then $q$" is logically equivalent to "$p$ and not $q$."
Symbolically: $\sim ( p \rightarrow q ) \equiv p\ \land \sim q$

**The Contrapositive of a Conditional Statement:**
One of the most fundamental laws of logic is the equivalence between a conditional statement and its contrapositive. The contrapositive of a conditional statement of the form "If $p$ then $q$" is "If $\sim q$ then $\sim p$.
Symbolically: The contrapositive of $p \rightarrow q$ is $\sim q \rightarrow \sim p$.
$p \rightarrow q \equiv \sim q \rightarrow \sim p$

**The Converse and Inverse of a Conditional Statement:**
These two variants of conditional statements are not logically equivalent to the statement. Suppose a conditional statement of the form "If $p$ then $q$" is given. The converse is "If $q$ then $p$." The inverse is "If $\sim p$ then $q$." The converse and the inverse of a conditional statement are logically equivalent to each other.
Symbolically:
The converse of $p \rightarrow q$ is $q \rightarrow p$,
and the inverse of $p \rightarrow q$ is $\sim p \rightarrow \sim q$,
they are logically equivalent: $q \rightarrow p \equiv \sim p \rightarrow \sim q$.

**Biconditional Statements:**
Given statement variables $p$ and $q$, the biconditional of $p$ and $q$ is "$p$ if, and only if, $q$" and is denoted $p \leftrightarrow q$. It is true if both $p$ and $q$ have the same truth values and is false if $p$ and $q$ have opposite truth values.
Symbolically: $p \leftrightarrow q \equiv (p \rightarrow q) \land (q \rightarrow p) \equiv (\sim p \lor q) \land (\sim q \lor p)$.

**Necessary and Sufficient Conditions:**
If $r$ and $s$ are statements:
$r$ is a sufficient condition for $s$ means "if $r$ then $s$" or that the occurrence of $r$ is sufficient to guarantee the occurrence of $s$.
$r$ is a necessary condition for $s$ means "if not $r$ then not $s$" or that if $r$ does not occur, then $s$ cannot occur either.

**Order of Operations for Logical Operators:**
1. $\sim$ is performed is performed first
2. Then $\land$ and $\lor$
3. And finally $\rightarrow$ and $\leftrightarrow$

**Summary of Symbolical Representation for Conditional Statements:**
1. Conditional Statement: $p \rightarrow q \equiv \sim p \lor q$
2. Negation: $\sim ( p \rightarrow q ) \equiv p\ \land \sim q$
3. Contrapositive: $p \rightarrow q \equiv \sim q \rightarrow \sim p$
4. Converse: $p \rightarrow q \not\equiv q \rightarrow p$
5. Inverse: $p \rightarrow q \not\equiv \sim p \rightarrow \sim q$


#### 2.3: Valid and Invalid Arguments:

> "Contrariwise," continued Tweedledee, "if it was so, it might be; and if it were so, it would be; but as it isn't, it ain't. That's logic.
> - Lewis Carroll, *Through the Looking Glass*

**Arguments:**
An argument is a sequence of statements, and an argument form is a sequence of statement forms. All statements in an argument and all statement forms in an argument form, except for the final one, are called premises (or assumptions or hypotheses). The final statement or statement form is called the conclusion. The symbol $\therefore$, which is read "therefore," is normally placed just before the conclusion. To say an argument form is valid means that no matter what particular statements are substituted for the statement variables in its premises, if the resulting premises are all true, then the conclusion is also true. To say that an argument is valid means that its form is valid. When an argument is valid and its premises are true, the truth of the conclusion is said to be inferred or deduced from the truth of the premises. A truth table can be used to determine validity or invalidity of an argument. We can only be sure that an argument is true when we know that the argument is sound. An argument is called sound if, and only if, it is valid and all its premises are true. An argument that is not sound is called unsound.

**Rules of Inference:**
A rule of inference is a form of argument that is valid. Here are some examples:
1. Modus Ponens
2. Modus Tollens
3. Generalization
4. Specialization
5. Elimination
6. Transitivity
7. Proof by Division into Cases

**Modus Ponens:**
An argument form consisting of two premises and a conclusion is called a syllogism. The first and second premises are called the major premise and minor premise.The most famous form of syllogism in logic is called modus ponens (latin meaning "method of affirming"). It has the following form:
	If Socrates is a man, then Socrates is mortal.
	Socrates is a man.
	$\therefore$ Socrates is mortal.
Or in abstract form:
	If $p$ then $q$
	$p$
	$\therefore q$

**Modus Tollens:**
Modus tollens is Lating meaning "method of denying".
It has the following form:
	If Zeus is human, then Zeus is mortal.
	Zeus is not mortal.
	$\therefore$ Zeus is not human
Or in abstract form:
	If $p$ then $q$.
	$\sim q$
	$\therefore\ \sim p$

**Generalization:**
	$p$
	$\therefore\ p \lor q$

**Specialization:**
	$p \land q$
	$\therefore\ p$

**Elimination:**
	$p \lor q$
	$\sim q$
	$\therefore\ p$

**Transitivity:**
	$p \rightarrow q$
	$q \rightarrow r$
	$\therefore\ p \rightarrow r$

**Proof by Division into Cases:**
	$p \lor q$
	$p \rightarrow r$
	$q \rightarrow r$
	$\therefore\ r$

**Fallacies:**
A fallacy is an error in reasoning that results in an invalid argument. Three common fallacies are:
1. Using ambiguous premises, and treating them as if they were unambiguous
2. Circular reasoning (assuming what is to proved without having derived it from the premises)
3. Jumping to a conclusion (without adequate grounds).

**The Converse Error Fallacy:**
Converse error is also known as the fallacy of affirming the consequent.
	$p \rightarrow q$
	$q$
	$\therefore\ p$

**The Inverse Error Fallacy:**
Inverse error is also known as the fallacy of denying the antecedent.
	$p \rightarrow q$
	$\sim p$
	$\therefore\ \sim q$

**A Valid Argument with a False Premise and a False Conclusion:**
The example argument is valid my modus ponens. But its major premise is false, and so is its conclusion:
	If Spot is a dog, then Spot is eating yoghurt for breakfast.
	Spot is a dog.
	$\therefore$ Spot is eating yoghurt for breakfast.

**An Invalid Argument with True Premises and a True Conclusion:**
The following argument is invalid by the converse error, but has a true conclusion:
	If New York is a big city, then New York has tall buildings.
	New York has tall buildings.
	$\therefore$ New York is a big city.

**Contradiction rule:**
If you can show that the supposition that statement $p$ is false leads logically to a contradiction, then you can conclude that $p$ is true.
	$\sim p \rightarrow c$, where $c$ is a contradiction
	$\therefore p$

**Summary of Rules of Inference:**
![[screenshot_2025-09-02-220743.png]]


#### 2.4: (Application) Digital Logic Circuits:

> Only connect!
> - E.M. Forster, *Howards End*

Electrical engineers generally use the symbols 1 and 0 rather than T and F to denote true and false values. 0 and 1 are called bits, short for binary digits.

Any variable, such as a statement variable or an input signal, that can take one of only two values is called a Boolean variable. An expression composed of Boolean variables and the connectives $\sim$, $\land$, and $\lor$ is called a Boolean expression.

**Black box:**
A black box is a circuit where the detailed implementation is often ignored while attention is focus on the relation between the input and the output.

**Recognizer:**
A recognizer is a circuit that outputs a 1 for exactly one particular combination of input signals and outputs 0's for all other combinations.
Ex.: $(P \land Q)\ \land \sim R$

**Types of gates:**
- NOT
- AND
- OR
- NAND (AND + NOT)
- NOR (OR + NOT)


- - -

### Chapter 3 - The Logic of Quantified Statements:

#### 3.1: Predicates and Quantified Statements I:

> ... it was not till within the last few years that it has been realized how fundamental any and some are to the very nature of mathematics.
> - A.N. Whitehead (1861-1947)

**Predicate:**
A predicate is a sentence that contains a finite number of variables and becomes a statement when specific values are substituted for the variables. The domain of a predicate variable is the set of all values that may be substituted in place of the variable.

**Truth Set;**
If $P(x)$ is a predicate and $x$ has domain $D$, the truth set of $P(x)$ is the set of all elements of $D$ that make $P(x)$ true when they are substituted for $x$. The truth set of $P(x)$ is denoted: $\{ x \in D\ |\ P(x)\}$
Let $P(x)$ and $Q(x)$ be predicates and suppose the common domain of $x$ is $D$.
The notation $P(x) \Rightarrow Q(x)$ means that every element in the truth set of $P(x)$ is in the truth set of $Q(x)$, or, equivalently, $\forall x, P(x) \rightarrow Q(x)$.
The notation $P(x) \Leftrightarrow Q(x)$ means that $P(x)$ and $Q(x)$ have identical truth sets, or, equivalently, $\forall x , P(x) \leftrightarrow Q(x)$.

**The Universal Quantifier $\forall$:**
Let $Q(x)$ be a predicate and $D$ the domain of $x$. A universal statement is a statement of the form "$\forall x \in D, Q(x)$." It is defined to be true if, and only if, $Q(x)$ is true for each individual $xx$ in $D$. It is defined to be false if, and only if, $Q(x)$ is false for at least one $x$ in $D$. A value for $x$ for which $Q(x)$ is false is called a counterexample to the universal statement.

**The Existential Quantifier $\exists$:**
Let $Q(x)$ be a predicate and $D$ the domain of $x$. An existential statement is a statement of the form "$\exists x \in D$ such that $Q(x)$." It is defined to be true if, and only if, $Q(x)$ is true for at least one $x$ in $D$. It is false if, and only if, $Q(x)$ is false for all $x$ in $D$.

**Universal Conditional Statement:**
It is common to omit explicit identification of the domain of predicate variables in universal conditional statements.
$\forall x$, if $P(x)$ then $Q(x)$.
$\forall x, P(x) \rightarrow Q(x)$


#### 3.2: Predicates and Quantified Statements II:

> TOUCHSTONE: Stand you both forth now: stroke your chins, and swear by your beards that I am a knave.
> CELIA: By our beards - if we had them - thou art.
> TOUCHSTONE: By my knavery - if I had it - then I were; but if you swear by that that is not, you are not forsworn.
> - William Shakespeare, *As You Like It*

**Negation of a Universal Statement:**
The negation of a statement of the form $\forall x$ in $D, Q(x)$ is logically equivalent to a statement of the form $\exists x$ in $D$ such that $\sim Q (x)$.
Symbolically: $\sim ( \forall x \in D, Q(x) ) \equiv \exists x \in D$ such that $\sim Q(x)$.

**Negation of an Existential Statement:**
The negation of a statement of the form $\exists x$ in $D$ such that $Q(x)$ is logically equivalent to a statement of the form $\forall x$ in $D, \sim Q(x)$.
Symbolically: $\sim ( \exists x \in D$ such that $Q(x)) \equiv \forall x \in D, \sim Q(x)$

**Negation of Universal Conditional Statements:**
$\sim ( \forall x, P(x) \rightarrow Q(x)) \equiv \exists x$ such that $\sim ( P(x) \rightarrow Q(x))$

**Vacuous Truth of Universal Statements:**
When a universal quantifier is used on an empty set, it is called vacuously true or true by default.

**Variants of Universal Conditional Statements:**
Consider a statement of the form $\forall x \in D$, if $P(x)$ then $Q(x)$.
1. Its contrapositive is the statement $\forall x \in D$, if $\sim Q(x)$ then $\sim P(x)$.
2. Its converse is the statement $\forall x \in D$, if $Q(x)$ then $P(x)$.
3. Its inverse is the statement $\forall x \in D$, if $\sim P(X)$ then $\sim Q(x)$
The original statement and its contrapositive are logically equivalent.
The original statement and its converse form are not logically equivalent.
The original statement and its inverse form are not logically equivalent.
The converse and inverse forms of the original statement are logically equivalent.

**Necessary and Sufficient Conditions, Only if:**
- "$\forall x, r(x)$ is a sufficient condition for $s(x)$" means "$\forall x$, if $r(x)$ then $s(x)$."
- "$\forall x, r(x)$ is a necessary condition for $s(x)$" means "$\forall x$, if $\sim r(x)$ then $\sim s(x)$" or, equivalently, "$\forall x$, if $s(x)$ then $r(x)$."
- "$\forall x, r(x)$ only if $s(x)$" means "$\forall x$, if $\sim s(x)$ then $\sim r(x)$" or equivalently, "$\forall x$, if $r(x)$ then $s(x)$."


#### 3.3: Statements with Multiple Quantifiers:

> It is not enough to have a good mind. The main thing is to use it well.
> - René Descartes

**Interpreting Statements with Two Different Quantifiers:**
In a statement containing both $\forall$ and $\exists$, changing the order of the quantifiers can significantly change the meaning of the statement.
If you want to establish the truth of a statement of the form $\forall x$ in $D, \exists y$ in $E$, such that $P(x, y)$ your challenge is to allow someone else to pick whatever element $x$ in $D$ they wish and then you must find an element $y$ in $E$ that "works" for that particular $x$.
If you want to establish the truth of a statement of the form $\exists x$ in $D$ such that $\forall y$ in $E, P(x, y)$ your job is to find one particular $x$ in $D$ that will "work" no matter what $y$ in $E$ anyone might choose to challenge you with.

**Negations of Statements with Two Different Quantifiers:**
$\sim ( \forall x \in D, \exists y \in E, P(x, y) ) \equiv \exists x \in D, \forall y \in E, \sim P(x, y)$
$\sim ( \exists x \in D, \forall y \in E, P(x, y) ) \equiv \forall x \in D, \exists y \in E, \sim P(x, y)$

**Language of First-Order Logic:**
Taken together, the symbols for quantifiers, variables, predicates, and logical connectives makes up what is known as the language of first-order logic.


#### 3.4: Arguments with Quantified Statements:

> The only complete safeguard against reasoning ill, is the habit of reasoning well; familiarity with the principles of correct reasoning; and practice in applying those principles.
> - John Stuart Mill

**Universal Instantiation:**
If a property is true of everything in a set, then it is true for any particular thing in the set.

**Universal Modus Ponens:**
$\forall x$, if $P(x)$ then $Q(x)$
$P(a)$ for a particular $a$.
$\therefore Q(a)$.

**Universal Modus Tollens:**
$\forall x$, if $P(x)$ then $Q(x)$.
$\sim Q(a)$, for a particular $a$.
$\therefore \sim P(a)$.

**Converse Error (Quantified Form):**
This is an invalid conclusion:
$\forall x$, if $P(x)$ then $Q(x)$.
$Q(a)$ for a particular $a$.
$\therefore P(a)$.

**Inverse Error (Quantified Form):**
This is an invalid conclusion:
$\forall x$, if $P(x)$ then $Q(x)$.
$\sim P(a)$, for a particular $a$.
$\therefore \sim Q(a)$.

**Universal Transitivity:**
$\forall x P(x) \rightarrow Q(x)$
$\forall x Q(x) \rightarrow R(x)$
$\therefore \forall x P(x) \rightarrow R(x)$


- - -

### Chapter 6 - Set Theory:

#### 6.1: Set Theory - Definitions and the Element Method of Proof

> The introduction of suitable abstractions is our mental aid to organize and master complexity.
> - E. W. Dijkstra (1930-2002)

**Subsets:**
$A \subseteq B \Leftrightarrow \forall x$, if $x \in A$ then $x \in B$.
$A \not\subseteq B \Leftrightarrow \exists x$, such that $x \in A$ and $x \not\in B$.

**Proper Subsets:**
$A \subset B \Leftrightarrow A \subseteq B$, and there is at least one element in $B$ that is not in $A$.

**Set Equality:**
Given sets $A$ and $B$, $A$ equals $B$, written $A = B$, if, and only if, every element of $A$ is in $B$ and every element of $B$ is in $A$.
Symbolically: $A = B \Leftrightarrow A \subseteq B$ and $B \subseteq A$.

**Universal Set:**
Most mathematical discussions are carried on within some context. For example, in a certain situation all sets being considered might be sets of real numbers. In such a situation, the set of real numbers would be called a universal set or a universe of discourse for the discussion. The universal set is usually denoted by the letter U.

**Operations on Sets:**
![[screenshot_2025-09-12-233105.png]]
Let $A$ and $B$ be subsets of a universal set $U$.
1. The union of $A$ and $B$, denoted $A \cup B$, is the set of all elements that are in at least one of $A$ or $B$.
   Symbolically: $A \cup B = \{x \in U\ |\ x \in A$ or $x \in B\}$
2. The intersection of $A$ and $B$, denoted $A \cap B$, is the set of all elements that are common to both $A$ and $B$.
   Symbolically: $A \cap B = \{x \in U\ |\ x \in A$ and $x \in B\}$
3. The difference of $B$ minus $A$ (or relative complement of $A$ in $B$), denoted $B - A$ or $B \setminus A$, is the set of all elements that are in $B$ and not $A$.
   Symbolically: $B - A = \{x \in U\ |\ x \in B$ and $x \not\in A\}$
4. The complement of $A$, denoted $A^c$, is the set of all elements in $U$ that are not in $A$.
   Symbolically: $A^c = \{ x \in U\ |\ x \not\in A \}$

**Interval Notation:**
Given real numbers $a$ and $b$ with $a \le b$:
$$\begin{align*}
&(\ a, b\ ) = { x \in \mathbb{R}\ |\ a < x < b}&&[\ a, b\ ] = { x \in \mathbb{R}\ |\ a \le x \le b}\\
&(\ a, b\ ] = { x \in \mathbb{R}\ |\ a < x \le b}&&[\ a, b\ ) = { x \in \mathbb{R}\ |\ a \le x < b}
\end{align*}$$
The symbols $\infty$ and $-\infty$ are used to indicate intervals that are unbounded either on the right or on the left:
$$\begin{align*}
(\ a, \infty\ ) &= { x \in \mathbb{R}\ |\ x > a} &&[\ a, \infty\ ] = { x \in \mathbb{R}\ |\ x \ge b}\\
(-\infty, b\ ] &= { x \in \mathbb{R}\ |\ x < b} &&[-\infty, b\ ) = { x \in \mathbb{R}\ |\ x \le b}
\end{align*}$$

**Disjoint Sets:**
Two sets are called disjoint if, and only if, they have no elements in common.
Symbolically: $A$ and $B$ are disjoint $\Leftrightarrow A \cap B = \emptyset$.

**Mutually Disjoint:**
Sets $A_1, A_2, A_3, \dots$ are mutually disjoint (or pairwise disjoint or nonoverlapping) if, and only if, no two sets $A_i$ and $A_j$ with distinct subscripts have any elements in common. More precisely, for all integers $i$ and $j = 1,2,3,\dots$ $A_i \cap A_j = \emptyset$ whenever $i \not = j$.

**Partitions of Sets:**
![[screenshot_2025-09-12-235835.png|200]]
A finite or infinite collection of nonempty sets $\{A_1, A_2, A_3,\dots\}$ is a partition of a set $A$ if, and only if, $A$ is the union of all the $A_i$; the sets $A_1, A_2, A_3,\dots$ are mutually disjoint.

**Power Sets:**
Given a set $A$, the power set of $A$, denoted $\mathcal{P}(A)$, is the set of all subsets of $A$.


#### 6.2: Properties of Sets

> ... only the last line is a genuine theorem here - everything else is in the fantasy.
> - Douglas Hofstadter, *Gödel, Escher, Bach*, 1979

**Some Subset Relations:**
1. Inclusion of Intersection:
   For all sets $A$ and $B$,
   $(a)\ \ A \cap B \subseteq A$ and $(b)\ \ A \cap B \subseteq B$.
2. Inclusion in Union:
   For all sets $A$ and $B$,
   $(a)\ \ A \subseteq A \cup B$ and $(b)\ \ B \subseteq A \cup B$.
3. Transitive Property of Subsets:
   For all sets $A$, $B$, and $C$,
   if $A \subseteq B$ and $B \subseteq C$, then $A \subseteq C$.

**Set Identities:**
An identity is an equation that is universally true for all elements in some set. Let all sets referred to below be subsets of a universal set $U$.
1. Commutative Laws: For all sets $A$ and $B$,
   $(a)\ \ A \cup B = B \cup A \ \ \text{and} \ \ (b)\ \ A \cap B = B \cap A$.
2. Associative Laws: For all sets $A$, $B$ and $C$,
   $(a)\ \ (A \cup B) \cup C = A \cup (B \cup C) \ \ \text{and} \ \ (b)\ \ (A \cap B) \cap C = A \cap (B \cap C)$.
3. Distributive Laws: For all sets $A$, $B$ and $C$,
   $(a)\ \ A \cup (B \cap C) = (A \cup B) \cap (A \cup C) \ \ \text{and} \ \ (b)\ \ A \cap (B \cup C) = (A \cap B) \cup (A \cap C)$.
4. Identity Laws: For every set $A$,
   $(a)\ \ A \cup \emptyset = A \ \ \text{and} \ \ (b)\ \ A \cap U = A$.
5. Complement Laws: For every set $A$,
   $(a)\ \ A \cup A^C = U \ \ \text{and} \ \ (b)\ \ A \cap A^C = \emptyset$.
6. Double Complement Laws: For every set $A$,
   $(A^C)^C = A$
7. Idempotent Laws: For every set $A$,
   $(a)\ \ A \cup A = A \ \ \text{and} \ \ (b)\ \ A \cap A = A$.
8. Universal Bound Laws: For every set A,
   $(a)\ \ A \cup U = U \ \ \text{and} \ \ (b)\ \ A \cap \emptyset = \emptyset$.
9. De Morgan's Laws: For all sets $A$ and $B$,
   $(a)\ \ (A \cup B)^C = A^C \cap B^C \ \ \text{and} \ \ (b)\ \ (A \cap B)^C = A^C \cup B^C$.
10. Absorption Laws: For all sets $A$ and $B$,
    $(a)\ \ A \cup (A \cap B) = A \ \ \text{and} \ \ (b)\ \ A \cap (A \cup B) = A$.
11. Complements of $U$ and $\emptyset$:
    $(a)\ \ U^C = \emptyset \ \ \text{and} \ \ (b)\ \ \emptyset^C = U$.
12. Set Difference Law: For all sets $A$ and $B$,
    $A - B = A \cap B^C$.

**Basic Method for Proving That Sets Are Equal:**
Let sets $X$ and $Y$ be given. To prove that $X = Y$:
1. Prove that $X \subseteq Y$.
2. Prove that $Y \subseteq X$.

**Element Method for Proving a Set Equals the Empty Set:**
To prove that a set $A$ is equal to the empty set $\emptyset$, prove that $X$ has no elements. To do this, suppose $A$ has an element and derive a contradiction
Example:
	Let $A$ be a set, and define $A =\{\ \}$. Suppose that there is at least one element, say $x$, such that $x \in A$. But this is impossible since $A$ has no elements. By Theorem 6.2.4, $A \subseteq \emptyset$ since $A$ has no elements. Also $\emptyset \subseteq A$ since $\emptyset$ has no elements. Thus $A = \emptyset$ by the definition of set equality.


#### 6.3: Disproofs and Algebraic Proofs

> If a fact goes against common sense, and we are nevertheless compelled to accept and deal with this fact, we learn to alter our notion of common sense.
> - Phillip J. Davis and Reuben Hersh, *The Mathematical Experience*, 1981


- - -

### Chapter 8 - Properties of Relations:

#### 8.1: Relations on Sets

> Strange as it may sound, the power of mathematics rests on its evasion of all unnecessary thought and on its wonderful saving of mental operations.
> - Ernst Mach (1838-1916)

A more formal way to refer to the kind of relation defined in Section 1.3 is to call it a binary relation because it is a subset of a Cartesian product of two sets. An $n$-ary relation is defined to be a subset of a Cartesian product of $n$ sets, where $n$ is any integer greater than or equal to two. Such a relation is the fundamental structure used in relational databases.

**The Less-than Relation for Real Numbers:**
	Define a relation $L$ from $\mathbb{R}$ to $\mathbb{R}$ as follows:
	For all real numbers $x$ and $y$,
	$x\ L\ y \Leftrightarrow x < y$

**The Congruence Modulo 2 Relation:**
	Define a relation $E$ from $\mathbb{Z}$ to $\mathbb{Z}$ as follows:
	For every $(m, n) \in \mathbb{Z} \times \mathbb{Z}$,
	$m\ E\ n \Leftrightarrow m - n\ \text{is even.}$

**The Inverse of a Relation:**
Let $R$ be a relation from $A$ to $B$. Define the inverse relation $R^{-1}$ from $A$ to $B$ as follows: $R^{-1} = \{(y,x) \in B \times A\ |\ (x,y) \in R\}$.
Operationally: For all $x \in A$ and $y \in B$, $(y, x) \in R^{-1} \Leftrightarrow (x,y) \in R$.

**Directed Graph of a Relation:**
A relation on a set $A$ is a relation from $A$ to $A$. When a relation $R$ is defined on a set $A$, the arrow diagram of the relation can be modified so that it becomes a directed graph. Instead of representing $A$ as two separate sets of points, represent $A$ only once, and draw and arrow from each point of $A$ to each related point. If a point is related to itself, a loop is drawn that extends out from the point and goes back to it. For all points $x$ and $y$ in $A$, there is an arrow from $x$ to $y \Leftrightarrow x\ R\ y \Leftrightarrow (x, y) \in R$.
Example:
	Let $A = \{ 3, 4, 5, 6, 7, 8 \}$ and define a relation $R$ on $A$ as follows:
	For every $x, y \in A$, $x\ R\ y \Leftrightarrow 2\ \ (x,- y)$
	![[screenshot_2025-09-13-163440.png|200]]

**N-ary Relations:**
Given sets $A_1 , A_2, \dots, A_n$ an $n$-ary relation $R$ on $A_1 \times A_2 \times \dots \times A_n$ is a subset of $A_1 \times A_2 \times \dots \times A_n$. The special cases of 2-ary, 3-ary, and 4-ary relations are called binary, ternary, and quaternary relations, respectively.


#### 8.2: Reflexivity, Symmetry, and Transitivity

> Mathematics is the tool specially suited for dealing with abstract concepts of any kind and there is no limit to its power in this field.
> - P. A. M. Dirac (1902-1984)

**Reflexive, Symmetric, and Transitive Properties of Relations:**
Let $R$ be a relation of a set $A$
1. $R$ is reflexive if, and only if, for every $x \in A, x\ R\ x$.
	Or written as:
		For every $x$ in $A, (x, x) \in R$.
	In informal terms:
		Each element is related to itself.
	On a directed graph:
		Each point of the graph has an arrow looping around from it and going back to it.
2. $R$ is symmetric if, and only if, for every $x, y \in A$, if $x\ R\ y$ then $y\ R\ x$.
	Or written as:
		For every $x$ and $y$ in $A$, if $(x, y) \in R$ then $(y, x) \in R$.
	In informal terms:
		If any one element is related to any other element, then the second element is related to the first.
	On a directed graph:
		In each case where there is an arrow going from one point to a second, there is an arrow going from the second point back to the first.
3. $R$ is transitive if, and only if, for every $x, y, z \in A$, if $x\ R\ y$ and $y\ R\ z$ then $x\ R\ z$.
	Or written as:
		For every $x$, $y$, and $z$ in $A$, if $(x, y) \in R$ and $(y, z) \in R$ then $(x, z) \in R$.
	In informal terms:
		If any one element is related to a second and that second element is related to a third, then the first element is related to the third.
	On a directed graph:
		In each case where there is an arrow going from one point to a second and from the second point to a third, there is an arrow going from the first point to the third. That is, there ar no "incomplete directed triangles" in the graph.
Example of a reflexive, symmetric and transitive relation:
	Let $A = \{2,3,4,6,7,9\}$ and define a relation $R$ on $A$ as follows:
	For every $x, y \in A,\ \ x\ R\ y \ \ \Leftrightarrow \ \ 3\ |\ (x - y)$
	![[screenshot_2025-09-13-170111.png|300]]


#### 8.3: Equivalence Relations

...


#### 8.5: Partial Order Relations

...


- - -

### Chapter 7 - Properties of Functions:

#### 7.1: Functions Defined on General Sets

...


#### 7.2: One-to-One, Onto, and Inverse Functions

...


#### 7.3: Composition of Functions

...


- - -

### Chapter 5 - Sequences, Mathematical Induction, and Recursion:

#### 5.1: Sequences

...


#### 5.2: Mathematical Induction I: Proving Formulas

...


#### 5.3: Mathematical Induction II: Applications 

...


#### 5.6: Defining Sequences Recursively

...


#### 5.9: General Recursive Definitions and Structural Induction

...


- - -

### Chapter 4 - Elementary Number Theory and Methods of Proof:

#### 4.4: Direct Proof and Counterexample IV: Divisibility

...


#### 4.5: Direct Proof and Counterexample V: Division into Cases and the Quotient-Remainder Theorem

...


- - -
#### 2.5: Application: Number Systems and Circuits for Addition
#### 1.4: The Language of Graphs
- - -
### Chapter 10 - Theory of Graphs and Trees:
#### 10.1: Trails, Paths, and Circuits
#### 10.2: Matrix Representation of Graphs
#### 10.3: Isomorphisms of Graphs
#### 10.4: Trees: Examples and Basic Properties
#### 10.5: Rooted Trees
#### 10.6: Spanning Trees and a Shortest Path Algorithm


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

**Proving that divisibility is transitive:**
	...