user = int(input("Enter the number of numbers whose sum needs to be calculated"))
i = 1
num = []

while i <= user:
    x = int(input("Enter the number"))
    num.append(x)
    i += 1

print(num)

sum = 0
for j in num:
    sum = sum + j
    print (sum)

print(f"Sum of all the values in the list num is {sum}")

