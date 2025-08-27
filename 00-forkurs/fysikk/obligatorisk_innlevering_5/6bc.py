import numpy as np
import matplotlib.pyplot as plt

# Konstante variabler
m = 0.410      # Masse oppgitt i kilogram (kg)
k = 0.012      # Luftmotstandskoeffisienten oppgitt i kilogram per meter (kg/m)
g = 9.81       # Konstant akselerasjon i fritt fall oppgitt i meter per sekund per sekund (m/s^2)
G = g * m      # Tyngdekraft oppgitt i Newton (N)

# Startverdier for variabler
a = g          # Akselerasjon oppgitt i meter per sekund per sekund (m/s^2)
v = 0.0        # Fart oppgitt i meter per sekund (m/s)
t = 0.0        # Tid oppgitt i sekunder (s)
s = 0.0        # Posisjon fra start oppgitt i meter (m)

# Variabler for tid / antall iterasjoner
feilmargin = 0.001            # Avslutt løkken hvis akselerasjonen er under denne verdien
max_antall_steg = 10000       # Avslutt løkken etter antall iterasjoner er nådd
tids_steg = 10                # Økning i tid oppgitt i millisekund (ms) per kjøring av while-løkken
deltatid = (tids_steg / 1000) # Tid mellom hver iterasjon av løkken oppgitt i sekunder (s)

# Loggfør verdiene i lister
aLog = [a]
vLog = [v]
tLog = [t]
sLog = [s]

print("Kjører løkke som tar i bruk Euler metoden for å finne akselerasjon, fart og posisjon fra krefter:")
print("1. Beregn krefter som virker på legemet")
print("2. Finn akselerasjon fra krefter delt på masse")
print("3. Integrer akselerasjon over tid og finn fart")
print("4. Integrer fart over tid og finn posisjon")
print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
for i in range(0, max_antall_steg):
    r_L = k * v * v      # Kvadratisk luftmotstand
    a = (G - r_L) / m    # Akselerasjon = F / m
    t += deltatid        # Legg tid til i totaltiden
    v += a * deltatid    # Integrer akselerasjon for å finne fart
    s += v * deltatid    # Integrer fart for å finne posisjon
    aLog.append(a)
    vLog.append(v)
    tLog.append(t)
    sLog.append(s)
    # Print resultat
    print(f"{str(i+1).ljust(6)} | tid (s): {str(round(t, 2)).ljust(8)} posisjon (m): {str(round(s, 2)).ljust(8)} akselerasjon (m/s^2): {str(round(a, 3)).ljust(8)} fart (m/s): {str(round(v, 3)).ljust(8)}")
    # Avslutt løkken når terminalfarten er nådd
    if (a < feilmargin):
        print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
        print(f"Terminalfart {v} m/s funnet etter {i} iterasjoner (med tidsintervall {tids_steg} ms og feilmargin +- {feilmargin})")
        break

# Grafer
plt.figure(1)
plt.plot(tLog,aLog,'-r')
plt.grid()
plt.title ('Akselerasjon')
plt.xlabel('$t$ / s')
plt.ylabel('$a$ / m/s$^2$')
plt.figure(2)
plt.plot(tLog,vLog,'-b')
plt.grid()
plt.title ('Fart')
plt.xlabel('$t$ / s')
plt.ylabel('$v$ / m/s')
plt.figure(3)
plt.plot(tLog,sLog,'-g')
plt.grid()
plt.title ('Posisjon')
plt.xlabel('$t$ / s')
plt.ylabel('$s$ / m')
plt.show()
