from math import sqrt, e

def v_m_h_tilnarming(a = 1, b = 10, n = 100):
    dx = (b - a) / n
    v, m, h = 0, 0, 0

    def f(x):
        return sqrt(x**2 + e**x)

    for i in range(n + 1):
        x_v = a + dx * (i - 1)
        x_m = a + dx * (i - 1/2)
        x_h = a + dx * i
        v += f(x_v) * dx
        m += f(x_m) * dx
        h += f(x_h) * dx

    print(f"Tilnæringsverdi fra {a} til {b} med {n} rektangler gir delta x: {dx}")
    print(f"Venstremetoden gir resultatet: {round(v, 2)}")
    print(f"Midtmetoden gir resultatet: {round(m, 2)}")
    print(f"Høyremetoden gir resultatet: {round(h, 2)}")

def trapes_tilnarming(a = -2, b = 2, n = 100):
    dx = (b - a) / n
    r = 0

    def f(x):
        return sqrt(4 - x**2)

    r = 1/2 * f(a) * dx + 1/2 * f(b) * dx
    for i in range(2, n+1):
        x = a + dx * (i - 1)
        r += f(x) * dx

    print(f"Tilnæringsverdi fra {a} til {b} med {n} trapeser gir delta x: {dx}")
    print(f"resultat: {round(r, 3)}")

trapes_tilnarming()