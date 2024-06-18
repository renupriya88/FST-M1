fiblist = []
def fib (a):
    if a <= 1:
        return a
    else:
        return (fib(a-1) + fib (a-2))

def load(h):
    fiblist.append(h)
    return

x = int(input("how many Fibonnaci numbers to generate"))
sum = 0
i = 0

for i in range(x):
    sum = fib(i)
    load(sum)

for index in fiblist:
    print(index)