user = int(input("What is the length of array"))
i = 1
num = []

while i <= user:
    x = int(input("Enter the number"))
    num.append(x)
    i += 1

print(num)

while (num[0] == num[-1]) == True:
    print("True")
    print("first and last number of a list is same")
    break
else:
    print("first and last number of a list NOT SAME")
