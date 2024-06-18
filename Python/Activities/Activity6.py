user = int(input("Which numbers nested loop you want to create?"))

print(f"Nested loop of {user} is as below:\n")

for i in range(1,user+1):
    print(str(i) * i)
    i += 1
          