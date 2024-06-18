def sum (a, b):
    return a + b

user = int(input("How many numbers are in the list\n"))
i = 0
add = 0
num = []

while i <= (user-1):
    x = int(input("Enter the number"))
    num.append(x)
    i += 1

print(num)

for index in num:
    add = sum(add, index)

print(add)
