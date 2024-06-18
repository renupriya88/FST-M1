user = int(input("What is the length of array"))
i = 1
num = []

while i <= user:
    x = int(input("Enter the number"))
    num.append(x)
    i += 1

tupnum = tuple(num)
print(tupnum)

for item in tupnum:
    if item % 5 == 0:
        print(item)