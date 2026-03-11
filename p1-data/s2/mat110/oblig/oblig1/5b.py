# Utregning av determinant (Python):

from sympy import Matrix

A = Matrix([
    [ 50,  25,  75, 100],
    [ 75, 100,  50,  25],
    [ 75,  75,  75,  50],
    [ 50,  50,  50,  75]
])

print(f'det(A) = {A.det()}')

# Dette gir utputt: "det(A) = 0"
