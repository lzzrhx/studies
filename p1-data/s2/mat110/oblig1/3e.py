from sympy import Matrix

A = Matrix([
    [ 1,  1,  1],
    [ 1,  2, -1],
    [ 2,  3,  3]
])

b = Matrix([
    [1],
    [4],
    [2]
])

x = A.inv() * b

print(f'Løsning: x_1 = {x[0]}, x_2 = {x[1]}, x_3 = {x[2]}')

# Dette gir utputt: "Løsning: x_1 = 1, x_2 = 1, x_3 = -1"
