import pandas as pd

data = {
"Usernames" : ["admin", "Charles", "Deku"],
"Passwords" : ["password", "Charl13", "AllMight"]
}

# Create a new DataFrame using the data
dataframe = pd.DataFrame(data)
	
# Print the DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("activity17.csv")