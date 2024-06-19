import pandas as pd


#read data from excel
dataframe = pd.read_excel("activity19.xlsx", sheet_name="Sheet1")
	
# Print the DataFrame
print(dataframe)

#Print the number of rows and columns
print("number of rows and columns in excel are")
print(dataframe.shape)

#Print the data in the emails column only
print("Below are the data in emails column")
print(dataframe["Email"])

#Sort the data based on FirstName in ascending order and print the data
print("Sorted FirstName column")
print(dataframe.sort_values("FirstName", ascending = True))