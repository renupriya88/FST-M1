import pandas as pd

# Create a new DataFrame using the data
x = pd.read_csv("activity17.csv")
	
# Print the DataFrame
print(x)

#Print the values only in the Usernames column
print("Usernames column is as below:\n")
print(x["Usernames"])

#Print the username and password of the second row
print("username and password of the second row is as below:\n")
print(x["Usernames"][1] , x["Passwords"][1])

#Sort the Usernames column data in ascending order and print data
print(x.sort_values("Usernames", ascending = True))

#Sort the Passwords column in descending order and print data
print(x.sort_values("Usernames", ascending = False))