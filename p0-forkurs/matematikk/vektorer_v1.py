from math import sqrt

class Vec2:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"[{self.x}, {self.y}]"

    def __add__(self, v):
        if isinstance(v, self.__class__):
            return Vec2(self.x + v.x, self.y + v.y)
        else:
            raise TypeError(f"unsupported operator types for +: {type(self)} and {type(v)}")
    
    def __sub__(self, v):
        if isinstance(v, self.__class__):
            return Vec2(self.x - v.x, self.y - v.y)
        else:
            raise TypeError(f"unsupported operator types for -: {type(self)} and {type(v)}")
    
    def __mul__(self, n):
        if isinstance(n, int) or isinstance(n, float):
            return Vec2(self.x * n, self.y * n)
        else:
            raise TypeError(f"unsupported operator types for *: {type(self)} and {type(n)}")
    
    def __truediv__(self, n):
        if isinstance(n, int) or isinstance(n, float):
            return Vec2(self.x / n, self.y / n)
        else:
            raise TypeError(f"unsupported operator types for /: {type(self)} and {type(n)}")
    
    def Skaler(self, n):
        self.x *= n
        self.y *= n

    def Lengde(self):
        return sqrt(self.x**2 + self.y**2)
    
    def LengdeTil(self, v):
        return sqrt((v.x - self.x)**2 + (v.y - self.y)**2)

    @staticmethod
    def LengdeMellom(a, b):
        return a.LengdeTil(b)

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
