from math import sqrt, cos, acos, pi

class Vec2:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"[{self.x}, {self.y}]"

    def __add__(a, b):
        if isinstance(b, a.__class__):
            return Vec2(a.x + b.x, a.y + b.y)
        else:
            raise TypeError(f"ustøttet datatype for addisjon av Vec2: {type(a)}, {type(b)}")
    
    def __sub__(a, b):
        if isinstance(b, a.__class__):
            return Vec2(a.x - b.x, a.y - b.y)
        else:
            raise TypeError(f"ustøttet datatype for subtraksjon av Vec2: {type(a)}, {type(b)}")
    
    def __mul__(a, b):
        if isinstance(b, int) or isinstance(b, float):
            return Vec2(a.x * x, a.y * b)
        elif isinstance(b, a.__class__):
            return (a.x * b.x + a.y * b.y)
        else:
            raise TypeError(f"ustøttet datatype for multiplikasjon av Vec2: {type(a)}, {type(b)}")

    def __truediv__(a, b):
        if isinstance(b, int) or isinstance(b, float):
            return Vec2(a.x / b, a.y / b)
        else:
            raise TypeError(f"ustøttet datatype for deling av Vec2: {type(a)}, {type(b)}")
    
    def Skaler(self, n):
        self.x *= n
        self.y *= n

    def Lengde(self):
        return sqrt(self.x**2 + self.y**2)
    
    def LengdeTil(self, v):
        return sqrt((v.x - self.x)**2 + (v.y - self.y)**2)

    def VinkelTil(self, v, grader = True):
        vinkel = acos((self.x * v.x + self.y * v.y) / (self.Lengde() * v.Lengde()))
        if grader is True:
            vinkel *= (180.0 / pi)
        return vinkel

    @staticmethod
    def LengdeMellom(a, b):
        return a.LengdeTil(b)

    @staticmethod
    def VinkelMellom(a, b, grader = True):
        return a.VinkelTil(b, grader)

    @staticmethod
    def SkalarpoduktFraVinkel(a, b, vinkel, grader = True):
        if (isinstance(a, int) or isinstance(a, float)) and (isinstance(b, int) or isinstance(b, float)) and (isinstance(b, int) or isinstance(b, float)):
            return a * b * cos(vinkel * (pi / 180.0) if grader is True else vinkel)
        else:
            raise TypeError(f"ustøttet datatype for Vec2 -> SkalarpoduktFraVinkel(): {type(a)}, {type(b)}, {type(vinkel)}")

def opg12_61():
    A = Vec2(1,1)
    B = Vec2(5,-1)
    D = Vec2(2,4)
    C = B + (D - A)
    print(C)

def opg12_62():
    B = Vec2(4,1)
    C = Vec2(6,5)
    D = Vec2(-3,2)
    A = B + (D - C)
    print(A)

def opg12_63():
    A = Vec2(3,1)
    B = Vec2(1,5)
    M = A + (B - A) / 2
    print(M)

def opg12_64():
    A = Vec2(1,1)
    B = Vec2(3,2)
    C = Vec2(2,4)
    AB = B - A
    CB = B - C
    CD = AB * 2 + CB * 3
    D = C + CD
    print(D)

def opg12_65():
    A = Vec2(-2,-1)
    h1 = Vec2(3,1) 
    h2 = Vec2(-1,4)

    # Løs med D som ukjent hjørne:
    d_B = h1
    d_C = h2
    D = A + (d_C - d_B)
    print(D)

    # Løs med C som ukjent hjørne:
    c_B = h1
    c_D = h2
    C = c_B + (c_D - A)
    print(C)

    # Løs med B som ukjent hjørne:
    b_C = h1
    b_D = h2
    B = A + (b_C - b_D)
    print(B)

opg12_65()
