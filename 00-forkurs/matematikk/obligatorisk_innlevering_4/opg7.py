
def f(x):
    return 3 ** x

def print_f(x):
    for i in x:
        print(f"  3^{str(i).ljust(2)} = {f(i)}")

print("  OPPGAVE 7:")
print(" - - - - - - - - - - - -")
print("a)")
print_f([4,10])
print()
print("b)")
print_f(range(0,5))

