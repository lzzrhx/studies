> [!info]
> [Emneplan](https://www.hvl.no/studier/studieprogram/emne/DAT100)  /  [GitHub](https://github.com/dat100hib/dat100public)
> **Studiepoeng:** 10
> **Vurdering:** Skoleeksamen, 25.11.2025 kl. 09:00

>[!todo]
>- [x] Uke 33 - Lese kapittel 1
>- [x] Uke 33 - JP0
>- [x] Uke 34 - Lese kapittel 2
>- [x] Uke 34 - Lese kapittel 3
>- [x] Uke 34 - JP1
>- [x] Uke 35 - Lese kapittel 4
>- [x] Uke 35 - JP2
>- [ ] Uke 36 - **Levere oppgave 1**
>- [x] Uke 36 - Lese kapittel 5
>- [ ] Uke 36 - JP3
>- [x] Uke 38 - Lese kapittel 6
>- [ ] Uke 38 - JP4
>- [ ] Uke 39 - JP5
>- [ ] Uke 40 - JP6
>- [ ] Uke 41 - **Levere oppgave 2**
>- [ ] Uke 41 - Lese kapittel 7
>- [ ] Uke 42 - **Levere prosjekt**
>- [ ] Uke 42 - Lese kapittel 9
>- [ ] Uke 43 - JP7
>- [ ] Uke 44 - **Levere oppgave 3**
>- [ ] Uke 44 - JP8
>- [ ] Uke 46 - JP9
>- [ ] Uke 47 - JP10

| Uke | Undervisning #1      | Undervisning #2      | Lab                | Hovedfrister  |
| --- | -------------------- | -------------------- | ------------------ | ------------- |
| 33  | F01 (kap. 1)         | F01 (kap. 1)         | JP00               |               |
| 34  | F02 (kap. 2.1 - 2.7) | F03 (kap. 3.1 - 3.3) | JP01               |               |
| 35  | F04 (kap. 3.4 - 3.6) | F05 (kap. 3.7 - 3.9) | JP02               |               |
| 36  | F06 (kap. 4.1 - 4.4) | F07 (kap. 4.5 - 4.8) | JP03               | **Oppgave 1** |
| 37  | F08                  | F09 (kap. 5.1 - 5.6) | Obligatorisk prøve |               |
| 38  | F10                  | F11 (kap. 5.8)       | JP04               |               |
| 39  | F12                  | F12 (kap. 6.1 - 6.3) | JP05               |               |
| 40  | F13 (kap. 6.1 - 6.3) | F14 (kap. 6.4 - 6.6) | JP06               |               |
| 41  | F15                  | **Prosjekt**         | **Prosjekt**       | **Oppgave 2** |
| 42  | F16 (kap. 7.1 - 7.3) | F17 (kap. 5.4)       | **Prosjekt**       | **Prosjekt**  |
| 43  | F18 (kap. 7.4)       | F19 (kap. 9.2)       | JP07               |               |
| 44  | F20 (kap. 9.1)       | F21 (kap. 9.2 - 9.3) | JP08               | **Oppgave 3** |
| 45  | F22 (kap. 5.7)       | F23                  | **Mini-eksamen**   |               |
| 46  | F24                  | F25                  | JP09               |               |
| 47  | F26                  | F26                  | JP10               |               |
| 48  | **Eksamen**          | **Eksamen**          | **Eksamen**        | **Eksamen**   |

**Pensumliste:**
- [Forstå programmering med Java (2. utg.)](https://bibsys-xc.alma.exlibrisgroup.com/leganto/public/47BIBSYS_HIB/citation/10380362690002221?auth=SAML)

**Andre linker:**
- [Forstå programmering med Java - Nettressurs](https://dbsys.info/programmering/)
- [JDoodle](https://www.jdoodle.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Learn Java](https://dev.java/learn/)
- [Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Java Code Conventions (pdf)](https://www.oracle.com/docs/tech/java/codeconventions.pdf)
- [JavaFX nettside](https://openjfx.io/)
- [JavaFX dokumentasjon](https://openjfx.io/javadoc/11/)
- [Dokumentasjon for Java-biblioteket](https://docs.oracle.com/en/java/javase/24/docs/api)

**Arch pakker:**
`sudo pacman -S jdk-openjdk intellij-idea-community-edition`



## Notater:
- - -

**Kapittel 1 - Forstå program:**

En *variabeldeklarasjon* innfører en ny variabel og tildeler den datatype.
`int x;`
`double y;`

Variabler kan *initieres*, dvs. gis en startverdi i selve deklarasjonen.
`int x = 10;`
`double y = 3.14;`

Deklarerte variabler kan gis nye verdier ved bruk av *tilordning*.
`x = 5;`

*Syntaks* - Regler: Hva er som er lovlig i et program
*Semantikk* - Betydning: Hva programmet gjør når det kjøres
*Pragmatikk* - Hvordan bruke språket på en god måte

- - -

**Kapittel 2 - Setninger og uttrykk:**

Å sette sammen to eller flere tegnsekvenser kalles *konkatenering*.
`String navn = "Anne";`
`String resultat = "Hei " + navn + ".";`

- - -

**Kapittel 3 - Kontrollstrukturer:**

To typer kontrollstrukturer:
- Valgsetninger (if-then-else/switch) - Består av betingelser og greiener (eks. if-grein, else-grein)
- Løkker (for/while/do-while) - Består av *løkkekropp*

En if-setning inni en annen if-setning kalles *nøstet (nested)* if-setning. Begrepet *nøsting* brukes når en kontrollstruktur er inne i samme kontrollstruktur.

En switch-setning består av et antall greiner, som starter med det reserverte ordet *case* og en *tilslagsmarkør (case label)*. Hver switch-grein avsluttes med *break* (hvis setningen ikke har returverdi). 

Ved bruk av *while-løkker* er det viktig å unngå *evige løkker*. Dette kan sikres mot ved å sørge for at løkkekroppen alltid inneholder en oppdatering av *kontrollvariablene*.

*Skopet (scope)*  er virkeområdet til en variabel. Variabler deklarert i en metode kalles for *lokale variabler*.

- - -

**Kapittel 4 - Metoder**

*Prosedural programmering* betyr at større program blir strukturert ved hjelp av mindre delprogram (prosedyrer).

```
// Metodedeklarasjon:

Hjelpemetode      Returdatatype       Formell parameter
 /                /                   /
private static void eksempelMetode(int antall) { ... }
          \               \                       \
        Selvstendig      Navn                 Metodekropp (fordeles over flere linjer)

// private: Metoden kan kun brukes internt i klassen
// static:  Metoden er statisk, og er uavhengig av objekt
// void:    En spesiell datatype som forteller at metoden ikke har returverdi


// Metodekall:

 Metodenavn
 /
eksempelMetode(2);
                 \
                 Aktuell parameter (argument)
```

*Formelle parametre* er en deklarering av metodens forventede parametre som del av metodedeklarasjonen.

*Aktuelle parametre* er angitte parametre i metodekallet som brukes i utførelse av metoden.

*Parameterliste* er en liste av formelle eller aktuelle parametre. Plassert mellom paranteser og adskilt med komma.

I noen språk skilles det mellom delprogram som returnerer en verdi og de som ikke gjør det.

En *funksjon* er et delprogram som kan ta 0 eller flere parametre, og som returnerer nøyaktig 1 verdi. *Funksjonskall* brukes som *uttrykk*.

En *prosedyre* er et delprogram som kan ta 0 eller flere parametre, men som ikke returnerer noen verdi. *Prosedyrekall* brukes som *setninger*.

I hava brukes ikke begrepene *funksjon* og *prosedyre*, alt kalles metoder.

For *parameteroverføring* av variabler for primitive datatyper bruker Java *verdioverføring (call by value)*. Tilordninger eller verdiendringer av den formelle parameteren i metoden får ikke tilbakevirkende effekt på den aktuelle parameteren i kallet.

En *hjelpevariabel* er en lokal variabel deklarert i den aktuelle metodekroppen. *Levetiden* til lokale variabler er begrenset til én utførelse av metoden. *Virkeområdet* til lokale variabler er kun (lokalt) inne i metodekroppen.

*Dummy-metoder* brukes midlertidig. De har riktige formelle parametre og returnerer riktig datatype, men mangler utfylt metodekropp og returnerer alltid samme midlertidige returverdi. Dummy-metodene brukes for å få programmet til å kompilere underveis i utviklingen, og erstattes gradvis med reel kode.

I Java deles større program opp i *pakker*, *klasser* og *metoder*. En pakke består av klasser (og andre pakker), en klasse av metoder, og en metode av setninger. En *modul* kan inneholde flere pakker.

Filnavnet på Klasser skrives med PascalCase og organiseres i kataloger som tilsvarer pakkenavnet. Klassen javafx.scene.control.Button ville vært lagret med filnavnet Button.java i katalogen javafx/scene/control.

Programmering kan gjøre *topp-ned*, der vi starter med en overordnet idé. eller *bunn-opp* der flere "byggeklosser" settes sammen til et fullstendig program.

*Statiske metoder* hører til *klassen* de er deklarert i og er uavhengig av enkeltobjekter. En statisk metode kan tenkes på som en "selvstendig" metode. Disse metodene omtales gjerne som *klassemetoder*.

Java har automatisk import av pakken java.lang.

- - - 

**Kapittel 5 - Tabeller**

Deklarering av tabell med datatypen int:
`int[] eksempelTabell; = new int[lengde]`

Deklarering og initiering av tabell med bruk av *verdiliste*:
`int[] eksempelTabell = {1, 2, 3, 4};`

Avlesing av en verdi fra tabellen gjøres ved å bruke *indeks*:
`int tallFraTabell = eksempelTabell[0];`

En *indeksert variabel* er én enkelt lagringsplass i en tabell.

En tabellvariabel er en *referanse* til en tabell. Tabellvariablen inneholder kun adressen til tabellen (adressen til det første elementet i tabellen).

Ved oppretting (new) av en tabell blir alle elementene i tabellen tildelt datatypens standardverdi.

*Lengden* til en tabell er antallet elementer i tabellen.
`eksempelTabell.length`

*Sortering og søk* er viktige tema innen programmering, og effektive søk krever et sortert datasett.

I en tabell der verdier ligger usortert hulter til bulter er det ikke noe bedre fremgangsmåte enn å lete fra start til slutt i et såkalt *sekvensielt søk*.

*Stigende sortering:*
$v1 \le v2 \le v3 \le \dots \le v_N$

*Strengt stigende sortering:*
$v1 \lt v2 \lt v3 \lt \dots \lt v_N$

*Avtagende sortering:*
$v1 \ge v2 \ge v3 \ge \dots \ge v_N$

*Strengt avtagende sortering:*
$v1 \gt v2 \gt v3 \gt \dots \gt v_N$

Det finnes mange ulike algoritmer for sortering. En av de aller enkleste er såkalt *plukksortering*.

For variabler av primitive datatyper brukes verdioverføring for tilordning og parameteroverføring. For tabeller brukes *referanseoverføring* for tilordning og parameteroverføring.

Når en tabell A brukes som *referansevariabel* for tilordning til en annen tabell B, vil B settes til å *peke på* A. Endringer i A vil også gi endringer i B ettersom A og B da blir samme tabell.

For å kjøre en løkke gjennom alle elementene i en tabell kan en bruke en *utvidet for-løkke*:
```
String[] eksempelTabell = {"navn1", "navn2", "navn3"}
for (String navn: eksempelTabell) {
	System.out.println(navn);
}
```

Arrays-klassen har en rekke nyttige metoder å bruke når man jobber med tabeller.

`Arrays.equals(tabellA, tabellB)` kan brukes for se om to tabeller er like. Det vil si om de er like lange, har samme  verdier, og at verdiene står i samme rekkefølge. `tabellA == tabellB` kan brukes for å sjekke om referansevariablene peker på samme adresse.


`Arrays.sort(tabell)` kan brukes for å sortere en tabell med en såkalt *quick sort* algoritme når elementene er primitive datatyper, og en *merge sort* algoritme når elementene er objekter.

For å sjekke om to tabeller er like, uavhengig av rekkefølge, kan `Arrays.sort` brukes først på begge tabeller, etterfulgt av `Arrays.equals`

`Arrays.binarySearch` gir effektive søk i sorterte tabeller.

*Flerdimensjonale tabeller* har minst to indekser og kan gjennomløpes med *nøstede løkker*.

```
int[][] eksempel = {
	{1, 2, 3},
	{1, 2, 3},
	{1, 2, 3}
};

int[][] eksempel2 = new int[antall1][antall2];

for (int i = 0; i < antall1; i++) {
	for (int j = 0; j < antall2; j++) {
		System.out.println(eksempel2[i][j]);
	}
}
```

`Array.equals` brukes på endimensjonale tabeller, men for flerdimensjonale brukes metoden `Arrays.deepEquals`.

- - -

**Kapittel 6 - Objekt**

En *klasse* er en formell beskrivelse av *objekt*. Klasser kan sees på som nye datatyper. Variabler som blir deklarert med klasse som datatype kalles for *referansevariabler*. De peker på et objekt. Et objekt er en informasjonsenhet sammensatt av ulike data som er laget i en eller flere objektvariabler.

```
public class EksempelKlasse {
	int id;
	String navn;
}

EksempelKlasse nyttObjekt;
nyttObjekt = new EksempelKlasse();

nyttObjekt.id = 10;
nyttObjekt.navn = "navn her";
```

Tilordning med en refereransevariabel fungerer likt som med tabeller og vil overføre objektets *adresse* til variabelen.

```
EksempelKlasse eks1 = new EksempelKlasse();
EksempelKlasse eks2 = eks1;
// eks1 og eks2 peker nå på samme objekt
```

Java har automatisk *søppeltømming* og objekter som ikke blir referert til av noen referansevariabler blir automatisk slettet (minne blir frigjort).

```
EksempelKlasse eks1 = new EksempelKlasse();
EksempelKlasse eks2 = new EksempelKlasse();
eks1 = eks2;
// Det første objektet som eks1 originalt pekte på er ikke lenger i bruk blir etter hvert automatisk slettet av Java
```

Initiering med konstruktør utfører en metode som kan motta parametre når det nye objektet lages. En konstruktør ser ut som en vanlig metodedeklarasjon, med to unntak: En konstruktør har ikke returdatatype. En konstruktør har samme navn som den tilhørende klassen.

```
public class EksempelKlasse {
	int id;
	String navn;
	
	// Konstruktør
	public EksempelKlasse(int id, String navn) {
		this.id = id;
		this.navn = navn;
	}
}

EksempelKlasse nyttObjekt = new EksempelKlasse(10, "navn her");
```

For sammenligning av innholdet i to String objekter brukes objektmetoden .equals(). Eks.: `string1.equals(string2)` vil gi true hvis teksten i begge String objektene er lik. `string1 == string2` sammenligner bare referansevariablene og sjekker om de peker på samme adresse i minnet. `equals()` objektmetoden avgjør *verdilikhet* på tekststrenger. `equalsIgnoreCase()` sammenligner innholdet i to String objekter uten å ta hensyn til store/små bokstaver.

En objektmetode som endrer tilstanden til det aktuelle objektet kalles en *mutator*.

En objektmetode som avleser tilstanden til et objekt kalles for en *observator*.

Objektvariabler kan inkapsuleres med modifikatoren *private*. `private int x = 123;` dette gjør at variabelen kun er tilgjengelig internt i klassen og ikke kan nås utenfra direkte. Det er god tone å sette alle objektvariabler som `private`, samt inføre set- og get-metoder for kontrollert aksess utenfor klassen. Det er dette som menes med *innkapsling*.

Java-ordene `public` og `private` er eksempel på såkalte *aksessmodifikatorer*. De styrer i hvilken grad objektvariabler og metoder er synlige utenfor klassen de er deklarert i.

En klasse kan ha flere konstruktører med forskjellige parameterlister og flere metoder med samme navn og ulike parameterlister. Dette kalles *overlasting*.

*Verditabeller* inneholder verdier av primitive datatyper. *Referansetabeller* inneholder referanser (adresser) til konkrete objekter.

*Klassevariabler* er statiske variabler som hører til selve klassen, og er ulikt objektvariabler som er unike for hvert objekt.

Parameteroverføring av objekt blir, slik som med tabeller, håndtert ved *referanseoverføring*.

Flere metodekall kan gjøres etter hverandre i samme setning med *kjedet punktnotasjon*. `obj.met1(1,2).met2(1,2).met3(1,2);`

*String* klassen er immutabel og metodekall som `.toUpperCase()` leverer et nytt string-objekt.

Ved bruk av `==` sammenlignes primitive datatyper med verdilikhet, og objekter med referanselikhet. Sammenligning med verdilikhet må vi selv definere når vi lager nye klasser. (String har `.equals()` innebygd).

Objektvariabler med modifikatoren *static* er felles for alle objektene av klassen. Disse kalles *klassevariabler*. `private static int x = 1;`

Oppramstypen *enum* kan sammenlignes med `.equals` metoden. Ordningsnummer kan hentes ut ved kall på ordinal-metoden `.ordinal()`. Elementene i en enum kan konverteres til en endimensjonell tabell med `.values()` metoden.

- - -

**Kapittel 7 - Filer og unntak**

- - -

**Kapittel 8 - Grafisk brukergrensesnitt**

- - -

**Kapittel 9 - Objektorientert programmering**



## Om Java:

```
Java konsollkommandoer:
javac     Java-kompilator.
java      Verktøy (VM) for å kjøre kompilert Java bytekode.
javadoc   Verktøy for å generere dokumentasjon basert på kommentarer
jar       Verktøy for å håndtere jar-filer (komprimerte filer)
jshell    Java REPL

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Reserverte ord:
abstract
assert
boolean
break
byte
case
catch
char
class
const
continue
default
do
double
else
enum
extends
final
finally
float
for
goto
if
implements
import
instanceof
int
interface
long
native
new
package
private
protected
public
return
short
static
strictfp
super
switch
synchronized
this
throw
throws
transient
try
void
volatile
while

Restricted keywords:
exports
module
open
opens
provides
requires
to
transitive
uses
with

Unngå:
true
false
null
main
String

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Anbefalt ordsammensetning:
variabler     camelCase
metoder       camelCase
klasser       PascalCase
konstanter    SCREAMING_SNAKE_CASE
enum verdier  SCREAMING_SNAKE_CASE

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Primitive datatyper:
byte
Type: 8-bit signed two's complement integer
Verdi: Fra -128 til 127
Standardverdi: 0

short
Type: 16-bit signed two's complement integer
Verdi: Fra -32,768 til 32,767
Standardverdi: 0

int
Type: 32-bit signed two's complement integer
Verdi: Fra -2^31 til -2^31 - 1
Standardverdi: 0

long
Type: 64-bit signed two's complement integer
Verdi: Fra -2^63 til -2^63 - 1
Standardverdi: 0L

float
Type: single-precision 32-bit IEEE 754 floating point
Standardverdi: 0.0f

double
Type: double-precision 64-bit IEEE 754 floating point
Standardverdi: 0.0d

boolean
Verdi: true / false
Standardverdi: false

char
Type: 16-bit Unicode character
Verdi: Fra \u0000 til \uffff
Standardverdi: \u0000

String
String er i grunn ikke en primitv type, men en klasse.
Stringverdier er immutable.
Standardverdi for String og alle andre klasser er null.


int i = 26;                 // = 26 (int)
long l = 26L;               // = 26 (long)
int hexadecimalVal = 0x1a;  // = 26 (int)
int binaryVal = 0b11010;    // = 26 (int)
double d = 123.4;           // = 123.4 (double)
float f = 123.4F;           // = 123.4 (float)
double sci = 1.234e2        // = 123.4 (double)
byte b = 0b0001_1010;       // = 26 (byte)
String s = "string"
char c = 'c'

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Tilordningsoperator:
= Tilordning

Arithmetic operators:
+ Additive operator
- Subtractive operator
* Multiplication operator
/ Division operator
% Remainder operator (modulo)

Unary operators:
+  Unary plus operator
-  Unary minus operator
++ Increment operator
-- Decrement operator
!  Logical complement operator (inverts boolean value)

Equality and relational operators:
== Equal to
!= Not equal to
>  Greater than
>= Greater than or equal to
<  Less than
<= Less than or equal to

Conditional operators:
&& Conditional-AND
|| Conditional-OR
?: Ternary (if-then-else statement shorthand)

Type comparison operator:
instanceof Compares an object to a specific type

Bitwise and bit shift operators:
~   Unary bitwise complement
<<  Signed left shift
>>  Signed right shift
>>> Unsigned right shift
&   Bitwise AND
^   Bitwise exclusive OR
|   Bitwise inclusive OR

Oppdateringsoperatorer:
++  Inkrementoperator
--  Dekrementoperator
+=
-=
*=
/=

Operatorprioritet (foreklet liste):
!             ikke
*  /  %       multiplikasjon, divisjon og modulo
+  -          addisjon og subtraksjon
<  <=  >=  >  mindre/større enn (eller lik)
==  !=        er lik / er ikke lik
&&            og
||            eller

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Kontrollstrukturer:

If-then-else valgsetning:
	if (...) {
		...
	} else if (...) {
		...
	} else {
		...
	}

While løkke:
	while (...) {
		...
	}

Do-while løkke:
	do {
		...
	} while (...);

For løkke:
	for (int i = 0; i == 10; i++) {
	    ...
	}

For løkke (tabeller):
	String[] eksempelTabell = {"navn1", "navn2", "navn3"}
	for (String navn: eksempelTabell) {
		System.out.println(navn);
	}

Switch valgsetning:
	String result = null;
	switch (x) {
	    case 0: result = "zero";
			    break;
	    case 1: result = "one";
	            break;
	    case 2: result = "two";
	            break;
	    case 3: result = "three";
	            break;
	    case 4:
	    case 5:
	    case 6:
	    case 7: result = "higher than 3, lower than 8";
				break;
	    default: result = "???";
	};

Switch valgsetning (som uttrykk):
	String result =
	    switch (x) {
	        case 0  -> "zero";
	        case 1  -> "one";
	        case 2  -> "two";
	        case 3  -> "three";
	        default -> "???";
	    };

Bruke av yield eksempel #1:
	public String exampleMethod(int x) {
	    String result =
	        switch (x) {
	            case 0  -> { 
		            System.out.println("zero");
		            yield "zero";
		        }
	            case 1  -> { 
		            System.out.println("one");
		            yield "one";
		        }
	            default -> "???";
	        };
	    }
	    return result;
	}

Bruk av yield eksempel #2:
		int x = 0;
	    String result =
	        switch (x) {
	            case 0: yield "zero";
	            case 1: yield "one";
	            case 2: yield "two";
	            case 3: yield "three";
	            default: yield "???";
	        };
	    }

Other statements:
	break;
	continue;
	return;

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Enum:
enum EksempelEnum {FORSTE, ANDRE, TREDJE}
EksempelEnum x = EksempelEnum.ANDRE;

for (EksempelEnum enkelVerdi: Eksempelenum.values()) { ... }

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Andre notater:
2 + 2                       // Uttrykk (expression)
int num = (int)5.8          // Typetvang (casting) til verdien 5
int num = (int)(5.8 + 0.5)  // Typetvang med avrunding til verdien 6
final int MAX_NUM = 12;     // Deklarasjon av (integer) konstant

Escape sequences:
\b (backspace)
\t (tab)
\n (line feed)
\f (form feed)
\r (carriage return)
\" (double quote)
\' (single quote)
\\ (backslash)

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Nyttige bibliotek og metoder:

// Matematikk bibliotek
Math.*
	 abs()
	 max()
	 min()
	 round()
	 sqrt()
	 pow()
	 random()
	 PI

// Arrays-klassen
Arrays.*
       equals(tabellA, tabellB)
       sort(tabell)
       cpyOf(tabell)

// String-klassen
String.*
        char charAt(int index)
        int indexOf(String str)
        String[] split(String regex)
        String toUpperCase()
        String toLowerCase()
        boolean equals(String s)

// Dialogvindu bibliotek
javax.swing.JOptionPane.*   
                        showInputDialog()
                        showMessageDialog(null, melding)

// Konverter String til integer
Integer.parseInt()

 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

Norsk / Engelsk ordliste:
betingelse            condition
blokk                 block
datastruktur          data structure
datatype              data type
deklarasjon           declaration
evig løkke            infinite loop
feilfjerning          debugging
flyttall              float
funksjon              function
grensesnitt           interface
heltall               integer
hurtigminne           memory
initiere              initialization
inn-enhet             input device
interpreter           interpreter
kall                  call
katalog               folder
kjørestopp            runtime error
kjøremiljø            run-time / execution environment
klasse                class
klassemetode          class method
kommentar             comment
kompilator            compiler
komponent             component
konsoll               console
konkatenere           concatenation
konstant              constant
konstruktør           constructor
kontrollvariabel      control variable
levetid               extent
lokal variabel        local variable
løkke                 loop
metode                method
metodekall            method call
modifikator           modifier
objekt                object
objektmetode          object method
objektsamling         collection
objektvariabel        object variable
operator              operator
operatorprioritet     operator precedence
overlasting           overloading
overstyre             override
parameter             parameter
polymorfi             polymorphism
pragmatikk            pragmatics
primitiv datatype     primitive data type
produksjonslinje      pipeline
program               program
prosedyre             procedure
pseudokode            pseudocode
punktnotasjon         dot notation
referanseoverføring   call by reference
referansevariabel     reference variable
rekursjon             recursion
reservert ord         reserved word
returverdi            return value
semantikk             semantics
setning               statement
skilletegn            delimiter
skop                  scope
subklasse             subclass
syntaks               syntax
søppeltømming         garbage collection
tabell                table
tegnsett              character set
tellevariabel         counter variable
tilordning            assignment
typekollisjon         type mismatch
typetvang             casting
unntak                exception
unntakshåndterer      exception handler
uttrykk               expression
valgsetning           conditional
variabel              variable
verdioverføring       call by value
```

