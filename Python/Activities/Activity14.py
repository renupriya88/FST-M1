fiblist = [0, 1]
def fib (a, b):
    return a+b

def load(h):
    fiblist.append(h)
    return

x = int(input("how many Fibonnaci numbers to generate"))
i = 0
j = 1
sum = 0

while i < x-2 and j < x-1:
    sum = fib(fiblist[i], fiblist[j])
    load(sum)
    i += 1
    j += 1

for index in fiblist:
    print(index)
