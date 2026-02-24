from math import sin

# Finn sin av x delt på 2
def f(x):
    return sin(x / 2.0)

# Finn x opphøyd i 3.
def g(x):
    return x**3

# Sammenlight g(x) og f(x)
def h(x):
  return g(x) - f(x)

# Finn midtpunkt mellom to verdier
def mid(a, b):
    return (a + b) / 2.0

# Halveringsmetoden
def halvering(a, b, iterasjoner = 10):
    m = mid(a, b)
    for i in range(0, iterasjoner):
        if h(m) < 0:
            a = m
        else:
            b = m
        m = mid(a, b)
    print(f"Halveringsmetoden ga resultatet x = {round(m, 4)} (etter {iterasjoner} iterasjoner)")

# Kjør halveringsmetoden
halvering(a = 0.1, b = 1.0)
