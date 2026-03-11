# Gauss-Jordan-eliminasjon for å løse likningssystemet (Python):

from sympy import Matrix

A = Matrix([
    [ 50,  25,  75, 100],
    [ 75, 100,  50,  25],
    [ 75,  75,  75,  50],
    [ 50,  50,  50,  75]
])

b = Matrix([
    [4200],
    [3800],
    [4400],
    [3600]
])

x, params, free_vars = A.gauss_jordan_solve(b, freevar=True);
x = [str(row).replace('tau0', 'x_'+str(free_vars[0]+1)) for row in x]
print(f'Løsning: (x_1, x_2, x_3, x_4) = ({x[0]}, {x[1]}, {x[2]}, {x[3]})')

# Dette gir utputt: "Løsning: (x_1, x_2, x_3, x_4) = (56 - 2*x_3, x_3 - 8, x_3, 16)"
