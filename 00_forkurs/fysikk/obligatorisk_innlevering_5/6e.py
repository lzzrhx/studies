import numpy as np
import matplotlib.pyplot as plt

# Konstante variabler
m = 0.410      # Masse oppgitt i kilogram (kg)
k = 0.012      # Luftmotstandskoeffisienten oppgitt i kilogram per meter (kg/m)
g = 9.81       # Konstant akselerasjon i fritt fall oppgitt i meter per sekund per sekund (m/s^2)
G = g * m      # Tyngdekraft oppgitt i Newton (N)

# Finn krefter, akselerasjon, fart og posisjon for fallende legeme
def fall(v = 0.0):  # v er fart oppgitt i meter per sekund (m/s)
    a = 0.0         # Akselerasjon oppgitt i meter per sekund per sekund (m/s^2)
    t = 0.0         # Tid oppgitt i sekunder (s)
    s = 0.0         # Posisjon fra start oppgitt i meter (m)

    # Variabler for tid / antall iterasjoner
    feilmargin = 0.001            # Avslutt løkken hvis akselerasjonen er under denne verdien
    max_antall_steg = 10000       # Avslutt løkken etter antall iterasjoner er nådd
    tids_steg = 10                # Økning i tid oppgitt i millisekunder (ms) per kjøring av while-løkken
    deltatid = (tids_steg / 1000) # Tid mellom hver iterasjon av løkken oppgitt i sekunder (s)
    endring_i_retning = None      # Variabel for loggøring av tidspunkt der fartsretningen endres

    # Klargjør lister for loggføring av verdier
    aLog, vLog, tLog, sLog = [], [], [], []

    print("Kjører løkke for å finne akselerasjon, fart og posisjon over tid:")
    print("F (kg * m / s^2)  ->  a (m/s^2)  ->  v (m/s)  ->  s (m)")
    print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
    for i in range(0, max_antall_steg):
        r_L = k * v * v        # Kvadratisk luftmotstand
        F = G - r_L            # Summer kreftene som virker på legemet
        a = F / m              # Akselerasjon = F / m
        if (i > 0):
            t += deltatid      # Legg tid til i totaltiden
            v += a * deltatid  # Integrer akselerasjon over tid for å finne fart
            s += v * deltatid  # Integrer fart over tid for å finne posisjon
        aLog.append(a)
        vLog.append(v)
        tLog.append(t)
        sLog.append(s)
        # Print resultat
        print(f"{str(i+1).ljust(6)} | tid (s): {str(round(t, 2)).ljust(8)} posisjon (m): {str(round(s, 2)).ljust(8)} akselerasjon (m/s^2): {str(round(a, 3)).ljust(8)} fart (m/s): {str(round(v, 3)).ljust(8)}")
        # Logg tiden hvis fartsretningen er endret siden forrige iterasjon
        if (i > 0 and (v < 0) != (vLog[i-1] < 0)):
            endring_i_retning = t
        # Avslutt løkken når terminalfarten er nådd (ingen akselerasjon)
        elif (a < feilmargin):
            print(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
            print(f"Terminalfart {v} m/s funnet etter {i} iterasjoner (med tidsintervall {tids_steg} ms og feilmargin +-{feilmargin} m/s^2 i akselerasjon)")
            break
    
    # Print tidspunkt for endret retning (hvis retning ble endret underveis)
    if endring_i_retning is not None:
        print(f"Retning endret ved {round(endring_i_retning, 2)} sekunder")
    
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

# Kjør funksjonen med startfart 5 m/s oppover
fall(v = -5.0)
