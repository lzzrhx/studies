> [!info]
> [Emneplan](https://www.hvl.no/studier/studieprogram/emne/DAT100)  /  [GitHub](https://github.com/dat100hib/dat100public)
> **Studiepoeng:** 10
> **Vurdering:** Skoleeksamen, 25.11.2025 kl. 09:00

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

**Arch pakker:**
`sudo pacman -S jdk-openjdk intellij-idea-community-edition`

**Om Java:**

```
Java konsollkommandoer:

javac     Java-kompilator.
java      Verktøy (VM) for å kjøre kompilert Java bytekode.
javadoc   Verktøy for å generere dokumentasjon basert på kommentarer
jar       Verktøy for å håndtere jar-filer (komprimerte filer)
jshell    Java REPL
```


```
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
```


```
Anbefalt ordsammensetning:
variabler  camelCase
klasser    PascalCase
konstanter SCREAMING_SNAKE_CASE
```


```
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
```


```
Assignment operator:
= Assignment

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
```


```
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

```


```
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
```


```
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


// Dialogvindu bibliotek
javax.swing.JOptionPane.*   
                        showInputDialog()
                        showMessageDialog(null, melding)

// Konverter String til integer
Integer.parseInt()
```

```
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


**Kapittel 1 - Forstå program:**

En *variabeldeklarasjon* innfører en ny variabel og tildeler den datatype.
`int x;`
`double y;`

Variabler kan *initieres*, dvs. gis en startverdi i selve deklarasjonen.
`int x = 10;`
`double y = 3.14;`

Deklarerte variabler kan gis nye verdier ved bruk av *tilordning*.
`x = 5;`

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
- - - 
**Kapittel 5 - Tabeller**
- - -
**Kapittel 6 - Objekt**
- - -
**Kapittel 7 - Filer og unntak**
- - -
**Kapittel 8 - Grafisk brukergrensesnitt**
- - -
**Kapittel 9 - Objektorientert programmering**
