user = input("Which number multiplication table do you want?")
a = int(user)
i = 1
print(f"Multiplication table of {a} is as below:\n")

while i < 11:
    print(f"{a} * {i} = {a * i}")
    i += 1
          

