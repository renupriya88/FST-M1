len1 = int(input("What is the length of array1"))
len2 = int(input("What is the length of array2"))
i = 1
j = 1
list1 = []
list2 = []
list3 = []

while i <= len1:
    x = int(input("Enter the number : array 1"))
    list1.append(x)
    i += 1

while j <= len2:
    x = int(input("Enter the number : array 2"))
    list2.append(x)
    j += 1

print(list1, list2)

for index in list1:
    if index % 2 != 0:
        list3.append(index)

for index in list2:
    if index % 2 == 0:
        list3.append(index)

print(list3)