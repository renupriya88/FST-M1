def adder (a,b):
    return a + b

sum = 0

x = range(11)
for n in x:
    sum = adder(sum, n)

print(f"Recursive sum of numbers from 0 to 10 is {sum}")
