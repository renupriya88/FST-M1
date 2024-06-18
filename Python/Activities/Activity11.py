user = int(input("How many types of fruits are there in your shop"))
i = 1
fruit = {} 

while i <= user:
    x = input("Enter the fruit")
    y = float(input("Enter the price"))
    fruit[x] = y
    i += 1

print(fruit)

user2 = input("what fruit do you want?")
if user2 in fruit:
    print(f"{user2} is available")
else:
    print(f"{user2} we dont have")