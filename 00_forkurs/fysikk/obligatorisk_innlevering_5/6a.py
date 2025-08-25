import math

# Konstante variabler
m = 0.410      # Masse oppgitt i kilogram (kg)
k = 0.012      # Luftmotstandskoeffisienten oppgitt i kilogram per meter (kg/m)
g = 9.81       # Konstant akselerasjon i fritt fall oppgitt i meter per sekund per sekund (m/s^2)
G = g * m      # Tyngdekraft oppgitt i Newton (N)

# Finn terminalfarten gjennom Newtons andre lov:
# F = G - r_L
# F = 0
# G - r_L = 0
# G = r_L
# mg = k * v^2
# v^2 = mg / k
# v = sqrt(mg / k)
print(f"Terminalfarten ifølge Newtons andre lov er: {round(math.sqrt(G / k), 2)} m/s")

# Finn et uttrykk for akselerasjonen:
# F = ma
# a = F / m
print("Et utrykk for for akselerasjonen i Python (med positiv retning nedover) er: a = F / m, der F = m * g - k * v**2")
print("Eksempel ved v = 2 m/s er: a = (m * g - k * 2**2) / m")
print(f"Det gir resultatet: a = {(m * g - k * 2**2) / m} m/s^2")
