from numpy import sin
import matplotlib.pyplot as plt

def f(x):
    return sin(x / 2.0)

def g(x):
    return x * x * x

x_akse = [x * 0.01 for x in range(100)]
f_verdier = [f(x) for x in x_akse]
g_verdier = [g(x) for x in x_akse]

plt.figure(1)
plt.plot(x_akse, f_verdier)
plt.plot(x_akse, g_verdier)
plt.grid()
plt.show()
